package it.exolab.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.exolab.utils.Flash;
import it.exolab.entity.Dipendenti;
import it.exolab.service.ContrattoService;
import it.exolab.service.DipendenteService;

@Controller
@RequestMapping(value = "dipendente")
public class DipendenteController {

	private DipendenteService service;
	private ContrattoService contrattoService;

	private String base_folder = "dipendente/";

	@Autowired(required = true)
	public void setService(DipendenteService service) {
		this.service = service;
	}

	@Autowired(required = true)
	public void setContrattoService(ContrattoService contrattoService) {
		this.contrattoService = contrattoService;
	}

	@RequestMapping(value = "all")
	public ModelAndView all(it.exolab.model.Filter filters, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView(base_folder + "all");
		List<Dipendenti> response = new ArrayList<Dipendenti>();
		if (filters.getQuery() == null || filters.getQuery().equals("")) {
			response = service.all();
		} else {
			response = service.cercaPerIdCheIniziaPer(filters.getQuery());
		}

		modelAndView.addObject("items", response);
		modelAndView.addObject("err", Flash.flash(session, "err"));
		modelAndView.addObject("filters", filters);

		return modelAndView;
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create(Dipendenti model, Model viewModel, HttpSession session) {
		String err = (String)Flash.flash(session, "err");
		viewModel.addAttribute("model", model);
		viewModel.addAttribute("err", err);
		viewModel.addAttribute("contratto", contrattoService.all());
		return base_folder + "form";
	}

	@RequestMapping(value="create", method=RequestMethod.POST)
	public String doCreate(@Valid @ModelAttribute("model") Dipendenti model,BindingResult bindingResult,HttpSession session,Model viewModel) {
		if (bindingResult.hasErrors()) {
			return base_folder + "form";
        }
		service.insert(model);
		
		return "redirect:all";
		
		
	}
	/*
	@RequestMapping(value = "dipendenteContratto", method = RequestMethod.GET)
	public String cercaPerIdJoinContratto(Dipendenti model, Model viewModel) {
		viewModel.addAttribute("model", model);
		return base_folder + "cercaPerId";
	}

	@RequestMapping(value = "dipendenteContratto", method = RequestMethod.POST)
	public ModelAndView cercaPerIdJoinContratto(Dipendenti id) {
		ModelAndView modelAndView = new ModelAndView(base_folder + "dipendenteContratto");

		Dipendenti response = service.cercaPerIdJoinContratto(id.getId_dipendente());
		modelAndView.addObject("items", response);

		return modelAndView;
	}
	*/
	@RequestMapping(value="update/{id_dipendente}", method=RequestMethod.GET)
	public String update(@PathVariable Integer id_dipendente,Model viewModel,HttpSession session) {
		
			
		Dipendenti response = service.find(id_dipendente);
			if(response==null) {
				Flash.flash(session, "err", BaseController.ERR_GENERAL);
				return "redirect:../all";
			}
			String err = (String)Flash.flash(session, "err");
			viewModel.addAttribute("model", response);
			viewModel.addAttribute("err", err);
			viewModel.addAttribute("mansioni", contrattoService.all());
		
		return base_folder + "form";
	}
	
	
	@RequestMapping(value="update/{id_dipendente}", method=RequestMethod.POST)
	public String doUpdate(Dipendenti model,@PathVariable Integer id_dipendente,Model viewModel,HttpSession session) {
		
		
			service.update(model);
			
			return "redirect:../all";
		
		
	}
	
	@RequestMapping(value="delete/{id_dipendente}", method=RequestMethod.GET)
	public String remove(@PathVariable Integer id_dipendente,HttpSession session) {
		service.delete(id_dipendente);
			
		return "redirect:../all";
	}
	
}
