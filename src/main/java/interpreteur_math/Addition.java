/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interpreteur_math;

/**
 *
 * @author Etudiant
 */
public class Addition extends OperateurBinaire {

    public Addition(IExpression a, IExpression b) {
        _a = a;
        _b = b;
    }

    @Override
    public Double interpreter() {
        return _a.interpreter() + _b.interpreter();
    }

}
