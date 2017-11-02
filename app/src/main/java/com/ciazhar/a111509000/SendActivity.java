package com.ciazhar.a111509000;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.ciazhar.a111509000.model.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SendActivity extends AppCompatActivity {

    EditText name, content;
    static String MY_PREF="ciazhar";
    List<Message> messageList = new ArrayList<>();
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        name = (EditText) findViewById(R.id.send_pengguna);
        content = (EditText) findViewById(R.id.send_content);
    }

    public void sendMessage(View view) {

        String sName = name.getText().toString();
        String sContent = content.getText().toString();

        ///
        SharedPreferences.Editor editor = getSharedPreferences(MY_PREF,MODE_PRIVATE).edit();
        editor.putString("name",sName);
        editor.putString("content",sContent);
        editor.apply();

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public static void writeArray() {

    }

}
