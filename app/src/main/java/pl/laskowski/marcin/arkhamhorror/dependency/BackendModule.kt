package pl.laskowski.marcin.arkhamhorror.dependency

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pl.laskowski.marcin.arkhamhorror.model.card.CardAdapter
import pl.laskowski.marcin.arkhamhorror.model.pack.PackAdapter
import pl.laskowski.marcin.arkhamhorror.repository.ArkhamDbApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

@Module
class BackendModule {

    @Provides
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
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
                .add(CardAdapter())
                .add(PackAdapter())
                .build()
    }

    @Provides
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
    }

    @Provides
    fun loggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

}