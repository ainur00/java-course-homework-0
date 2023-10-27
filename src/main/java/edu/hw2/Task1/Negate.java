package edu.hw2.Task1;

record Negate(Expr value) implements Expr {
    Negate(double value) {
        this(new Constant(value));
    }

    public double evaluate() {
        return -value.evaluate();
    }
}
