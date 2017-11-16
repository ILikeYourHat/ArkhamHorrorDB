package pl.laskowski.marcin.arkhamhorror.dependency

import android.content.Context
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pl.laskowski.marcin.arkhamhorror.model.card.CardAdapter
import pl.laskowski.marcin.arkhamhorror.model.pack.PackAdapter
import pl.laskowski.marcin.arkhamhorror.repository.ArkhamDbApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

@Module
class BackendModule {

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): ArkhamDbApi {
        return retrofit.create(ArkhamDbApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
                .client(client)
                .baseUrl("https://arkhamdb.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
                .add(CardAdapter())
                .add(PackAdapter())
                .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor, cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .cache(cache)
                .build()
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideCache(@Named("cacheDirectory") cacheDirectory: File): Cache {
        return Cache(cacheDirectory, 50 * 1024 * 1024)
    }

    @Provides
    @Singleton
    @Named("cacheDirectory")
    fun provideCacheDirectory(context: Context): File {
        return File(context.cacheDir, "network")
    }

}