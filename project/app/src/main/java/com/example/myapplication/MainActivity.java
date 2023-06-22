package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // 버튼 정의
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // nextButton은 activity_main.xml에서 Button ID명을 표시 (화면 이동 버튼)
        nextButton = findViewById(R.id.nextButton);
        // nextButton 클릭 시 이벤트 발생
        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Intent : 정보를 읽어오는 함수 (Native App)
                // 이 기능은 다음 화면으로 이동하는 것 (MainActivity2 컴포넌트)
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}