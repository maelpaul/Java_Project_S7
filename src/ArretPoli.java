package tec;

class ArretPoli extends ArretAbstrait {
    private static final ArretPoli arretPoli = new ArretPoli();

    public static ArretPoli recuperer(){
        return arretPoli;
    }

    private ArretPoli(){
        super("ArretPoli");
    }

    public void choixPlaceArret(Passager p, Vehicule v, int numeroArret) {
        if(numeroArret == p.destination()){
            v.arretDemanderSortie(p);
        }
        else if (!v.aPlaceAssise()) {
            v.arretDemanderDebout(p);
        }
    }
}