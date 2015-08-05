package com.jack.android.util;

import android.util.*;


public class LogUtil {
	
	public static String TAG = "COM.JACK.APP";
	
	public static void d (String text) {
		Log.d(TAG, text);
	}
	
	
	public static void e (Exception e) {
		Log.d(TAG, "", e);
	}
	
}