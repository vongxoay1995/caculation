package com.circulationapp.calculator.calculatorfree.view;

import android.util.Log;

import androidx.multidex.BuildConfig;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.core.CrashlyticsCore;

import io.fabric.sdk.android.Fabric;

public class MyApplication extends MultiDexApplication {
    public void onCreate() {
        MultiDex.install(this);
        Crashlytics crashlyticsKit = new Crashlytics.Builder()
                .core(new CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build())
                .build();
        Fabric.with(this, crashlyticsKit, new Crashlytics());
        super.onCreate();
    }
}
