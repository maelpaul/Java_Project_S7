package tec;

class ArretPrudent extends ArretAbstrait {
    private static final ArretPrudent arretPrudent = new ArretPrudent();
    
    public static ArretPrudent recuperer(){
        return arretPrudent;
    }

    private ArretPrudent(){
        super("ArretPrudent");
    }

    public void choixPlaceArret(Passager p, Vehicule v, int numeroArret) {
        if(numeroArret == p.destination()){
            v.arretDemanderSortie(p);
        }
        else{
            if(p.destination() - numeroArret >= 5){
                v.arretDemanderAssis(p);
            }
            else if(p.destination() - numeroArret <= 3){
                v.arretDemanderDebout(p);
            }
        }
    }
}