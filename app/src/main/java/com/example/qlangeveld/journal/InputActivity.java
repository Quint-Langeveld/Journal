package com.example.qlangeveld.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input2);

        Intent intent = getIntent();
    }

    public void onSubmitCLicked(View view) {
        Intent intent = new Intent(InputActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void onSmileyClicked(View view) {
        ImageView checkHappy = findViewById(R.id.checkHappy);
        ImageView checkSad = findViewById(R.id.checkSad);
        ImageView checkNeutral = findViewById(R.id.checkNeutral);

        switch (view.getId()) {
            case R.id.smileyNeutral: {
                checkNeutral.setVisibility(View.VISIBLE);
                checkHappy.setVisibility(View.INVISIBLE);
                checkSad.setVisibility(View.INVISIBLE);
                break;
            }

            case R.id.smileyHappy: {
                checkHappy.setVisibility(View.VISIBLE);
                checkNeutral.setVisibility(View.INVISIBLE);
                checkSad.setVisibility(View.INVISIBLE);
                break;
            }

            case R.id.smileySad: {
                checkSad.setVisibility(View.VISIBLE);
                checkHappy.setVisibility(View.INVISIBLE);
                checkNeutral.setVisibility(View.INVISIBLE);
                break;
            }
        }
    }
}
