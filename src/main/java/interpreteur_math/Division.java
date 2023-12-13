package interpreteur_math;

public class Division extends Expression {

    public Division(IExpression a, IExpression b) {
        _a = a;
        _b = b;
    }

    @Override
    public double interpreter() {
        return _a.interpreter() / _b.interpreter();
    }

}
