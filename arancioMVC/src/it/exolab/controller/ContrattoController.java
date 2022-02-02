package it.exolab.controller;

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


import it.exolab.entity.Contratti;
import it.exolab.entity.Dipendenti;
import it.exolab.service.ContrattoService;
import it.exolab.utils.Flash;

@Controller
@RequestMapping(value="contratto")
public class ContrattoController {

	private ContrattoService service;
	
	private String base_folder = "contratto/";
	
	@Autowired(required=true)
	public void setService(ContrattoService service) {
		this.service = service;
	}
	
	@RequestMapping(value="all")
	public ModelAndView all(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView(base_folder+ "all");
			List<Contratti> response = service.all();
			
			
			
			modelAndView.addObject("items", response);
			modelAndView.addObject("err", Flash.flash(session, "err"));
			
			
		return modelAndView;
	}
	
	@RequestMapping(value="create", method=RequestMethod.GET)
	public String create(Contratti model, Model viewModel,HttpSession session) {
		String err = (String)Flash.flash(session, "err");
		viewModel.addAttribute("model", model);
		viewModel.addAttribute("err", err);
		
		return base_folder + "form";
	}
	
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public String doCreate(@Valid @ModelAttribute("model") Contratti model,BindingResult bindingResult,HttpSession session,Model viewModel) {
		if (bindingResult.hasErrors()) {
			return base_folder + "form";
        }
		service.insert(model);
		
		return "redirect:all";
		
		
	}
	
	@RequestMapping(value="update/{id}", method=RequestMethod.GET)
	public String update(@PathVariable Integer id_contratto,Model viewModel,HttpSession session) {
		
			
		Contratti response = service.find(id_contratto);
			if(response==null) {
				Flash.flash(session, "err", BaseController.ERR_GENERAL);
				return "redirect:../all";
			}
			String err = (String)Flash.flash(session, "err");
			viewModel.addAttribute("model", response);
			viewModel.addAttribute("err", err);
		
		return base_folder + "form";
	}
	
	
	@RequestMapping(value="update/{id}", method=RequestMethod.POST)
	public String doUpdate(Contratti model,@PathVariable Integer id_contratto,Model viewModel,HttpSession session) {
		
		
			service.update(model);
			
			return "redirect:../all";
		
		
	}
	
	@RequestMapping(value="delete/{id}", method=RequestMethod.GET)
	public String remove(@PathVariable Integer id_contratto,HttpSession session) {
		service.delete(id_contratto);
			
		return "redirect:../all";
	}

	@RequestMapping(value="view/{id}", method=RequestMethod.GET)
	public String view(@PathVariable Integer id_contratto,Model viewModel,HttpSession session) {
		
			
		Contratti response = service.find(id_contratto);
			
			if(response==null) {
				Flash.flash(session, "err", BaseController.ERR_GENERAL);
				return "redirect:../all";
			}

			
			String err = (String)Flash.flash(session, "err");
			viewModel.addAttribute("model", response);
			viewModel.addAttribute("err", err);
		
		return base_folder + "view";
	}
	
}
