package com.example.addprofile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_add;
    ListView lv;
    int rec_code_add=1;
    postAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.addProfile_btn_add);
        lv = findViewById(R.id.addProfile_lv);

        ArrayList<Post> posts = new ArrayList<>();

        adapter = new postAdapter(this,R.layout.custom_post_layout,posts);
        lv.setAdapter(adapter);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),addPostActivity.class);
                startActivityForResult(intent,rec_code_add);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == rec_code_add && resultCode == RESULT_OK){
            Post p = (Post)data.getSerializableExtra("post");
            adapter.addItem(p);
            adapter.notifyDataSetChanged();
        }

    }
}