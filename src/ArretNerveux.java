package tec;

class ArretNerveux extends ArretAbstrait {
    private static final ArretNerveux arretNerveux = new ArretNerveux();

    public static ArretNerveux recuperer(){
        return arretNerveux;
    }

    private ArretNerveux(){
        super("ArretNerveux");
    }

    public void choixPlaceArret(Passager p, Vehicule v, int numeroArret) {
        if(numeroArret == p.destination()){
            v.arretDemanderSortie(p);
        }
        else{
            if(p.estAssis()){
                v.arretDemanderDebout(p);
            }
            else{
                v.arretDemanderAssis(p);
            }
        }
    }
}

