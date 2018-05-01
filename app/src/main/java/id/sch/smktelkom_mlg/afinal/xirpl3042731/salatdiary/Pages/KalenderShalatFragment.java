package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Pages;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.DetailCalendarActivity;
import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.R;


public class KalenderShalatFragment extends Fragment implements OnDateSelectedListener, OnMonthChangedListener {

    MaterialCalendarView widget;
    private static final DateFormat FORMATTER = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);

    public KalenderShalatFragment() {
        // Required empty public constructor
    }

    public static KalenderShalatFragment newInstance() {
        return new KalenderShalatFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_kalender_shalat, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        widget = getView().findViewById(R.id.calendarView);
        widget.setOnDateChangedListener(this);
        widget.setOnMonthChangedListener(this);
    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
        Intent intent = new Intent(getActivity(), DetailCalendarActivity.class);
        intent.putExtra("TANGGAL_HARI_INI", getSelectedDatesString());
        startActivity(intent);
    }

    @Override
    public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {

    }

    private String getSelectedDatesString() {
        CalendarDay date = widget.getSelectedDate();
        if (date == null) {
            return "No Selection";
        }
        return FORMATTER.format(date.getDate());
    }
}
