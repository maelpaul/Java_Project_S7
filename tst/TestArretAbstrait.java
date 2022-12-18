package tec;

abstract class TestArretAbstrait {

    protected abstract PassagerAbstrait creerPassager(String nom, int destination);

    /* Interaction a un arret
    * Deux cas
    *  - numero d'arret < a la destination
    *  - numero d'arret >= a la destination 
    */
    protected abstract void testInteractionArret();

    protected String getLastLog(FauxVehicule f) {
        return f.logs.get(f.logs.size() -1);
    }
}
