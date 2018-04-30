package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Adapters.DetailCalendarAdapter;
import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Adapters.ListItem;

public class DetailKalenderActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kalender);

        View inflaterView = getLayoutInflater().inflate(R.layout.list_item, null);
        Button cobapencet = inflaterView.findViewById(R.id.cobaPencet);
        // cobapencet.setOnClickListener(new View.OnClickListener() {
        //   @Override
        //  public void onClick(View view) {
        //  Intent i = new Intent(HistoryActivity.this,IntroSliderActivity.class);
        //  startActivity(i);
        //}
        // });


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
        listItems = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            ListItem listItem = new ListItem(
                    "heading" + (i + 1),
                    "Loren ipsum dummy text"
            );
            listItems.add(listItem);
        }
        adapter = new DetailCalendarAdapter(listItems, this);
        recyclerView.setAdapter(adapter);
    }
}
