package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // webview 함수 호출
        WebView webView = (WebView) findViewById(R.id.webViewIndex);

        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);

//        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("file:///android_asset/html/index.html");
        webView.addJavascriptInterface(new JavaScriptFunction(this), "Android");
    }

//    public void init() {
//        WebSettings settings = getSettings();
//        // Javascript 사용하기
//        settings.setJavaScriptEnabled(true);
//        // WebView 내장 줌 사용여부
//        settings.setBuiltInZoomControls(true);
//        // 화면에 맞게 WebView 사이즈를 정의
//        settings.setLoadWithOverviewMode(true);
//        // ViewPort meta tag를 활성화 여부
//        settings.setUseWideViewPort(true);
//        // 줌 컨트롤 사용 여부
//        settings.setDisplayZoomControls(false);
//        // 사용자 제스처를 통한 줌 기능 활성화 여부
//        settings.setSupportZoom(false);
//        // TextEncoding 이름 정의
//        settings.setDefaultTextEncodingName("UTF-8");
//
//        // Setting Local Storage
//        settings.setDatabaseEnabled(true);
//        settings.setDomStorageEnabled(true);
//
//        // 캐쉬 사용 방법을 정의
//        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
//    }
}