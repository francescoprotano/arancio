import { Contratto } from "./contratto";
import { DipendenteMese } from "./dipendenteMese";
import { Mese } from "./mese";

export class Dipendente{
    id_dipendente!: number;
    nome!: string;
    cognome!: string;
    data_nascita!: Date;
    email!: string;
    password!: string;
    ruolo_fk!: string;
    contratto_corrente_fk!: number;
    contratto!: Contratto;
    dipendenteMese!: DipendenteMese;
    mese!: Mese;
}