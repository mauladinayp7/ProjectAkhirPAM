package com.example.quotestokoh.database;

public class Tokoh {
    String id, nama, qts;

    public Tokoh(String id, String nama, String qts) {
        this.id = id;
        this.nama = nama;
        this.qts = qts;
    }

    public Tokoh() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getQts() {
        return qts;
    }

    public void setQts(String qts) {
        this.qts = qts;
    }
}