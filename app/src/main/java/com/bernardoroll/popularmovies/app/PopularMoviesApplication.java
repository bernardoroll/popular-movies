package com.bernardoroll.popularmovies.app;

import android.support.multidex.MultiDexApplication;

import com.bernardoroll.popularmovies.di.ApplicationComponent;
import com.bernardoroll.popularmovies.di.DaggerApplicationComponent;
import com.tspoon.traceur.Traceur;


public class PopularMoviesApplication extends MultiDexApplication {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Traceur.enableLogging();
        applicationComponent = DaggerApplicationComponent.create();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

}
