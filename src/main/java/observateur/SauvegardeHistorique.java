package observateur;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class SauvegardeHistorique implements ISoucripteur {

    File _fichier;
    FileWriter writer;

    public SauvegardeHistorique(String nomFichier)
    {
        _fichier = new File(nomFichier);
    }

    @Override
    public void update(String expression) {
        System.out.println("sauvegarde dans le fichier " + _fichier.getName() + " l'expression suivante :" + expression);

        try {
            Scanner sc = new Scanner(_fichier);
            String texte = "";
            while(sc.hasNextLine())
            {
                texte += sc.nextLine() + "\n";
            }
            sc.close();
            writer = new FileWriter(_fichier);
            writer.write(texte + expression);
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
