package com.example.digiplanner.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.digiplanner.R;

public class AdaptadorGridDias extends BaseAdapter {

    Context context;
    String[] numeroDia;
    TextView textDia;

    LayoutInflater inflater;

    public AdaptadorGridDias(Context context,String[] numeroDia){
        this.context=context;
        this.numeroDia=numeroDia;
    }

    @Override
    public int getCount() {
        return numeroDia.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_dias, parent,false);

        }

        textDia =(TextView) convertView.findViewById(R.id.grid_numero_dia);
        textDia.setText(numeroDia[position]);
        return convertView;

    }
}
