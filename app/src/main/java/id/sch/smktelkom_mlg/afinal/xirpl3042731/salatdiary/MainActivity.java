package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.github.florent37.bubbletab.BubbleTab;

import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Adapters.BubbleTabAdapter;


public class MainActivity extends AppCompatActivity {

    BubbleTab bubbleTab;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeView();
        viewPager.setAdapter(new BubbleTabAdapter(getSupportFragmentManager()));
        bubbleTab.setupWithViewPager(viewPager);
    }

    private void initializeView() {
        viewPager = findViewById(R.id.viewpager);
        bubbleTab = findViewById(R.id.bubbleTab);
    }
}
