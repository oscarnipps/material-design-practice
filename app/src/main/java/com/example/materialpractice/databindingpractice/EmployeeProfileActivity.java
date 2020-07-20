package com.example.materialpractice.databindingpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.net.Uri;
import android.os.Bundle;

import com.example.materialpractice.R;
import com.example.materialpractice.databinding.ActivityEmployeeProfileBinding;

import java.io.File;

public class EmployeeProfileActivity extends AppCompatActivity {

    public static final String TAG = EmployeeProfileActivity.class.getSimpleName();
    public static final int IMAGE_CAPTURE_REQUEST_CODE = 1;
    ActivityEmployeeProfileBinding employeeProfileBinding;
    Uri photoUri = null;
    public static final String EMPLOYEE_IMAGE_DIRECTORY = "/Employee/images";
    Uri photoViewUri = null;
    File actualFile = null;
    String imageFileName;
    String currentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        employeeProfileBinding = DataBindingUtil.setContentView(this, R.layout.activity_employee_profile);

       /* employeeProfileBinding.takeEmployeeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takeImage();
            }
        });*/


    }

/*    private void takeImage() {
        Log.d(TAG, "data directory ------------> " + Environment.getDataDirectory());
        Log.d(TAG, "external storage directory ------------> " + Environment.getExternalStorageDirectory());

        //new image intent
        Intent imageIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //check if there is an activity component that can handle the image
        if (imageIntent.resolveActivity(getPackageManager()) != null) {
           *//* Log.d(TAG,"external file directory with root directory is ------------> " + this.getExternalFilesDir(Environment.getRootDirectory().toString()));
            Log.d(TAG,"external storage directory with root directory is ------------> " + this.getDir(Environment.getRootDirectory().toString()));*//*



            actualFile = createImageFile();

            if (actualFile != null) {

                if ((Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT)) {
                    photoUri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".provider", actualFile);
                    Log.d(TAG, "photo uri is ------------> " + photoUri);
                    imageIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                    startActivityForResult(imageIntent, IMAGE_CAPTURE_REQUEST_CODE);


                } else {
                    photoUri = Uri.fromFile(actualFile);
                    Log.d(TAG, "photo uri is ------------> " + photoUri);
                    imageIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                    startActivityForResult(imageIntent, IMAGE_CAPTURE_REQUEST_CODE);
                }

            }

        }
    }

    private File createImageFile() {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        imageFileName = "JPEG_" + timeStamp;
        *//*File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);*//*
        File storageDir = getExternalFilesDir(EMPLOYEE_IMAGE_DIRECTORY);
        Log.d(TAG, "storage directory is ------------> " + storageDir);
     *//*   if (!storageDir.exists() || !storageDir.exists()) {
            storageDir.mkdir();
            Log.d(TAG,"storage directory is ------------>>>>>>> " + storageDir);
        }*//*
        File imageFIle = new File(storageDir, imageFileName);
        *//*File imageFIle = null;*//*

        try {
            imageFIle = File.createTempFile(
                    imageFileName,
                    ".jpg",
                    storageDir
            );
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = imageFIle.getAbsolutePath();
        Log.d(TAG, "image file path is ------------> " + currentPhotoPath);
        return imageFIle;
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.d(TAG, "result code ------------> " + resultCode);
        if (requestCode == IMAGE_CAPTURE_REQUEST_CODE || resultCode == RESULT_OK) {

            loadImageFromFile();

        }
    }

    private void loadImageFromFile() {

        *//*actualFile = new File(this.getFilesDir(), "2_employee_images_stuff");
        employeeProfileBinding.employeeImage.setImageDrawable(Drawable.createFromPath(actualFile.toString()));*//*
        Glide.with(this).load(photoUri).into(employeeProfileBinding.employeeImage);
    }*/
}
