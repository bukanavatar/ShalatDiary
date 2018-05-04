package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Pages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Adapters.JadwalShalatAdapter;
import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Model.DataJadwalShalatModel;
import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Model.JadwalShalatModel;
import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Network.ApiService;
import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Network.BaseUrlApi;
import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import android.widget.Toast;



public class JadwalShalatFragment extends Fragment {
    JadwalShalatAdapter jadwalShalatAdapter;
    RecyclerView mRecyclerView;
    ProgressBar progressBar;
    LinearLayout linearLayout;
    Calendar waktuSekarang = Calendar.getInstance();
    int jam = waktuSekarang.get(Calendar.HOUR_OF_DAY);

    private ApiService apiService;
    TextView tanggalsekarang;
    Date tanggalSekarang = Calendar.getInstance().getTime();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
    String dateFormatted = simpleDateFormat.format(tanggalSekarang);
    RelativeLayout RelativeLayout;

    public JadwalShalatFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_jadwal_shalat, container, false);
    }

    public static JadwalShalatFragment newInstance() {
        return new JadwalShalatFragment();
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tanggalsekarang = getView().findViewById(R.id.tanggalsekarang);
        tanggalsekarang.setText(dateFormatted);

        retrofitJadwalShalat();
        gantibackground();

        RelativeLayout rl = getView().findViewById(R.id.layout_bg);

    }

    private void gantibackground() {
        if (jam >= 4 && jam < 12) {

            rl.setBackground( @drawable/bg_subuh)
        } else if (jam >= 12 && jam < 15) {

            rl.setBackground( @drawable/bg_duhur)
        } else if (jam >= 15 && jam < 18) {

            rl.setBackground( @drawable/bg_ashar)
        } else if (jam >= 18 && jam < 19) {

            rl.setBackground( @drawable/bg_maghrib)
        } else {

            rl.setBackground( @drawable/bg_isya)
        }
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    private void retrofitJadwalShalat() {
        progressBar = getView().findViewById(R.id.pb_jadwalShalat);

        progressBar.setVisibility(View.VISIBLE);
        mRecyclerView = getView().findViewById(R.id.rv_jadwal_sholat);
        apiService = BaseUrlApi.apiService();
        apiService.getJadwalShalat("80c4419fb4b6bb8811243396d2bc455f").enqueue(new Callback<JadwalShalatModel>() {
            @Override
            public void onResponse(Call<JadwalShalatModel> call, Response<JadwalShalatModel> response) {
                progressBar.setVisibility(View.GONE);
                ArrayList<DataJadwalShalatModel> dataList = response.body().getItems();
                jadwalShalatAdapter = new JadwalShalatAdapter(dataList);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setAdapter(jadwalShalatAdapter);
            }

            @Override
            public void onFailure(Call<JadwalShalatModel> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getActivity(), "Maaf Ada Kesalahan", Toast.LENGTH_LONG).show();
            }
        });
    }
}
