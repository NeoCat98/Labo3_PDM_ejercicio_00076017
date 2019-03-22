package com.example.tarea_labo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.tarea_labo3.utils.AppConstants;

public class NewActivity extends AppCompatActivity {

    private TextView tvUsername,tvPassword,tvEmail,tvGender;
    private Button btn_share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        tvUsername = findViewById(R.id.tv_username);
        tvPassword = findViewById(R.id.tv_password);
        tvEmail = findViewById(R.id.tv_email);
        tvGender = findViewById(R.id.tv_gender);
        btn_share = findViewById(R.id.btn_share);

        Intent m_intent = this.getIntent();

        if(m_intent !=  null){
            String username,password,email,gender;
            username = m_intent.getStringExtra(AppConstants.INTENT_KEY_USERNAME);
            password = m_intent.getStringExtra(AppConstants.INTENT_KEY_PASSWORD);
            email = m_intent.getStringExtra(AppConstants.INTENT_KEY_EMAIL);
            gender = m_intent.getStringExtra(AppConstants.INTENT_KEY_GENDER);
            tvUsername.setText(username);
            tvPassword.setText(password);
            tvGender.setText(gender);
            tvEmail.setText(email);
        }

        btn_share.setOnClickListener(v->{
            String result;
            result = m_intent.getStringExtra(AppConstants.INTENT_KEY_USERNAME)+" "+m_intent.getStringExtra(AppConstants.INTENT_KEY_PASSWORD)+" "+ m_intent.getStringExtra(AppConstants.INTENT_KEY_EMAIL)+" "+m_intent.getStringExtra(AppConstants.INTENT_KEY_GENDER);
            Intent mIntent = new Intent();
            mIntent.setAction(Intent.ACTION_SEND);
            mIntent.setType("text/plain");
            mIntent.putExtra(Intent.EXTRA_TEXT,result);
            startActivity(mIntent);
        });
    }
}
