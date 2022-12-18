import tec.Transport;
import tec.Usager;
import tec.FabriqueTec;
import tec.TecException;
abstract class SimpleAbstrait {

  /*
   * Affiche l'etat des deux instances passees en parametre.
   * La methode println(Object x) de la classe PrintWriter 
   * declenche la methode toString() sur l'objet passe 
   * en parametre (x.toString()) et affiche la chaine 
   * de caracteres obtenue..
   */
  static private final void deboguerEtat (Transport t, Usager p) {
    System.out.println(p);
    System.out.println(t);
  }

  /*
    [Méthode à implementer par les sous classes]
    Retourne l'instance de la classe de type Transport / Véhicule utilisée pour le test de recette
   */
  abstract Transport recupererTransport();

  /*
    [Méthode à implementer par les sous classes]
    Retourne l'instance 1 de la classe de type Usager / Passager utilisée pour le test de recette
   */
  abstract Usager recupererUsager1();

  /*
    [Méthode à implementer par les sous classes]
    Retourne l'instance 2 de la classe de type Usager / Passager utilisée pour le test de recette
   */
  abstract Usager recupererUsager2();

  /*
    [Méthode à implementer par les sous classes]
    Retourne l'instance 3 de la classe de type Usager / Passager utilisée pour le test de recette
   */
  abstract Usager recupererUsager3();

  /*
    Tests de recettes généralistes qui sera testé dans différentes condition de véhicules et d'usagers par des sous-classes.
   */
  public final void test() throws TecException{
    Transport serenity = recupererTransport();

    Usager kaylee = recupererUsager1();
    Usager jayne =  recupererUsager2();
    Usager inara =  recupererUsager3();

    //0
    System.out.println(serenity);

    serenity.allerArretSuivant();
    //1
    kaylee.monterDans(serenity);

    System.out.println(serenity);
    System.out.println(kaylee);

    serenity.allerArretSuivant();
    //2
    jayne.monterDans(serenity);

    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);

    serenity.allerArretSuivant();
    //3
    inara.monterDans(serenity);

    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);

    serenity.allerArretSuivant();
    //4
    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);

    serenity.allerArretSuivant();
    //5
    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);

    serenity.allerArretSuivant();
    //6
  }
}
