package interpreteur_math;

import java.util.HashMap;

public class Variable implements IExpression {

    String _var;

    public Variable(String var) {
        _var = var;
    }

    public String interpreter() {
        return _var;
    }

}
