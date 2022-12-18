package tec;

public class TestArretPoli extends TestArretAbstrait{
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
        new TestArretPoli().testInteractionArret();
    
        System.out.println("(" + nbTest + "):OK: " + "tec.ArretCalme");
      }

      protected PassagerAbstrait creerPassager(String nom, int destination){
        return new MonteeRepos(nom, destination, (ComportementArret)FabriqueTec.recupererArretPoli());
      }

      protected void testInteractionArret(){
        PassagerAbstrait p = creerPassager("yyy", 5);
    
        FauxVehicule faux = new FauxVehicule(FauxVehicule.DEBOUT);
        p.changerEnAssis();

        p.nouvelArret(faux, 1);
        assert "arretDemanderDebout" == getLastLog(faux) : "assis -> debout";    
      }
}