package observateur;

import java.util.*;

public class Diffuseur {
    Map<String, List<ISoucripteur>> souscripteurs = new HashMap<>();

    public Diffuseur(String... operations)
    {
        for (String operation: operations)
        {
            this.souscripteurs.put(operation, new ArrayList<>());
        }
    }

    public void abonnement(String type, ISoucripteur s)
    {
        List<ISoucripteur> abbonnees = souscripteurs.get(type);
        abbonnees.add(s);
    }

    public void desabonnement(String type, ISoucripteur s)
    {
        List<ISoucripteur> abbonnees = souscripteurs.get(type);
        abbonnees.add(s);
    }

    public void notifier(String type, String expression)
    {
        List<ISoucripteur> abbonnees = souscripteurs.get(type);
        for(ISoucripteur s : abbonnees)
        {
            s.update(expression);
        }
    }

}
