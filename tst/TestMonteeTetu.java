package tec;

class TestMonteeTetu extends TestPassagerAbstrait {

  public static void main (String[] args)  throws TecException {
    boolean estMisAssertion = false;
    assert estMisAssertion = true;

    if (!estMisAssertion) {
      System.out.println("Execution impossible sans l'option -ea");
      return;
    }

    int nbTest = 0;

    //************ Verifier l'instanciation *************
    System.out.print('.'); nbTest++;
    new TestMonteeTetu().testInstanciation();

    //********* Verifier changement d'etat **************
    System.out.print('.'); nbTest++;
    new TestMonteeTetu().testGestionEtat();

    //********* Verifier les interactions  *************
    System.out.print('.'); nbTest++;
    new TestMonteeTetu().testInteractionMontee();

    System.out.println("(" + nbTest + "):OK: " + "tec.MonteeTetu");
  }
 
  protected PassagerAbstrait creerPassager(String nom, int destination){
    return new MonteeTetu(nom, destination, (ComportementArret)FabriqueTec.recupererArretCalme());
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

    assert "monteeDemanderDebout" == getLastLog(faux) : "debout si vide";
    
    faux = new FauxVehicule(FauxVehicule.PLEIN);
    p.monterDans(faux);

    assert "monteeDemanderDebout" == getLastLog(faux) : "debout si plein"; 
  }
}
