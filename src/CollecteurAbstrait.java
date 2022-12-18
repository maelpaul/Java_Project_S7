package tec;

/**
 * Un collecteur sert à sauvegarder les informations sur un arrêt,
 * c'est à dire le numéro d'arrêt, le nombre de personne qui sont montés dans le véhicule à cet arrêt et le nombre de personne qui sont descendus du véhicule à cet arrêt.
 */
abstract class CollecteurAbstrait {
    private int tempMontee;
    private int tempDescente;
    private int arret;

    /**
     * Appelé quand un passager entre dans le véhicule.
     */
    public final void uneEntree(){
        ++tempMontee;
    }

    /**
     * Appelé quand un passager sort dans le véhicule.
     */
    public final void uneSortie(){
        ++tempDescente;
    }
 
    /**
     * Appelé à chaque arrêt
     */
    public final void incrementerArret(){
        ++arret;
    }

    /**
     * Reinitise les données, à appeller au changement d'arret 
     */
    public final void reinitialiserCollecte(){
        tempMontee = 0;
        tempDescente = 0;
    }

    /*
     * [Méthode à implementer par les sous classes]
     * Retourne l'instance de la classe de type Transport / Véhicule utilisée pour le test de recette
     */
    public abstract void changerArret();

    /**
     * [Méthode à implementer par les sous classes]
     * Méthode à portée de debug, affiche l'état du collecteur
     */
    public abstract void afficher();

    
    /// GETTERS ///
    public final int recupererTempMontee(){
        return this.tempMontee;
    }

    public final int recupererTempDescente(){
        return this.tempDescente;
    }

    public final int recupererArret(){
        return this.arret;
    }
    ///         ///
}