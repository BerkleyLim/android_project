package com.example.webview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView mWebView;
    private static final String ENTRY_URL = "file:///android_asset/www/index.html";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // activity_main.xml엣생성한 Webview와 연결
        mWebView = (WebView) findViewById(R.id.activity_main_webview);
        
        WebSettings webSettings = mWebView.getSettings();
        // javascript 실행 가능하게 한다.
        webSettings.setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient() {
            // 새창을 띄우지 않게 한다
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                // 여기서 WebView의 데이터를 가져오는 작업을 한다.
                if (url.equals(ENTRY_URL)) {
                    String keyword = "tistory";

                    String script = "javascript:function afterLoad() {"
                            + "document.getElementById('keyword').value = '" + keyword + "';"
                            + "document.forms[0].setAttribute('onsubmit', 'window.Zeany.justDoIt(elements[0].value); return true;');"
                            + "};"
                            + "afterLoad();";

                    view.loadUrl(script);
                }
            }
        });

        // webChromeClient() 인스턴스 생성 후 setWebChromeClient() 메소드를 통해 등록
        // Alert 나 Confirm 발생 시 해당 내용을 AlertDialog로 처리하도록 구현
        //  mWebView.setWebChromeClient(new WebChromeClient() {}); 만으로도 가능
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                new AlertDialog.Builder(view.getContext())
                        .setTitle("Alert")
                        .setMessage(message)
                        .setPositiveButton(android.R.string.ok,
                                new AlertDialog.OnClickListener(){
                                    public void onClick(DialogInterface dialog, int which) {
                                        result.confirm();
                                    }
                                })
                        .setCancelable(false)
                        .create()
                        .show();
                return true;
            }

            @Override
            public boolean onJsConfirm(WebView view, String url, String message,
                                       final JsResult result) {
                new AlertDialog.Builder(view.getContext())
                        .setTitle("Confirm")
                        .setMessage(message)
                        .setPositiveButton("Yes",
                                new AlertDialog.OnClickListener(){
                                    public void onClick(DialogInterface dialog, int which) {
                                        result.confirm();
                                    }
                                })
                        .setNegativeButton("No",
                                new AlertDialog.OnClickListener(){
                                    public void onClick(DialogInterface dialog, int which) {
                                        result.cancel();
                                    }
                                })
                        .setCancelable(false)
                        .create()
                        .show();
                return true;
            }
        });

        mWebView.addJavascriptInterface(new Object() {
            @JavascriptInterface
            public void justDoIt(String keyword) {
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        }, "Zeany");


//        mWebView.loadUrl("https://zeany.tistory.com");
//        mWebView.loadUrl("file:///android_asset/www/index.html");
        mWebView.loadUrl(ENTRY_URL);
    }

    // 이전 페이지 있을 시 그 페이지로 이동 하게 함
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mWebView.canGoBack()) {
                mWebView.goBack();
                return false;
            }
        }

        return super.onKeyDown(keyCode, event);
    }
}