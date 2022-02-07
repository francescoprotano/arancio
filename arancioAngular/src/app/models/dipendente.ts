import { Contratto } from "./contratto";

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
}