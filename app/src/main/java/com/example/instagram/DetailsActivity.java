package com.example.instagram;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.instagram.model.Post;
import com.parse.ParseFile;

public class DetailsActivity extends AppCompatActivity {
    Post post;
    private TextView tvHandle;
    private ImageView ivImage;
    private TextView tvDescription;
    public TextView tvTimeStamp;
    private ImageView ivMore;
    private ImageView ivLike;
    private ImageView ivComment;
    private ImageView ivSend;
    private ImageView ivSave;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);

        tvHandle = findViewById(R.id.tvHandle);
        ivImage = findViewById(R.id.ivImage);
        tvDescription = findViewById(R.id.tvDescription);
        tvTimeStamp = findViewById(R.id.tvTimeStamp);
        ivMore = findViewById(R.id.ivMore);
        ivLike = findViewById(R.id.ivLike);
        ivComment = findViewById(R.id.ivComment);
        ivSend = findViewById(R.id.ivSend);
        ivSave = findViewById(R.id.ivSave);

        post = (getIntent().getParcelableExtra("Detailed"));
        tvHandle.setText(post.getUser().getUsername());
        ParseFile image = post.getImage();
        if (image != null) {
            Glide.with(this).load(image.getUrl()).into(ivImage);
        }
        tvDescription.setText(post.getDescription());
        tvTimeStamp.setText(post.getCreatedAt().toString());
    }
}
