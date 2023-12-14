package observateur;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AffichageHistorique implements ISoucripteur{

    JTextArea _historique;

    File _fichier;
    Scanner reader;

    public AffichageHistorique(JTextArea historique, String fichier)
    {
        _historique = historique;
        _fichier = new File(fichier);
    }

    @Override
    public void update(String expression) {
        String texte = "Historique: \n";
        try {
            reader = new Scanner(_fichier);
            while(reader.hasNextLine())
            {
                texte += reader.nextLine() + "\n";
            }
            _historique.setText(texte);
            reader.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
