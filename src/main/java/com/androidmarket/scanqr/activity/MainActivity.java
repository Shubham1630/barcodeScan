package com.androidmarket.scanqr.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.androidmarket.scanqr.BuildConfig;
import com.androidmarket.scanqr.R;
import com.androidmarket.scanqr.databinding.ActivityMain2Binding;
import com.androidmarket.scanqr.databinding.ActivityMainBinding;
import com.androidmarket.scanqr.scanner_model.Admob;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private UnifiedNativeAd nativeAd;
    boolean doubleBackToExitPressedOnce = false;
    AdView mAdView;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main2);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(binding.n, navController);


//        BottomNavigationView navView  = findViewById(R.id.nav_view);
//
//        val navController = findNavController(R.id.nav_host_fragment)
//        val appBarConfiguration = AppBarConfiguration(
//                setOf(
//                        R.id.navigation_scan
//                )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
        //Native Ad
        refreshAd();

        //onBack Banner Ad
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);




    }


    @Override
    public void onBackPressed() {
        ShowBackStuff();
    }

    public void ShowBackStuff() {

        if (doubleBackToExitPressedOnce) {
            finish();
            return;
        }

        doubleBackToExitPressedOnce = true;
        RelativeLayout exitLayout = findViewById(R.id.exitLayout);
        exitLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitLayout.setVisibility(View.INVISIBLE);
            }
        });
        exitLayout.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);


    }

    public void Disppear(View view) {
        RelativeLayout exitLayout = findViewById(R.id.exitLayout);
        exitLayout.setVisibility(View.INVISIBLE);
    }


    public void StartScan(View view) {
        if (Admob.interstitialA.isLoaded()) {
            Admob.interstitialA.show();
            Admob.interstitialA.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    Admob.InterstitialA(MainActivity.this);

                    startActivity(new Intent(MainActivity.this, ScanActivity.class));
                }
            });
        } else{startActivity(new Intent(MainActivity.this, ScanActivity.class));}



    }

    public void StartCreation(View view) {
        if (Admob.interstitialA.isLoaded()) {
            Admob.interstitialA.show();
            Admob.interstitialA.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    Admob.InterstitialA(MainActivity.this);

                    startActivity(new Intent(MainActivity.this, CreateActivity.class));
                }
            });
        } else{startActivity(new Intent(MainActivity.this, CreateActivity.class));}
    }

    public void ShowHistory(View view) {
        if (Admob.interstitialA.isLoaded()) {
            Admob.interstitialA.show();
            Admob.interstitialA.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    Admob.InterstitialA(MainActivity.this);

                    startActivity(new Intent(MainActivity.this, HistoryActivity.class));
                }
            });
        } else{startActivity(new Intent(MainActivity.this, HistoryActivity.class));}
        ;
    }


    public void StartSetting(View view) {

        if (Admob.interstitialA.isLoaded()) {
            Admob.interstitialA.show();
            Admob.interstitialA.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    Admob.InterstitialA(MainActivity.this);

                    startActivity(new Intent(MainActivity.this, SettingActivity.class));
                }
            });
        } else{startActivity(new Intent(MainActivity.this, SettingActivity.class));}


    }





    public void Share(View view) {
            try {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.SUBJECT", "My application name");
                intent.putExtra("android.intent.extra.TEXT", "\nLet me recommend you this application\n\n" + "https://play.google.com/store/apps/details?id=" + getPackageName());
                startActivity(Intent.createChooser(intent, "Choose one"));
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    public void MoreApps(View view) {
        String url = "https://play.google.com/store/apps/developer?id=yourDeveloperId";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }





    private void populateUnifiedNativeAdView(UnifiedNativeAd nativeAd, UnifiedNativeAdView adView) {

        MediaView mediaView = adView.findViewById(R.id.ad_media);
        adView.setMediaView(mediaView);

// Set other ad assets.
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
        adView.setPriceView(adView.findViewById(R.id.ad_price));
        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
        adView.setStoreView(adView.findViewById(R.id.ad_store));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));

// The headline is guaranteed to be in every UnifiedNativeAd.
        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());

// These assets aren't guaranteed to be in every UnifiedNativeAd, so it's important to
// check before trying to display them.
        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            adView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }

        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            adView.getCallToActionView().setVisibility(View.VISIBLE);
            ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }

        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(View.GONE);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(
                    nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getPrice() == null) {
            adView.getPriceView().setVisibility(View.INVISIBLE);
        } else {
            adView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
        }

        if (nativeAd.getStore() == null) {
            adView.getStoreView().setVisibility(View.INVISIBLE);
        } else {
            adView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
        }

        if (nativeAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) adView.getStarRatingView())
                    .setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
        }

// This method tells the Google Mobile Ads SDK that you have finished populating your
// native ad view with this native ad. The SDK will populate the adView's MediaView
// with the media content from this native ad.
        adView.setNativeAd(nativeAd);

// Get the video controller for the ad. One will always be provided, even if the ad doesn't
// have a video asset.
        VideoController vc = nativeAd.getVideoController();

// Updates the UI to say whether or not this ad has a video asset.
        if (vc.hasVideoContent()) {

// Create a new VideoLifecycleCallbacks object and pass it to the VideoController. The
// VideoController will call methods on this object when events occur in the video
// lifecycle.
            vc.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
                @Override
                public void onVideoEnd() {
// Publishers should allow native ads to complete video playback before
// refreshing or replacing them with another ad in the same UI location.
                    super.onVideoEnd();
                }
            });
        }
    }

    /**
     * Creates a request for a new native ad based on the boolean parameters and calls the
     * corresponding "populate" method when one is successfully returned.
     */
    private void refreshAd() {

        AdLoader.Builder builder = new AdLoader.Builder(this, getResources().getString(R.string.native_id_admob));

// OnUnifiedNativeAdLoadedListener implementation.
        builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
            @Override
            public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
// You must call destroy on old ads when you are done with them,
// otherwise you will have a memory leak.
                if (nativeAd != null) {
                    nativeAd.destroy();
                }
                nativeAd = unifiedNativeAd;
                FrameLayout nativeAdPlaceHolder = MainActivity.this.findViewById(R.id.nativeAdPlaceHolder);
                @SuppressLint("InflateParams") UnifiedNativeAdView adView = (UnifiedNativeAdView) MainActivity.this.getLayoutInflater()
                        .inflate(R.layout.ad_unified_new, null);
                MainActivity.this.populateUnifiedNativeAdView(unifiedNativeAd, adView);
                nativeAdPlaceHolder.removeAllViews();
                nativeAdPlaceHolder.addView(adView);
                nativeAdPlaceHolder.setVisibility(View.VISIBLE);
            }
        });
        VideoOptions videoOptions = new VideoOptions.Builder()
                .setStartMuted(true)
                .build();

        NativeAdOptions adOptions = new NativeAdOptions.Builder()
                .setVideoOptions(videoOptions)
                .build();

        builder.withNativeAdOptions(adOptions);

        AdLoader adLoader = builder.withAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.d("failNativeAd", "Failed to load native ad:: ");
            }
        }).build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    @Override
    protected void onDestroy() {
        if (nativeAd != null) {
            nativeAd.destroy();
        }
        super.onDestroy();
    }



}