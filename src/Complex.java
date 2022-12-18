import tec.Transport;
import tec.Usager;
import tec.FabriqueTec;
import tec.TecException;

/* 
  Test de recettes : 
    Vehicule autobus sans collecte 
    Passagers standard, stresse et indecis
*/
class Complex extends SimpleAbstrait {

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
    return FabriqueTec.fairePassagerStresse("Jayne", 4);
  }

  @Override
  Usager recupererUsager3(){
    return FabriqueTec.fairePassagerIndecis("Inara", 5);
  }

  static public void main (String[] args) throws TecException {
    System.out.println("-----------------\nTest de recette Complex\n-----------------");
    new Complex().test();
    System.out.println("-----------------\nFin test de recette Complex\n-----------------");
  }
}
