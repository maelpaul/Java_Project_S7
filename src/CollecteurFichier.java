package tec;

import java.io.Writer;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

class CollecteurFichier extends CollecteurAbstrait implements Recuperateur {
    private ArrayList<GreffonStat> stats;

    public CollecteurFichier() {
        stats = new ArrayList<>();
    }

    public void changerArret() {
        GreffonStat greffon = new GreffonStat(recupererTempMontee(), recupererTempDescente(), recupererArret());
        stats.add(greffon);
        afficher();
        incrementerArret();
        reinitialiserCollecte();
    }

    public void afficher() {
        try {
            FileWriter f = new FileWriter("build/log.txt");        
            this.ecrireDuTexte(f);
            f.close();
        }
        catch (IOException e) {
            System.out.println("exception levée");
        }
    }

    private void ecrireDuTexte(Writer w) {
        PrintWriter p = new PrintWriter(w);

        for (int i = 0; i < stats.size(); ++i) {
            GreffonStat stat = stats.get(i);
            p.println("arret: " + stat.numeroArret());
            p.println("nb personnes entrées: " + stat.entrees());
            p.println("nb personnes sorties: " + stat.sorties());
            p.println(" ");            
        }
        p.flush();
    }
}
