package com.flege.gumukrejo.model;

import com.google.gson.annotations.SerializedName;

public class Pelanggan {
    @SerializedName("id_pelanggan")
    private String id_pelanggan;
    @SerializedName("nik")
    private String nik;
    @SerializedName("nama")
    private String nama;
    @SerializedName("kontak")
    private String kontak;
    @SerializedName("gender")
    private String gender;

    public Pelanggan(){}

    public Pelanggan(String id_pelanggan, String nik, String nama, String kontak, String gender) {
        this.id_pelanggan = id_pelanggan;
        this.nik = nik;
        this.nama = nama;
        this.kontak = kontak;
        this.gender = gender;
    }

    public String getId_pelanggan() {
        return id_pelanggan;
    }

    public void setId_pelanggan(String id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
