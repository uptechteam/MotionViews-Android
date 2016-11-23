package team.uptech.motionviews.viewmodel;

public class Font {

    /**
     * color value (ex: 0xFF00FF)
     */
    private int color;
    /**
     * name of the font
     */
    private String face;
    /**
     * size of the font, relative to parent
     */
    private float size;

    public Font() {
    }

    public void increaseSize(float diff) {
        size = size + diff;
    }

    public void decreaseSize(float diff) {
        if (size - diff >= Limits.MIN_FONT_SIZE) {
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

    private interface Limits {
        float MIN_FONT_SIZE = 0.01F;
    }
}