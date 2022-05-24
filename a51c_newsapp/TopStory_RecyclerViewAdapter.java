package com.example.a51c_newsapp;


import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TopStory_RecyclerViewAdapter extends RecyclerView.Adapter<TopStory_RecyclerViewAdapter.TopStoryViewHolder> {

    private List<TopStory> topStoryList;
    private Context context;
    private TopStoryClickListener listener;

    public TopStory_RecyclerViewAdapter(List<TopStory> topStoryList, Context context, TopStoryClickListener clickListenr) {
        this.topStoryList = topStoryList;
        this.context = context;
        this.listener = clickListenr;
    }

    @NonNull
    @Override
    public TopStoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.top_stories_view, parent, false);

        return new TopStoryViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull TopStoryViewHolder holder, int position) {
        holder.topHeader.setText(topStoryList.get(position).getNewsHeading());
        holder.topBait.setText(topStoryList.get(position).getNewsBait());
        holder.topLogo.setImageResource(topStoryList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return topStoryList.size();
    }

    public class TopStoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TopStoryClickListener topStoryClickListener;
        TextView topHeader;
        TextView topBait;
        ImageView topLogo;

        public TopStoryViewHolder(@NonNull View itemView, TopStoryClickListener topStoryClickListener) {
            super(itemView);
            this.topStoryClickListener = topStoryClickListener;
            topHeader = itemView.findViewById(R.id.topStoryHeadingTextView);
            topBait = itemView.findViewById(R.id.topStoryBody);
            topLogo = itemView.findViewById(R.id.newsTopStoryLogo);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            topStoryClickListener.onTopStoryItemClick(getAdapterPosition());

        }
    }

    public interface TopStoryClickListener{
        void onTopStoryItemClick(int position);
    }

}
