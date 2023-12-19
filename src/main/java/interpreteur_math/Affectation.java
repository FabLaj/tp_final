package interpreteur_math;

import java.util.HashMap;

public class Affectation implements IExpression {

    HashMap<IExpression, IExpression> lesVariables = new HashMap<IExpression, IExpression>();

    public Affectation(IExpression variable, IExpression valeur) {
        lesVariables.put(variable, valeur);
    }

    @Override
    public String interpreter() {
        return "";
    }

}
