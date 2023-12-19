package observateur;

import java.util.*;

public class Diffuseur {
    Map<String, List<ISoucripteur>> souscripteurs = new HashMap<>();

    public Diffuseur(String... operations) {
        for (String operation : operations) {
            this.souscripteurs.put(operation, new ArrayList<>());
        }
    }

    public void abonnement(String type, ISoucripteur s) {
        List<ISoucripteur> abonnees = souscripteurs.get(type);
        abonnees.add(s);
    }

    public void desabonnement(String type, ISoucripteur s) {
        List<ISoucripteur> abonnees = souscripteurs.get(type);
        abonnees.add(s);
    }

    public void notifier(String type, String expression) {
        List<ISoucripteur> abonnees = souscripteurs.get(type);
        for (ISoucripteur s : abonnees) {
            s.update(expression);
        }
    }

}
