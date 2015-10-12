package com.easy_binom.easybin;

import android.content.Intent;

public class ThemeChanger {
    private static int sTheme;
    public final static int THEME_DEFAULT = 0;
    public final static int THEME_SECOND = 1;

    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    public static void changeToTheme(BinomActivity activity, int theme) {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    /**
     * Set the theme of the activity, according to the configuration.
     */
    public static void onActivityCreateSetTheme(BinomActivity activity) {
        switch (sTheme) {
            default:
            case THEME_DEFAULT:
                activity.setTheme(R.style.AppThemeBase);
                break;
            case THEME_SECOND:
                activity.setTheme(R.style.AppThemeSecond);
                break;
        }
    }

    /**
     * Set the theme of the activity, according to the configuration.
     */
    public static void onActivityCreateSetTheme(NullActivity activity) {
        switch (sTheme) {
            default:
            case THEME_DEFAULT:
                activity.setTheme(R.style.AppThemeBase);
                break;
            case THEME_SECOND:
                activity.setTheme(R.style.AppThemeSecond);
                break;
        }
    }
}
