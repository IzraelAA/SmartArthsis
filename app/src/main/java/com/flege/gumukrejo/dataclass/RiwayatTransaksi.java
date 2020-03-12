package com.flege.gumukrejo.dataclass;

public class RiwayatTransaksi {
    private String title;
    private String subTitle;
    private String status;
    private String tanggal;

    public RiwayatTransaksi(String title, String subTitle, String status, String tanggal) {
        this.title = title;
        this.subTitle = subTitle;
        this.status = status;
        this.tanggal = tanggal;
    }

    public RiwayatTransaksi(String title, String status, String tanggal) {
        this.title = title;
        this.status = status;
        this.tanggal = tanggal;
    }

    public RiwayatTransaksi() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String isSuccess) {
        this.status = isSuccess;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    @Override
    public String toString() {
        return "RiwayatTransaksi{" +
                "title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", status='" + status + '\'' +
                ", tanggal='" + tanggal + '\'' +
                '}';
    }
}
