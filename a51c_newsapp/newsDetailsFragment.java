package com.example.a51c_newsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link newsDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class newsDetailsFragment extends Fragment implements RecyclerViewAdapter.newsItemClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String HEADLINE = "news_headline";
    private static final String NEWSBODY = "news_body";
    private static final String NEWSPUB = "news_type";
    private static final String NEWSLOGO = "news_logo";

    private TextView headlineText;
    private TextView bodyText;
    private ImageView newsLogo;

    public RecyclerView fragRecyclerView;
    public RecyclerViewAdapter fragRecyclerViewAdapter;
    public List<NewsStory> newsStories = getNewsStoryList();


    // TODO: Rename and change types of parameters
    private String storyHeadline;
    private int storyBody;
    private int newsImage;
    private String storyType;

    public newsDetailsFragment() {
        // Required empty public constructor
    }

    public static newsDetailsFragment newInstance(String headline, int body, String publisher, int image) {
        newsDetailsFragment fragment = new newsDetailsFragment();
        Bundle args = new Bundle();
        args.putString(HEADLINE, headline);
        args.putInt(NEWSBODY, body);
        args.putString(NEWSPUB, publisher);
        args.putInt(NEWSLOGO, image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            storyHeadline = getArguments().getString(HEADLINE);
            storyBody= getArguments().getInt(NEWSBODY);
            newsImage = getArguments().getInt(NEWSLOGO);
            storyType = getArguments().getString(NEWSPUB);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news_details, container, false);
        headlineText = (TextView) view.findViewById(R.id.detailedNewsHeading);
        bodyText = (TextView) view.findViewById(R.id.detailedNewsBody);
        newsLogo = (ImageView) view.findViewById(R.id.logoHeadlineImage);
        headlineText.setText(storyHeadline);
        bodyText.setText(storyBody);
        newsLogo.setImageResource(newsImage);

        Button closebtn = (Button) view.findViewById(R.id.closeFragmentButton);

        closebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().remove(newsDetailsFragment.this).commit();
            }
        });

        fragRecyclerView = view.findViewById(R.id.newsFragmentRecyclerView);
        fragRecyclerViewAdapter = new RecyclerViewAdapter(newsStories, this.getContext(), newsDetailsFragment.this);
        fragRecyclerView.setAdapter(fragRecyclerViewAdapter);
        fragRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;

    }


    @Override
    public void onItemClick(int position) {
        Bundle args = new Bundle();

        args.putString(HEADLINE, newsStories.get(position).getHeadline());
        args.putInt(NEWSBODY, newsStories.get(position).getBody());
        args.putInt(NEWSLOGO, newsStories.get(position).getNewsImage());

        newsDetailsFragment fragment = new newsDetailsFragment();

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        fragment.setArguments(args);

        fragmentTransaction.replace(R.id.blankFragmentContainer, fragment).commit();

    }

    private List<NewsStory> getNewsStoryList() {
        List<NewsStory> newsStoryList = new ArrayList<>();
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

        return newsStoryList;
    }
    public List<TopStory> getTopStoryList() {
        List<TopStory> topStoryList = new ArrayList<>();

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


        return topStoryList;}
}