package com.example.webandnative;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
//    private static final String ENTRY_URL = "file:///android_asset/index.html";
    private static final String ENTRY_URL = "http://www.berkleylim.link/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.webview);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);



//        mWebView.setWebViewClient(new WebViewClient() {
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                // 여기서 WebView의 데이터를 가져오는 작업을 한다.
//                if (url.equals(ENTRY_URL)) {
//                    String keyword = "tistory";
//
//                    String script = "javascript:function afterLoad() {"
//                            + "document.getElementById('keyword').value = '" + keyword + "';"
//                            + "document.forms[0].setAttribute('onsubmit', 'window.Zeany.justDoIt(elements[0].value); return true;');"
//                            + "};"
//                            + "afterLoad();";
//
//                    view.loadUrl(script);
//                }
//                super.onPageFinished(view, url);
//            }
//        });

//        mWebView.addJavascriptInterface(new Object() {
//            @JavascriptInterface
//            public void justDoIt(String keyword) {
//                Toast.makeText(MainActivity.this, "Keyword is " + keyword, Toast.LENGTH_LONG).show();
//            }
//        }, "Zeany");
        mWebView.loadUrl(ENTRY_URL);
    }
}