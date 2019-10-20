package com.netology.androidcherepanov421;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class SampleAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private final List<Sample> samples;


    SampleAdapter(Context context, List<Sample> samples) {

        this.samples = samples;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return samples.size();
    }

    @Override
    public Object getItem(int i) {
        return samples.get(i);
    }

    @Override
    public long getItemId(int i) {
        return (long) i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = inflater.inflate(R.layout.sample_item_layout, viewGroup, false);
        }

        Sample sample = samples.get(i);

            ((TextView) view.findViewById(R.id.sample_title)).setText(sample.getTitle());
            ((TextView) view.findViewById(R.id.sample_category)).setText(sample.getCategory());
            ((ImageView) view.findViewById(R.id.pic_place)).setImageDrawable(sample.getScreenshot());

        return view;
    }
}
