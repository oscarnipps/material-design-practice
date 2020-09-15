package com.example.materialpractice.inputfieldspractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.materialpractice.R;
import com.example.materialpractice.databinding.ActivityInputFieldsBinding;

public class InputFieldsActivity extends AppCompatActivity {
    ActivityInputFieldsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_input_fields);
    }


}