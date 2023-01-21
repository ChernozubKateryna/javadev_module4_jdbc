package com.goit.feature.utils;

public class LongestProject {
    private int name;
    private int monthCount;

    public void setName(int name) {
        this.name = name;
    }

    public void setMonthCount(int monthCount) {
        this.monthCount = monthCount;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "name=" + name +
                ", monthCount=" + monthCount +
                '}';
    }
}
