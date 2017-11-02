package com.ciazhar.a111509000;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ciazhar.a111509000.model.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by D2J-00 on 01/11/2017.
 */
public class MessageAdapter  extends RecyclerView.Adapter<MessageAdapter.MessageView>{

    Context context;
    List<Message> messageList = new ArrayList<>();

    public MessageAdapter(Context context, List<Message> messageList) {
        this.context = context;
        this.messageList = messageList;
    }

    @Override
    public MessageView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_data,parent,false);
        return new MessageView(view);
    }

    @Override
    public void onBindViewHolder(MessageView holder, int position) {
        Message data = messageList.get(position);
        holder.image.setImageResource(data.getFoto());
        holder.name.setText(data.getPengirim());
        holder.message.setText(data.getContent());
        holder.date.setText(data.getWaktu().toString());
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class MessageView extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name, message,date;
        CardView cardView;

        public MessageView(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.main_image);
            name = (TextView) itemView.findViewById(R.id.main_name);
            message = (TextView) itemView.findViewById(R.id.main_message);
            date = (TextView) itemView.findViewById(R.id.main_date);
            cardView = (CardView) itemView.findViewById(R.id.main_card_view);
        }
    }
}
