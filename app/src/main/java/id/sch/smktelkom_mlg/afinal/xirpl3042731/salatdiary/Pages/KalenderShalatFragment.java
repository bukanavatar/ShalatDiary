package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Pages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.R;


public class KalenderShalatFragment extends Fragment {


    public KalenderShalatFragment() {
        // Required empty public constructor
    }

    public static KalenderShalatFragment newInstance() {
        return new KalenderShalatFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_kalender_shalat, container, false);
    }

}
