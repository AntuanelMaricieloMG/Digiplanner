package com.example.digiplanner.ui.postits;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.digiplanner.databinding.FragmentPostitsBinding;


public class PostitsFragment extends Fragment {

    private FragmentPostitsBinding fragmentP;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PositsViewModel positsViewModel =
                new ViewModelProvider(this).get(PositsViewModel.class);

        fragmentP = FragmentPostitsBinding.inflate(inflater, container, false);
        View root = fragmentP.getRoot();
        //elementos del layout
        final TextView textView = fragmentP.textPost;
        positsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentP = null;
    }
}