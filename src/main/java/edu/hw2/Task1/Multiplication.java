package edu.hw2.Task1;

record Multiplication(Expr multiplier1, Expr multiplier2) implements Expr {
    Multiplication(Expr multiplier1, double multiplier2) {
        this(multiplier1, new Constant(multiplier2));
    }

    Multiplication(double multiplier1, Expr multiplier2) {
        this(new Constant(multiplier1), multiplier2);
    }

    Multiplication(double multiplier1, double multiplier2) {
        this(new Constant(multiplier1), new Constant(multiplier2));
    }

    public double evaluate() {
        return multiplier1.evaluate() * multiplier2.evaluate();
    }
}
