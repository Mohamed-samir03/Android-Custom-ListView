package com.example.addprofile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class addPostActivity extends AppCompatActivity {

    EditText et_name,et_body,et_date,et_following,et_followers,et_posts;
    Button btn_takePhoto,btn_add_post;
    ImageView imgv;
    static Bitmap b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        et_name = findViewById(R.id.add_post_name);
        et_body = findViewById(R.id.add_post_body);
        et_date = findViewById(R.id.add_post_date);
        et_following = findViewById(R.id.add_post_following);
        et_followers = findViewById(R.id.add_post_followers);
        et_posts = findViewById(R.id.add_post_posts);
        btn_takePhoto = findViewById(R.id.add_post_btn_takephoto);
        btn_add_post = findViewById(R.id.add_post_btn_add);
        imgv = findViewById(R.id.add_post_imgv);

        btn_add_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_name.getText().toString();
                String body = et_body.getText().toString();
                String date = et_date.getText().toString();
                int following = Integer.parseInt(et_following.getText().toString());
                int posts = Integer.parseInt(et_posts.getText().toString());
                int followers = Integer.parseInt(et_followers.getText().toString());
                String myImage = b.toString();

                Post post = new Post(date,name,body,following,followers,posts);

                Intent intent = new Intent();
                intent.putExtra("post",post);

                setResult(RESULT_OK,intent);
                finish();
            }
        });

        btn_takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, 2);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 2 && resultCode == RESULT_OK){
            b = (Bitmap)data.getExtras().get("data");
            imgv.setImageBitmap(b);
        }

    }
}