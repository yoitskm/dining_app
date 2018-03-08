package mis.oblabs.com.takeorder.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {

    public static final String PREFS_NAME = "SESSION_PREFS";
    public static final String PREFS_KEY_SESSION_STATUS = "SESSION_IS_ACTIVE";
    public static final String PREFS_KEY_SESSION_ID = "SESSION_ID";

    public SharedPreference() {
        super();
    }

    public void saveSession(Context context, Boolean isActive) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2
        editor.putBoolean(PREFS_KEY_SESSION_STATUS, isActive); //3
        editor.commit(); //4
    }
    public void saveValueWithKey(Context context, String key , String value) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2
        editor.putString(key, value); //3
        editor.commit(); //4
    }
    public String getValueWithKey(Context context , String key) {
        SharedPreferences settings;
        String value;
        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        value = settings.getString(key, null);
        return value;
    }
    public int getIntWithKey(Context context , String key) {
        SharedPreferences settings;
        int  value;
        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        value = settings.getInt(key,0);
        return value;
    }
    public void saveIntWithKey(Context context, String key , int value) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2
        editor.putInt(key, value); //3
        editor.commit(); //4
    }
    public void saveSessionID(Context context, String sessionID) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2
        editor.putString(PREFS_KEY_SESSION_ID, sessionID); //3
        editor.commit(); //4
    }

    public Boolean getSession(Context context) {
        SharedPreferences settings;
        Boolean isActive;

        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        isActive = settings.getBoolean(PREFS_KEY_SESSION_STATUS, false);
        return isActive;
    }
    public String getSessionID(Context context) {
        SharedPreferences settings;
        String sessionID;

        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        sessionID = settings.getString(PREFS_KEY_SESSION_ID, null);
        return sessionID;
    }

    public void clearSharedPreference(Context context) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();

        editor.clear();
        editor.commit();
    }

    public void removeValueWithKey(Context context , String PREFS_KEY) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();

        editor.remove(PREFS_KEY);
        editor.commit();
    }

}
