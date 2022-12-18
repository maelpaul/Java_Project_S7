package tec;

public class TestArretAgoraphobe extends TestArretAbstrait{
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
        new TestArretAgoraphobe().testInteractionArret();
    
        System.out.println("(" + nbTest + "):OK: " + "tec.ArretAgoraphobe");
      }

      protected PassagerAbstrait creerPassager(String nom, int destination){
        return new MonteeRepos(nom, destination, (ComportementArret)FabriqueTec.recupererArretAgoraphobe());
      }

      protected void testInteractionArret(){
        PassagerAbstrait p = creerPassager("yyy", 5);
        p.changerEnDebout();
    
        FauxVehicule faux = new FauxVehicule(FauxVehicule.PLEIN);
    
        p.nouvelArret(faux, 1);
        assert "arretDemanderSortie" == getLastLog(faux) : "changement debout -> dehors";  
      }
}