package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.logging.Logger;

public class MainActivity2 extends AppCompatActivity {
    // 안드로이드 클래스 샘플용
    class JsObject {
        @JavascriptInterface // 젤리빈 이상인 경우 추가
        public void sampleAction(String str) {
            System.out.println("HTML / JS ==> Android Webview로 데이터 전송 : " + str);
        }
    }


    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        wv=findViewById(R.id.wv);
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

        //웹뷰가 보여줄 웹문서 (.html) 로드하기
        //하이브리드앱은 오프라인에서도 동작해야 하므로
        //웹문서가 이 프로젝트 안에 위치해야함
//        wv.loadUrl("file:///android_asset/index.html"); //에셋 주소 : /android_asset
        wv.loadUrl("file:///android_asset/html2canvas/index.html"); //에셋 주소 : /android_asset
        
        // html / JS ==> Android WebView 코드
        // JS 허용
        wv.getSettings().setJavaScriptEnabled(true);
        // JS의 window.open 허용
        wv.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        // JS 인터페이스 등록 (클래스)
        wv.addJavascriptInterface(new JsObject(), "sampleAndroid");
        
        // 참조 : https://machine-woong.tistory.com/451
        // Android WebView ==> HTML / JS
        // JS 허용
        wv.getSettings().setJavaScriptEnabled(true);
        // JS 호출
        wv.loadUrl("javascript:getCall()");

        // Android Activity에서 데이터 받기
        // html에서 보내준 데이터 받을 시
        Intent intent = getIntent();

//        System.out.println(getIntent());

        String TAG = "MyActivity : ";
//        Log.i(TAG, intent.getDataString());

        boolean b;
        if (intent.getData() == null) {
            b = true;
        } else {
            b = false;
        }

        System.out.println(TAG + b);

//        // scheme 확인
//        if(intent.getData().getScheme().equals("something")) {
////            System.out.println("스키마 확인");
//        }
//
//        // host 확인
//        if(intent.getData().getAuthority().equalsIgnoreCase("project.example.com")) {
////            System.out.println("호스트 확인");
//        }
//
//        // 데이터 받기
//        String url = intent.getData().getQueryParameter("url"); // 결과 : http:/google.co.kr
//        String data = intent.getData().getQueryParameter("data"); // 결과 : 0
    }

    //    뒤로가기 버튼 눌렀을 때 웹뷰의 페이지가 돌아가기 페이지가 있다면
//    페이지를 되돌리도록
    @Override
    public void onBackPressed() {

        if(wv.canGoBack()) wv.goBack();
        else super.onBackPressed();
    }
}
