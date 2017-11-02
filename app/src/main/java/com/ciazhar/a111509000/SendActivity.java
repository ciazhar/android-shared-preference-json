package com.ciazhar.a111509000;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.ciazhar.a111509000.model.Message;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SendActivity extends AppCompatActivity {

    EditText name, content;
    static String MY_PREF="ciazhar";
    List<Message> messageList = new ArrayList<>();
    Set<String> list;
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

        Message message = new Message(sName,sContent,new Date(),R.drawable.chrysanthemum);

        Gson gson = new Gson();
        String jsonMessage = gson.toJson(message);

        SharedPreferences.Editor editor = getSharedPreferences(MY_PREF,MODE_PRIVATE).edit();
        editor.putString("allMessage",jsonMessage);
        editor.apply();

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
