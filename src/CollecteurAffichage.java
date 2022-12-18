package tec;

import java.util.ArrayList;

class CollecteurAffichage extends CollecteurAbstrait implements  Recuperateur{

    private ArrayList<GreffonStat> stats;

    public CollecteurAffichage() {
        stats = new ArrayList<>();
    }

    public void changerArret(){
        GreffonStat stat = new GreffonStat(this.recupererTempMontee(), this.recupererTempDescente(), this.recupererArret());
        stats.add(stat);
        System.out.println(stat.toString());

        this.incrementerArret();
        this.reinitialiserCollecte();
    }

    public void afficher(){
        for (int i = 0 ; i < stats.size() ; ++i){
            System.out.println(stats.get(i).toString());
        }
    }
}
