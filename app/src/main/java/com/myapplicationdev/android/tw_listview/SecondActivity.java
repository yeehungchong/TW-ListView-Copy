package com.myapplicationdev.android.tw_listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    TextView tvYear;
    ArrayAdapter aa;
    ArrayList<Module> module;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = findViewById(R.id.lvModule);
        tvYear = findViewById(R.id.tvYear);

        Intent i = getIntent();
        String year = i.getStringExtra("selectedYear");
        tvYear.setText(year);

        module = new ArrayList<Module>();

        if (year.equals("Year 1")) {
            module.add(new Module("C11", false));
            module.add(new Module("C12", true));
            module.add(new Module("C13", false));
        } else if (year.equals("Year 2")) {
            module.add(new Module("C21", true));
            module.add(new Module("C22", true));
            module.add(new Module("C23", false));
        } else if (year.equals("Year 3")) {
            module.add(new Module("C31", false));
            module.add(new Module("C32", true));
            module.add(new Module("C33", true));
        }

        aa = new ModuleAdapter(this, R.layout.row, module);
        lv.setAdapter(aa);

    }



}
