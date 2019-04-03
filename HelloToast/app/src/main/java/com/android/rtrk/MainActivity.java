package com.android.rtrk;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        Button button = findViewById(R.id.openSecond);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                Rect rect = new Rect (0, 0, 100, 100);
                ActivityOptions activityOptions = ActivityOptions.makeBasic();
                ActivityOptions bounds = activityOptions.setLaunchBounds(rect);

                startActivity(i);
            }
        });

    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this,R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        ++mCount;
        if(mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
}
