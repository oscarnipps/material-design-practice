package com.example.materialpractice.dialogpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.materialpractice.R;
import com.example.materialpractice.databinding.ActivityDialogPracticeBinding;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
 * Class that shows a dialog fragment (full screen , custom alert dialogs)
 *
 * Created by oscar 07/25/2020
 *
 */
public class DialogPracticeActivity extends AppCompatActivity {

    ActivityDialogPracticeBinding dialogPracticeBinding;
    int selectedMenuId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialogPracticeBinding = DataBindingUtil.setContentView(this, R.layout.activity_dialog_practice);

        dialogPracticeBinding.showDialog.setOnClickListener(v -> {
            DialogPracticeFragment dialogPracticeFragment = DialogPracticeFragment.getInstance();
            dialogPracticeFragment.show(getSupportFragmentManager(), "location_dialog_fragment");
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
            case 1:
                Toast.makeText(this, item.getTitle() + " was clicked", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, item.getTitle() + " clicked", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, item.getTitle() + " clicked", Toast.LENGTH_SHORT).show();
        }

        return false;

    }


    public void showMenuPopUp(View view) {
        Context context = new ContextThemeWrapper(this,R.style.PopUpMenuCustomStyle);

        PopupMenu popupMenu = new PopupMenu(context, dialogPracticeBinding.showAmountMenu);

        /*
        popupMenu.getMenu().add(0, 1, 0, "kiosk");
        popupMenu.getMenu().add(0, 2, 0, "shop");
        popupMenu.getMenu().add(0, 3, 0, "sales");
        */

        popupMenu.getMenuInflater().inflate(R.menu.practice_menu, popupMenu.getMenu());

        if (selectedMenuId != 0) popupMenu.getMenu().findItem(selectedMenuId).setIcon(getResources().getDrawable(R.drawable.ic_check));

        popupMenu.setOnMenuItemClickListener(menuItem -> {

            selectedMenuId = menuItem.getItemId();

            String itemTitleClickedOn = menuItem.getTitle().toString();
            Toast.makeText(DialogPracticeActivity.this,
                    itemTitleClickedOn + " clicked with id : " + menuItem.getItemId(),
                    Toast.LENGTH_SHORT).show();
            return true;
        });


        try {
            //get the field declared in the PopupMenu class and make it accessible
            Field field = popupMenu.getClass().getDeclaredField("mPopup");
            field.setAccessible(true);

            //use the field to get the method use to force show the icons
            Object menuPopUpHelper = field.get(popupMenu);
            Class<?> classPopUpHelper = Class.forName(menuPopUpHelper.getClass().getName());
            Method setForceIcons = classPopUpHelper.getMethod("setForceShowIcon", boolean.class);
            setForceIcons.invoke(menuPopUpHelper, true);

        } catch (Exception e) {
            e.printStackTrace();
        }


        popupMenu.show();

    }

}