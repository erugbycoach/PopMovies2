package com.erugbycoach.popmovies.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.erugbycoach.popmovies.Models.Reviews;
import com.erugbycoach.popmovies.R;

import java.util.ArrayList;

/**
 * Created by William D Howell on 10/27/2017.
 */

public class ReviewAdapter extends BaseAdapter {
    private ArrayList<Reviews> mReviews;
    private Context context;

    public ReviewAdapter(Context context) {
        this.context = context;
        mReviews = new ArrayList<>();
    }

    public void setReview(ArrayList<Reviews> data) {
        mReviews.clear();
        mReviews.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mReviews.size();
    }

    @Override
    public Reviews getItem(int position) {
        if (position >= 0 && position < mReviews.size()) {
            return mReviews.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        if (getItem(position) == null) {
            return -1L;
        }
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View reviewItem = convertView;
        Reviews review = getItem(position);
        if (reviewItem == null) {
            try {
                LayoutInflater vi;
                vi = LayoutInflater.from(context);
                reviewItem = vi.inflate(R.layout.reviews_list_item, null);

            } catch (Exception e) {
                Log.e(context.getClass().getSimpleName(), e.toString());
            }
        }
        assert reviewItem != null;
        ((TextView) reviewItem.findViewById(R.id.review_item_author)).setText(String.format(context.getString(R.string.review_author), review.author));
        ((TextView) reviewItem.findViewById(R.id.review_item_content)).setText(review.content);
        return reviewItem;
    }
}
