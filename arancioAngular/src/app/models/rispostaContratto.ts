import { Contratto } from "./contratto";
import { Risposta } from "./risposta";

export class RispostaContratto extends Risposta{
    contratti: Array<Contratto>;
    id_contratto: number;
}