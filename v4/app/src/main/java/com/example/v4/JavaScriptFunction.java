package com.example.v4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

public class JavaScriptFunction {
    Context context;
    Activity activity;
    WebView webView;
    ImageView imageView;
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
    public void callGallery() {
        Log.i("JS 통신 : ", "성공");

//        Intent intent = new Intent(Intent.ACTION_PICK);
//        intent.setType("image/");
//
//        Bundle bundle = new Bundle();
//        bundle.putString("image","image");
//        intent.putExtra("bundle",bundle);
//        int PICK_FROM_ALBUM = 1;
////        activity.startActivityForResult(intent, 1);
//        context.startActivity(intent);
        Intent intent = new Intent(context.getApplicationContext(), GalleryActivity.class);
        context.startActivity(intent);

    }


}

