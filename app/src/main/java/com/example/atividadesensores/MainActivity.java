package com.example.atividadesensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SensorManager sensorManager;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewSensor);

        sensorManager = (SensorManager) getSystemService(getApplicationContext().SENSOR_SERVICE);
        List<Sensor> sensores = sensorManager.getSensorList(Sensor.TYPE_ALL);

        ArrayList<String> listaSensores = new ArrayList<String>();
        for(Sensor s : sensores){
            listaSensores.add(s.getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                listaSensores
        );
        listView.setAdapter(adapter);
    }
}
