package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class JadwalShalatModel {

    @SerializedName("items")
    private ArrayList<DataJadwalShalatModel> items;

    public JadwalShalatModel(ArrayList<DataJadwalShalatModel> items) {
        this.items = items;
    }

    public ArrayList<DataJadwalShalatModel> getItems() {
        return items;
    }

    public void setItems(ArrayList<DataJadwalShalatModel> items) {
        this.items = items;
    }

}


