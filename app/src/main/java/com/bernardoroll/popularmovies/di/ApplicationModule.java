package com.bernardoroll.popularmovies.di;

import android.app.Application;

import dagger.Module;

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

}
