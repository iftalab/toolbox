package com.iftalab.toolbox;


import android.os.Handler;
import android.os.Looper;

public class HandlerServer {
    private static volatile Handler handler;
    private static Handler uiHandler;
    static {
        initialize();
    }
    public static void initialize() {
        Executor.ex(() -> {
            Looper.prepare();
            handler = new Handler();
            Looper.loop();
        });
    }

    public static Handler getNonUiHandler() {
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
