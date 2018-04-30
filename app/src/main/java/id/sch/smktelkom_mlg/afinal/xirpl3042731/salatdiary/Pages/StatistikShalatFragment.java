package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Pages;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;

import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.R;


public class StatistikShalatFragment extends Fragment {


    PieChart mHalfPieChart;

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
}
