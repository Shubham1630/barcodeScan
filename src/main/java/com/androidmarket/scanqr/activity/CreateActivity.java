package com.androidmarket.scanqr.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.androidmarket.scanqr.R;
import com.androidmarket.scanqr.scanner_feature.tabs.create.CreateBarcodeFragment;
import com.google.android.gms.ads.AdView;

public class CreateActivity extends AppCompatActivity {

    AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_create);



        CreateBarcodeFragment fragment = new CreateBarcodeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.create_frame, fragment);
        transaction.commit();

    }
}