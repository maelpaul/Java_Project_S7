package tec;

// Mot clef final pour que la classe ne puisse pas être hérité
public final class FabriqueTec {
    /**
     * Retourne le comportement d'arret agoraphobe
     * Composant nécessaire à la création d'un passager customisé
     */
    public static AgissementArret recupererArretAgoraphobe() {
        return ArretAgoraphobe.recuperer();
    }

    /**
     * Retourne le comportement d'arret calme
     * Composant nécessaire à la création d'un passager customisé
     */
    public static AgissementArret recupererArretCalme() {
        return ArretCalme.recuperer();
    }

    /**
     * Retourne le comportement d'arret nerveux
     * Composant nécessaire à la création d'un passager customisé
     */
    public static AgissementArret recupererArretNerveux() {
        return ArretNerveux.recuperer();
    }

    /**
     * Retourne le comportement d'arret poli
     * Composant nécessaire à la création d'un passager customisé
     */
    public static AgissementArret recupererArretPoli() {
        return ArretPoli.recuperer();
    }

    /**
     * Retourne le comportement d'arret prudent
     * Composant nécessaire à la création d'un passager customisé
     */
    public static AgissementArret recupererArretPrudent() {
        return ArretPrudent.recuperer();
    }

    // Classe non instanciable
    private FabriqueTec(){}

    /**
     * Création d'un passager stresse au comportement de monte fatigue et d'arret prudent.
     */
    public static Usager fairePassagerStresse(String nom, int destination){
        return fairePassagerMonteeFatigue(recupererArretPrudent(), nom, destination);
    }

    /**
     * Création d'un passager standard au comportement de monte repos et d'arret calme.
     */
    public static Usager fairePassagerStandard(String nom, int destination){
        return fairePassagerMonteeRepos(recupererArretCalme(), nom, destination);
    }

    /**
     * Création d'un passager standard au comportement de monte repos et d'arret calme.
     */
    public static Usager fairePassagerIndecis(String nom, int destination){
        return fairePassagerMonteeSportif(recupererArretNerveux(), nom, destination);
    }

    // Créer un objet de type autobus 
    public static Transport faireAutobus(int nbPlaceAssise, int nbPlaceDebout){
        return new Autobus(nbPlaceAssise, nbPlaceDebout);
    }   

    // Créer un objet de type BusSportif 
    public static Transport faireBusSportif(int nbPlaceAssise, int nbPlaceDebout){
        return new BusSportif(nbPlaceAssise, nbPlaceDebout);
    }

    /**
     * Retourne un autobus qui sera utilisé par un système de collecte de données
     * La construction du greffon nécessite un collecteur passé en paramètre
     */
    public static Transport faireGreffonAutobus(Recuperateur recuperateur, int nbPlaceAssise, int nbPlaceDebout){
        if (!(recuperateur instanceof CollecteurAbstrait))
            throw new TecRuntimeException("Le récupérateur passé en paramètre n'est pas un sous type de l'interface CollecteurAbstrait");

        return new GreffonEstUnAutobus((CollecteurAbstrait)recuperateur, nbPlaceAssise, nbPlaceDebout);
    }   


    /**
     * Retourne un transport passé en paramètre sera utilisé par un système de collecte de données
     * La construction du greffon nécessite un collecteur passé en paramètre
     */
    public static Transport faireGreffonAUn(Recuperateur recuperateur, Transport transport){
        if (!(recuperateur instanceof CollecteurAbstrait))
            throw new TecRuntimeException("L'argument de type Recuperateur passé en paramètre n'est pas un sous type de l'interface CollecteurAbstrait");
        
        if (! (transport instanceof Vehicule))
            throw new TecRuntimeException("L'argument de type Transport passé en paramètre n'est pas un sous type de l'interface Vehicule");
        

        return new Greffon((CollecteurAbstrait)recuperateur, (Vehicule) transport);
    }

    /**
     * Retourne un système de collecte de données affichant dans le terminal les informations pour chaque arrêt.
     * Composant nécessaire à la création d'un greffon
     */
    public static Recuperateur faireRecuperateurAffichage(){
        return new CollecteurAffichage();
    }

    /**
     * Retourne un système de collecte de données écrivant dans un fichier les informations pour chaque arrêt.
     * Composant nécessaire à la création d'un greffon
     */
    public static Recuperateur faireRecuperateurFichier(){
        return new CollecteurFichier();
    }


    /** 
     * Contruit un passager avec le comportement de montee repos
     */
    public static Usager fairePassagerMonteeRepos(AgissementArret agissementArret, String nom, int destination){
        if (!(agissementArret instanceof ComportementArret))
            throw new TecRuntimeException("L'argument de type agissementArret passé en paramètre n'est pas un sous type de l'interface ComportementArret");
        

        // Si règle impossible
        /*if (agissementArret instanceof ArretNerveux)
            return null;*/

        return new MonteeRepos(nom, destination, (ComportementArret)agissementArret);
    }

    // Contruit un passager avec le comportement de montee fatigue
    public static Usager fairePassagerMonteeFatigue(AgissementArret agissementArret, String nom, int destination){
        if (!(agissementArret instanceof ComportementArret))
            throw new TecRuntimeException("L'argument de type agissementArret passé en paramètre n'est pas un sous type de l'interface ComportementArret");

        return new MonteeFatigue(nom, destination, (ComportementArret)agissementArret);
    }

    // Contruit un passager avec le comportement de montee sportif
    public static Usager fairePassagerMonteeSportif(AgissementArret agissementArret, String nom, int destination){
        if (!(agissementArret instanceof ComportementArret))
            throw new TecRuntimeException("L'argument de type agissementArret passé en paramètre n'est pas un sous type de l'interface ComportementArret");

        return new MonteeSportif(nom, destination, (ComportementArret)agissementArret);
    }

     // Contruit un passager avec le comportement de montee tetu
    public static Usager fairePassagerMonteeTetu(AgissementArret agissementArret, String nom, int destination){
        if (!(agissementArret instanceof ComportementArret))
            throw new TecRuntimeException("L'argument de type agissementArret passé en paramètre n'est pas un sous type de l'interface ComportementArret");

        return new MonteeTetu(nom, destination, (ComportementArret)agissementArret);
    }
}
