package org.civis.blockchain.sporttrakerimpact.repository

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import okhttp3.OkHttpClient
import org.civis.blockchain.sporttrakerimpact.strava.StravaRepository
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit
import com.squareup.okhttp.internal.Internal.logger
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class RepositoryFactory {

    private fun buildRetrofit(baseUrl: String, objectMapper: ObjectMapper): Retrofit {
        val httpClient = OkHttpClient.Builder()
        val interceptor = LoggingInterceptor()

        val client = httpClient
                .addInterceptor({ chain ->
                    val original = chain.request()
                    val requestBuilder = original.newBuilder()
                            .header("Content-Type", "application/json")
                            .method(original.method(), original.body())
                    chain.proceed(requestBuilder.build())
                })
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build()

        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .client(client)
                .build()
    }

    fun buildStravaRepository(objectMapper: ObjectMapper): StravaRepository {
        val retrofit :Retrofit= buildRetrofit(StravaRepository.baseUrl, objectMapper)
        return retrofit.create(StravaRepository::class.java)
    }

    internal inner class LoggingInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()

            val t1 = System.nanoTime()
            logger.info(String.format("Sending request %s on %s%n%s",
                    request.url(), chain.connection(), request.headers()))

            val response = chain.proceed(request)

            val t2 = System.nanoTime()
            logger.info(String.format("Received response for %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6, response.headers()))

            return response
        }
    }
}