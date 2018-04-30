package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Pages;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.R;


public class TambahkanShalatFragment extends Fragment {

    //Jam Sekarang
    Calendar waktuSekarang = Calendar.getInstance();
    int jam = waktuSekarang.get(Calendar.HOUR_OF_DAY);
    //Tanggal Sekarang
    Date tanggalSekarang = Calendar.getInstance().getTime();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yy");
    String dateFormatted = simpleDateFormat.format(tanggalSekarang);
    //Firestore
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();

    ImageButton mJamaah, mSendiri, mTelat, mTidakShalat;
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
        final String[] namaShalat = {"Subuh", "Dzuhur", "Ashar", "Maghrib", "Isya"};
        final String[] kondisiShalat = {"Jamaah", "Sendiri", "Telat", "Tidak Shalat"};
        if (jam >= 4 && jam < 12) {

            mJamaah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tambahkanDataShalat(namaShalat[0], kondisiShalat[0]);
                }
            });
            mSendiri.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tambahkanDataShalat(namaShalat[0], kondisiShalat[1]);
                }
            });

            mTelat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tambahkanDataShalat(namaShalat[0], kondisiShalat[2]);
                }
            });

            mTidakShalat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tambahkanDataShalat(namaShalat[0], kondisiShalat[3]);
                }
            });

            mStatusShalat.setText("Bagaimana Shalat Subuhmu?");
        } else if (jam >= 12 && jam < 15) {

            mJamaah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tambahkanDataShalat(namaShalat[1], kondisiShalat[0]);
                }
            });
            mSendiri.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tambahkanDataShalat(namaShalat[1], kondisiShalat[1]);
                }
            });

            mTelat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tambahkanDataShalat(namaShalat[1], kondisiShalat[2]);
                }
            });

            mTidakShalat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tambahkanDataShalat(namaShalat[1], kondisiShalat[3]);
                }
            });
            mStatusShalat.setText("Bagaimana Shalat Dzuhurmu?");
        } else if (jam >= 15 && jam < 18) {
            mJamaah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tambahkanDataShalat(namaShalat[2], kondisiShalat[0]);
                }
            });
            mSendiri.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tambahkanDataShalat(namaShalat[2], kondisiShalat[1]);
                }
            });

            mTelat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tambahkanDataShalat(namaShalat[2], kondisiShalat[2]);
                }
            });

            mTidakShalat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tambahkanDataShalat(namaShalat[2], kondisiShalat[3]);
                }
            });
            mStatusShalat.setText("Bagaimana Shalat Asharmu?");
        } else if (jam >= 18 && jam < 19) {

            mJamaah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tambahkanDataShalat(namaShalat[3], kondisiShalat[0]);
                }
            });
            mSendiri.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tambahkanDataShalat(namaShalat[3], kondisiShalat[1]);
                }
            });

            mTelat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tambahkanDataShalat(namaShalat[3], kondisiShalat[2]);
                }
            });

            mTidakShalat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tambahkanDataShalat(namaShalat[3], kondisiShalat[3]);
                }
            });

            mStatusShalat.setText("Bagaimana Shalat Maghribmu?");
        } else if (jam >= 19 && jam < 4) {

            mJamaah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tambahkanDataShalat(namaShalat[4], kondisiShalat[0]);
                }
            });
            mSendiri.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tambahkanDataShalat(namaShalat[4], kondisiShalat[1]);
                }
            });

            mTelat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tambahkanDataShalat(namaShalat[4], kondisiShalat[2]);
                }
            });

            mTidakShalat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tambahkanDataShalat(namaShalat[4], kondisiShalat[3]);
                }
            });

            mStatusShalat.setText("Bagaimana Shalat Isya?");
        }
    }

    private void tambahkanDataShalat(String namaShalat, String kondisiShalat) {
        Map<String, Object> dataShalat = new HashMap<>();
        dataShalat.put("nama", namaShalat);
        dataShalat.put("status", kondisiShalat);


        db.collection("dataShalat").document(email)
                .collection("tanggal").document(dateFormatted)
                .collection("statusShalat").document(namaShalat)
                .set(dataShalat).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getActivity(), "Berhasil Menambahkan", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), task.getException().getMessage()
                            , Toast.LENGTH_LONG).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Ada Kesalahan", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void initializeView() {
        mJamaah = getView().findViewById(R.id.but_jamaah);
        mSendiri = getView().findViewById(R.id.but_sendiri);
        mTelat = getView().findViewById(R.id.but_telat);
        mTidakShalat = getView().findViewById(R.id.but_tdkShalat);
        mStatusShalat = getView().findViewById(R.id.tv_status_shalat);
    }
}
