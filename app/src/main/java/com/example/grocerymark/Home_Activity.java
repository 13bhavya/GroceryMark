package com.example.grocerymark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Home_Activity extends AppCompatActivity implements View.OnClickListener {

    ImageView freshco, nofrill, loblaws, walma;
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

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.freshco:
                Toast.makeText(this, "You Clicked Freshco", Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(getApplicationContext(), Category_Activity.class);
                i1.putExtra("Click","Freshco");
                startActivity(i1);
                break;
            case R.id.nofrill:
                Toast.makeText(this, "You Clicked Nofrill", Toast.LENGTH_SHORT).show();
                Intent i2 =new Intent(getApplicationContext(), Category_Activity.class);
                i2.putExtra("Click","Nofrill");
                startActivity(i2);
                break;
            case R.id.loblaw:
                Toast.makeText(this, "You Clicked Loblaw", Toast.LENGTH_SHORT).show();
                Intent i3 =new Intent(getApplicationContext(), Category_Activity.class);
                i3.putExtra("Click","Loblaw");
                startActivity(i3);
                break;
            case R.id.walmart:
                Toast.makeText(this, "You Clicked Walmart", Toast.LENGTH_SHORT).show();
                Intent i4 =new Intent(getApplicationContext(), Category_Activity.class);
                i4.putExtra("Click","Walmart");
                startActivity(i4);
                break;
        }
    }
}
