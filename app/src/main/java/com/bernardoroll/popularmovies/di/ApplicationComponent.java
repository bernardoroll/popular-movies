package com.bernardoroll.popularmovies.di;

import com.bernardoroll.popularmovies.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
}
