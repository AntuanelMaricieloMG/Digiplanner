package com.example.digiplanner.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.digiplanner.R;
import com.example.digiplanner.databinding.FragmentHomeBinding;
import com.example.digiplanner.ui.AdaptadorGridDias;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding fragmentH;
    GridView grid;
    Context context;
    String[] numero = {"1","2","3","4","5","6","7"};


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);
        grid = (GridView) view.findViewById(R.id.gridViewMes);
        AdaptadorGridDias adaptador= new AdaptadorGridDias(getActivity(),numero);
        grid.setAdapter(adaptador);

        return view;
    }
}