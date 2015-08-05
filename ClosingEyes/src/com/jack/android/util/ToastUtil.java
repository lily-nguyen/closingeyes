package com.jack.android.util;

import android.content.*;
import android.widget.*;


public class ToastUtil {
	
	public static void showText (Context context, String text) {
		Toast.makeText(context, text, Toast.LENGTH_LONG).show();
	}
	
}