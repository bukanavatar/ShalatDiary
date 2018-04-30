package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Network;

import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Model.DataJadwalShalatModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("pray/Malang")
    Call<DataJadwalShalatModel> getJadwalShalat();
}

