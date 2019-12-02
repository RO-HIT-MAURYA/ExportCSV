package com.example.exportcsv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},3147);
    }

    private void function() {
        

        CSVWriter writer = null;
        try
        {
            FileWriter fileWriter = new FileWriter("/sdcard/sponsor.csv");
            writer = new CSVWriter(fileWriter);
            String[] entries = "first#second#third#fourth#fifth#sixth#seventh".split("#"); // array of your values
            writer.writeNext(entries);
            writer.close();
            Log.e("exceptionIs","noException");
        }
        catch (IOException e)
        {
           Log.e("exceptionIs",e.toString());
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        function();

    }
}
