package interpreteur_math;

public class Nombre implements IExpression {

    double _nb;

    public Nombre(double nb) {
        _nb = nb;
    }

    @Override
    public double interpreter() {
        return _nb;
    }

}
