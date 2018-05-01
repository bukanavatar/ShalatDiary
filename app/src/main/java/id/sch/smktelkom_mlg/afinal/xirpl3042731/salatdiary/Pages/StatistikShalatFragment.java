package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Pages;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.R;

import static android.support.constraint.Constraints.TAG;


public class StatistikShalatFragment extends Fragment {


    PieChart mHalfPieChart;
    FirebaseFirestore mFirebaseFirestore;
    String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();

    Date tanggalSekarang = Calendar.getInstance().getTime();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yy", Locale.ENGLISH);
    String dateFormatted = simpleDateFormat.format(tanggalSekarang);

    ArrayList<String> statusShalatDialy = new ArrayList<String>();
    int jamaah;
    int sendiri;
    int telat;
    int tidakShalat;

    public StatistikShalatFragment() {

    }

    public int getJamaah() {
        return jamaah;
    }

    public void setJamaah(int jamaah) {
        this.jamaah = jamaah;
    }

    public int getSendiri() {
        return sendiri;
    }

    public void setSendiri(int sendiri) {
        this.sendiri = sendiri;
    }

    public int getTelat() {
        return telat;
    }

    public void setTelat(int telat) {
        this.telat = telat;
    }

    public int getTidakShalat() {
        return tidakShalat;
    }

    public void setTidakShalat(int tidakShalat) {
        this.tidakShalat = tidakShalat;
    }

    public static StatistikShalatFragment newInstance() {
        return new StatistikShalatFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_statistik_shalat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeHalfChart();
        getDialyShalat();

    }

    private void getDialyShalat() {
        mFirebaseFirestore = FirebaseFirestore.getInstance();

        mFirebaseFirestore.collection("dataShalat").document(email)
                .collection("tanggal").document(dateFormatted)
                .collection("statusShalat").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (DocumentSnapshot doc : task.getResult()) {

                        statusShalatDialy.add(doc.getString("status"));
                        Log.d(TAG, "Jumlah Array: " + statusShalatDialy.size());

                        setJamaah(Collections.frequency(statusShalatDialy, "Jamaah"));
                        setSendiri(Collections.frequency(statusShalatDialy, "Sendiri"));
                        setTelat(Collections.frequency(statusShalatDialy, "Telat"));
                        setTidakShalat(Collections.frequency(statusShalatDialy, "Tidak Shalat"));

                        setHalfPieChartData(getJamaah(), getSendiri(), getTelat(), getTidakShalat());
                        mHalfPieChart.notifyDataSetChanged();
                        Log.d(TAG, "Jumlah Tidak Shalat AAA: " + getTidakShalat());
                    }
                }
            }
        });
    }

    private void initializeHalfChart() {
        mHalfPieChart = getView().findViewById(R.id.chart_dialy);

        mHalfPieChart.setBackgroundColor(Color.WHITE);
        mHalfPieChart.setPadding(16, 16, 16, 16);
        mHalfPieChart.setUsePercentValues(true);
        mHalfPieChart.getDescription().setEnabled(true);

        mHalfPieChart.setDrawHoleEnabled(true);
        mHalfPieChart.setHoleColor(Color.WHITE);

        mHalfPieChart.setTransparentCircleColor(Color.WHITE);
        mHalfPieChart.setTransparentCircleAlpha(110);

        mHalfPieChart.setHoleRadius(58f);
        mHalfPieChart.setTransparentCircleRadius(61f);

        mHalfPieChart.setDrawCenterText(true);

        mHalfPieChart.setRotationEnabled(false);
        mHalfPieChart.setHighlightPerTapEnabled(true);

        mHalfPieChart.setMaxAngle(180f); // HALF CHART
        mHalfPieChart.setRotationAngle(180f);
        mHalfPieChart.setCenterTextOffset(0, -20);

        mHalfPieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);

        Legend l = mHalfPieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);

        // entry label styling
        mHalfPieChart.setEntryLabelColor(Color.WHITE);
        mHalfPieChart.setEntryLabelTextSize(12f);

        moveOffScreen();
    }

    public void setHalfPieChartData(int jamaah, int sendiri, int telat, int tidakShalat) {
        ArrayList<PieEntry> values = new ArrayList<>();

        values.add(new PieEntry(jamaah, "Jamaah"));
        values.add(new PieEntry(sendiri, "Sendiri"));
        values.add(new PieEntry(telat, "Telat"));
        values.add(new PieEntry(tidakShalat, "Tidak Shalat"));
        Log.d(TAG, "Jumlah Tidak Shalat A: " + tidakShalat);

        PieDataSet dataSet = new PieDataSet(values, "");
        dataSet.setSelectionShift(5f);
        dataSet.setSliceSpace(3f);
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        PieData pieData = new PieData(dataSet);
        pieData.setValueFormatter(new PercentFormatter());
        pieData.setValueTextSize(15f);
        pieData.setValueTextColor(Color.WHITE);

        mHalfPieChart.setData(pieData);

        mHalfPieChart.invalidate();

    }

    public void moveOffScreen() {

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        int height = display.getHeight();  // deprecated

        int offset = (int) (height * 0.001); /* percent to move */

        RelativeLayout.LayoutParams rlParams =
                (RelativeLayout.LayoutParams) mHalfPieChart.getLayoutParams();
        rlParams.setMargins(0, 0, 0, -offset);
        mHalfPieChart.setLayoutParams(rlParams);

    }
}
