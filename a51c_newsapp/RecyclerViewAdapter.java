package com.example.a51c_newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<NewsStory> newsStoryList;
    private Context context;
    private newsItemClickListener listener;

    public RecyclerViewAdapter(List<NewsStory> newsStoryList, Context context, newsItemClickListener clickListener) {
        this.newsStoryList = newsStoryList;
        this.context = context;
        this.listener = clickListener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.news_item_view, parent, false);

        return new ViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {

        holder.newsHeading.setText(newsStoryList.get(position).getHeadline());
        holder.newsBody.setText(newsStoryList.get(position).getBody());
        holder.newsLogo.setImageResource(newsStoryList.get(position).getNewsImage());
    }

    @Override
    public int getItemCount() {
        return newsStoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public newsItemClickListener newsItemClickListener;
        TextView newsHeading;
        TextView newsBody;
        ImageView newsLogo;

        public ViewHolder(@NonNull View itemView, newsItemClickListener newsItemClickListener) {
            super(itemView);

            this.newsItemClickListener = newsItemClickListener;
            itemView.setOnClickListener(this);

            newsHeading = itemView.findViewById(R.id.newsHeadingTextView);
            newsBody = itemView.findViewById(R.id.newsBodyTextView);
            newsLogo = itemView.findViewById(R.id.newsLogo);
        }

        @Override
        public void onClick(View view) {
            newsItemClickListener.onItemClick(getAdapterPosition());
        }
    }

    public interface newsItemClickListener{
        void onItemClick(int position);
    }

}

