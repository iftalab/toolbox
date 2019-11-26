package com.iftalab.toolbox;

import android.content.Context;
import android.util.DisplayMetrics;

public class Converter {
    public static class Unit{
        public static float convertDpToPixel(float dp, Context context){
            return dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        }
        public static float convertPixelsToDp(float px, Context context){
            return px / ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        }
    }
}
