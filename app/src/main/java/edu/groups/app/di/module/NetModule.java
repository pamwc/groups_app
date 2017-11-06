package edu.groups.app.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import edu.groups.app.api.ApiService;
import edu.groups.app.api.BasicAuthInterceptor;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kamil on 04/11/2017.
 */

@Module
public abstract class NetModule {

    private static final String BASE_URL = "http://10.0.2.2:8080/";
    private static final int MB = 1024 * 1024;

    @Provides
    @Singleton
    static Interceptor provideInterceptor() {
        return new BasicAuthInterceptor();
    }

    @Provides
    @Singleton
    static Cache provideHttpCache(Context context) {
        return new Cache(context.getCacheDir(), 10 * MB);
    }

    @Provides
    @Singleton
    static OkHttpClient provideOkHttpClient(Interceptor interceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .cache(cache)
                .build();
    }

    @Provides
    @Singleton
    static Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    static ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
