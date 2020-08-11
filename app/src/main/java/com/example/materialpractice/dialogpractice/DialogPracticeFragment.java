package com.example.materialpractice.dialogpractice;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;

import com.example.materialpractice.R;
import com.example.materialpractice.databinding.FragmentDialogPracticeBinding;
import com.example.materialpractice.searchviewpractice.SearchActivity;

public class DialogPracticeFragment extends DialogFragment {
    public static final String TAG = DialogPracticeFragment.class.getSimpleName();
    FragmentDialogPracticeBinding binding;
    Context mContext;
    onDialogPracticeFragmentInterface mListener;
    SearchView searchView;

    //required empty constructor
    public DialogPracticeFragment() {
    }

    public static DialogPracticeFragment getInstance() {
        return new DialogPracticeFragment();
    }

    interface onDialogPracticeFragmentInterface{

        void onButtonSaveClicked();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dialog_practice, container, false);


        ((AppCompatActivity)requireActivity()).setSupportActionBar(binding.searchToolbar);
        binding.searchToolbar.setNavigationOnClickListener(v-> dismiss());


        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu , menu);
        searchView =  (SearchView) menu.findItem(R.id.search).getActionView();

        // remove the under line / under-bar (line under the edit text) of the toolbar searchView by setting the color to be the same as the toolbar background
        View v =  searchView.findViewById(androidx.appcompat.R.id.search_plate);
        v.setBackgroundColor(getResources().getColor(R.color.color_toolbar));

        //use a custom close icon in the search view
        ImageView searchCloseIcon = searchView.findViewById(androidx.appcompat.R.id.search_close_btn);
        searchCloseIcon.setImageResource(R.drawable.ic_search_close);

        // get the edit text element from the searchView and set custom font and color changes
        TextView searchEditText = searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        searchEditText.setTextColor(getResources().getColor(R.color.colorAccent));
        searchEditText.setHintTextColor(getResources().getColor(R.color.colorAccent));
        Typeface typeface = ResourcesCompat.getFont(requireContext(),R.font.raleway);
        searchEditText.setTypeface(typeface);


        searchView.setQueryHint("search items");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String searchFilter) {
                Log.d(TAG," " + searchFilter);
                return false;
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.MATCH_PARENT;

        if (dialog != null) {
            dialog.getWindow().setLayout(width,height);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mListener = (onDialogPracticeFragmentInterface) context;
        } catch (ClassCastException e) {
            Log.d(TAG, "error -> " + e.getLocalizedMessage());
        }

    }
}
