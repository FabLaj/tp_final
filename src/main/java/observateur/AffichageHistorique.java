package observateur;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AffichageHistorique implements ISoucripteur {

    JTextArea _texteArea;

    File _fichier;
    Scanner reader;

    public AffichageHistorique(JTextArea texteArea, String fichier) {
        _texteArea = texteArea;
        _fichier = new File(fichier);
    }

    @Override
    public void update(Historique historique) {
        String texte = "";
        for (String ligne : historique._historique) {
            texte += ligne + "\n";
        }
        _texteArea.setText(texte);
    }

}
