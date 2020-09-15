package com.example.materialpractice.inputfieldspractice;

import android.view.View;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.example.materialpractice.R;

public class InputItemBindingAdapter {

    @BindingAdapter("onEditTextFocused")
    public static void onEditTextFocused(View view , TextView textView) {

        view.setOnFocusChangeListener((view1, b) -> {
            if (b) {
                textView.setText(view1.getContext().getResources().getText(R.string.focus_changed_text));
                return;
            }
            textView.setText(view1.getContext().getResources().getText(R.string.employee_list));
        });

    }
}
