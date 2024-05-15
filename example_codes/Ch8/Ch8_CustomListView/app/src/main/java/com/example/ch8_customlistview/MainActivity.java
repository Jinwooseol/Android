package com.example.ch8_customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.Image;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView list;
    String[] titles = {
            "The Truman Show (1998)",
            "Back to The Future (1987)",
            "The Silence of The Lambs (1991)",
            "Jurassic Park (1993)",
            "Alien (1979)",
            "E.T. (1982)",
            "STAR WARS (1977)",
            "STAR WARS (1977)",
            "STAR WARS (1977)",
            "STAR WARS (1977)"
    };
    Integer[] images = {
            R.drawable.movie1,
            R.drawable.movie2,
            R.drawable.movie3,
            R.drawable.movie4,
            R.drawable.movie5,
            R.drawable.movie6,
            R.drawable.movie7,
            R.drawable.movie7,
            R.drawable.movie7,
            R.drawable.movie7,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomList adapter = new CustomList(MainActivity.this);
        list = findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), titles[+position], Toast.LENGTH_SHORT).show();
            }
        });
    }
    public class CustomList extends ArrayAdapter<String> {
        private final Activity context;
        public CustomList(Activity context) {
            super(context, R.layout.listitem, titles);
            this.context = context;
        }
        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.listitem, null, true);
            ImageView imageView = rowView.findViewById(R.id.image);
            TextView title = rowView.findViewById(R.id.title);
            TextView rating = rowView.findViewById(R.id.rating);
            TextView genre = rowView.findViewById(R.id.genre);
            TextView releaseYear = rowView.findViewById(R.id.releaseYear);

            title.setText(titles[position]);
            imageView.setImageResource(images[position]);
            rating.setText("9.0" + position);
            genre.setText("MOVIE");
            releaseYear.setText(titles[position].substring(titles[position].length()-5, titles[position].length()-1));
            return rowView;
        }
    }

}