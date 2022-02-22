import { Mese } from "./mese";

export class DipendenteMese {
    [x: string]: any;
    id_dipendente_fk!: number;
    id_mese_fk!: number;
    stato!: number;
    mese!: Mese;
    dipendenteMese!: DipendenteMese;
}