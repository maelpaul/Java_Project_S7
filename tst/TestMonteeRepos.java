package tec;

class TestMonteeRepos extends TestPassagerAbstrait{

  public static void main (String[] args)  throws TecException{
    boolean estMisAssertion = false;
    assert estMisAssertion = true;

    if (!estMisAssertion) {
      System.out.println("Execution impossible sans l'option -ea");
      return;
    }

    int nbTest = 0;

    //************ Verifier l'instanciation *************
    System.out.print('.'); nbTest++;
    new TestMonteeRepos().testInstanciation();

    //********* Verifier changement d'etat **************
    System.out.print('.'); nbTest++;
    new TestMonteeRepos().testGestionEtat();

    //********* Verifier les interactions  *************
    System.out.print('.'); nbTest++;
    new TestMonteeRepos().testInteractionMontee();

    System.out.println("(" + nbTest + "):OK: " + "tec.MonteeRepos");
  }
 
  protected PassagerAbstrait creerPassager(String nom, int destination){
    return new MonteeRepos(nom, destination, (ComportementArret)FabriqueTec.recupererArretCalme());
  }

  /* Interaction a la montee
   * Trois cas
   *  - des places assises et debout
   *  - pas de place assise
   *  - aucune place. 
   */
  protected void testInteractionMontee()  throws TecException {
    PassagerAbstrait p = creerPassager("yyy", 5);
    
    FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
    p.monterDans(faux);
    
    assert "monteeDemanderAssis" == getLastLog(faux) : "assis";    
    
    faux = new FauxVehicule(FauxVehicule.DEBOUT);
    p.monterDans(faux);
    
    assert "monteeDemanderDebout" == getLastLog(faux) : "debout";    

    faux = new FauxVehicule(FauxVehicule.PLEIN);
    p.monterDans(faux);
    
    assert 0 == faux.logs.size() : "pas de place";        
  }
}
