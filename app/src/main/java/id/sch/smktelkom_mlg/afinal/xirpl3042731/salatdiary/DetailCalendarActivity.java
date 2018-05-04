package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Adapters.DetailCalendarListAdapter;
import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Model.StatusShalatModel;

public class DetailCalendarActivity extends AppCompatActivity {


    private static final String TAG = "Log";
    RecyclerView mRv;
    String tanggalHariIni;
    TextView mJudul;
    FirebaseFirestore mFirebaseFirestore;
    String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
    List<StatusShalatModel> statusShalatList;
    private DetailCalendarListAdapter detailCalendarListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_calendar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        statusShalatList = new ArrayList<>();
        detailCalendarListAdapter = new DetailCalendarListAdapter(statusShalatList);


        tanggalHariIni = getIntent().getStringExtra("TANGGAL_HARI_INI");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyy", Locale.ENGLISH);
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yy", Locale.ENGLISH);

        try {
            Date date = dateFormat.parse(tanggalHariIni);
            String tanggalSekarang = dateFormat2.format(date);

            mRv = findViewById(R.id.rv_detail);
            mRv.setHasFixedSize(true);
            mRv.setLayoutManager(new LinearLayoutManager(this));
            mRv.setAdapter(detailCalendarListAdapter);


            mFirebaseFirestore = FirebaseFirestore.getInstance();

            mFirebaseFirestore.collection("dataShalat").document(email)
                    .collection("tanggal").document(tanggalSekarang)
                    .collection("statusShalat").addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                    if (e != null) {
                        Log.d(TAG, "Error" + e.getMessage());
                    }

                    for (DocumentChange doc : documentSnapshots.getDocumentChanges()) {
                        if (doc.getType() == DocumentChange.Type.ADDED) {
                            StatusShalatModel statusShalatModel = doc.getDocument().toObject(StatusShalatModel.class);
                            statusShalatList.add(statusShalatModel);

                            detailCalendarListAdapter.notifyDataSetChanged();
                        }
                    }
                }
            });

        } catch (ParseException e) {

        }

        mJudul = findViewById(R.id.tb_judul_detail);
        mJudul.setText(tanggalHariIni);


    }
}
