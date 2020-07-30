package com.example.assu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;


public class AdapterAssignmentsTest extends ArrayAdapter {

    ArrayList<AssModel> datalistassignmentstest ;
    Context adapterContext;
    public static String lec_name;
    int adapterRescources;
    DatabaseReference reference;
    public AdapterAssignmentsTest( Context context, int resource,  ArrayList<AssModel> mydatalistassignmentstest) {
        super(context, resource, mydatalistassignmentstest);
        this.adapterContext = context;
        this.adapterRescources = resource;
        datalistassignmentstest = mydatalistassignmentstest;
    }
    public View getView(int position, View convertView, final ViewGroup parent) {
        View row;
        LayoutInflater rowInflater = LayoutInflater.from(adapterContext);
        row = rowInflater.inflate(adapterRescources ,parent,false);
        TextView ass_name_view , question;
        RadioGroup rgb;
        RadioButton b1,b2,b3,b4;

        String ass_name = AdapterAssignmentOfStudent.ass_name;
        TextView nameJAVA = (TextView) row.findViewById(R.id.mainText);
        final Button Attend = row.findViewById(R.id.attend_lecture);
        reference = AssignmentsList.reference_ass;
        ass_name_view = row.findViewById(R.id.ass_name);
        question = row.findViewById(R.id.ass_question);
        rgb = row.findViewById(R.id.radio_edit_text);
        b1 = row.findViewById(R.id.txt1);
        b2 = row.findViewById(R.id.txt2);
        b3 = row.findViewById(R.id.txt3);
        b4 = row.findViewById(R.id.txt4);

        ass_name_view.setText("Q"+(position+1));
        question.setText(datalistassignmentstest.get(position).getQuestion());
        b1.setText(datalistassignmentstest.get(position).getAnswer_one());
        b2.setText(datalistassignmentstest.get(position).getAnswer_two());
        b3.setText(datalistassignmentstest.get(position).getAnswer_three());
        b4.setText(datalistassignmentstest.get(position).getAnswer_four());



        return row;
    }
}
