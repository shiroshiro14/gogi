package com.example.gogi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.net.MalformedURLException;
import java.net.URL;

public class NumberTrace extends AppCompatActivity {
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_trace);
        mDatabase = FirebaseDatabase.getInstance().getReference("/");
        EditText editText = findViewById(R.id.input);
        Button input_button = findViewById(R.id.send);

        input_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Editable input = editText.getText();
                String real_input = input.toString();
                mDatabase.setValue(real_input);
            }
        });

    }
}