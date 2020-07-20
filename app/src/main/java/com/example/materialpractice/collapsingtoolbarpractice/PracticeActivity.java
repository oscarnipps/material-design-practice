package com.example.materialpractice.collapsingtoolbarpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.example.materialpractice.R;
import com.example.materialpractice.databinding.ActivityPracticeBinding;

public class PracticeActivity extends AppCompatActivity {

    ActivityPracticeBinding practiceBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        practiceBinding = DataBindingUtil.setContentView(this , R.layout.activity_practice);
        setSupportActionBar(practiceBinding.practiceToolBar);

        practiceBinding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PracticeActivity.this , SecondPracticeActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.practice_menu ,menu);
        return true;
    }
}
