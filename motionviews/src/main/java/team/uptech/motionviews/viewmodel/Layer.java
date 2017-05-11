package team.uptech.motionviews.viewmodel;

import android.support.annotation.FloatRange;

public class Layer {

    /**
     * rotation relative to the layer center, in degrees
     */
    @FloatRange(from = 0.0F, to = 360.0F)
    private float rotationInDegrees;

    private float scale;
    /**
     * top left X coordinate, relative to parent canvas
     */
    private float x;
    /**
     * top left Y coordinate, relative to parent canvas
     */
    private float y;
    /**
     * is layer flipped horizontally (by X-coordinate)
     */
    private boolean isFlipped;

    public Layer() {
        reset();
    }

    protected void reset() {
        this.rotationInDegrees = 0.0F;
        this.scale = 1.0F;
        this.isFlipped = false;
        this.x = 0.0F;
        this.y = 0.0F;
    }

    public void postScale(float scaleDiff) {
        float newVal = scale + scaleDiff;
        if (newVal >= getMinScale() && newVal <= getMaxScale()) {
            scale = newVal;
        }
    }

    protected float getMaxScale() {
        return Limits.MAX_SCALE;
    }

    protected float getMinScale() {
        return Limits.MIN_SCALE;
    }

    public void postRotate(float rotationInDegreesDiff) {
        this.rotationInDegrees += rotationInDegreesDiff;
        this.rotationInDegrees %= 360.0F;
    }

    public void postTranslate(float dx, float dy) {
        this.x += dx;
        this.y += dy;
    }

    public void flip() {
        this.isFlipped = !isFlipped;
    }

    public float initialScale() {
        return Limits.INITIAL_ENTITY_SCALE;
    }

    public float getRotationInDegrees() {
        return rotationInDegrees;
    }

    public void setRotationInDegrees(@FloatRange(from = 0.0, to = 360.0) float rotationInDegrees) {
        this.rotationInDegrees = rotationInDegrees;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public void setFlipped(boolean flipped) {
        isFlipped = flipped;
    }

    interface Limits {
        float MIN_SCALE = 0.06F;
        float MAX_SCALE = 4.0F;
        float INITIAL_ENTITY_SCALE = 0.4F;
    }
}
