package app.demo.iot.com.kotlinwithretrofit

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import app.demo.iot.com.kotlinwithretrofit.databinding.ActivityMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    var mainBinding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainBinding?.items?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        callApi()
    }

    private fun callApi() {
        val retrofit = RequestInterface.create()

        compositeDisposable.add(retrofit.getValues()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        { result ->
                            mainBinding?.items?.adapter = MyAdapter(result)
                        }, { error ->
                    error.printStackTrace()
                }
                ))
    }

}
