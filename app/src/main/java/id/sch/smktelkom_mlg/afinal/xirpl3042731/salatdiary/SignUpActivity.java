package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    ProgressDialog progressBar;
    EditText etEmail, etUsername, etPassword;
    TextView Login;
    Button btnSignUp;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        progressBar = new ProgressDialog(this);
        btnSignUp = findViewById(R.id.btnSignup);

        findViewById(R.id.Login).setOnClickListener(this);
        findViewById(R.id.btnSignup).setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSignup:
                registerUser();
                break;
            case R.id.Login:
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                break;
        }
    }

    private void registerUser() {

        String S_email = etEmail.getText().toString().trim();
        String S_password = etPassword.getText().toString().trim();

        if (S_email.isEmpty()) {
            etEmail.setError("Email is required");
            etEmail.requestFocus();
            return;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(S_email).matches()) {
            etEmail.setError("Please enter a valid email");
            etEmail.requestFocus();
            return;
        } else if (S_password.isEmpty()) {
            etPassword.setError("Password is required");
            etPassword.requestFocus();
            return;
        } else if (S_password.length() < 6) {
            etPassword.setError("Minimum length of password should be 6");
            etPassword.requestFocus();
            return;
        } else {

            progressBar.setMessage("Registering...");
            progressBar.show();

            mAuth.createUserWithEmailAndPassword(S_email, S_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        progressBar.dismiss();
                        Toast.makeText(getApplicationContext(), "Berhasil Register", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                        finish();
                    } else {
                        if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                            progressBar.dismiss();
                            Toast.makeText(getApplicationContext(), "You are already registered", Toast.LENGTH_SHORT).show();
                        } else {
                            progressBar.dismiss();
                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }

    }

}
