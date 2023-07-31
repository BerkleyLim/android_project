package com.example.v4;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

// 참조 : https://siku314.tistory.com/70
// 참조 더하기 : https://bacassf.tistory.com/63
public class GalleryActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.galley_main);
        setTitle("list view exam");

        final GridView gv = findViewById(R.id.gridView);
        MyGridAdapter gAdapter = new MyGridAdapter(this);

        gv.setAdapter(gAdapter);
    }

    public class MyGridAdapter extends BaseAdapter {
        Context context;
        public MyGridAdapter(Context c){
            context = c;
        }

        // 실제 이미지는 10개이지만, 갤러리에 풍성하게 보이기 위해
        // 세 번 반복해서 붙여넣었습니다.
        Integer[] picID = {
                R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
                R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9, R.drawable.pic10,
                R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
                R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9, R.drawable.pic10,
                R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
                R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9, R.drawable.pic10
        };

        // BaseAdapter를 상속받은 클래스가 구현해야 할 함수들은
        // { getCount(), getItem(), getItemId(), getView() }
        // Ctrl + i 를 눌러 한꺼번에 구현할 수 있습니다.
        @Override
        public int getCount() {
            return picID.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(200,300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);

            imageView.setImageResource(picID[i]);



            // 갤러리의 이미지뷰를 눌렀을 때
            // 다이얼로그뷰를 팝업하여 큰 이미지를 출력합니다.
            final int pos = i;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View dialogView = View.inflate(GalleryActivity.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(GalleryActivity.this);
                    ImageView ivPic = dialogView.findViewById(R.id.ivPic);
                    ivPic.setImageResource(picID[pos]);
                    dlg.setTitle("큰 이미지");
                    dlg.setIcon(R.drawable.ic_launcher);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });

            return imageView;
        }
    }
}
