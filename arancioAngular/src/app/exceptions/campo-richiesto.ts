export class CampoRichiesto{

    private field : string;
   constructor(field : string) { 
        this.field = field;
  
  }
  
  getField(){
      return this.field;
  }
}