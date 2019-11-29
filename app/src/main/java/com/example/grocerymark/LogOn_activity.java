package com.example.grocerymark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.ref.Reference;
import java.util.HashMap;
import java.util.Map;

public class LogOn_activity extends AppCompatActivity {

    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    EditText name, passw, confpass, number, email, address;
    public String namestr, passstr, confpassstr, numberstr, emailstr, addressstr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_on_activity);
        Intent intent = getIntent();
        String toast = intent.getStringExtra("Toast");
        Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_LONG).show();

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("User");
        name = findViewById(R.id.fillName);
        passw = findViewById(R.id.password);
        confpass = findViewById(R.id.confirmpass);
        number = findViewById(R.id.fillNumb);
        email = findViewById(R.id.fillEmail);
        address = findViewById(R.id.fillAddr);
    }

    public void checkCurrentUser() {
        // [START check_current_user]
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            Intent intent = new Intent(LogOn_activity.this, Home_Activity.class);
            //intent.putExtra("Success", "Profile Successfully created");
            Toast.makeText(getApplicationContext(), "Already Sign In", Toast.LENGTH_LONG).show();
            startActivity(intent);
        } else {
            // No user is signed in
            Toast.makeText(getApplicationContext(),"Error!",Toast.LENGTH_LONG).show();
        }
    }

    public void CreateId(View view) {

        namestr = name.getText().toString();
        passstr = passw.getText().toString();
        confpassstr = confpass.getText().toString();
        numberstr = number.getText().toString();
        emailstr = email.getText().toString();
        addressstr = address.getText().toString();

        if (namestr.trim().equals("")) {
            name.setError("Please Enter your name");
        } else if (numberstr.trim().equals("")) {
            number.setError("Please Enter your Number");
        } else if (emailstr.trim().equals("")) {
            email.setError("Please Enter your Address");
        } else if (!confpassstr.equals(passstr)) {
            // give an error that password and confirm password not match
            confpass.setError("Password must matched");
            Toast.makeText(getApplicationContext(), confpassstr + passstr, Toast.LENGTH_LONG).show();
        } else {
            Map newUser = new HashMap();
            newUser.put("name", namestr);
            newUser.put("number", numberstr);
            newUser.put("password", passstr);
            newUser.put("address", addressstr);
            newUser.put("email", emailstr);
            databaseReference.setValue(newUser);
            Toast.makeText(getApplicationContext(),newUser.toString(),Toast.LENGTH_LONG).show();

            firebaseAuth.createUserWithEmailAndPassword(emailstr, passstr)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                Intent intent = new Intent(LogOn_activity.this, Home_Activity.class);
                                //intent.putExtra("Success", "Profile Successfully created");
                                Toast.makeText(getApplicationContext(), "Successfully Registered", Toast.LENGTH_LONG).show();
                                startActivity(intent);

                            } else {
                                Toast.makeText(getApplicationContext(), "Registered Failed", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }
}
   /* private void writeNewUser(String name, String user, String number, String password, String address, String email) {
        User userf = new User(name, "", number, password, address, email);

        Map newUser = new HashMap();
        newUser.put("name", namestr);
        newUser.put("user", useridstr);
        newUser.put("number", numberstr);
        newUser.put("password", passstr);
        newUser.put("address", addressstr);
        newUser.put("email", emailstr);

        databaseReference.child("User").child(user).setValue(userf);
    }
*//*
    private void onAuthSuccess(FirebaseUser user) {
        writeNewUser(namestr, useridstr,numberstr,passstr,addressstr, emailstr);
    }*/
