package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Network;

public class BaseUrlApi {
    public static final String url = "http://muslimsalat.com/";

    public static ApiService apiService() {
        return RetrofitClient.getClient(url).create(ApiService.class);
    }
}