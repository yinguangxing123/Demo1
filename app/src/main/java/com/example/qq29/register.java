package com.example.qq29;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class register extends AppCompatActivity {
    private EditText et1,et2;
    private Button bt1,bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        bt1 = findViewById(R.id.zhuce1);
        bt2 = findViewById(R.id.deng);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(register.this,MainActivity.class);
                startActivity(intent);
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et1.getText().toString();
                String password = et2.getText().toString();
                Intent intent = new Intent(register.this,MainActivity.class);
                intent.putExtra("user",username);
                intent.putExtra("word",password);
                startActivity(intent);
            }
        });
    }
}