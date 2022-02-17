import { Dipendente } from "./dipendente";
import { DipendenteMese } from "./dipendenteMese";
import { Mese } from "./mese";
import { Presenza } from "./presenza";

export class Container {
    dip: Dipendente = new Dipendente()
    dipMes: DipendenteMese = new DipendenteMese()
    mese: Mese = new Mese()
    pres: Presenza = new Presenza()
}