package ru.academits.oskina.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getRangeLength(Range range) {
        return range.to - range.from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }
}