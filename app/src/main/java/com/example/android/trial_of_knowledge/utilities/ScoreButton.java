package com.example.android.trial_of_knowledge.utilities;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Helper class, extending Button. Defines helper methods for the ScoreActivity's buttons
 */
public class ScoreButton extends android.support.v7.widget.AppCompatButton {

    private static final int HEIGHT = 60;

    // Constructor overrides
    public ScoreButton(Context context) {
        super(context);
    }

    public ScoreButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScoreButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Sets Button background color according to input param
     *
     * @param questionIsAnswered true if used answered the question correctly
     */
    public void style(boolean questionIsAnswered) {
        Drawable drawable =  this.getBackground();
        int colorId;
        if (questionIsAnswered) {
            colorId = Color.GREEN;
        } else {
            colorId = Color.RED;
        }

        drawable.setColorFilter(new
                PorterDuffColorFilter(colorId, PorterDuff.Mode.MULTIPLY));
    }

    /**
     * Helper function to set density-independent margins.
     *
     * @param left in pixels
     * @param top in pixels
     * @param right in pixels
     * @param bottom in pixels
     * @param pixelDensity device's pixel density
     */
    public void setMargins(int left, int top, int right, int bottom, float pixelDensity) {
        left = (int)( (float) left * pixelDensity);
        right = (int) ((float) right * pixelDensity);
        top = (int) ((float) top * pixelDensity);
        bottom = (int) ((float) bottom * pixelDensity);
        int height = (int)(HEIGHT * pixelDensity);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        height);
        params.setMargins(left, top, right, bottom);
        this.setLayoutParams(params);
    }

}
