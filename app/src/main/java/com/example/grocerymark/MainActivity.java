package com.example.grocerymark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.jgabrielfreitas.core.BlurImageView;

public class MainActivity extends AppCompatActivity {

    BlurImageView blurImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND,
                WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        setContentView(R.layout.activity_main);

        //blurImageView = findViewById(R.id.BlurImageView);
        //blurImageView.setBlur(5);

        Intent intent = getIntent();
        String bckcome = intent.getStringExtra("Success");
        Toast.makeText(getApplicationContext(),bckcome,Toast.LENGTH_LONG).show();
    }

    public void ClickSignIn(View view){

        Intent intent = new Intent(this,SignOn_activity.class);
        intent.putExtra("Toast", "SignOn Page");
        startActivity(intent);
    }

    public void ClickSignUp(View view){

        Intent intent = new Intent(this,LogOn_activity.class);
        intent.putExtra("Toast", "LogOn Page");
        startActivity(intent);
    }
}
