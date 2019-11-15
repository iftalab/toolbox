package com.iftalab.toolbox;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Set;

/**
 * @author Ifta
 */

public class I {
    private static IftaLabBuilder iftaLabBuilder = null;
    private static String LOG_TAG;
    private static LogLevel LOG_LEVEL;
    private static WeakReference<Context> contextWeakReference;

    //==================================BUILDER CODES===============================================
    public static IftaLabBuilder getBuilder(Context context) {
        if (I.iftaLabBuilder == null) {
            iftaLabBuilder = new IftaLabBuilder(context);
        }
        return iftaLabBuilder;
    }

    public static void destroy() {
        iftaLabBuilder = null;
        contextWeakReference = null;
    }

    public static void log(Set<String> strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for(String s : strings){
            stringBuilder.append(s);
            stringBuilder.append("\n");
        }
        I.log(stringBuilder.toString());
    }

    public static void err(String error) {
        if(error == null){
            Log.e(LOG_TAG, "The error is itself null");
        }else {
            Log.e(LOG_TAG, error);
        }
    }
    public static void err(Exception e) {
        if(e == null){
            Log.e(LOG_TAG, "The error is itself null");
        }else {
            Log.e(LOG_TAG, e.getLocalizedMessage());
        }
    }
    public static void errTrace(Exception e) {
        if(e == null){
            Log.e(LOG_TAG, "The error is itself null");
        }else {
            Log.e(LOG_TAG, e.getLocalizedMessage());
        }
    }
    public static void avrakaDavra() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("------------------------------------------------");
        stringBuilder.append("\n");
        for(StackTraceElement element : stackTraceElements)
        {
            stringBuilder.append(element.toString());
            stringBuilder.append("\n");
        }
        Log.e(LOG_TAG,stringBuilder.toString());
    }

    public static void log(Object o) {
        log(o.toString());
    }

    public static class IftaLabBuilder {
        private String logTag = "IftaLog";
        private LogLevel logLevel = LogLevel.DEBUG;
        private Context context;

        public IftaLabBuilder(Context context) {
            this.context = context;
        }

        public IftaLabBuilder logLevel(LogLevel logLevel) {
            this.logLevel = logLevel;
            return this;
        }

        public IftaLabBuilder logTag(String logTag) {
            this.logTag = logTag;
            return this;
        }

        public void build() {
            new I(context, logTag, logLevel);
        }
    }

    private I(Context context, String logTag, LogLevel loglevel) {
        I.contextWeakReference = new WeakReference<Context>(context);
        LOG_TAG = logTag;
        LOG_LEVEL = loglevel;
    }
    //==================================BUILDER CODES END===========================================


    //==================================VARIABLES===================================================


    public enum LogLevel {
        VERBOSE, DEBUG, INFO, WARN, ERROR
    }
    //==================================VARIABLES END===============================================


    //==================================TOAST=======================================================
    public static void toast(boolean bool) {
        Toast.makeText(contextWeakReference.get(), Boolean.toString(bool), Toast.LENGTH_SHORT).show();
    }

    public static void toast(int integer) {
        Toast.makeText(contextWeakReference.get(), Integer.toString(integer), Toast.LENGTH_SHORT).show();
    }

    public static void toast(String message) {
        Toast.makeText(contextWeakReference.get(), message, Toast.LENGTH_SHORT).show();
    }

    public static void tooooooast(String message) {
        Toast.makeText(contextWeakReference.get(), message, Toast.LENGTH_LONG).show();
    }


    public static void toast(String message, boolean isLong) {
        if (isLong) {
            Toast.makeText(contextWeakReference.get(), message, Toast.LENGTH_LONG).show();
        } else {
            I.toast(message);
        }
    }
    //==================================TOAST CODE END =============================================


    //==================================LOG CODE ===================================================
    public static void log(int integer) {
        log(Integer.toString(integer));
    }

    public static void log(float f) {
        log(Float.toString(f));
    }

    public static void log(boolean bool) {
        log(Boolean.toString(bool));
    }

    public static void log(String[] array) {
        if (array == null) {
            log("NULL array");
            return;
        }
        if (array.length == 0) {
            log("Empty array");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(i);
            sb.append(" : ");
            sb.append(array[i]);
            sb.append("\n");
        }
        log(sb.toString());
    }

    public static void log(Bundle bundle) {
        StringBuilder stringBuilder = new StringBuilder();
        if (bundle != null) {
            for (String key : bundle.keySet()) {
                Object value = bundle.get(key);
                stringBuilder.append(String.format("%s : %s", key, value== null ? "null value in bundle":value.toString()));
            }
            log(stringBuilder.toString());
        } else {
            log("bundle is null");
        }
    }

    public static void log(ArrayList<String> list) {
        if (list == null) {
            log("NULL list");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(i);
            sb.append(" : ");
            sb.append(list.get(i));
            sb.append("\n");
        }
        log(sb.toString());
    }

    public static void log(Cursor cursor) {
        if (cursor == null) {
            log("NULL cursor");
            return;
        }
        log(DatabaseUtils.dumpCursorToString(cursor));
    }

    public static void log(String message) {
        if (message == null) {
            message = "NULL";
        }
        switch (LOG_LEVEL) {
            case VERBOSE:
                Log.v(LOG_TAG, message);
                break;
            case DEBUG:
                Log.d(LOG_TAG, message);
                break;
            case INFO:
                Log.i(LOG_TAG, message);
                break;
            case WARN:
                Log.w(LOG_TAG, message);
                break;
            case ERROR:
                Log.e(LOG_TAG, message);
                break;
            default:
                Log.d(LOG_TAG, message);
                break;
        }
    }
    //==================================LOG CODE END================================================

    //====================================== KEY BOARD==============================================
    public static void toggleKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }
}
