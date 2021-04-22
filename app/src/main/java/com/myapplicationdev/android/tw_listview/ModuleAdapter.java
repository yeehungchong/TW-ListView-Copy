package com.myapplicationdev.android.tw_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ModuleAdapter extends ArrayAdapter<Module> {

    private ArrayList<Module> module;
    private Context context;
    private TextView tvModule;
    private ImageView ivProgram;

    public ModuleAdapter(Context context, int resource, ArrayList<Module> objects){
        super(context, resource, objects);
        module = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvModule = rowView.findViewById(R.id.tvModule);
        ivProgram = rowView.findViewById(R.id.ivProgram);

        Module currentModule = module.get(position);

        tvModule.setText(currentModule.getModule());
        if(currentModule.isProgram()) {
            ivProgram.setImageResource(R.drawable.prog);
        }
        else {
            ivProgram.setImageResource(R.drawable.nonprog);
        }
        return rowView;
    }




}
