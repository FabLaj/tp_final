/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package tp_final;

import interpreteur_math.IInterpreteur;
import interpreteur_math.Interpreteur;
import observateur.AffichageHistorique;
import observateur.Diffuseur;
import observateur.SauvegardeHistorique;
import observateur.SupprimerSauvegarde;

/**
 *
 * @author Etudiant
 */

//Le premier patron que j'ai utilisé c'est l'interpréteur
//Les classes concernés sont:
//IInterpreteur
//Interpreteur
//IExpression
//Expression
//Addition, Soustraction, Multiplication, Division
//Nombre

public class Tp_final {

    public static void main(String[] args) {
        IInterpreteur interpreteur = new Interpreteur();
        CalculatriceGUI calcul = new CalculatriceGUI(interpreteur);
        String nomFichier = "sauvegarde.txt";
        calcul.diffuseur.abonnement("sauvegarder", new SauvegardeHistorique(nomFichier));
        AffichageHistorique histo = new AffichageHistorique(calcul.historique, nomFichier);
        histo.update("");
        calcul.diffuseur.abonnement("sauvegarder", histo);
        calcul.diffuseur.abonnement("supprimer", new SupprimerSauvegarde(nomFichier));
        calcul.setVisible(true);
    }
}
