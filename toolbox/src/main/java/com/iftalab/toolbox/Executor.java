/*
 *  Created by Ifta on 8/8/18 11:05 AM
 *  Copyright (c) 2018 . ALL rights reserved.
 *  Last modified 8/8/18 10:43 AM
 *
 */

package com.iftalab.toolbox;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Ifta
 */
public class Executor {
    private static volatile ExecutorService executorService;
    private static void prepare(){

        if(executorService==null || executorService.isShutdown()) {
            synchronized (ExecutorService.class) {
                if(executorService==null || executorService.isShutdown()) {
                    executorService = Executors.newFixedThreadPool(5);
                }
            }
        }
    }
    public static void destroy(){
        if(executorService!=null && !executorService.isShutdown()) {
            executorService.shutdown();
        }
    }

    public static void ex(Runnable runnable){
        prepare();
        executorService.execute(runnable);
    }

}
