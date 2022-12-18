package tec;

import java.util.ArrayList;

class Greffon implements Vehicule, Transport{

    private CollecteurAbstrait collecteur;
    private Vehicule vehicule;

    private ArrayList<Passager> passagers;


    public Greffon(CollecteurAbstrait collecteur, Vehicule vehicule){
        this.vehicule = vehicule;
        this.collecteur = collecteur;

        passagers = new ArrayList<>();
    }

    @Override
    public boolean aPlaceAssise(){
        return vehicule.aPlaceAssise();
    }

    @Override
    public boolean aPlaceDebout(){
        return vehicule.aPlaceDebout();
    }

    @Override
    public void monteeDemanderAssis(Passager p){
        if(!p.estDehors()){
            return;
        }
        vehicule.monteeDemanderAssis(p);
        if(p.estAssis()){
            passagers.add(p);
            collecteur.uneEntree();
        }
    }

    @Override
    public void monteeDemanderDebout(Passager p){
        if(!p.estDehors()){
            return;
        }
        vehicule.monteeDemanderDebout(p);
        if(p.estDebout()){
            passagers.add(p);
            collecteur.uneEntree();
        }
    }

    @Override
    public void arretDemanderDebout(Passager p){
        vehicule.arretDemanderDebout(p);
    }

    @Override
    public void arretDemanderAssis(Passager p){
        vehicule.arretDemanderAssis(p);
    }

    @Override
    public void arretDemanderSortie(Passager p){
        vehicule.arretDemanderSortie(p);

        collecteur.uneSortie();
    }

    @Override
    public void allerArretSuivant(){
        collecteur.changerArret();
        
        ((Transport)vehicule).allerArretSuivant();

        for (int i = passagers.size() - 1; i >= 0 ; --i){
            if(passagers.get(i).estDehors()){
                collecteur.uneSortie();
                passagers.remove(i);
            }
          }
    }


    @Override
    public String toString(){
        return "(Greffon a-un)" + vehicule;
    }
}
