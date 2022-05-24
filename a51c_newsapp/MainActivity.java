package com.example.a51c_newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.newsItemClickListener, TopStory_RecyclerViewAdapter.TopStoryClickListener{

    RecyclerView bodyRecyclerView;
    RecyclerViewAdapter bodyRecyclerViewAdapter;
    List<NewsStory> newsStoryList = new ArrayList<>();

    RecyclerView topRecyclerView;
    TopStory_RecyclerViewAdapter topRecyclerViewAdapter;
    public List<TopStory> topStoryList = new ArrayList<>();

    private static final String HEADLINE = "news_headline";
    private static final String NEWSBODY = "news_body";
    private static final String NEWSLOGO = "news_logo";
    private static final String NEWSTYPE= "news_type";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getNewsStoryList();
        getTopStoryList();

        topRecyclerView = findViewById(R.id.topStoriesRecyclerView);
        topRecyclerViewAdapter = new TopStory_RecyclerViewAdapter(topStoryList, this, this);
        topRecyclerView.setAdapter(topRecyclerViewAdapter);
        topRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        bodyRecyclerView = findViewById(R.id.newsRecyclerView);
        bodyRecyclerViewAdapter = new RecyclerViewAdapter(newsStoryList, this, this);
        bodyRecyclerView.setAdapter(bodyRecyclerViewAdapter);

        //bodyRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        bodyRecyclerView.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false));

    }


    public List<TopStory> getTopStoryList() {
        TopStory abcTop = new TopStory("ABC TOP STORY HEADING", R.string.default_text,"abc", R.drawable.abc_logo_long);
        TopStory aljTop = new TopStory("ALJAZEERA TOP STORY HEADING", R.string.default_text, "alj", R.drawable.alj_news_logo);
        TopStory sbsTop = new TopStory("SBS TOP STORY HEADING", R.string.default_text, "sbs", R.drawable.sbs_news_logo);
        TopStory bbcTop = new TopStory("BBC TOP STORY HEADING", R.string.default_text,"bbc", R.drawable.bbc_news_logo);
        TopStory reuTop = new TopStory("REUTERS TOP STORY HEADING", R.string.default_text, "reu", R.drawable.reu_news_logo);

        topStoryList.add(abcTop);
        topStoryList.add(aljTop);
        topStoryList.add(sbsTop);
        topStoryList.add(bbcTop);
        topStoryList.add(reuTop);

        TopStory abcTop2 = new TopStory("ABC TOP STORY HEADING 2", R.string.default_text,"abc", R.drawable.abc_logo_long);
        TopStory aljTop2 = new TopStory("ALJAZEERA TOP STORY HEADING 2", R.string.default_text, "alj", R.drawable.alj_news_logo);
        TopStory sbsTop2 = new TopStory("SBS TOP STORY HEADING 2", R.string.default_text, "sbs", R.drawable.sbs_news_logo);
        TopStory bbcTop2 = new TopStory("BBC TOP STORY HEADING 2", R.string.default_text, "bbc", R.drawable.bbc_news_logo);
        TopStory reuTop2 = new TopStory("REUTERS TOP STORY HEADING 2", R.string.default_text, "reu", R.drawable.reu_news_logo);


        topStoryList.add(abcTop2);
        topStoryList.add(aljTop2);
        topStoryList.add(sbsTop2);
        topStoryList.add(bbcTop2);
        topStoryList.add(reuTop2);

        return topStoryList;
    }

    private void getNewsStoryList() {
        NewsStory abcNews = new NewsStory("ABC TRENDING NEWS", R.string.default_text, "abc", R.drawable.abc_logo_long);
        NewsStory aljNews = new NewsStory("ALJAZEERA TRENDING NEWS", R.string.default_text, "alj", R.drawable.alj_news_logo);
        NewsStory sbsNews = new NewsStory("SBS TRENDING NEWS", R.string.default_text, "sbs", R.drawable.sbs_news_logo);
        NewsStory bbcNews = new NewsStory("BBC TRENDING NEWS", R.string.default_text, "bbc", R.drawable.bbc_news_logo);
        NewsStory reuNews = new NewsStory("BBC TRENDING NEWS", R.string.default_text, "reu", R.drawable.reu_news_logo);

        newsStoryList.add(abcNews);
        newsStoryList.add(sbsNews);
        newsStoryList.add(aljNews);
        newsStoryList.add(bbcNews);
        newsStoryList.add(reuNews);

        NewsStory abcNews2 = new NewsStory("ABC TRENDING NEWS 2 ", R.string.default_text, "abc", R.drawable.abc_logo_long);
        NewsStory aljNews2 = new NewsStory("ALJAZEERA TRENDING NEWS 2", R.string.default_text, "alj", R.drawable.alj_news_logo);
        NewsStory sbsNews2 = new NewsStory("SBS TRENDING NEWS 2", R.string.default_text, "sbs", R.drawable.sbs_news_logo);
        NewsStory bbcNews2 = new NewsStory("BBC TRENDING NEWS 2", R.string.default_text, "bbc", R.drawable.bbc_news_logo);
        NewsStory reuNews2 = new NewsStory("BBC TRENDING NEWS 2", R.string.default_text, "reu", R.drawable.reu_news_logo);

        newsStoryList.add(abcNews2);
        newsStoryList.add(sbsNews2);
        newsStoryList.add(aljNews2);
        newsStoryList.add(bbcNews2);
        newsStoryList.add(reuNews2);
    }


    @Override
    public void onItemClick(int position) {
        String clickedHeadline = newsStoryList.get(position).getHeadline();
        Bundle args = new Bundle();

        args.putString(HEADLINE, newsStoryList.get(position).getHeadline());
        args.putInt(NEWSBODY, newsStoryList.get(position).getBody());
        args.putInt(NEWSLOGO, newsStoryList.get(position).getNewsImage());
        args.putString(NEWSTYPE, "top");

        newsDetailsFragment fragment = new newsDetailsFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        fragment.setArguments(args);

        fragmentTransaction.replace(R.id.blankFragmentContainer, fragment).commit();

    }

    @Override
    public void onTopStoryItemClick(int position) {
        Bundle args = new Bundle();

        args.putString(HEADLINE, topStoryList.get(position).getNewsHeading());
        args.putInt(NEWSBODY, topStoryList.get(position).getNewsBait());
        args.putInt(NEWSLOGO, topStoryList.get(position).getImage());
        args.putString(NEWSTYPE, "main");


        newsDetailsFragment fragment = new newsDetailsFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        fragment.setArguments(args);

        fragmentTransaction.replace(R.id.blankFragmentContainer, fragment).commit();

    }




}