package lbx.xskinlib.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author lbx
 * @date 2017/11/6.
 */

public class PreUtil {


    public static void putString(Context context, String key, String value) {
        SharedPreferences preferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        preferences.edit().putString(key, value).apply();
    }

    public static String getString(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        return preferences.getString(key, "");
    }

    public static void clear(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        preferences.edit().clear().apply();
    }
}
