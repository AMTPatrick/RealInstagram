package com.example.instagram;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.instagram.Fragments.ProfileFragment;
import com.example.instagram.model.Post;
import com.parse.ParseFile;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private Context context;
    private List<Post> posts;
    private boolean isProfile;

    public PostsAdapter(Context context, List<Post> posts, boolean isProfile) {
        this.context = context;
        this.posts = posts;
        this.isProfile = isProfile;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view;
        if (isProfile) {
            view = LayoutInflater.from(context).inflate(R.layout.profile_images, parent, false);
        }
        else {
            view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        }
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Post post = posts.get(position);
        viewHolder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvHandle;
        private ImageView ivImage;
        private TextView tvDescription;
        public TextView tvTimeStamp;
        private ImageView ivMore;
        private ImageView ivProfile;
        private ImageView ivLike;
        private ImageView ivComment;
        private ImageView ivSend;
        private ImageView ivSave;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImage);

            if(!isProfile) {
                tvHandle = itemView.findViewById(R.id.tvHandle);
                tvDescription = itemView.findViewById(R.id.tvDescription);
                tvTimeStamp = itemView.findViewById(R.id.tvTimeStamp);
                ivMore = itemView.findViewById(R.id.ivMore);
                ivProfile = itemView.findViewById(R.id.ivProfile);
                ivLike = itemView.findViewById(R.id.ivLike);
                ivComment = itemView.findViewById(R.id.ivComment);
                ivSend = itemView.findViewById(R.id.ivSend);
                ivSave = itemView.findViewById(R.id.ivSave);

                ivMore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            Post post = posts.get(position);
                            Intent intent = new Intent(context, DetailsActivity.class);
                            intent.putExtra("Detailed", (post));
                            context.startActivity(intent);
                        }
                    }
                });

                tvHandle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            Post post = posts.get(position);
                            FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
                            Fragment fragment;
                            fragment = new ProfileFragment();
                            Bundle args = new Bundle();
                            //get object id from User
                            args.putParcelable("objectId", post);
                            fragment.setArguments(args);
                            fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).addToBackStack(null).commit();
                        }
                    }
                });
            }


        }

        public void bind(Post post) {
            ParseFile image = post.getImage();
            if (image != null) {
                Glide.with(context).load(image.getUrl()).into(ivImage);
            }
            if(!isProfile) {
                tvHandle.setText(post.getUser().getUsername());
                tvDescription.setText(post.getDescription());
                tvTimeStamp.setText(post.getCreatedAt().toString());
            }
        }
    }

    public void clear() {
        posts.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Post> list) {
        posts.addAll(list);
        notifyDataSetChanged();
    }
}
