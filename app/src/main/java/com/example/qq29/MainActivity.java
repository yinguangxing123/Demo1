package com.example.qq29;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText Et1,Et2;
    private ImageButton Bt1;
    private Button Zhuce;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Et1=findViewById(R.id.Et1);
        Et2=findViewById(R.id.Et2);
        Bt1 = findViewById(R.id.bt1);
        Zhuce =findViewById(R.id.zhuce);
        Intent intent = getIntent();
        String username = intent.getStringExtra("user");
        String password = intent.getStringExtra("word");
        Zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,register.class);
                startActivity(intent);
            }
        });
        Bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Et1.setHint(null);
                Et2.setHint(null);
                Intent intent = getIntent();
                String username1 = intent.getStringExtra("user");
                String password1 = intent.getStringExtra("word");
                String username = Et1.getText().toString();
                String password = Et2.getText().toString();
                if (username.equals(username1)&&password.equals(password1))
                {
                    Intent intent1 =new Intent();
                    intent.setClass(MainActivity.this,chat.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this,"账号或密码错误",Toast.LENGTH_SHORT).show();
                    Intent intent2 =new Intent();
                    intent2.setClass(MainActivity.this,register.class);
                    startActivity(intent2);
                    Toast.makeText(MainActivity.this,"重新注册",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}