package tec;

class MonteeFatigue extends PassagerAbstrait{
    public MonteeFatigue(String nom, int destination, ComportementArret comportementArret) {
        super("PassagerMonteeFatigue", nom, destination, comportementArret);
    }
      

    @Override
    public void choixPlaceMontee(Vehicule v){
        if (v.aPlaceAssise()) {
            v.monteeDemanderAssis(this);
        }
    }
}