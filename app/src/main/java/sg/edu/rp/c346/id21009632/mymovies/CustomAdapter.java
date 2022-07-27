package sg.edu.rp.c346.id21009632.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Movie> versionList;

    public CustomAdapter(Context context, int resource, ArrayList<Movie> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        versionList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View rowView = inflater.inflate(layout_id, parent, false);


        TextView tvTitle = rowView.findViewById(R.id.movieTitle);
        TextView tvGenre = rowView.findViewById(R.id.genre);
        TextView tvYear = rowView.findViewById(R.id.year);
        ImageView ivRating = rowView.findViewById(R.id.ratingImage);

        Movie currentVersion = versionList.get(position);

        tvTitle.setText(currentVersion.getTitle());
        tvGenre.setText(currentVersion.getGenre());
        tvYear.setText(currentVersion.getYear() + "");

        if (currentVersion.getRating() == "g") {
            ivRating.setImageResource(R.drawable.rating_g);

        } else if (currentVersion.getRating() == "m18") {
            ivRating.setImageResource(R.drawable.rating_m18);

        } else if (currentVersion.getRating() == "nc16") {
            ivRating.setImageResource(R.drawable.rating_nc16);

        } else if (currentVersion.getRating() == "pg") {
            ivRating.setImageResource(R.drawable.rating_pg);

        } else if (currentVersion.getRating() == "pg13") {
            ivRating.setImageResource(R.drawable.rating_pg13);

        } else {
            ivRating.setImageResource(R.drawable.rating_r21);
        }
        return rowView;
    }
}

