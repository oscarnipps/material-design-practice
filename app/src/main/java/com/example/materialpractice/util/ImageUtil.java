package com.example.materialpractice.util;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.materialpractice.R;

public class ImageUtil {

    public void setProfileImage(ImageView view) {
        Context context  = view.getContext();

        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_employee).error(R.drawable.ic_employee);

        Glide.with(context)
                .setDefaultRequestOptions(requestOptions)
                .load(R.drawable.oscar_picture).into(view);

        Toast.makeText(context, "profile updated", Toast.LENGTH_SHORT).show();
    }
}
