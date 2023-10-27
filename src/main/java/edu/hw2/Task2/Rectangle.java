package edu.hw2.Task2;

class Rectangle {
    Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    private final double height;

    private final double width;

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getArea() {
        return height * width;
    }
}
