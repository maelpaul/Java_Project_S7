package tec;

public class TestArretCalme extends TestArretAbstrait{
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
        new TestArretCalme().testInteractionArret();
    
        System.out.println("(" + nbTest + "):OK: " + "tec.ArretCalme");
      }

      protected PassagerAbstrait creerPassager(String nom, int destination){
        return new MonteeRepos(nom, destination, (ComportementArret)FabriqueTec.recupererArretCalme());
      }

      protected void testInteractionArret(){
        PassagerAbstrait p = creerPassager("yyy", 5);
    
        FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
    
        p.nouvelArret(faux, 1);
        assert 0 == faux.logs.size() : "pas a destination";
    
        p.nouvelArret(faux, 5);
        assert "arretDemanderSortie" == getLastLog(faux) : "destination";    
      }
}
