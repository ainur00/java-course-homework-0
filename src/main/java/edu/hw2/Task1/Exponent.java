package edu.hw2.Task1;

record Exponent(Expr base, Expr exponent) implements Expr {
    Exponent(Expr base, double exponent) {
        this(base, new Constant(exponent));
    }

    Exponent(double base, Expr exponent) {
        this(new Constant(base), exponent);
    }

    Exponent(double base, double exponent) {
        this(new Constant(base), new Constant(exponent));
    }

    public double evaluate() {
        return Math.pow(base.evaluate(), exponent.evaluate());
    }
}
