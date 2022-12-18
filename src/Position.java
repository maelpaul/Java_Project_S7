package tec;

/**
 * Cette classe représente la position d'un passager par rapport à un transport.
 * Une position a trois états possibles : assis dans un transport, 
 * debout dans un transport et dehors d'un transport.
 *
 * Les instances de cette classe sont des objets constants.
 *
 * @author Georgy
 * @since 2007-2019
 **/
final class Position {
  private static final Position posDehors = new Position();
  private static final Position posDebout = new Position();
  private static final Position posAssis = new Position();
  
  private Position(){}

  /**
   * Retourne une instance de Position par defaut
   *
   * @return instance dans l'état dehors.
   */
  public static Position recupererPosition(){
    return recupererPositionDehors();
  }

  /**
   * Retourne une instance de Position dehors.public
   *
   * @return instance dans l'état dehors.
   */
  public static Position recupererPositionDehors(){
    return posDehors;
  }
  
  
  /**
   * Retourne une instance de Position debout.
   *
   * @return instance dans l'état debout.
   */
  public static Position recupererPositionDebout(){
    return posDebout;
  }

  /**
   * Retourne une instance de Position assis.
   *
   * @return instance dans l'état assis.
   */
  public static Position recupererPositionAssis(){
    return posAssis;
  }

  /**
   * La position est-elle dehors ?
   *
   * @return vrai si l'état de l'instance est dehors;
   */
  public boolean estDehors() {
    return this == posDehors;
  }

  /**
   * La position est-elle assis ?
   *
   * @return vrai si l'état de l'instance est assis;
   */
  public boolean estAssis() {
    return this == posAssis;
  }

  /**
   * La position est-elle debout ?
   *
   * @return vrai si l'état de l'instance est debout;
   */
  public boolean estDebout() {
    return this == posDebout;
  }

  /**
   * La position est-elle assis ou debout ?
   *
   * @return vrai la position est assis ou debout.
   */
  public boolean estInterieur() {
    return this != posDehors;
  }

  /**
   * Cette méthode est héritée de la classe {@link java.lang.Object}.
   * Très utile pour le débogage, elle permet de fournir une 
   * chaîne de caractères correspondant à l'état d'un objet.
   * Mais, il faut adapter son code à chaque classe.
   */
  @Override
  public String toString() {
    String nom = null;
    if (estAssis())
      nom = "assis";
    else if (estDebout())
      nom = "debout";
    else if (estDehors())
      nom = "endehors";

    return "<" + nom + ">";
  }
}
