package tec;

final class GreffonStat{

    private final int entrees;
    private final int sorties;
    private final int numero_arret;
    
    public GreffonStat(int entrees, int sorties, int numero_arret){
        this.entrees = entrees;
        this.sorties = sorties;
        this.numero_arret = numero_arret;
    }

    public final int numeroArret(){
        return this.numero_arret;
    }

    public final int entrees(){
        return this.entrees;
    }

    public final int sorties(){
        return this.sorties;
    }

    @Override
    public String toString(){
      return "n° arret : " + this.numero_arret + " | " + entrees + " entree(s) | " + sorties + " sortie(s)\n";
    }
}
