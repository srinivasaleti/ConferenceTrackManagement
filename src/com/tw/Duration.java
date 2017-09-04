package com.tw;

//Represents the time during which something continues
class Duration {

    private static final String MINUTE = "Minutes";
    private static final String LIGHTNING = "Lightnings";
    private static final String SPACE = " ";

    private static final String HOUR = "HOUR";
    private static final int HOUR_TO_MINUTE_CONVERSION_FACTOR = 60;
    private static final int MINUTE_TO_MINUTE_CONVERSION_FACTOR = 1;
    private static final int LIGHTNING_TO_MINUTE_CONVERSION_FACTOR = 5;

    private int value;
    private int baseValue;
    private String unitName;

    Duration(int value, int conversionFactor, String representation) {
        this.value = value;
        this.baseValue = this.value * conversionFactor;
        this.unitName = representation;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        if (this == object) {
            return true;
        }
        Duration that = (Duration) object;
        return this.baseValue == that.baseValue;
    }

    static Duration minute(int value) {
        return new Duration(value, MINUTE_TO_MINUTE_CONVERSION_FACTOR, MINUTE);
    }

    static Duration lightning(int value) {
        return new Duration(value, LIGHTNING_TO_MINUTE_CONVERSION_FACTOR, LIGHTNING);
    }

    static Duration hour(int value) {
        return new Duration(value, HOUR_TO_MINUTE_CONVERSION_FACTOR, HOUR);
    }

    boolean isMoreThanOrEqualOf(Duration duration) {
        return this.baseValue >= duration.baseValue;
    }

    int baseValue() {
        return this.baseValue;
    }

    String representation() {
        return this.value + SPACE + this.unitName;
    }

}
