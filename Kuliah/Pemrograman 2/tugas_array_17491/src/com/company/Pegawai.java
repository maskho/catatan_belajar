package com.company;

public class Pegawai {
    private String nama;
    private String nip;
    private String masa;
    private String gaji;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getMasa() {
        return masa;
    }

    public void setMasa(String masa) {
        this.masa = masa;
    }

    public String getGaji() {
        return gaji;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
    }

    public String getInfo(){
        return  "Nama: "+nama+
                "\nNIP: "+nip+
                "\nMasa Kerja: "+masa+" Tahun"+
                "\nGaji: "+gaji;
    }
}
