package com.bernardoroll.popularmovies.client;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface PopularMoviesClient {

    @GET("movie/popular")
    Single<Object> getPopularMovies();

    @GET("movie/top_rated")
    Single<Object> getTopRatedMovies();

}
