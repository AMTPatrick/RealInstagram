//package com.example.instagram;
//
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//
//import com.example.instagram.model.Post;
//
//import java.util.List;
//
//public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {
//
//    private Context context;
//    private List<Post> posts;
//
//    public ProfileAdapter(Context context, List<Post> posts) {
//        this.context =context;
//        this.posts =posts;
//    }
//
//    @NonNull
//    @Override
//    public ProfileAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
//        View view = LayoutInflater.from(context).inflate(R.layout.fragment_profile, parent, false);
//        return new ProfileAdapter.ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull PostsAdapter.ViewHolder viewHolder, int position) {
//        Post post = posts.get(position);
//        viewHolder.post(post);
//        viewHolder.bind(post);
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        private ImageView ivProfile;
//        private Post post;
//
//        private ViewHolder(View itemView) {
//            public void onClick(View v) {
//
//            }
//        }
//
//    }
//}