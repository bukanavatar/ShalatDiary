package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DataJadwalShalatModel {
    @SerializedName("data")
    private ArrayList<JadwalShalatModel> JadwalShalatModels = new ArrayList<>();

    public ArrayList<JadwalShalatModel> getJadwalShalatModels() {
        return JadwalShalatModels;
    }

    public void setJadwalShalatModels(ArrayList<JadwalShalatModel> jadwalShalatModels) {
        JadwalShalatModels = jadwalShalatModels;
    }
}
