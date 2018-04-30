package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailCalendarActivity extends AppCompatActivity {


    String tanggalHariIni;
    TextView mJudul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_calendar);

        tanggalHariIni = getIntent().getStringExtra("TANGGAL_HARI_INI");

        mJudul = findViewById(R.id.tb_judulDetail);
        mJudul.setText(tanggalHariIni);


    }
}
