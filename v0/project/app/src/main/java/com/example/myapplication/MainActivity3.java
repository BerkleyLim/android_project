package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    // 안드로이드 클래스 샘플용
    class JsObject {
        @JavascriptInterface // 젤리빈 이상인 경우 추가
        public void test() {
//            System.out.println("HTML / JS ==> Android Webview로 데이터 전송 : ");
                Intent mintent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
                startActivity(mintent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        WebView wv=findViewById(R.id.wv);
//        setContentView(wv);

        //기본적으로 웹뷰는 Javascript 실행을 허용하지 않도록 설정되어 있음.
        //웹뷰의 설정을 통해 JS 사용을 허용하도록 변경
        //웹의 설정객체를 얻어오기
        WebSettings settings=wv.getSettings();
        settings.setJavaScriptEnabled(true);

        //2가지 반드시 해야할 설정
        //1. 웹문서가 열릴때 기본적으로 내 WebView가 아니라 새로운 웹뷰를 열어주는 방식을 사용함.
        //그래서 현재의 WebView안에 웹문서가 열리도록 설정
        wv.setWebViewClient(new WebViewClient());
        //2. alert(), comfirm() 같은 팝업기능의 JS코드가 사용가능하도록하는 코드 필요
        wv.setWebChromeClient(new WebChromeClient());

        wv.loadUrl("file:///android_asset/galleryButton/index.html"); //에셋 주소 : /android_asset

        // html / JS ==> Android WebView 코드
        // JS 허용
        wv.getSettings().setJavaScriptEnabled(true);
        // JS의 window.open 허용
        wv.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        // JS 인터페이스 등록 (클래스)
        wv.addJavascriptInterface(new MainActivity3.JsObject(), "sampleAndroid");

//        Button button = (Button)findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // 갤러리 열기
//                Intent mintent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
//                startActivity(mintent);
//            }
//        });
    }
}
