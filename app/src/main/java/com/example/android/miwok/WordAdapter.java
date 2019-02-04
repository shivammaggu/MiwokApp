package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mcolorId;

    public WordAdapter(Activity context, ArrayList<Word> num, int colorId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, num);
        mcolorId = colorId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.numberslist, parent, false);
        }

        Word currentWord = getItem(position);

        TextView miwakTextView = (TextView) listItemView.findViewById(R.id.miwak_word);
        miwakTextView.setText(currentWord.getMmiwaktrans());

        TextView engTextView = (TextView) listItemView.findViewById(R.id.eng_word);
        engTextView.setText(currentWord.getMdefaultTrans());

        ImageView img = (ImageView) listItemView.findViewById(R.id.images);
        if (currentWord.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            img.setImageResource(currentWord.getmResourceId());
            // Make sure the view is visible
            img.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            img.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mcolorId);

        textContainer.setBackgroundColor(color);

        return listItemView;
    }

}
