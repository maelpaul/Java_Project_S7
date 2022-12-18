package tec;

class MonteeSportif extends PassagerAbstrait{
    public MonteeSportif(String nom, int destination, ComportementArret comportementArret) {
        super("PassagerMonteeSportif", nom, destination, comportementArret);
    }
      

    @Override
    public void choixPlaceMontee(Vehicule v){
        if (v.aPlaceDebout()) {
            v.monteeDemanderDebout(this);
        }
    }
}