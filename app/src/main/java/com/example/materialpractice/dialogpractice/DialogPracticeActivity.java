package com.example.materialpractice.dialogpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

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

        registerForContextMenu(dialogPracticeBinding.showMenu);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("select channel");
        menu.add(0, 1, 0, "kiosk channel");
        menu.add(0, 2, 0, "shop channel");
        menu.add(0, 3, 0, "sales channel");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case 1 :
                Toast.makeText(this, item.getTitle() + " was clicked", Toast.LENGTH_SHORT).show();
                break;
            case 2 :
                Toast.makeText(this, item.getTitle() + " clicked", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, item.getTitle() + " clicked", Toast.LENGTH_SHORT).show();
        }

        return false;

    }


    public void showMenuPopUp(View view) {
        PopupMenu popupMenu = new PopupMenu(this,dialogPracticeBinding.showAmountMenu);
        popupMenu.getMenu().add(0, 1, 0, "kiosk");
        popupMenu.getMenu().add(0, 2, 0, "shop");
        popupMenu.getMenu().add(0, 3, 0, "sales");
        popupMenu.getMenuInflater().inflate(R.menu.practice_menu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Toast.makeText(DialogPracticeActivity.this, "pop up menu clicked", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        popupMenu.show();
    }
}