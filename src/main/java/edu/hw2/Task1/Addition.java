package edu.hw2.Task1;

record Addition(Expr summand1, Expr summand2) implements Expr {
    Addition(Expr summand1, double summand2) {
        this(summand1, new Constant(summand2));
    }

    Addition(double summand1, Expr summand2) {
        this(new Constant(summand1), summand2);
    }

    Addition(double summand1, double summand2) {
        this(new Constant(summand1), new Constant(summand2));
    }

    public double evaluate() {
        return summand1.evaluate() + summand2.evaluate();
    }
}
