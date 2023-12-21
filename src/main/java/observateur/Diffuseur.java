package observateur;

import java.util.*;

public class Diffuseur {
    List<ISoucripteur> souscripteurs = new ArrayList<>();

    // public Diffuseur() {
    // }

    public void abonnement(ISoucripteur s) {
        souscripteurs.add(s);
    }

    public void desabonnement(ISoucripteur s) {
        souscripteurs.remove(s);
    }

    protected void notifier(Historique historique) {
        for (ISoucripteur s : souscripteurs) {
            s.update(historique);
        }
    }

}
