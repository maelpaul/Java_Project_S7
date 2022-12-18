package tec;

import java.util.ArrayList;

class Autobus implements Vehicule, Transport {
  private int numeroArret;

  /**
   * Jauge permettant de compter le nombre de passager assis et debout présent dans le bus.
   */
  private final Jauge jaugeAssis, jaugeDebout;

  /**
   * Liste des passagers présents dans le bus.
   */
  private final ArrayList<Passager> passagers;

  public Autobus(int nbPlaceAssise, int nbPlaceDebout) {
    if(nbPlaceAssise < 0){
      throw new IllegalArgumentException("nbPlacceAssise < 0 invalide");
    }
    else if(nbPlaceDebout < 0){
      throw new IllegalArgumentException("nbPlacceDebout < 0 invalide");
    }
    numeroArret = 0;

    jaugeAssis = new Jauge(nbPlaceAssise, 0);
    jaugeDebout = new Jauge(nbPlaceDebout, 0);

    passagers = new ArrayList<>();
  }

  /**
   * Indique s'il reste une place assise dans l'autobus.
   */
  public boolean aPlaceAssise() {
    return jaugeAssis.estVert();
  }

  /**
   * Indique s'il reste une place debout dans l'autobus.
   */
  public boolean aPlaceDebout() {
    return jaugeDebout.estVert();
  }

  /**
   * Ajoute un passager dans l'autobus montant dans le bus directement en place assise.
   */
  public void monteeDemanderAssis(Passager p) {
    if(chercherPassager(p)!=-1){
      throw new IllegalStateException("le passager est déjà dans ce transport");
    }

    if (p.estDehors()){
      if (aPlaceAssise()) {
        jaugeAssis.incrementer();
        p.changerEnAssis();

        passagers.add(p);
      }
    }
  }

  /**
   * Ajoute un passager dans l'autobus montant dans le bus directement en place debout.
   */
  public void monteeDemanderDebout(Passager p) {
    if(chercherPassager(p) != -1){
      throw new IllegalStateException("le passager est déjà dans ce transport");
    }
    
    if (p.estDehors()){
      if (aPlaceDebout()) {
        jaugeDebout.incrementer();
        p.changerEnDebout();
        
        passagers.add(p);
      }
    }
  }

  /**
   *  Transfert d'un passager d'une place assise à debout
   */
  public void arretDemanderDebout(Passager p) {
    if (aPlaceDebout()){
      jaugeDebout.incrementer();
      jaugeAssis.decrementer();
      p.changerEnDebout();
    }
  }
  
  /**
   * Transfert d'un passager d'une place debout à assise
   */
  public void arretDemanderAssis(Passager p) {
      if (p.estDehors()) {
      if (aPlaceAssise()){
      jaugeAssis.incrementer();
      jaugeDebout.decrementer();
      p.changerEnAssis();
    }
      }
  }

  /**
   * Sort un passager de l'autobus le demandant
   */
  public void arretDemanderSortie(Passager p) { 
    if (p.estDebout()){
      jaugeDebout.decrementer();
      passagers.remove(p);

      p.changerEnDehors();

    } else if (p.estAssis()){
      jaugeAssis.decrementer();

      passagers.remove(p);

      p.changerEnDehors();
    } 
  }

  /**
   * Amene l'autobus à l'arret suivant
   */
  public void allerArretSuivant() { 
    ++numeroArret;

    for (int i = passagers.size() - 1; i >= 0 ; --i){
      passagers.get(i).nouvelArret(this, numeroArret);
    }
  }

  /**
   * Le passager est t'il dans la liste 
   *
   * @return indice >= 0 si il est présent sinon -1
   */
  private int chercherPassager(Passager p){
    return passagers.indexOf(p);
  }

  @Override
  public String toString(){
    return "Autobus, jauge assis : " + jaugeAssis + " | jauge debout : " + jaugeDebout;
  }
}
