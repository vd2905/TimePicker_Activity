package com.example.timepicker_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker;
    TextView setTime;
    private String am_pm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTime=findViewById(R.id.setTime);
        setTime.setOnClickListener(new View.OnClickListener() {
            Calendar calendar = Calendar.getInstance();
            @Override
            public void onClick(View v) {
                TimePickerDialog dialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hours, int minutes) {
                        calendar.set(Calendar.HOUR_OF_DAY,hours);
                        calendar.set(Calendar.MINUTE,minutes);
                        if(calendar.get(Calendar.AM_PM) == Calendar.AM)
                        {
                            am_pm = "AM";
                        }
                        else if(calendar.get(Calendar.AM_PM) == Calendar.AM)
                        {
                            am_pm = "PM";
                        }
                        String strHrsToShow = (calendar.get(Calendar.HOUR) == 0) ?"12":Integer.toString(calendar.get(Calendar.HOUR));
                        setTime.setText(""+strHrsToShow+":"+minutes+" "+am_pm);
                    }
                },calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false);
                dialog.show();
            }
        });
    }
}