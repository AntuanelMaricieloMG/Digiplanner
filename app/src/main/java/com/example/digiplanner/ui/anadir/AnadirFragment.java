package com.example.digiplanner.ui.anadir;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.example.digiplanner.databinding.FragmentAnadirBinding;


public class AnadirFragment extends Fragment {

    private FragmentAnadirBinding fragmentA;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AnadirViewModel anadirViewModel =
                new ViewModelProvider(this).get(AnadirViewModel.class);

        fragmentA = FragmentAnadirBinding.inflate(inflater, container, false);
        View root = fragmentA.getRoot();
        //elementos del layout
        final TextView textView = fragmentA.textAnadir;
        anadirViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentA = null;
    }
}