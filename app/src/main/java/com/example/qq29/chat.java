package com.example.qq29;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

public class chat extends AppCompatActivity {
    private Spinner spin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        spin = findViewById(R.id.spinner1);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String name = (String) spin.getItemAtPosition(position);
                switch (name){
                    case "打开浏览器":
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse("http://www.baidu.com");
                        intent.setData(content_url);
                        startActivity(intent);
                        break;
                    case "拨打电话":
                        startActivityForResult(new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI), 0);
                        break;
                    case "打开图片":
                        Intent intent2 = new Intent();
                        intent2.setAction(Intent.ACTION_MAIN);
                        intent2.addCategory(Intent.CATEGORY_APP_GALLERY);
                        startActivity(intent2);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}