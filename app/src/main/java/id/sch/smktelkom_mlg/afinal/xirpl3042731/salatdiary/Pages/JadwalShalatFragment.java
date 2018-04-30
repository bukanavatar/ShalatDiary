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
import android.widget.Toast;

import java.util.ArrayList;

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

    private ApiService apiService;

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
        retrofitJadwalShalat();
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
