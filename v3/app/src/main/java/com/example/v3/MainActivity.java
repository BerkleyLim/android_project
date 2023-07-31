package com.example.v3;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

// 참고 : https://tae-hui.tistory.com/entry/WebViewAndroidStudio-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-WebView-%EC%B9%B4%EB%A9%94%EB%9D%BC-%EB%B0%8F-%EC%82%AC%EC%A7%84-%EC%97%85%EB%A1%9C%EB%93%9C-%ED%8D%BC%EB%AF%B8%EC%85%98
public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private WebSettings webSettings;
    private long time = 0;

    public ValueCallback<Uri> filePathCallbackNormal;
    public ValueCallback<Uri[]> filePathCallbackLolipop;
    public final static int FILECHOOSER_NORMAL_REQ_CODE = 2001;
    public final static int FILECHOOSER_LOLIPOP_REQ_CODE = 2002;
    private Uri cameraImageUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // webview 함수 호출
        webView = (WebView) findViewById(R.id.webViewIndex);

        webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);

        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("file:///android_asset/html/index.html");
        webView.addJavascriptInterface(new JavaScriptFunction(this), "Android");
    }
}