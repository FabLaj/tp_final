/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interpreteur_math;

/**
 *
 * @author Etudiant
 */
public class Addition extends Expression {

    public Addition(IExpression a, IExpression b) {
        _a = a;
        _b = b;
    }

    @Override
    public String interpreter() {
        return Double.toString(Double.parseDouble(_a.interpreter()) + Double.parseDouble(_b.interpreter()));
    }

}
