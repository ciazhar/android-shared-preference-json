package com.ciazhar.a111509000;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ciazhar.a111509000.model.Message;
import com.ciazhar.a111509000.model.MessageAdapter;

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

        String nama = sharedPreferences.getString("name",null);
        String content = sharedPreferences.getString("content",null);

        messageList.add(new Message("Hafidz","Halo",new Date(),R.drawable.chrysanthemum));
        messageList.add(new Message("Hafidz","Halo",new Date(),R.drawable.chrysanthemum));
        messageList.add(new Message("Hafidz","Halo",new Date(),R.drawable.chrysanthemum));

        if (nama!=null&&content!=null){
            messageList.add(new Message(nama,content,new Date(),R.drawable.chrysanthemum));
        }

    }

    public void newMessage(View view) {
        Intent intent = new Intent(this,SendActivity.class);
        startActivity(intent);
    }
}
