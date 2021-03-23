package com.example.materialpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.materialpractice.bottomsheetpractice.BottomSheetActivity;
import com.example.materialpractice.collapsingtoolbarpractice.PracticeActivity;
import com.example.materialpractice.databindingpractice.MainActivity;
import com.example.materialpractice.dialogpractice.DialogPracticeActivity;
import com.example.materialpractice.inputfieldspractice.InputFieldsActivity;
import com.example.materialpractice.progressbarpractice.CircularProgressBarActivity;
import com.example.materialpractice.recyclerviewpractice.RecyclerViewEntryActivity;
import com.example.materialpractice.searchviewpractice.SearchActivity;

public class EntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
    }

    public void openRecyclerViewDemo(View view) {
        Intent intent = new Intent(this , RecyclerViewEntryActivity.class);
        startActivity(intent);
    }

    public void openProgressBarDemo(View view) {
        Intent intent = new Intent(this , CircularProgressBarActivity.class);
        startActivity(intent);
    }

    public void openInputFieldsDemo(View view) {
        Intent intent = new Intent(this , InputFieldsActivity.class);
        startActivity(intent);
    }

    public void openDialogsDemo(View view) {
        Intent intent = new Intent(this , DialogPracticeActivity.class);
        startActivity(intent);
    }

    public void openDataBindingDemo(View view) {
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
    }

    public void openSearchViewDemo(View view) {
        Intent intent = new Intent(this , SearchActivity.class);
        startActivity(intent);
    }

    public void openCollapsingToolbarDemo(View view) {
        Intent intent = new Intent(this , PracticeActivity.class);
        startActivity(intent);
    }

    public void openBottomSheetsDemo(View view) {
        Intent intent = new Intent(this , BottomSheetActivity.class);
        startActivity(intent);
    }

}