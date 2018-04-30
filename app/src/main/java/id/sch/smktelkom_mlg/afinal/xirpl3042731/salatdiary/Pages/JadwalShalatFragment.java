package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Pages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Adapters.JadwalShalatAdapter;
import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Model.DataJadwalShalatModel;
import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Network.ApiService;
import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.R;


public class JadwalShalatFragment extends Fragment {
    List<DataJadwalShalatModel> data = new ArrayList<>();
    RecyclerView mRecyclerView;
    private ApiService apiService;
    private JadwalShalatAdapter jadwalShalatAdapter;

    private ArrayList<String> namaShlat = new ArrayList<>();

    private String[] listShalat = {"Subuh", "Dzuhur", "Ashar", "Maghrib", "Isya"};

    public JadwalShalatFragment() {
        // Required empty public constructor
    }

    public static JadwalShalatFragment newInstance() {
        return new JadwalShalatFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_jadwal_shalat, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}
