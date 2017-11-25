package edu.groups.app.di.module;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import edu.groups.app.api.ApiService;
import edu.groups.app.api.BasicAuthInterceptor;
import edu.groups.app.api.GroupService;
import edu.groups.app.api.NetworkAvailableInterceptor;
import edu.groups.app.api.PostService;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kamil on 04/11/2017.
 */

@Module
public abstract class NetModule {

    public static final String BASE_URL = "http://10.0.2.2:8080/";
    private static final int MB = 1024 * 1024;

    @Provides
    @Singleton
    static BasicAuthInterceptor provideBasicAuthInterceptor() {
        return new BasicAuthInterceptor();
    }

    @Provides
    @Singleton
    static NetworkAvailableInterceptor provideNetworkAvailableInterceptor(Context context) {
        return new NetworkAvailableInterceptor(context);
    }

    @Provides
    @Singleton
    static Cache provideHttpCache(Context context) {
        return new Cache(context.getCacheDir(), 10 * MB);
    }

    @Provides
    @Singleton
    static OkHttpClient provideOkHttpClient(BasicAuthInterceptor interceptor, Cache cache,
                                            NetworkAvailableInterceptor networkAvailableInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(networkAvailableInterceptor)
                .addInterceptor(interceptor)
                .cache(cache)
                .build();
    }

    @Provides
    @Singleton
    static Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();
        Gson gson= gsonBuilder.create();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    static ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    static GroupService provideGroupService(Retrofit retrofit) {
        return retrofit.create(GroupService.class);
    }

    @Provides
    @Singleton
    static PostService providePostService(Retrofit retrofit) {
        return retrofit.create(PostService.class);
    }
}
