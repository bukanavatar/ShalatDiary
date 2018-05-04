package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    ProgressDialog progressBar;
    EditText etEmail, etPassword;
    TextView Login;
    Button btnSignUp;
    TextInputLayout tilEmail, tilPassword;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        progressBar = new ProgressDialog(this);
        btnSignUp = findViewById(R.id.btnRegister);

        tilEmail = findViewById(R.id.til_email);
        tilPassword = findViewById(R.id.til_password);

        findViewById(R.id.SignIn).setOnClickListener(this);
        findViewById(R.id.btnRegister).setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRegister:
                registerUser();
                break;
            case R.id.SignIn:
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                break;
        }
    }

    private void registerUser() {

        String S_email = etEmail.getText().toString().trim();
        String S_password = etPassword.getText().toString().trim();

        if (S_email.isEmpty()) {
            tilEmail.setError("Email is required");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(S_email).matches()) {
            tilEmail.setError("Please enter a valid email");
        } else if (S_password.isEmpty()) {
            tilPassword.setError("Password is required");
        } else if (S_password.length() < 6) {
            tilPassword.setError("Minimum length of password should be 6");
        } else {
            progressBar.setMessage("Registering...");
            progressBar.show();

            mAuth.createUserWithEmailAndPassword(S_email, S_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        progressBar.dismiss();
                        Snackbar.make(findViewById(R.id.relative_login), "Sukses Registrasi", Snackbar.LENGTH_LONG).show();
                        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                        finish();
                    } else {
                        if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                            progressBar.dismiss();
                            Snackbar.make(findViewById(R.id.relative_login), "Anda Sudah Register Sebelumnya", Snackbar.LENGTH_LONG).show();
                        } else {
                            progressBar.dismiss();
                            Snackbar.make(findViewById(R.id.relative_login), task.getException().getMessage(), Snackbar.LENGTH_LONG).show();
                        }
                    }
                }
            });
        }

    }

}
