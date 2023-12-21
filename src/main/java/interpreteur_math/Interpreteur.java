package interpreteur_math;

import java.util.HashMap;
import java.util.Map;

import observateur.Diffuseur;
import tp_final.StockageVariable;

public class Interpreteur implements IInterpreteur {

    // Je sais pas si faut je le garde
    StockageVariable _variables;
    // IExpression>();

    public Interpreteur(StockageVariable variables) {
        _variables = variables;
    }

    @Override
    public IExpression parse(String expr) {
        expr = expr.trim();
        if (expr.isEmpty()) {
            return null; // throw?
        } else if (estDeNiveau1(expr)) {
            return parse(expr.substring(1, expr.length() - 1));
        }

        final int opIndex = trouverProchainOperateur(expr);
        if (opIndex >= 0) {
            final String operande1 = expr.substring(0, opIndex).trim();
            final String operande2 = expr.substring(opIndex + 1).trim();
            if (operande1.isEmpty() || operande2.isEmpty()) {
                throw new ArithmeticException("Expression invalide.");
            }
            switch (expr.charAt(opIndex)) {
                case '+':
                    return new Addition(parse(operande1), parse(operande2));
                case '-':
                    return new Soustraction(parse(operande1), parse(operande2));
                case '*':
                    return new Multiplication(parse(operande1), parse(operande2));
                case '/':
                    return new Division(parse(operande1), parse(operande2));
                case '>':
                    return new Affectation(operande1, parse(operande2), _variables._variables);
                default:
                    throw new ArithmeticException("Expression invalide: opérateur inconnu " + expr.charAt(opIndex));
            }
        }
        try {
            Double.parseDouble(expr);
            return new Nombre(Double.parseDouble(expr));
        } catch (Exception e) {
            return new Variable(expr, _variables._variables);
        }

    }

    // Retourne l'index du caractère de l'opérateur (ou au début de l'opérateur s'il
    // est représenté par plus d'un symbole (mod, div, etc.)
    // Retourne -1 s'il n'en trouve pas.
    protected int trouverProchainOperateur(String expr) {
        int niveauParantheses = 0;
        final int exprLen = expr.length();
        int indexSecondOrdre = -1;
        for (int i = 0; i < exprLen; ++i) {
            switch (expr.charAt(i)) {
                // Sauter les espaces blancs, ils n'ont aucune valeur sémantique.
                case ' ':
                case '\t':
                case '\n':
                    continue;
                case '(':
                    ++niveauParantheses;
                    break;
                case ')':
                    --niveauParantheses;
                    break;
                case '>':
                case '+':
                case '-':
                    if (niveauParantheses == 0) {
                        return i;
                    }
                    break;
                case '*':
                case '/':
                    if (niveauParantheses == 0) {
                        indexSecondOrdre = i;
                    }
                    break;
            }
        }
        return indexSecondOrdre;
    }

    protected boolean estDeNiveau1(String expr) {
        if (!expr.startsWith("(") || !expr.endsWith(")")) {
            return false;
        }

        int niveauParentheses = 0;
        for (int i = 0; i < expr.length(); ++i) {
            if (expr.charAt(i) == '(') {
                niveauParentheses++;
            } else if (expr.charAt(i) == ')') {
                niveauParentheses--;
                if (niveauParentheses == 0) {
                    return i == expr.length() - 1;
                }
            }
        }

        return false;
    }
}
