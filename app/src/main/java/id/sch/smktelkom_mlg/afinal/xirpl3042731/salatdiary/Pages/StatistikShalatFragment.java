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
import java.util.Date;

import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.R;

import static android.support.constraint.Constraints.TAG;


public class StatistikShalatFragment extends Fragment {


    PieChart mHalfPieChart;
    final String[] namaShalat = {"Subuh", "Dzuhur", "Ashar", "Maghrib", "Isya"};
    String[] statusShalat = {"Jamaah", "Sendiri", "Telat", "Tidak Shalat"};
    FirebaseFirestore db;
    String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
    Date tanggalSekarang = Calendar.getInstance().getTime();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yy");
    String dateFormatted = simpleDateFormat.format(tanggalSekarang);

    public StatistikShalatFragment() {
        // Required empty public constructor
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
    public void onStart() {
        super.onStart();
        initializeHalfChart();
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

        setHalfPieChartData(4, 5);
        moveOffScreen();
    }

    public void getFirebaseTodayData() {
        db = FirebaseFirestore.getInstance();
        db.collection("dataShalat").document(email)
                .collection("tanggal").document(dateFormatted)
                .collection("statusShalat").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (DocumentSnapshot document : task.getResult()) {
                        Log.d(TAG, document.getId() + " => " + document.getData());
                    }
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }

            }
        });
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

    public void setHalfPieChartData(int count, int range) {
        ArrayList<PieEntry> values = new ArrayList<>();


        values.add(new PieEntry(1, statusShalat[0]));
        values.add(new PieEntry(2, statusShalat[1]));
        values.add(new PieEntry(2, statusShalat[2]));
        values.add(new PieEntry(1, statusShalat[3]));


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
}
