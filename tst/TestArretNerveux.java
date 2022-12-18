package tec;

public class TestArretNerveux extends TestArretAbstrait{
    public static void main (String[] args) {
        boolean estMisAssertion = false;
        assert estMisAssertion = true;
    
        if (!estMisAssertion) {
          System.out.println("Execution impossible sans l'option -ea");
          return;
        }
    
        int nbTest = 0;

    
        //********* Verifier les interactions  *************
        System.out.print('.'); nbTest++;
        new TestArretNerveux().testInteractionArret();
    
        System.out.println("(" + nbTest + "):OK: " + "tec.ArretNerveux");
      }

      protected PassagerAbstrait creerPassager(String nom, int destination){
        return new MonteeRepos(nom, destination, (ComportementArret)FabriqueTec.recupererArretNerveux());
      }

      protected void testInteractionArret(){
        PassagerAbstrait p = creerPassager("yyy", 5);
        p.changerEnDebout();
    
        FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
    
        p.nouvelArret(faux, 1);
        assert "arretDemanderAssis" == getLastLog(faux) : "changement debout -> assis";    
    
        p.changerEnAssis();
        
        p.nouvelArret(faux, 2);
        assert "arretDemanderDebout" == getLastLog(faux) : "changement assis -> debout";    
    
        p.nouvelArret(faux, 5);
        assert "arretDemanderSortie" == getLastLog(faux) : "destination";    
      }
}