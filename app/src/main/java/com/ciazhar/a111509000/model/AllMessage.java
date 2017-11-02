package com.ciazhar.a111509000.model;

import java.util.List;

/**
 * Created by D2J-00 on 01/11/2017.
 */
public class AllMessage {
    String name;
    List<Message> allMessage;


    public AllMessage(String name, List<Message> allMessage) {
        this.name = name;
        this.allMessage = allMessage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getAllMessage() {
        return allMessage;
    }

    public void setAllMessage(List<Message> allMessage) {
        this.allMessage = allMessage;
    }
}
