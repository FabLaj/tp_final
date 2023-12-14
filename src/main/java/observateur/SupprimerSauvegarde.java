package observateur;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SupprimerSauvegarde implements ISoucripteur {

    File _fichier;

    public SupprimerSauvegarde(String nomFichier)
    {
        _fichier = new File(nomFichier);
    }

    @Override
    public void update(String expression) {
        try {
            FileWriter writer = new FileWriter(_fichier);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}
