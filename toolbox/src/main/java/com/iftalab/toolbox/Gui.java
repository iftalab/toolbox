/*
 *  Created by Ifta on 8/8/18 11:05 AM
 *  Copyright (c) 2018 . ALL rights reserved.
 *  Last modified 8/8/18 10:07 AM
 *
 */

package com.iftalab.toolbox;

import android.os.Handler;
import android.os.Looper;

public class Gui {
    private static volatile Gui access  = null;
    private Handler handler;
    public static Gui get(){
        if(access == null){
            synchronized (Gui.class){
                if(access == null){
                    access = new Gui();
                }
            }
        }
        return access;
    }

    private Gui() {
        if(handler == null){
            handler = new Handler(Looper.getMainLooper());
        }
    }
    public void run(Runnable runnable){
        handler.post(runnable);
    }
}
