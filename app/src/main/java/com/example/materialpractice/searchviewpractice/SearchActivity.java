package com.example.materialpractice.searchviewpractice;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.materialpractice.R;
import com.example.materialpractice.bottomsheetpractice.BottomSheetActivity;


/*
 * Class that handles search activity using the search view widget as a toolbar/actionbar and as a custom search view
 *
 * Created by oscar 07/25/2020
 *
 */
public class SearchActivity extends AppCompatActivity {
    public static final String TAG = SearchActivity.class.getSimpleName();
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = findViewById(R.id.search_toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_menu , menu);

        searchView =  (SearchView) menu.findItem(R.id.search).getActionView();

        // remove the under line / under-bar (line under the edit text) of the toolbar searchView by setting the color to be the same as the toolbar background
        View v =  searchView.findViewById(androidx.appcompat.R.id.search_plate);
        v.setBackgroundColor(getResources().getColor(R.color.color_toolbar));

        //use a custom close icon in the search view
        ImageView searchCloseIcon = (ImageView)searchView.findViewById(androidx.appcompat.R.id.search_close_btn);
        searchCloseIcon.setImageResource(R.drawable.ic_search_close);

        // get the edit text element from the searchView and set custom font and color changes
        EditText searchEditText = (EditText) searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        searchEditText.setTextColor(getResources().getColor(R.color.colorAccent));
        searchEditText.setHintTextColor(getResources().getColor(R.color.colorAccent));
        Typeface typeface = ResourcesCompat.getFont(this,R.font.raleway);
        searchEditText.setTypeface(typeface);


        searchView.setQueryHint("search items");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String searchFilter) {
                Log.d(TAG," " + searchFilter);
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.search) {
            Toast.makeText(this, "search clicked", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}