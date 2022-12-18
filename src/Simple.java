import tec.Transport;
import tec.Usager;
import tec.FabriqueTec;
import tec.TecException;

/* 
  Test de recettes : 
    Vehicule autobus sans collecte 
    Passagers standard
*/
class Simple extends SimpleAbstrait{

  @Override
  Transport recupererTransport(){
    return FabriqueTec.faireAutobus(1, 2);
  }

  @Override
  Usager recupererUsager1(){
    return FabriqueTec.fairePassagerStandard("Kaylee", 4);
  }

  @Override
  Usager recupererUsager2(){
    return FabriqueTec.fairePassagerStandard("Jayne", 4);
  }

  @Override
  Usager recupererUsager3(){
    return FabriqueTec.fairePassagerStandard("Inara", 5);
  }

  static public void main (String[] args) throws TecException {
    System.out.println("-----------------\nTest de recette Simple\n-----------------");
    new Simple().test();
    System.out.println("-----------------\nFin test de recette Simple\n-----------------");
  }
}

