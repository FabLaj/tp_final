/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package tp_final;

import interpreteur_math.IExpression;
import interpreteur_math.IInterpreteur;
import interpreteur_math.Interpreteur;

/**
 *
 * @author Etudiant
 */
public class Tp_final {

    public static void main(String[] args) {
        IInterpreteur interpreteur = new Interpreteur();
        CalculatriceGUI calcul = new CalculatriceGUI(interpreteur);
        calcul.setVisible(true);
    }
}
