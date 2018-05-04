package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    EditText etEmail, etPassword;
    ProgressDialog pd;
    TextView signUp, login;
    TextInputLayout tilEmail, tilPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        tilEmail = findViewById(R.id.til_email);
        tilPassword = findViewById(R.id.til_password);

        pd = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        signUp = findViewById(R.id.SignUp);
        login = findViewById(R.id.btnLogin);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prosesMasukRegister();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prosesLogin();
            }
        });
    }

    private void prosesLogin() {
        String S_email = etEmail.getText().toString().trim();
        String S_password = etPassword.getText().toString().trim();

        if (S_email.isEmpty()) {
            tilEmail.setError("Email is required");
        } else if (S_password.isEmpty()) {
            tilPassword.setError("Password is required");
        } else if (S_password.length() < 6) {
            tilPassword.setError("Minimum length of password should be 6");
        } else {
            pd.setMessage("Signin In...");
            pd.show();
            mAuth.signInWithEmailAndPassword(S_email, S_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    pd.dismiss();
                    if (task.isSuccessful()) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();

                    } else {
                        Snackbar.make(findViewById(R.id.relative_login), "Maaf Ada Kesalahan", Snackbar.LENGTH_LONG).show();
                    }
                }
            });

        }

    }

    private void prosesMasukRegister() {
        Intent toRegister = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(toRegister);
    }

}
