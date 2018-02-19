package app.demo.iot.com.kotlinwithretrofit

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by muhammed on 2/14/2018.
 */
interface RequestInterface {
    @GET("posts")
    fun getValues(): Observable<List<User>>

    companion object Factory {
        fun create(): RequestInterface {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .build()

            return retrofit.create(RequestInterface::class.java)
        }
    }
}