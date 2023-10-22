package edu.hw2.Task1;

record Constant(double value) implements Expr {
    public double evaluate() {
        return value;
    }
}
