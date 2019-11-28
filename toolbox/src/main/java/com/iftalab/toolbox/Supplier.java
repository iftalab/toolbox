package com.iftalab.toolbox;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;

import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;

public class Supplier {
    private static Resources resources;

    public static void initizlize(Context context) {
        resources = context.getResources();
    }

    public static String getString(@StringRes int stringResourceId) {
        return resources.getString(stringResourceId);
    }

    @SuppressWarnings("deprecation")
    public static int getColor(@ColorRes int colorResourceId, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return resources.getColor(colorResourceId, theme);
        } else {
            return resources.getColor(colorResourceId);
        }
    }
}
