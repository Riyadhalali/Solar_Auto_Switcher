package com.example.solarautoswitcher;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

public class Utils {

    //-> this method to make toast message from anywhere in the system
    public static void showToast(Context context, String message)
    {

        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }

}
