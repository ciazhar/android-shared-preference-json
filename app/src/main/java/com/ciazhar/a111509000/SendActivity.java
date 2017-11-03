package com.ciazhar.a111509000;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.ciazhar.a111509000.model.Message;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SendActivity extends AppCompatActivity {

    EditText name, content;
    static String MY_PREF="ciazhar";
    static List<Message> messageList = new ArrayList<>();

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
        messageList.add(message);

        Gson gson = new Gson();
        String jsonMessage = gson.toJson(messageList);

        SharedPreferences.Editor editor = getSharedPreferences(MY_PREF,MODE_PRIVATE).edit();
        editor.putString("allMessage",jsonMessage);
        editor.apply();

        Intent intent = new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
