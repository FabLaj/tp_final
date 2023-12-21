package interpreteur_math;

public class Soustraction extends OperateurBinaire {

    public Soustraction(IExpression a, IExpression b) {
        _a = a;
        _b = b;
    }

    @Override
    public Double interpreter() {
        return _a.interpreter() - _b.interpreter();
    }

}
