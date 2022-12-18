package tec;

class MonteeTetu extends PassagerAbstrait{
    public MonteeTetu(String nom, int destination, ComportementArret comportementArret) {
        super("PassagerMonteeTetu", nom, destination, comportementArret);
    }
      

    @Override
    public void choixPlaceMontee(Vehicule v){
        v.monteeDemanderDebout(this);
    }
}