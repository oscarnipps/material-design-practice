package com.example.materialpractice.bottomsheetpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.materialpractice.R;
import com.example.materialpractice.databinding.ActivityBottomSheetBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class BottomSheetActivity extends AppCompatActivity {
    public static final String TAG = BottomSheetActivity.class.getSimpleName();
    BottomSheetBehavior bottomSheetBehavior;
    ActivityBottomSheetBinding bottomSheetBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomSheetBinding = DataBindingUtil.setContentView(this,R.layout.activity_bottom_sheet);

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetBinding.bottomSheet);

        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                Toast.makeText(BottomSheetActivity.this, "changed", Toast.LENGTH_SHORT).show();
                switch (newState) {
                    case BottomSheetBehavior.STATE_EXPANDED:
                        bottomSheetBinding.addSchedule.setVisibility(View.GONE);
                        bottomSheetBinding.totalSchedules.setVisibility(View.GONE);
                        break;

                    case BottomSheetBehavior.STATE_COLLAPSED:
                        bottomSheetBinding.addSchedule.setVisibility(View.VISIBLE);
                        bottomSheetBinding.totalSchedules.setVisibility(View.VISIBLE);
                        break;

                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                Toast.makeText(BottomSheetActivity.this, "sliding", Toast.LENGTH_SHORT).show();
            }
        });

    }
}