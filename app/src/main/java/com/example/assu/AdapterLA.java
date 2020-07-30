package com.example.assu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AdapterLA extends ArrayAdapter {
    ArrayList<ModelLA > data;
    Context adapterContext;
    int adapterRescources;
    public static String lect_name;
    DatabaseReference d ;
    public AdapterLA(@NonNull Context context, int resource, @NonNull ArrayList objects) {
        super(context, resource, objects);
        this.adapterContext = context;
        this.adapterRescources = resource;
        data = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        LayoutInflater rowInflater = LayoutInflater.from(adapterContext);
        row = rowInflater.inflate(adapterRescources ,parent,false);

        TextView nameJAVA = (TextView) row.findViewById(R.id.mainText);
        final Button Finish = row.findViewById(R.id.finish_lecture);
        d = LecturesFragmentForDoctorSubject.reference_lec;
        final String subject1 = data.get(position).getName();
        nameJAVA.setText(subject1);
        if(data.get(position).getState().equals("false"))
        {
            Finish.setBackgroundResource(R.drawable.c);
        }

        Finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Finish.setBackgroundResource(R.drawable.c);
                d.child("lecture_access").setValue("false");
            }
        });
        nameJAVA.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                lect_name = subject1;
                Intent newActivity = new Intent(getContext(), ListViewLecturesForDoctors.class);
                getContext().startActivity(newActivity);
                return false;
            }
        });

        return row;
    }
}
