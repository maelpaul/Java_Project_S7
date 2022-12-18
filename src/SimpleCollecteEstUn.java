import tec.Transport;
import tec.Usager;
import tec.FabriqueTec;
import tec.TecException;

/* 
  Test de recettes : 
    Vehicule autobus avec collecte est-un
    Passagers standard, stresse et indecis
*/
class SimpleCollecteEstUn extends SimpleAbstrait {

  @Override
  Transport recupererTransport(){
    return FabriqueTec.faireGreffonAutobus(FabriqueTec.faireRecuperateurFichier(), 1, 2);
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
    System.out.println("-----------------\nTest de recette Simple collect est un \n-----------------");
    new SimpleCollecteEstUn().test();
    System.out.println("-----------------\nFin test de recette Simple collect est un\n-----------------");
  }
}
