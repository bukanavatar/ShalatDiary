package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Pages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.R;


public class ProfilFragment extends Fragment {


    public ProfilFragment() {
        // Required empty public constructor
    }

    public static ProfilFragment newInstance() {
        return new ProfilFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profil, container, false);
    }
}
