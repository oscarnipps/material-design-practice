package com.example.materialpractice.collapsingtoolbarpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.materialpractice.R;
import com.example.materialpractice.databinding.ActivitySecondPracticeBinding;

public class SecondPracticeActivity extends AppCompatActivity {

    ActivitySecondPracticeBinding secondPracticeBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        secondPracticeBinding = DataBindingUtil.setContentView(this , R.layout.activity_second_practice);
        setSupportActionBar(secondPracticeBinding.secondPracticeToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
