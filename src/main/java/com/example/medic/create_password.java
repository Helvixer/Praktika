package com.example.medic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class create_password extends AppCompatActivity {

    Button pass_btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_password);
        pass_btn1 = findViewById(R.id.pass_btn1);

        pass_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pass = new Intent(create_password.this, login.class);
                create_password.this.startActivity(pass);
                create_password.this.finish();
            }
        });
        pass_btn1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
    }

    public void retry_click(View view) {
        Intent pass = new Intent(create_password.this, login.class);
        create_password.this.startActivity(pass);
        create_password.this.finish();
    }
}