package com.example.digiplanner.ui.tablas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.digiplanner.databinding.FragmentTablasBinding;

public class TablasFragment extends Fragment {

    private FragmentTablasBinding fragmentT;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TablasViewModel tablasViewModel =
                new ViewModelProvider(this).get(TablasViewModel.class);

        fragmentT = FragmentTablasBinding.inflate(inflater, container, false);
        View root = fragmentT.getRoot();
        //elementos del layout
        final TextView textView = fragmentT.textTablas;
        tablasViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentT = null;
    }
}