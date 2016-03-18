package com.company.project.Pattern.Facade;

import android.content.Context;

/**
 * Created by Jacky on 2016/3/16.
 */
public class Tools {
    // Tool : Translation Density-independent Pixels to Pixels.
    public static float dp2px(float _value, Context _context) {
        return ((_value * _context.getResources().getDisplayMetrics().densityDpi) / 160);
    }

    // Tool : Translation Pixels to Density-independent Pixels.
    public static float px2dp(float _value, Context _context) {
        return ((_value * 160) / _context.getResources().getDisplayMetrics().densityDpi);
    }
}
