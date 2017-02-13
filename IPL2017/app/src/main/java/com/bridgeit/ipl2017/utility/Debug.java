package com.bridgeit.ipl2017.utility;

import android.util.Log;

/**
 * Created by bridgeit on 11/2/17.
 */

public class Debug {
    static boolean isDebuggable = true;
    public static void showLog(String tag,String message){
        if(isDebuggable){
            Log.i(tag, "showLog: "+message);
        }
    }
}
