package com.ciazhar.a111509000.model;

import java.util.Date;

/**
 * Created by D2J-00 on 01/11/2017.
 */
public class Message {
    String pengirim;
    String content;
    Date waktu;
    Integer foto;

    public Message(String pengirim, String content, Date waktu, Integer foto) {
        this.pengirim = pengirim;
        this.content = content;
        this.waktu = waktu;
        this.foto = foto;
    }

    public String getPengirim() {
        return pengirim;
    }

    public void setPengirim(String pengirim) {
        this.pengirim = pengirim;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getWaktu() {
        return waktu;
    }

    public void setWaktu(Date waktu) {
        this.waktu = waktu;
    }

    public Integer getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Message{" +
                "pengirim='" + pengirim + '\'' +
                ", content='" + content + '\'' +
                ", waktu=" + waktu +
                ", foto=" + foto +
                '}';
    }

}
