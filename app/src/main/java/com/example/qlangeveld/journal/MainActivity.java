package com.example.qlangeveld.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toInputActivity() {
        Intent intent = new Intent(this, InputActivity.class);
        startActivity(intent);
    }

}


