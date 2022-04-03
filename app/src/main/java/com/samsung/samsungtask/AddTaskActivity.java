package com.samsung.samsungtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.samsung.samsungtask.auth.LogInActivity;
import com.samsung.samsungtask.services.DatabaseService;

import java.util.Date;

public class AddTaskActivity extends AppCompatActivity {
    Button button;
    EditText editTextName;
    EditText editTextInfo;
    EditText editTextPersonName;
    EditText editTextImportance;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        initViews();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName = editTextName.getText().toString();
                String info = editTextInfo.getText().toString();
                String personName = editTextPersonName.getText().toString();
                String importance = editTextImportance.getText().toString();
                Date date = new Date();
                int year = date.getYear() + 1900;
                String time = date.getDate() + "." + date.getMonth() + "." + year + ", " + date.getHours() + ":" + date.getMinutes();

                DatabaseService.createNewTask(taskName, info, importance, personName, time);
                startActivity(new Intent(getBaseContext(), MainActivity.class));
            }
        });
    }

    void initViews() {
        button = findViewById(R.id.button);
        editTextName = findViewById(R.id.editTextName);
        editTextInfo = findViewById(R.id.editTextInfo);
        editTextImportance = findViewById(R.id.editTextImportance);
        editTextPersonName = findViewById(R.id.editTextPersonName);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
    }
}