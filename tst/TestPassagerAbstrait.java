package tec;

abstract class TestPassagerAbstrait {

  //********************************************************
  /* Etat apres instanciation
   * Un seul cas 
   */  
  public void testInstanciation() {
    PassagerAbstrait p = creerPassager("xxx", 3);

    assert false == p.estAssis();
    assert false == p.estDebout();
    assert true == p.estDehors();
  }

  protected abstract PassagerAbstrait creerPassager(String nom, int destination);

  /* Gestion des changement d'état.
   * 
   * Changer Debout puis Dehors puis assis. 
   */
  protected void testGestionEtat() {
    PassagerAbstrait p = creerPassager("yyy", 3);

    p.changerEnDebout();
    assert false == p.estAssis();
    assert true == p.estDebout();
    assert false == p.estDehors();

    p.changerEnDehors();
    assert false == p.estAssis();
    assert false == p.estDebout();
    assert true == p.estDehors();

    p.changerEnAssis();
    assert true == p.estAssis();
    assert false == p.estDebout();
    assert false == p.estDehors();

    try{
	PassagerAbstrait p2 = creerPassager("yyy", -3);
    }
    catch(IllegalArgumentException e){
        System.out.println("Exception levée");
    }
  }  

  /* Interaction a la montee
   * Trois cas
   *  - des places assises et debout
   *  - pas de place assise
   *  - aucune place. 
   */
  protected abstract void testInteractionMontee() throws TecException;   

  /* Interaction a un arret
   * Deux cas
   *  - numero d'arret < a la destination
   *  - numero d'arret >= a la destination 
   */
  //protected abstract void testInteractionArret();

  protected String getLastLog(FauxVehicule f) {
    return f.logs.get(f.logs.size() -1);
  }
  protected void testCasLimite() {
    PassagerAbstrait passager = null;
    ComportementArret comportementArret = null;

    passager = new MonteeFatigue("yo", -5, comportementArret);
  }

  protected void testExceptionCasLimite(){
      try{
          new TestMonteeFatigue().testCasLimite();
          assert false: "Exception non levée";
      }
      catch(IllegalArgumentException e){
          System.out.println("Exception levée");
      }      
  }

  protected void testCasLimite2() throws TecException {
    Autobus bus = new Autobus(99, 66);

    PassagerAbstrait passager = null;
    ComportementArret comportementArret = null;

    passager = new MonteeFatigue("yo", 5, comportementArret);

    passager.monterDans(bus);
    passager.monterDans(bus);
  }

  protected void testExceptionCasLimite2() {
    try {
      new TestMonteeFatigue().testCasLimite2();
      assert false: "Exception non levée"; 
    }
    catch(TecException e){
      System.out.println("Exception levée");
    }
  }
}
