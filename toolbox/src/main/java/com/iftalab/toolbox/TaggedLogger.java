package com.iftalab.toolbox;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.util.Log;

import java.util.Map;

/**
 * @author Ifta on 9/12/2017.
 */

public class TaggedLogger {
    private String logTag = "iftaLog";

    public TaggedLogger(String logTag) {
        this.logTag = logTag;
    }

    public void log(String data) {
        if (data != null) {
            Log.i(logTag, data);
        } else {
            Log.i(logTag, "no data send on logger");
        }
    }

    public void log(Cursor cursor) {
        if (cursor == null) {
            Log.i(logTag, "NULL cursor");
            return;
        }
        try {
            log(DatabaseUtils.dumpCursorToString(cursor));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void error(String data) {
        if (data != null) {
            Log.e(logTag, data);
        } else {
            Log.e(logTag, "No error message found");
        }
    }

    public void error(Exception e) {
        if (e != null && e.getLocalizedMessage()!=null) {
            Log.e(logTag, e.getLocalizedMessage());
        } else {
            Log.e(logTag, "No error message found");
        }
    }

    public void log(String[] array) {
        if (array != null) {
            log(">>");
            for (String s : array) {
                log(s);
            }
            log("<<");
        }
    }

    public void log(Map<String, String> data) {
        log(data.toString());
    }
}
