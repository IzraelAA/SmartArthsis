package com.flege.gumukrejo.dataclass;

public class Pelanggan {
    private String id_pelanggan;
    private String nik;
    private String nama;
    private String gender;
    private String kontak;

    public Pelanggan(String id_pelanggan, String nik, String nama, String gender, String kontak) {
        this.id_pelanggan = id_pelanggan;
        this.nik = nik;
        this.nama = nama;
        this.gender = gender;
        this.kontak = kontak;
    }

    public Pelanggan() {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    @Override
    public String toString() {
        return "Pelanggan{" +
                "id_pelanggan='" + id_pelanggan + '\'' +
                ", nik='" + nik + '\'' +
                ", nama='" + nama + '\'' +
                ", gender='" + gender + '\'' +
                ", kontak='" + kontak + '\'' +
                '}';
    }
}