package com.erugbycoach.popmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.erugbycoach.popmovies.Adapters.ReviewAdapter;
import com.erugbycoach.popmovies.Models.Reviews;

import java.util.ArrayList;

public class ReviewsActivity extends AppCompatActivity {
    ListView reviewsListView;
    ReviewAdapter mAdapter;
    TextView mTitleTextView, mErrorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        reviewsListView = (ListView) findViewById(R.id.reviews_listView);
        mErrorTextView = (TextView) findViewById(R.id.tv_reviews_error);
        mTitleTextView = (TextView) findViewById(R.id.tv_details_title);
        mAdapter = new ReviewAdapter(this);
        Intent intent = getIntent();

        reviewsListView.setAdapter(mAdapter);
        String title = intent.getStringExtra("title");
        mTitleTextView.setText(title);

        if (intent.hasExtra(getString(R.string.reviews_intent_extra))) {
            ArrayList<Reviews> reviews = Reviews.stringToArray(intent.getStringExtra(getString(R.string.reviews_intent_extra)));

            if (reviews.size() > 0) {
                mAdapter.setReview(reviews);
            } else {
                Log.d("ERROR", "Showing error message");
                reviewsListView.setVisibility(View.GONE);
                mErrorTextView.setVisibility(View.VISIBLE);
            }
        }

    }
}
