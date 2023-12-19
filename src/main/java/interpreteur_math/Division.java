package interpreteur_math;

public class Division extends Expression {

    public Division(IExpression a, IExpression b) {
        _a = a;
        _b = b;
    }

    @Override
    public String interpreter() {
        return Double.toString(Double.parseDouble(_a.interpreter()) / Double.parseDouble(_b.interpreter()));
    }

}
