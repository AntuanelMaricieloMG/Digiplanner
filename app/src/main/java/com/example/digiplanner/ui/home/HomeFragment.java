package com.example.digiplanner.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.digiplanner.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

private FragmentHomeBinding fragmentH;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

    fragmentH = FragmentHomeBinding.inflate(inflater, container, false);
    View root = fragmentH.getRoot();
        //elementos del layout
        final TextView textView = fragmentH.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
    fragmentH = null;
    }
}