package team.uptech.motionviews.utils;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

public class FontProvider {

    private final Map<String, Typeface> typefaces = new HashMap<>();
    private final Resources resources;

    public FontProvider(Resources resources) {
        this.resources = resources;
    }

    public Typeface getTypeface(@Nullable String typefaceName) {
        if (TextUtils.isEmpty(typefaceName)) {
            return Typeface.DEFAULT;
        } else {
            //noinspection Java8CollectionsApi
            if (typefaces.get(typefaceName) == null) {
                typefaces.put(typefaceName,
                        Typeface.createFromAsset(resources.getAssets(), "fonts/" + typefaceName));
            }
            return typefaces.get(typefaceName);
        }
    }
}