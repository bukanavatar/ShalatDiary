package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Pages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.R;


public class JadwalShalatFragment extends Fragment {

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

}
