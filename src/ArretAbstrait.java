package tec;

// Classe abstraite utilisée pour gérer les toString dans le cas des println
abstract class ArretAbstrait implements ComportementArret, AgissementArret {
    private String type;

    ArretAbstrait(String type){
        this.type = type;
    }

    ArretAbstrait(){
        this.type = "Arret";
    }

    @Override
    public String toString(){
        return type;
    }
}
