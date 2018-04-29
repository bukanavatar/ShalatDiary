package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Pages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.R;


public class TambahkanShalatFragment extends Fragment {

    //Jam Sekarang
    Calendar waktuSekarang = Calendar.getInstance();
    int jam = waktuSekarang.get(Calendar.HOUR_OF_DAY);
    
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
        buttonMenambahkanShalat();
    }

    private void buttonMenambahkanShalat() {
        final String[] namaShalat = {"subuh", "dzuhur", "ashar", "maghrib", "isya"};
        final String[] kondisiShalat = {"jamaah", "sendiri", "telat", "tidakShalat"};
        if (jam >= 4 && jam < 12) {

            mJamaah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            mSendiri.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            mTelat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            mTidakShalat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            mStatusShalat.setText("Bagaimana Shalat Subuhmu?");
        } else if (jam >= 12 && jam < 15) {

            mJamaah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            mSendiri.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            mTelat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            mTidakShalat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            mStatusShalat.setText("Bagaimana Shalat Dzuhurmu?");
        } else if (jam >= 15 && jam < 18) {
            mJamaah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            mSendiri.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            mTelat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            mTidakShalat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            mStatusShalat.setText("Bagaimana Shalat Asharmu?");
        } else if (jam >= 18 && jam < 19) {

            mJamaah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            mSendiri.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            mTelat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            mTidakShalat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            mStatusShalat.setText("Bagaimana Shalat Maghribmu?");
        } else if (jam >= 19 && jam < 4) {

            mJamaah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            mSendiri.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            mTelat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            mTidakShalat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            mStatusShalat.setText("Bagaimana Shalat Isya?");
        }
    }



    private void initializeView() {
        mJamaah = getView().findViewById(R.id.but_jamaah);
        mSendiri = getView().findViewById(R.id.but_sendiri);
        mTelat = getView().findViewById(R.id.but_telat);
        mTidakShalat = getView().findViewById(R.id.but_tdkShalat);
        mStatusShalat = getView().findViewById(R.id.tv_status_shalat);
    }
}
