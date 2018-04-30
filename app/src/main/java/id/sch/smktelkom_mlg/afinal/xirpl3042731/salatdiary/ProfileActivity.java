package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class ProfileActivity extends AppCompatActivity {

    private static final int CHOOSE_IMAGE = 101;
    ImageView profilePhoto;
    EditText editText;
    ProgressBar progressBar;
    String profileImageUrl;
    Uri uriProfileImge;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();

        editText = findViewById(R.id.etName);
        profilePhoto = findViewById(R.id.profilePhoto);
        progressBar = findViewById(R.id.progressBar);

        profilePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImageChooser();
            }
        });

        loadUserInfo();

        Button save = findViewById(R.id.btnSave);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUserInfo();
            }
        });
    }

    private void loadUserInfo() {
        FirebaseUser user = mAuth.getCurrentUser();

        if (user != null) {
            if (user.getPhotoUrl() != null) {
                Glide.with(this)
                        .load(user.getPhotoUrl().toString())
                        .into(profilePhoto);
            }
            if (user.getDisplayName() != null) {
                editText.setText(user.getDisplayName());
            }
        }
    }

        @Override
        protected void onStart () {
            super.onStart();

            if (mAuth.getCurrentUser() == null) {
                finish();
                startActivity(new Intent(this, MainActivity.class));
            }
        }

        private void saveUserInfo () {
            String displayName = editText.getText().toString().trim();
            if (displayName.isEmpty()) {
                editText.setError("Name is required");
                editText.requestFocus();
                return;
            }
            FirebaseUser user = mAuth.getCurrentUser();

            if (user != null) {
                UserProfileChangeRequest profile = new UserProfileChangeRequest.Builder()
                        .setDisplayName(displayName)
                        .setPhotoUri(Uri.parse(profileImageUrl))
                        .build();

                user.updateProfile(profile)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(ProfileActivity.this, "Profile Updated", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        }

        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == CHOOSE_IMAGE && requestCode == RESULT_OK && data != null && data.getData() != null) {
                uriProfileImge = data.getData();

                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uriProfileImge);
                    profilePhoto.setImageBitmap(bitmap);

                    uploadImageToFirebaseStorage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void uploadImageToFirebaseStorage () {
            StorageReference profileImageRef =
                    FirebaseStorage.getInstance().getReference("profilepics/" + System.currentTimeMillis() + ".jpg");

            if (uriProfileImge != null) {
                progressBar.setVisibility(View.VISIBLE);
                profileImageRef.putFile(uriProfileImge)
                        .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                                progressBar.setVisibility(View.GONE);
                                profileImageUrl = taskSnapshot.getDownloadUrl().toString();

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(ProfileActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        }

        private void showImageChooser () {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Profile Photo"), CHOOSE_IMAGE);
        }
    }