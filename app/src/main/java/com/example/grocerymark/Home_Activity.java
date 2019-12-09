package com.example.grocerymark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Home_Activity extends AppCompatActivity implements View.OnClickListener {

    ImageView freshco, nofrill, loblaws, walma;
    Button logOut;
    TextView gotomap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        freshco = findViewById(R.id.freshco);
        nofrill = findViewById(R.id.nofrill);
        loblaws = findViewById(R.id.loblaw);
        walma = findViewById(R.id.walmart);
        gotomap = findViewById(R.id.search_loc);
        logOut = findViewById(R.id.logout);

        freshco.setOnClickListener(this);
        nofrill.setOnClickListener(this);
        loblaws.setOnClickListener(this);
        walma.setOnClickListener(this);
        logOut.setOnClickListener(this);

    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.freshco:
                Toast.makeText(getApplicationContext(), "You Clicked Freshco", Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(this, Category_Activity.class);
                i1.putExtra("Click","Freshco");
                startActivity(i1);
                break;
            case R.id.nofrill:
                Toast.makeText(getApplicationContext(), "You Clicked Nofrill", Toast.LENGTH_SHORT).show();
                Intent i2 =new Intent(this, Category_Activity.class);
                i2.putExtra("Click","Nofrill");
                startActivity(i2);
                break;
            case R.id.loblaw:
                Toast.makeText(getApplicationContext(), "You Clicked Loblaw", Toast.LENGTH_SHORT).show();
                Intent i3 =new Intent(this, Category_Activity.class);
                i3.putExtra("Click","Loblaw");
                startActivity(i3);
                break;
            case R.id.walmart:
                Toast.makeText(getApplicationContext(), "You Clicked Walmart", Toast.LENGTH_SHORT).show();
                Intent i4 =new Intent(this, Category_Activity.class);
                i4.putExtra("Click","Walmart");
                startActivity(i4);
                break;
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getApplicationContext(), "Successfully LogOut", Toast.LENGTH_SHORT).show();
                Intent i5 =new Intent(this, SignOn_activity.class);
                //i5.putExtra("Click","Walmart");
                startActivity(i5);
                finish();
                break;
        }
    }
}
