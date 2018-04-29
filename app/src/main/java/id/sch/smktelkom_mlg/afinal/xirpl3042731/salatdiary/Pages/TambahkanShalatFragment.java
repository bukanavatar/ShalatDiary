package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Pages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.R;


public class TambahkanShalatFragment extends Fragment {

    Button mJamaah, mSendiri, mTelat, mTidakShalat;
    TextView mStatusShalat;

    public TambahkanShalatFragment() {

    }

    public static TambahkanShalatFragment newInstance() {
        return new TambahkanShalatFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tambahkan_shalat, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializeView();
    }

    private void initializeView() {
        mJamaah = getView().findViewById(R.id.but_jamaah);
        mSendiri = getView().findViewById(R.id.but_sendiri);
        mTelat = getView().findViewById(R.id.but_telat);
        mTidakShalat = getView().findViewById(R.id.but_tdkShalat);
        mStatusShalat = getView().findViewById(R.id.tv_status_shalat);
    }
}
