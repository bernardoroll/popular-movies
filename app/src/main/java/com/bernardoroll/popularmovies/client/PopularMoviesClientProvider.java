package com.bernardoroll.popularmovies.client;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

public class PopularMoviesClientProvider {

    private static final String API_KEY_QUERY_PARAM = "api_key=";
    private CallAdapter.Factory callAdapter;


    PopularMoviesClientProvider(CallAdapter.Factory callAdapter) {
        this.callAdapter = callAdapter;
    }

    public PopularMoviesClient get() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BODY);
        builder.addInterceptor(loggingInterceptor);

        builder.addInterceptor(chain -> {
            Request request = chain.request();
            return chain.proceed(request);
        });
        final Retrofit restAdapter = new Retrofit.Builder()
                .client(builder.build())
                .addCallAdapterFactory(callAdapter)
                .baseUrl("") // TODO: Create Constants.ENDPOINT
                .build();
        return restAdapter.create(PopularMoviesClient.class);
    }

}
