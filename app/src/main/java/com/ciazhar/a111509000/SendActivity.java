package com.ciazhar.a111509000;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.ciazhar.a111509000.model.Message;
import com.google.gson.Gson;

import java.util.Date;

public class SendActivity extends AppCompatActivity {

    EditText name, content;
    static String MY_PREF="ciazhar";

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
        MainActivity.messageList.add(message);

        Gson gson = new Gson();
        String jsonMessage = gson.toJson(MainActivity.messageList);

        SharedPreferences.Editor editor = getSharedPreferences(MY_PREF,MODE_PRIVATE).edit();
        editor.putString("allMessage",jsonMessage);
        editor.apply();

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
