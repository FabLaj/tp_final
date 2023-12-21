package observateur;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class SauvegardeHistorique implements ISoucripteur {

    File _fichier;
    FileWriter writer;

    public SauvegardeHistorique(String nomFichier) {
        _fichier = new File(nomFichier);
    }

    @Override
    public void update(Historique historique) {
        try {
            String texte = "";
            writer = new FileWriter(_fichier);
            for (String ligne : historique._historique) {
                texte += ligne + "\n";
            }
            writer.write(texte);
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
