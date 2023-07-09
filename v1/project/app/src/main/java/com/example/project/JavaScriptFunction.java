package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class JavaScriptFunction{
    Context context;
    public JavaScriptFunction(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public String webViewJSTest(String string) {
        Log.i("JS 통신 : ", string);
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
        
        
        return "Native Data 받기";
    }
}
