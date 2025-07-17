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

    public double getLength() {
        return this.to - this.from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public void printRange() {
        System.out.println("от " + this.from + " до " + this.to);
    }

    public Range getIntersection(Range range) {
        Range intersection = new Range(this.from, this.to);

        if (range.from >= this.to || this.from >= range.to) {
            intersection = null;
        } else {
            if (this.from < range.from) {
                intersection.from = range.from;
            }

            if (this.to > range.to) {
                intersection.to = range.to;
            }
        }

        return intersection;
    }

    public Range[] getUnion(Range range) {
        Range[] union = new Range[2];

        if (range.from > this.to || this.from > range.to) {
            union[0] = new Range(this.from, this.to);
            union[1] = new Range(range.from, range.to);
        } else {
            union[0] = new Range(from, to);
            union[1] = null;

            if (this.from > range.from) {
                union[0].from = range.from;
            }

            if (this.to < range.to) {
                union[0].to = range.to;
            }
        }

        return union;
    }

    public Range[] getSubtraction(Range range) {
        Range[] subtraction = {null, null};

        if (range.from >= this.to || this.from >= range.to) {
            subtraction[0] = new Range(this.from, this.to);
        } else {
            if (this.from < range.from && this.to < range.to) {
                subtraction[0] = new Range(this.from, range.from);
            }

            if (this.from > range.from && this.to > range.to) {
                subtraction[0] = new Range(range.to, this.to);
            }

            if (this.from < range.from && this.to > range.to) {
                subtraction[0] = new Range(this.from, range.from);
                subtraction[1] = new Range(range.to, this.to);
            }
        }

        return subtraction;
    }
}