package com.example.materialpractice.recyclerviewpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.materialpractice.R;
import com.example.materialpractice.databinding.ActivityRecyclerViewBinding;

public class RecyclerViewEntryActivity extends AppCompatActivity {
    private ActivityRecyclerViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_recycler_view);

        setUpDefaultFragment();
    }

    private void setUpDefaultFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.container,new DemoCategoryFragment());

        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
    }

    public void recyclerViewDemo(View view) {

        switch (view.getId()) {

            case R.id.with_collapsible_card:
                showFragment(DemoFragmentA.getInstance());
                break;

            case R.id.with_checkbox_and_edit_text:
                showFragment(DemoFragmentB.getInstance());
                break;

            case R.id.with_images_and_data_binding:
                showFragment(DemoFragmentC.getInstance());
                break;

            case R.id.with_diff_util:
                showFragment(DemoFragmentD.getInstance());
                break;

        }
    }

    private void showFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
            return;
        }
        finish();
    }
}