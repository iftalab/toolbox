package com.iftalab.toolbox;


import android.os.Handler;
import android.os.Looper;

public class HandlerServer {
    private static Handler handler;
    private static Handler uiHandler;

    public static Handler getHandler() {
        if (handler == null) {
            handler = new Handler();
        }
        return handler;
    }

    public static Handler getUiHandler() {
        if (uiHandler == null) {
            uiHandler = new Handler(Looper.getMainLooper());
        }
        return uiHandler;
    }
}
