package com.erugbycoach.popmovies.Adapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.erugbycoach.popmovies.Models.Trailers;
import com.erugbycoach.popmovies.R;

import java.util.ArrayList;

/**
 * Created by William D Howell on 10/27/2017.
 */

public class TrailerAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Trailers> mTrailers;

    public TrailerAdapter(Context context) {
        this.context = context;
        this.mTrailers = new ArrayList<>();
    }

    private void clear() {
        mTrailers.clear();
        notifyDataSetChanged();
    }

    public void setTrailers(ArrayList<Trailers> trailers) {
        clear();
        mTrailers.addAll(trailers);
        notifyDataSetChanged();
    }

    public void addTrailers(ArrayList<Trailers> trailers) {
        mTrailers.addAll(trailers);
        notifyDataSetChanged();
    }

    public Uri getTrailerUri(int position) {
        Trailers trailer = getItem(position);
        if (trailer != null) {
            return Uri.parse(trailer.url);
        }
        return null;
    }

    @Override
    public int getCount() {
        return mTrailers.size();
    }

    @Override
    public Trailers getItem(int position) {
        if (position >= 0 && position < mTrailers.size()) {
            return mTrailers.get(position);
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
        View trailerItem = convertView;
        Trailers trailer = getItem(position);
        if (trailerItem == null) {
            try {
                LayoutInflater vi;
                vi = LayoutInflater.from(context);
                trailerItem = vi.inflate(R.layout.trailers_list_item, parent, false);

            } catch (Exception e) {
                Log.e(context.getClass().getSimpleName(), e.toString());
            }
        }
        if (trailerItem != null) {
            ((TextView) trailerItem.findViewById(R.id.tv_trailer_item_title)).setText(trailer.title);
        }
        return trailerItem;
    }
}
