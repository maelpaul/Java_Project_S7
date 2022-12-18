package tec;

class MonteeRepos extends PassagerAbstrait{
    public MonteeRepos(String nom, int destination, ComportementArret comportementArret) {
        super("PassagerMonteeRepos", nom, destination, comportementArret);
    }
      

    @Override
    public void choixPlaceMontee(Vehicule v){
        if (v.aPlaceAssise()) {
            v.monteeDemanderAssis(this);
          } else if (v.aPlaceDebout()) {
            v.monteeDemanderDebout(this);
          }
    }
}