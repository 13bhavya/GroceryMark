package com.example.grocerymark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignOn_activity extends AppCompatActivity {

    Button btnlogin;
    EditText emaillog, paaslog;
    TextView forgotpass;

    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_on_activity);

        btnlogin = findViewById(R.id.logIn);
        emaillog = findViewById(R.id.emailId);
        paaslog = findViewById(R.id.logPass);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            //Profile Activity
            finish();
            startActivity(new Intent(getApplicationContext(), Home_Activity.class));
        }
        progressDialog = new ProgressDialog(this);

        Intent intent = getIntent();
        String toast = intent.getStringExtra("Toast");
        Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_LONG).show();

    }

    public void LoginBtn(View view) {
        String emailid = emaillog.getText().toString();
        String password = paaslog.getText().toString();

        //checking if email and passwords are empty
        if (TextUtils.isEmpty(emailid)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        } else

        //if the email and password are not empty
        //displaying a progress dialog
        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(emailid, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            //Start next activity
                            finish();
                            startActivity(new Intent(getApplicationContext(), Home_Activity.class));
                        } else {
                            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
