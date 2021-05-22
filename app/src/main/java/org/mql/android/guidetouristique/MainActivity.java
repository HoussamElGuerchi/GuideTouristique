package org.mql.android.guidetouristique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mLocation;
    private Button mShowMore;
    private Button mRetry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLocation = (TextView) findViewById(R.id.current_position);
        mLocation.setText("Fes");
        mShowMore = (Button) findViewById(R.id.show_more_button);
        mRetry = (Button) findViewById(R.id.retry_button);

        mShowMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDetail();
            }
        });

        mRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Localisation...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showDetail() {
        String location = mLocation.getText().toString();
        Intent details = new Intent(this, DetailActivity.class);
        details.putExtra("currentLocation", location);
        startActivity(details);
    }
}