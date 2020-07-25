package com.example.materialpractice.dialogpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.materialpractice.R;
import com.example.materialpractice.databinding.ActivityDialogPracticeBinding;

/*
 * Class that shows a dialog fragment (full screen , custom alert dialogs)
 *
 * Created by oscar 07/25/2020
 *
 */
public class DialogPracticeActivity extends AppCompatActivity {

    ActivityDialogPracticeBinding dialogPracticeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialogPracticeBinding = DataBindingUtil.setContentView(this ,R.layout.activity_dialog_practice);

        dialogPracticeBinding.showDialog.setOnClickListener(v->{
            DialogPracticeFragment dialogPracticeFragment = DialogPracticeFragment.getInstance();
            dialogPracticeFragment.show(getSupportFragmentManager() ,"location_dialog_fragment");
        });
    }
}