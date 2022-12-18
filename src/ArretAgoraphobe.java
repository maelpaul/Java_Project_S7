package tec;

class ArretAgoraphobe extends ArretAbstrait {
    private static final ArretAgoraphobe arretAgoraphobe = new ArretAgoraphobe();

    public static ArretAgoraphobe recuperer(){
        return arretAgoraphobe;
    }

    private ArretAgoraphobe(){
        super("ArretAgoraphobe");
    }

    public void choixPlaceArret(Passager p, Vehicule v, int numeroArret) {
        if(numeroArret == p.destination()){
            v.arretDemanderSortie(p);
        }
        else if (!v.aPlaceAssise() || !v.aPlaceDebout()) {
            v.arretDemanderSortie(p);
        }
    }
}