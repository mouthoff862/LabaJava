package com.laba.animal;

public class AviaryOne {
    private String nameAviary;
    private int maxHeight;
    private int maxWidth;

    public AviaryOne(String nameAviary) {
        this.nameAviary = nameAviary;
    }

    public AviaryOne(int maxHeight, int maxWidth) {
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;
    }

    public void setNameAviary(String nameAviary) {
        this.nameAviary = nameAviary;
    }

    public String getNameAviary() {
        return nameAviary;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    public int getMaxWidth() {
        return maxWidth;
    }
}