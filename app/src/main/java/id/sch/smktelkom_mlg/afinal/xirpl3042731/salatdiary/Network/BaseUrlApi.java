package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Network;

public class BaseUrlApi {
    public static final String url = "https://time.siswadi.com/";

    public static ApiService apiService() {
        return RetrofitClient.getClient(url).create(ApiService.class);
    }
}