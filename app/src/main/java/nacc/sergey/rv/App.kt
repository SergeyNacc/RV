package nacc.sergey.rv

import android.app.Application
import androidx.lifecycle.MutableLiveData
import nacc.sergey.rv.data.ApiConstants
import nacc.sergey.rv.data.RetrofitInterface
import nacc.sergey.rv.domain.Interactor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    lateinit var retrofitService: RetrofitInterface
    lateinit var interactor: Interactor

    override fun onCreate() {
        super.onCreate()
        instance = this

        val retrofit = Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        retrofitService = retrofit.create(RetrofitInterface::class.java)

        interactor = Interactor(retrofitService)
    }

    companion object {
        lateinit var instance: App
        private set
    }
}