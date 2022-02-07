export class Presenza{
    id_presenza!: number;
    id_dipendente_fk!: number;
    data!: Date;
    ore_lavorate!: number;
    ore_assenza!: number;
    motivazione_assenza_fk!: string;
    id_mese_fk!: number;
}