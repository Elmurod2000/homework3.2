package com.example.homework32;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mEmailEt, mThemeEt, mMessageEt;
    Button mSendEmailBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmailEt = findViewById(R.id.et_email);
        mThemeEt = findViewById(R.id.et_theme);
        mMessageEt = findViewById(R.id.et_message);
        mSendEmailBtn = findViewById(R.id.btn_send);

        mSendEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = mEmailEt.getText().toString().trim();
                String theme = mThemeEt.getText().toString().trim();
                String message = mMessageEt.getText().toString().trim();

                sendEmail(email, theme, message);
            }
        });
    }

    private void sendEmail(String email, String theme, String message) {
        Intent mEmailIntent = new Intent(Intent.ACTION_SEND);
        mEmailIntent.setData(Uri.parse("mailto:"));
        mEmailIntent.setType("text/plain");


        mEmailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        mEmailIntent.putExtra(Intent.EXTRA_SUBJECT, new String[]{theme});
        mEmailIntent.putExtra(Intent.EXTRA_TEXT, new String[]{message});

        try {
            startActivity(Intent.createChooser(mEmailIntent, "Choose an Email Client "));

        } catch (Exception e){

            Toast.makeText(this, "e.getMessage", Toast.LENGTH_SHORT).show();
        }

    }
}