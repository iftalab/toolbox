package com.iftalab.toolbox;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import static android.content.Context.MODE_PRIVATE;

/**
 * This class provide static access to app's shared preference data
 *
 * @author Ifta
 */

public class PreferenceDataManager {
    private static volatile SharedPreferences preference = null;

    public static void register(Context context) {
        preference = context.getSharedPreferences(context.getPackageName(), MODE_PRIVATE);
    }

    //=====================PUT============================
    public static void quickPut(String key, String value) {
        preference.edit().putString(key, value).apply();
    }

    public static void quickPut(String key, boolean value) {
        preference.edit().putBoolean(key, value).apply();
    }

    public static void quickPut(String key, int value) {
        preference.edit().putInt(key, value).apply();
    }

    public static void quickPut(String key, long value) {
        preference.edit().putLong(key, value).apply();
    }

    public static void quickPut(String key, float value) {
        preference.edit().putFloat(key, value).apply();
    }

    //=====================FORCE PUT============================
    @SuppressLint("ApplySharedPref")
    public static boolean forcePut(String key, String value) {
        return preference.edit().putString(key, value).commit();
    }

    @SuppressLint("ApplySharedPref")
    public static boolean forcePut(String key, boolean value) {
        return preference.edit().putBoolean(key, value).commit();
    }

    @SuppressLint("ApplySharedPref")
    public static boolean forcePut(String key, int value) {
        return preference.edit().putInt(key, value).commit();
    }

    @SuppressLint("ApplySharedPref")
    public static boolean forcePut(String key, long value) {
        return preference.edit().putLong(key, value).commit();
    }

    @SuppressLint("ApplySharedPref")
    public static boolean forcePut(String key, float value) {
        return preference.edit().putFloat(key, value).commit();
    }

    //================================================================
    //===========================GET==================================
    public static boolean quickGet(String key, boolean defaultValue) {
        return preference.getBoolean(key, defaultValue);
    }

    public static String quickGet(String key, String defaultValue) {
        return preference.getString(key, defaultValue);
    }

    public static int quickGet(String key, int defaultValue) {
        return preference.getInt(key, defaultValue);
    }

    public static float quickGet(String key, float defaultValue) {
        return preference.getFloat(key, defaultValue);
    }

    public static long quickGet(String key, long defaultValue) {
        return preference.getLong(key, defaultValue);
    }

    public static void quickRemove(String key) {
        preference.edit().remove(key).apply();
    }

    public static void clearAll() {
        preference.edit().clear().apply();
    }

    @SuppressLint("ApplySharedPref")
    public static boolean forceClearAll() {
        return preference.edit().clear().commit();
    }

    //===============================================================

}
