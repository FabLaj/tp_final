package interpreteur_math;

public class Multiplication extends OperateurBinaire {

    public Multiplication(IExpression a, IExpression b) {
        _a = a;
        _b = b;
    }

    @Override
    public Double interpreter() {
        return _a.interpreter() * _b.interpreter();
    }

}
