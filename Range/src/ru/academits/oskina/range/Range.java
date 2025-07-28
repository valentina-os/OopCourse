package ru.academits.oskina.range;

import static java.lang.Math.max;
import static java.lang.Math.min;

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
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    @Override
    public String toString() {
        return "от " + from + " до " + to;
    }

    public Range getIntersection(Range range) {
        if (range.from >= to || from >= range.to) {
            return null;
        } else {
            return new Range(max(from, range.from), min(to, range.to));
        }
    }

    public Range[] getUnion(Range range) {
        if (range.from > to || from > range.to) {
            return new Range[]{this, range};
        } else {
            return new Range[]{new Range(min(from, range.from), max(to, range.to))};
        }
    }

    public Range[] getDifference(Range range) {
        if (range.from >= to || from >= range.to) {
            return new Range[]{this};
        } else {
            if (from < range.from && to < range.to) {
                return new Range[]{new Range(from, range.from)};
            } else if (from > range.from && to > range.to) {
                return new Range[]{new Range(range.to, to)};
            } else if (from < range.from && to > range.to) {
                return new Range[]{new Range(from, range.from), new Range(range.to, to)};
            } else {
                return new Range[]{};
            }
        }
    }
}