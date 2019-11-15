package com.iftalab.toolbox;

import android.content.Context;

/**
 * @author Ifta on 10/25/2017.
 */

public class AppContext {
    private static AppContext appContext;
    private Context context;
    private String name;
    public static AppContext getAccess(){
        if(appContext == null){
            appContext = new AppContext();
        }
        return appContext;
    }

    public Context getContext(){
        return context;
    }

    public String getName() {
        return name;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setName(String name) {
        this.name = name;
    }
}
