package com.example.michal.weekplanner.fragments.Start;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.example.michal.weekplanner.R;

public class Biometr extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorManager;
    Sensor pressureSensor;

    TextView pressureTv;
    TextView pressQuality;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_sensor);;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pressureTv=(TextView)findViewById(R.id.pressure);
        pressQuality=(TextView)findViewById(R.id.pressureQuality);

        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        pressureSensor=sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,pressureSensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor=sensorEvent.sensor;
         if(sensor.getType()==Sensor.TYPE_PRESSURE)
        {
            pressureTv.setText(getResources().getText(R.string.pressure)+" "+sensorEvent.values[0]+" hPa");
            if((sensorEvent.values[0]<999)||(sensorEvent.values[0]>1025)){
                pressQuality.setText(getResources().getText(R.string.Biometrminus));
            }
            else
                pressQuality.setText(getResources().getText(R.string.Biometrplus));

        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
