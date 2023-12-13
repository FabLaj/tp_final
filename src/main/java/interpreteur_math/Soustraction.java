package interpreteur_math;

public class Soustraction extends Expression {

    public Soustraction(IExpression a, IExpression b) {
        _a = a;
        _b = b;
    }

    @Override
    public double interpreter() {
        return _a.interpreter() - _b.interpreter();
    }

}
