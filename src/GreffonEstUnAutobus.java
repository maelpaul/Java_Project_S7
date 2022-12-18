package tec;

class GreffonEstUnAutobus extends Autobus {
    CollecteurAbstrait collecteur;

    public GreffonEstUnAutobus(CollecteurAbstrait collecteur,  int nbPlaceAssise, int nbPlaceDebout) {
        super(nbPlaceAssise, nbPlaceDebout);
        this.collecteur = collecteur;
    }

    public void uneEntree() {
        collecteur.uneEntree();
    }

    public void uneSortie() {
        collecteur.uneSortie();
    }

    public void changerArret() {
        collecteur.changerArret();
    }

    public void monteeDemanderAssis(Passager p) {
        super.monteeDemanderAssis(p);
        if (p.estAssis()) {
            this.uneEntree(); 
        }
    }

    public void monteeDemanderDebout(Passager p) {
        super.monteeDemanderDebout(p);
        if (p.estDebout()) {
            this.uneEntree();
        }
    }

    public void arretDemanderSortie(Passager p) {
        super.arretDemanderSortie(p);
        if (p.estDehors()) {
            this.uneSortie();
        }
    }

    public void allerArretSuivant() {
        this.changerArret();
        super.allerArretSuivant();
    }

    @Override
    public String toString() {
        return "(Greffon est-un)" + super.toString();
    }
}
