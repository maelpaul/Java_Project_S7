package tec;

abstract class PassagerAbstrait implements Passager, Usager{
  /**
   * Nom du passager
   */
  private final String nom;

  /**
   * Numéro de l'arret de destination
   */
  private final int destination;

  /**
   * Position du passager : en dehors du bus, debout ou assis dans le bus
   */
  private Position position;

  private String typePassager;

  private ComportementArret comportementArret;


  public PassagerAbstrait(String typePassager, String nom, int destination, ComportementArret comportementArret) {
    if(destination < 0){
      throw new IllegalArgumentException("destination < 0 invalide");
    }
    
    this.typePassager = typePassager;
    this.nom = nom;
    this.destination = destination;
    this.position = Position.recupererPositionDehors();
    this.comportementArret = comportementArret;
  }

  public String nom() {
    return nom;
  }

  public int destination() {
    return destination;
  }

  /**
   * @return vrai si le passager est hors du bus sinon faux
   */
  public boolean estDehors() {
    return position.estDehors() ;
  }
  
  /**
   * @return vrai si le passager est assis dans le bus sinon faux
   */
  public boolean estAssis() {
    return position.estAssis();
  }
  
  /**
   * @return vrai si le passager est debout dans le bus sinon faux
   */
  public boolean estDebout() {
    return position.estDebout();
  }

  /**
   * Enregistre le fait que le passager n'est plus dans le bus
   */
  public void changerEnDehors() {
    this.position = Position.recupererPositionDehors();
  }

  /**
   * Enregistre le fait que le passager est assis dans le bus
   */
  public void changerEnAssis() {
    this.position = Position.recupererPositionAssis();
  }

  /**
   * Enregistre le fait que le passager est debout dans le bus
   */
  public void changerEnDebout() {
    this.position = Position.recupererPositionDebout();
  }

  /**
   * Informe le passager qu'un nouvel arret a été atteint.
   */
  public final void nouvelArret(Vehicule v, int numeroArret){
    if (numeroArret == destination) {
      v.arretDemanderSortie(this);
    } else {
      comportementArret.choixPlaceArret(this, v, numeroArret);
    }
  }

  /**
   * Fait monter le passager dans le vehicule
   */
  public final void monterDans(Transport t) throws TecException{
      /*if (t instanceof Vehicule) {
      choixPlaceMontee((Vehicule) t);
      }*/
      if (!(t instanceof Vehicule)){
	  throw new TecException("t n'est pas un véhicule");
      }
      try {
	  choixPlaceMontee((Vehicule) t);
      }
      catch(IllegalStateException e){
	  throw new TecException(e);
      }
  }

  protected abstract void choixPlaceMontee(Vehicule v);

  @Override
  public final String toString(){
    return typePassager + comportementArret + " " + position;
  }
}
