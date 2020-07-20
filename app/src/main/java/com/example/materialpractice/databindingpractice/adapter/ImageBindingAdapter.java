package com.example.materialpractice.databindingpractice.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.materialpractice.R;

public class ImageBindingAdapter {

    @BindingAdapter("imageResource")
    public static void setProfileImage(ImageView view , int imageResourceId) {

        Context context = view.getContext();
        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_employee).error(R.drawable.ic_employee);

        Glide.with(context)
                .setDefaultRequestOptions(requestOptions)
                .load(imageResourceId)
                .into(view);

        Toast.makeText(context, "profile updated", Toast.LENGTH_SHORT).show();
    }
}
