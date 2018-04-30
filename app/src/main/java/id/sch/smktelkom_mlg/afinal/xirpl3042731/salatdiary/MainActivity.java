package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.github.florent37.bubbletab.BubbleTab;
import com.google.firebase.auth.FirebaseAuth;

import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Adapters.BubbleTabAdapter;


public class MainActivity extends AppCompatActivity {

    BubbleTab bubbleTab;
    ViewPager viewPager;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeView();
        viewPager.setAdapter(new BubbleTabAdapter(getSupportFragmentManager()));
        bubbleTab.setupWithViewPager(viewPager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseLogin();

        mAuth.addAuthStateListener(mAuthListener);
    }

    private void firebaseLogin() {
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {
                    Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(loginIntent);
                    finish();
                }
            }
        };
    }

    private void initializeView() {
        viewPager = findViewById(R.id.viewpager);
        bubbleTab = findViewById(R.id.bubbleTab);
    }
}
