package interpreteur_math;

import java.util.HashMap;
import java.util.Map;

public class Variable implements IExpression {

    String _var;

    private HashMap<String, Double> _lesVariables = new HashMap<>();

    public Variable(String var, HashMap<String, Double> lesVariables) {
        _var = var;
        _lesVariables = lesVariables;
    }

    public Double interpreter() {
        return _lesVariables.get(_var);

        // for (Map.Entry<IExpression, IExpression> entry : _lesVariables.entrySet()) {
        // IExpression key = entry.getKey();
        // IExpression value = entry.getValue();
        // if (key.equals(this)) {
        // System.out.println("yé");
        // }
        // System.out.println("agag");
        // }
        // return 12.0;
    }

}
