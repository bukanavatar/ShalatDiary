package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DataJadwalShalatModel {
    List<String> namaShalat = new ArrayList<>();
    String[] listShalat = {"Subuh", "Dzuhur", "Ashar", "Margrib", "Isya"};
    @SerializedName("Fajr")
    private String Fajr;
    @SerializedName("Sunrise")
    private String Sunrise;
    @SerializedName("Dhuhr")
    private String Dhuhr;
    @SerializedName("Asr")
    private String Asr;
    @SerializedName("Maghrib")
    private String Maghrib;
    @SerializedName("Isha")
    private String Isha;

    public DataJadwalShalatModel(String fajr, String sunrise, String dhuhr, String asr, String maghrib, String isha) {
        Fajr = fajr;
        Sunrise = sunrise;
        Dhuhr = dhuhr;
        Asr = asr;
        Maghrib = maghrib;
        Isha = isha;
    }

    public String getFajr() {
        return Fajr;
    }

    public void setFajr(String fajr) {
        Fajr = fajr;
    }

    public String getSunrise() {
        return Sunrise;
    }

    public void setSunrise(String sunrise) {
        Sunrise = sunrise;
    }

    public String getDhuhr() {
        return Dhuhr;
    }

    public void setDhuhr(String dhuhr) {
        Dhuhr = dhuhr;
    }

    public String getAsr() {
        return Asr;
    }

    public void setAsr(String asr) {
        Asr = asr;
    }

    public String getMaghrib() {
        return Maghrib;
    }

    public void setMaghrib(String maghrib) {
        Maghrib = maghrib;
    }

    public String getIsha() {
        return Isha;
    }

    public void setIsha(String isha) {
        Isha = isha;
    }
}

