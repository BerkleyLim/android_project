package com.example.v3;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

public class JavaScriptFunction{
    Context context;
    WebView webView;
    public JavaScriptFunction(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public String webViewJSTest(String string) {
        Log.i("JS 통신 : ", string);
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
        return "Native Data 받기";
    }

    @JavascriptInterface
    public void callCamera() {
        Log.i("JS 통신 : ", "성공");
        try {
            Intent i = new Intent(context.getApplicationContext(), CameraActivity.class);
            context.startActivity(i);
        } catch (Exception e) {
            Log.d("Camera : ", e.toString());
        }
    }


}

