package com.example.materialpractice.bottomsheetpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.materialpractice.R;
import com.example.materialpractice.databinding.ActivityBottomSheetBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

public class BottomSheetActivity extends AppCompatActivity {
    public static final String TAG = BottomSheetActivity.class.getSimpleName();
    BottomSheetBehavior bottomSheetBehavior;
    ActivityBottomSheetBinding bottomSheetBinding;
    PopupWindow popupWindow;
    View popupView;
    TextView selectedCalendarDate;
    MaterialCalendarView materialCalendarView;
    String selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomSheetBinding = DataBindingUtil.setContentView(this,R.layout.activity_bottom_sheet);

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetBinding.bottomSheet);


        popupView = LayoutInflater.from(this).inflate(R.layout.schedule_calendar_popup, null);

        materialCalendarView = popupView.findViewById(R.id.dialog_calendar);


        selectedCalendarDate = popupView.findViewById(R.id.selected_calendar_date);

        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

                switch (newState) {
                    case BottomSheetBehavior.STATE_EXPANDED:

                        bottomSheetBinding.addSchedule.setVisibility(View.GONE);
                        bottomSheetBinding.totalSchedules.setVisibility(View.GONE);
                        bottomSheetBinding.bottomSheetIndicatorView.setVisibility(View.GONE);
                        bottomSheetBinding.scheduleDate.setVisibility(View.VISIBLE);
                        bottomSheetBinding.scheduledVisitToolbar.setVisibility(View.VISIBLE);
                        break;

                    case BottomSheetBehavior.STATE_DRAGGING:
                        bottomSheetBinding.scheduledVisitToolbar.setVisibility(View.GONE);
                        break;

                    case BottomSheetBehavior.STATE_COLLAPSED:
                        bottomSheetBinding.addSchedule.setVisibility(View.VISIBLE);
                        bottomSheetBinding.totalSchedules.setVisibility(View.VISIBLE);
                        bottomSheetBinding.bottomSheetIndicatorView.setVisibility(View.VISIBLE);
                        bottomSheetBinding.scheduleDate.setVisibility(View.GONE);
                        bottomSheetBinding.scheduledVisitToolbar.setVisibility(View.GONE);
                        break;

                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                selectedDate = String.valueOf (date.getDay());
                bottomSheetBinding.totalSchedules.setText(selectedDate);
            }
        });

        bottomSheetBinding.viewCalendar.setOnClickListener(v ->{
            showCalendarPopUp();
        });
    }

    private void showCalendarPopUp() {
        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;

        // lets taps outside the popup also dismiss it
        boolean focusable = true;
        popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        popupWindow.showAtLocation(bottomSheetBinding.getRoot(), Gravity.CENTER_VERTICAL, 0, -110);

        // dismiss the popup window when touched
        popupView.setOnTouchListener((v, event) -> {
            v.performClick();
            return true;
        });
    }


}