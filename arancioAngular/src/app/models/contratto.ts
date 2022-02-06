export class Contratto{
    id_contratto!: number;
    data_assunzione!: Date;
    data_scadenza!: Date;
    tipologia!: string;
    id_dipendente_fk!: number;
}