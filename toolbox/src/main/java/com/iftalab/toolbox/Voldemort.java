package com.iftalab.toolbox;

import android.util.Log;

import java.util.HashMap;

/**
 * @author Ifta
 *         on 3/16/2017.
 */

public class Voldemort {
    private static final String LOG_TAG = "voldemort";
    private static HashMap<String, Integer> counter = new HashMap<>();
    public static void youKnowWho(String me) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for ( int i = 0 ; i < stackTraceElements.length;i++) {
            StackTraceElement element = stackTraceElements[i];
            if(element.toString().contains(me)) {
                if(counter.containsKey(me)) {
                    counter.put(me, counter.get(me)+1);
                }else {
                    counter.put(me,1);
                }
                if((i+1)<stackTraceElements.length) {
                    String data = stackTraceElements[i+1].toString();
                    if(data.contains("(")) {
                        data = data.substring(data.indexOf('('));
                        data = data.substring(1,data.indexOf('.'));
                        if(counter.containsKey(data)) {
                            counter.put(data, counter.get(data)+1);
                        }else {
                            counter.put(data,1);
                        }
                    }

                }
                break;
            }
        }
    }

    public static void horcrux() {
        for(String key: counter.keySet()){
            Log.i(LOG_TAG,key+" : "+counter.get(key));
        }
    }

    public static String avrakaDavra() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("------------------------------------------------");
        stringBuilder.append("\n");
        for(StackTraceElement element : stackTraceElements)
        {
            stringBuilder.append(element.toString());
            stringBuilder.append("\n");
        }
        Log.i(LOG_TAG,stringBuilder.toString());
        return stringBuilder.toString();
    }
    public static void peepIntoMySoul(){
        Log.i(LOG_TAG, Long.toHexString(Thread.currentThread().getId()));
    }
}
