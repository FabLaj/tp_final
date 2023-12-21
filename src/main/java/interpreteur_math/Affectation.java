package interpreteur_math;

import java.util.HashMap;

public class Affectation implements IExpression {

    HashMap<String, Double> _lesVariables;

    String _a;
    IExpression _b;

    public Affectation(String variable, IExpression valeur, HashMap<String, Double> lesVariables) {
        _lesVariables = lesVariables;
        _a = variable;
        _b = valeur;
    }

    @Override
    public Double interpreter() {
        _lesVariables.put(_a, _b.interpreter());
        return _b.interpreter();
    }

}
