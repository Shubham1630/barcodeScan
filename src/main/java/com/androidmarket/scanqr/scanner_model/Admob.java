package com.androidmarket.scanqr.scanner_model;

import android.content.Context;

import com.androidmarket.scanqr.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class Admob {


    public static InterstitialAd interstitialA;
    public static void InterstitialA(Context context) {
        interstitialA = new InterstitialAd(context);
        interstitialA.setAdUnitId(context.getString(R.string.interstial_id_admob));

        if(interstitialA.isLoaded()){
            return;

        } else {
            AdRequest videoRequest = new AdRequest.Builder().build();
            interstitialA.loadAd(videoRequest);

        }
    }

}
