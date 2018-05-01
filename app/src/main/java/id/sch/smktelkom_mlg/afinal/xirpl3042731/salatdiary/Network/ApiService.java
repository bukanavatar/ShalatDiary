package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Network;

import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Model.JadwalShalatModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/Malang.json")
    Call<JadwalShalatModel> getJadwalShalat(@Query("key") String key);
}

