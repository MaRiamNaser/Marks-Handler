package com.example.assu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static String subject_name;
    public static String id;
    Button add_subject;
    ArrayList<String> Subjects;
    DatabaseReference ref ;
    ListView customListViewJAVA;
    String key_id = LoginActivityMain.key_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customListViewJAVA =  findViewById(R.id.listView1);
        add_subject = findViewById(R.id.add_subject);
        Subjects = new ArrayList<>();
        ref = FirebaseDatabase.getInstance().getReference("Subjects");


        getData();


       // String subjectsList[] = {"Data Comuncations", "Logic Design", "Introduction To Cs","Python", "Network1", "Simulation"};


        //**************************************************************
        // when you click on item in list view
        customListViewJAVA.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                subject_name = item;
                Intent newActivity = new Intent(MainActivity.this, EverySubjectInDetails.class);
                startActivity(newActivity);
            }
        });
        //**************************************************************
        add_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newActivity = new Intent(MainActivity.this, AddSubject.class);
                startActivity(newActivity);
            }
        });
    }
    void getData()
    {
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot d : dataSnapshot.getChildren()) {
                        String name = d.child("id_doctor").getValue().toString();
                        String sub_name = d.getKey();
                        if(name.equals(key_id)) {
                            Subjects.add(sub_name);
                        }
                    }
                int xmlFile = R.layout.row_subjects_doctors;
                AdapterSubjectsForDoctors adapter = new AdapterSubjectsForDoctors(MainActivity.this, xmlFile,Subjects);
                customListViewJAVA.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
