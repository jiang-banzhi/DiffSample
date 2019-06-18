package com.banzhi.diffsample;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.banzhi.libbsdiff.InstallUtils;
import com.banzhi.libbsdiff.PatchCallback;
import com.banzhi.libbsdiff.PatchUtils;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] pers = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
            if (checkSelfPermission(pers[0]) == PackageManager.PERMISSION_DENIED) {
                requestPermissions(pers, 1);
            }
        }
        findViewById(R.id.loadApk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String patch = new File(Environment.getExternalStorageDirectory(), "patch").getAbsolutePath();
                PatchUtils.patchApk(MainActivity.this, patch, new PatchCallback() {
                    @Override
                    public void onPatch(File file) {
                        InstallUtils.installApk(MainActivity.this, file);
                    }
                });
            }
        });
        findViewById(R.id.installApk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
