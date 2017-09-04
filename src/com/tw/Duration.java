package com.tw;

//Represents the time during which something continues
class Duration {

    private int value;
    private int baseValue;
    private String representation;

    Duration(int value, int conversionFactor, String representation) {
        this.value = value;
        this.baseValue = this.value * conversionFactor;
        this.representation = representation;
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

}
