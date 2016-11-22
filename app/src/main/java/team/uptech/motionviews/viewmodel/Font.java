package team.uptech.motionviews.viewmodel;

import java.io.Serializable;

public class Font implements Serializable {

    private static final float MIN_FONT_SIZE = 0.01F;

    private int color;
    private String face;
    private float size;

    public Font() {
    }

    public void increaseSize(float diff) {
        size = size + diff;
    }

    public void decreaseSize(float diff) {
        if (size - diff >= MIN_FONT_SIZE) {
            size = size - diff;
        }
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }
}