package com.example.tarea_labo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.tarea_labo3.utils.AppConstants;

public class MainActivity extends AppCompatActivity {

    private EditText et_username,et_password,et_email,et_gender;
    private String username,password,email,gender;
    private Button btn_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        et_email = findViewById(R.id.et_email);
        et_gender = findViewById(R.id.et_gender);
        btn_send = findViewById(R.id.btn_send);

        btn_send.setOnClickListener(v ->{
            username = et_username.getText().toString();
            password = et_password.getText().toString();
            email = et_email.getText().toString();
            gender = et_gender.getText().toString();

            Intent mIntent = new Intent(MainActivity.this,NewActivity.class);
            mIntent.putExtra(AppConstants.INTENT_KEY_USERNAME,username);
            mIntent.putExtra(AppConstants.INTENT_KEY_PASSWORD,password);
            mIntent.putExtra(AppConstants.INTENT_KEY_EMAIL,email);
            mIntent.putExtra(AppConstants.INTENT_KEY_GENDER,gender);
            startActivity(mIntent);

        });


    }
}
