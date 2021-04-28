package com.example.samplesenti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MakePostActivity extends AppCompatActivity {
    ImageView companyimage;
    Button button;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button btnFinish;

    EditText minMoney;
    EditText maxUser;
    EditText moreInfo;
    EditText endDate;

    String stEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_post);

        minMoney = (EditText) findViewById(R.id.minMoney);
        maxUser = (EditText) findViewById(R.id.maxUser);
        moreInfo = (EditText) findViewById(R.id.moreInfo);
        endDate = (EditText) findViewById(R.id.endDate);

        companyimage = (ImageView) findViewById(R.id.companyimage);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                companyimage.setImageResource(R.drawable.coupang);
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                companyimage.setImageResource(R.drawable.kurly);
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                companyimage.setImageResource(R.drawable.lotte);
            }
        });

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                companyimage.setImageResource(R.drawable.ssg);
            }
        });

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                companyimage.setImageResource(R.drawable.bag);
                Snackbar.make(view, "추가정보칸에 입력하세요.", Snackbar.LENGTH_LONG).show();
            }
        });



        btnFinish = (Button) findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference database = FirebaseDatabase.getInstance().getReference();
                String uid, name, email;
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    // Name, email address, and profile photo Url
                    name = user.getDisplayName();
                    email = user.getEmail();
                    Uri photoUrl = user.getPhotoUrl();

                    // Check if user's email is verified
                    boolean emailVerified = user.isEmailVerified();

                    // The user's ID, unique to the Firebase project. Do NOT use this value to
                    // authenticate with your backend server, if you have one. Use
                    // FirebaseUser.getIdToken() instead.
                    uid = user.getUid().toString();

                    database.child("content").setValue(uid);
                    Post post = new Post(minMoney.getText().toString(), //수정 해야함
                            maxUser.getText().toString(),
                            moreInfo.getText().toString(),
                            endDate.getText().toString(),
                            uid);

                    database.child("content").child(uid).push().setValue(post);  //수정 해야함

                    Intent in = new Intent(getApplicationContext(), ChatActivity.class);
                    in.putExtra("email", stEmail);
                    startActivity(in);
                }
            }
        });
    }


}