package com.example.android.mediaplayer;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param songs A List of Word objects to display in a list
     */
    public SongAdapter(Activity context, ArrayList<Song> songs) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, songs);
    }
    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwokWord
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.songTitle);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        if (currentSong != null) {
            titleTextView.setText(currentSong.getSongTitle());
        }

        // Find the TextView in the list_item.xml layout with the ID defaultWord
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.songArtist);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        if (currentSong != null) {
            artistTextView.setText(currentSong.getSongArtist());
        }

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        //ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        //iconView.setImageResource(currentAndroidFlavor.getImageResourceId());



        setCustomOnClickListener(R.layout.list_item, NowPlayingActivity.class, listItemView);
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
    public void setCustomOnClickListener(int resourceID, final Class className, View listItemView) {
        // Find the View that shows the numbers category
        View view = listItemView.findViewById(resourceID);

        // Set a click listener on that View
        if (view != null) {
            view.setOnClickListener(
                    new View.OnClickListener() {
                        // The code in this method will be executed when the respective View is clicked on.
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(view.getContext(), className);
                            view.getContext().startActivity(intent);
                        }
                    });
        }
    }
}
