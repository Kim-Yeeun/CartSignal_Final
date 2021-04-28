package com.example.samplesenti;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class itemcActivity extends AppCompatActivity {
    public static final String TAG = "Test_Alert_Dialog";

    Button btn01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemc);

        btn01 = (Button) findViewById(R.id.btn01);

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder(itemcActivity.this);

                ad.setTitle("참여");       // 제목 설정
                ad.setMessage("구매 금액을 입력하세요.");   // 내용 설정

                // 확인 버튼 설정
                ad.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Log.v(TAG,"Yes Btn Click");
                        dialog.dismiss();     //닫기
                        // Event
                    }
                });

                // 중립 버튼 설정
                ad.setNeutralButton("What?", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.v(TAG,"Neutral Btn Click");
                        dialog.dismiss();     //닫기
                        // Event
                    }
                });

                // 취소 버튼 설정
                ad.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.v(TAG,"No Btn Click");
                        dialog.dismiss();     //닫기
                        // Event
                    }
                });
                // 창 띄우기
                ad.show();
            }
        });
    }
}
