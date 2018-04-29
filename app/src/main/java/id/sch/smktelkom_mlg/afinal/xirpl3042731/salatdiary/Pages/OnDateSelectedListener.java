package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Pages;

import android.support.annotation.NonNull;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

public interface OnDateSelectedListener {
    void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected);

}
