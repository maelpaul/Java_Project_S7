package tec;

class ArretCalme extends ArretAbstrait {
    private static final ArretCalme arretCalme = new ArretCalme();

    public static ArretCalme recuperer(){
        return arretCalme;
    }

    private ArretCalme(){
        super("ArretCalme");
    }

    public void choixPlaceArret(Passager p, Vehicule v, int numeroArret) {
        if(numeroArret == p.destination()){
            v.arretDemanderSortie(p);
        }
    }
}