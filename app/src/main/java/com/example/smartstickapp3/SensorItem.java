package com.example.smartstickapp3;

import android.hardware.Sensor;

import java.util.ArrayList;

// MyCurrentPlantActivity' de yer alacak olan recyclerview için class tanımlaması yapıyoruz.
public class SensorItem {

    String bitkiVeriTur, bitkiAdi;
    int bitki_logo;
    int s_bar_min, s_bar_max, s_bar_current,s_bar_optimum;

    public SensorItem(){

    }

    public SensorItem(String bitkiVeriTur, String bitkiAdi, int bitki_logo, int s_bar_min, int s_bar_max, int s_bar_current, int s_bar_optimum) {
        this.bitkiVeriTur = bitkiVeriTur;
        this.bitkiAdi = bitkiAdi;
        this.bitki_logo = bitki_logo;
        this.s_bar_min = s_bar_min;
        this.s_bar_max = s_bar_max;
        this.s_bar_current = s_bar_current;
        this.s_bar_optimum = s_bar_optimum;
    }

    public int getS_bar_optimum() {
        return s_bar_optimum;
    }

    public void setS_bar_optimum(int s_bar_optimum) {
        this.s_bar_optimum = s_bar_optimum;
    }

    public String getBitkiVeriTur() {
        return bitkiVeriTur;
    }

    public void setBitkiVeriTur(String bitkiVeriTur) {
        this.bitkiVeriTur = bitkiVeriTur;
    }

    public String getBitkiAdi() {
        return bitkiAdi;
    }

    public void setBitkiAdi(String bitkiAdi) {
        this.bitkiAdi = bitkiAdi;
    }

    public int getBitki_logo() {
        return bitki_logo;
    }

    public void setBitki_logo(int bitki_logo) {
        this.bitki_logo = bitki_logo;
    }

    public int getS_bar_min() {
        return s_bar_min;
    }

    public void setS_bar_min(int s_bar_min) {
        this.s_bar_min = s_bar_min;
    }

    public int getS_bar_max() {
        return s_bar_max;
    }

    public void setS_bar_max(int s_bar_max) {
        this.s_bar_max = s_bar_max;
    }

    public int getS_bar_current() {
        return s_bar_current;
    }

    public void setS_bar_current(int s_bar_current) {
        this.s_bar_current = s_bar_current;
    }

    // Recyclerview'daki verileri doldurmak için bir metod oluşturuyoruz.
    // public static method sayesınde classtan nesne oluşturmadan çağırıyoruz.
    // Class tipinde (SensorItem) Arraylist oluşturuyoruz.

    public static ArrayList<SensorItem> getData(){
        ArrayList<SensorItem> dataList = new ArrayList<SensorItem>();
        // resimler simdilik drawable'dan lokalden çekiliyor ama bu resimlerin firebase'den gelmesi gerekiyor
        int [] resimler = {R.drawable.kalanso_cicegi,R.drawable.ataturk_cicegi,R.drawable.begonya_cicegi,R.drawable.baris_cicegi};

        int [] degerler  = {0,100};
        // currrent value sensorden gelecek
        // optimum value ise firebaseden cicege ait optimum deger getirelecek
        int currentValue =  50;
        int optimumValue = 60 ;

        for (int i=0 ; i<resimler.length ; i++){
            SensorItem gecici = new SensorItem();
            gecici.setBitki_logo(resimler[i]);
            gecici.setBitkiAdi("Bitki " + i);
            gecici.setBitkiVeriTur("Bitki Sensor " + i);

            gecici.setS_bar_min(degerler[0]);
            gecici.setS_bar_max(degerler[1]);

            gecici.setS_bar_current(currentValue);
            gecici.setS_bar_optimum(optimumValue);

            dataList.add(gecici);
        }
        return dataList;
    }

}
