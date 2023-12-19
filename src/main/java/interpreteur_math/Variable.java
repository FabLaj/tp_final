package interpreteur_math;

public class Variable {

    String _var;

    public Variable(String var) {
        _var = var;
    }
    
    public String interpreter() {
        return _var;
    }

}
