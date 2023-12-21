package observateur;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.JComboBox;

import interpreteur_math.IInterpreteur;
import interpreteur_math.Interpreteur;
import tp_final.StockageVariable;

public class Historique {
    List<String> _historique;
    public Diffuseur _diffuseur;
    StockageVariable _variables;

    public Historique(StockageVariable variables) {
        _diffuseur = new Diffuseur();
        _historique = new ArrayList<>();
        _variables = variables;
    }

    public void initialisation(String nomFichier, IInterpreteur interpreteur, JComboBox comboBox) {
        _historique = new ArrayList<>();
        File fichier = new File(nomFichier);
        try {
            Scanner reader = new Scanner(fichier);
            while (reader.hasNextLine()) {
                String ligne = reader.nextLine();
                if (ligne.contains(">")) {
                    interpreteur.parse(ligne).interpreter();
                    String[] laVariable = ligne.split(">");
                    comboBox.addItem(laVariable[0]);
                }
                ajouterLigne(ligne);
            }
            reader.close();
        } catch (FileNotFoundException e) {
        }
    }

    public void ajouterLigne(String ligne) {
        _historique.add(ligne);
        _diffuseur.notifier(this);
    }

    public void supprimerHistorique() {
        _historique.clear();
        _diffuseur.notifier(this);
    }
}
