package com.ciazhar.a111509000;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.ciazhar.a111509000.model.Message;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MessageAdapter messageAdapter;
    private List<Message> messageList = new ArrayList<>();
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);
        messageAdapter = new MessageAdapter(this, messageList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(messageAdapter);

        messageList();
    }

    private void messageList() {

        sharedPreferences = getSharedPreferences(SendActivity.MY_PREF, Context.MODE_PRIVATE);

        String jsonMessage = sharedPreferences.getString("allMessage","null");

        Log.i("jsonMessage",jsonMessage);

    }

    public void newMessage(View view) {
        Intent intent = new Intent(this,SendActivity.class);
        startActivity(intent);
    }
}
