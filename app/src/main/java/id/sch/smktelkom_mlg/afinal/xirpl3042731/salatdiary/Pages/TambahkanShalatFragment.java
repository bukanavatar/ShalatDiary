package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Pages;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
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
import java.util.Locale;
import java.util.Map;

import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.R;


public class TambahkanShalatFragment extends Fragment {

    //Jam Sekarang
    Calendar waktuSekarang = Calendar.getInstance();
    int jam = waktuSekarang.get(Calendar.HOUR_OF_DAY);
    //Tanggal Sekarang
    Date tanggalSekarang = Calendar.getInstance().getTime();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yy", Locale.ENGLISH);
    String dateFormatted = simpleDateFormat.format(tanggalSekarang);
    //Firestore
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();

    private ProgressDialog mProd;

    ImageButton mJamaah, mSendiri, mTelat, mTidakShalat;
    TextView mStatusShalat;
    CardView mainpage;

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
        mProd = new ProgressDialog(getContext());
        buttonMenambahkanShalat();
    }

    private void buttonMenambahkanShalat() {
        final String[] namaShalat = {"Subuh", "Dzuhur", "Ashar", "Maghrib", "Isya"};
        final String[] kondisiShalat = {"Jamaah", "Sendiri", "Telat", "Tidak Shalat"};
        //tinggal gambar
        if (jam >= 4 && jam < 12) {
            mStatusShalat.setText("Bagaimana Shalat Subuhmu?");
        } else if (jam >= 12 && jam < 15) {
            mStatusShalat.setText("Bagaimana Shalat Dzuhurmu?");
        } else if (jam >= 15 && jam < 18) {
            mStatusShalat.setText("Bagaimana Shalat Asharmu?");
        } else if (jam >= 18 && jam < 19) {
            mStatusShalat.setText("Bagaimana Shalat Maghribmu?");
        } else {
            mStatusShalat.setText("Bagaimana Shalat Isya?");
        }
    }

    private void tambahkanDataShalat(String namaShalat, String kondisiShalat) {
        Map<String, Object> dataShalat = new HashMap<>();
        dataShalat.put("nama", namaShalat);
        dataShalat.put("status", kondisiShalat);

        mProd.setMessage("Menambahkan...");
        mProd.show();

        db.collection("dataShalat").document(email)
                .collection("tanggal").document(dateFormatted)
                .collection("statusShalat").document(namaShalat)
                .set(dataShalat).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getActivity(), "Berhasil Menambahkan", Toast.LENGTH_LONG).show();
                    mProd.dismiss();
                } else {
                    Toast.makeText(getActivity(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    mProd.dismiss();
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
