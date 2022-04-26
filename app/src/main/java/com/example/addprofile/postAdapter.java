package com.example.addprofile;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class postAdapter extends BaseAdapter{

    private Context c;
    private int resource;
    private ArrayList<Post> posts;
    public postAdapter(Context c, int resource, ArrayList<Post> posts){
        this.c = c;
        this.resource = resource;
        this.posts = posts;
    }

    public void addItem(Post post){
        this.posts.add(post);
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Post getItem(int i) {
        return posts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = view;
        if(v == null){
            v = LayoutInflater.from(c).inflate(resource,null,false);
        }

        TextView tv_date = v.findViewById(R.id.custom_post_tv_date);
        TextView tv_name = v.findViewById(R.id.custom_post_tv_name);
        TextView tv_following = v.findViewById(R.id.custom_post_tv_following_data);
        TextView tv_followers = v.findViewById(R.id.custom_post_tv_followers_data);
        TextView tv_posts = v.findViewById(R.id.custom_post_tv_posts_data);
        TextView tv_body = v.findViewById(R.id.custom_post_tv_body);
        ImageView imgv = v.findViewById(R.id.custom_post_imgv_profile);

        Post p = getItem(i);
        tv_date.setText(p.getData());
        tv_body.setText(p.getBody());
        tv_followers.setText(p.getFollowers()+"");
        tv_posts.setText(p.getPosts()+"");
        tv_following.setText(p.getFollowing()+"");
        tv_name.setText(p.getName());
        imgv.setImageBitmap(addPostActivity.b);

        return v;
    }
}
