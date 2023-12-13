package interpreteur_math;

public class Multiplication extends Expression {

    public Multiplication(IExpression a, IExpression b) {
        _a = a;
        _b = b;
    }

    @Override
    public double interpreter() {
        return _a.interpreter() * _b.interpreter();
    }

}
