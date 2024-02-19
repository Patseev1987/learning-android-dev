package com.example.dogs

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivityViewModel : ViewModel() {
    private val BASE_URL = "https://dog.ceo/api/breeds/image/random"
    private val compositeDisposable = CompositeDisposable()


    private val _dogImage: MutableLiveData<DogImage> = MutableLiveData<DogImage>()

    val dogImage: LiveData<DogImage> get() = _dogImage

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean> get() = _isLoading


    fun getDogImage() {

        val dispose = getSingle()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { _isLoading.value = true }
            .doAfterTerminate { _isLoading.value = false }
            .subscribe(
                { _dogImage.value = it },
                { Log.d("myLog", "Error:  $it") }
            )
        compositeDisposable.addAll(dispose)
    }


    private fun getSingle(): Single<DogImage> {
        return Single.fromCallable {
            val url = URL(BASE_URL)
            val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
            val inputStream = urlConnection.inputStream
            val inputStreamReader = InputStreamReader(inputStream)
            val bufferedReader = BufferedReader(inputStreamReader)
            var data = StringBuilder()
            var result: String? = ""
            do {
                result = bufferedReader.readLine()
                if (result != null) {
                    data.append(result)
                }

            } while (result == null)

            val jsonObject = JSONObject(data.toString())
            val message = jsonObject.getString("message")
            val status = jsonObject.getString("status")
            val image = DogImage(message, status)
            return@fromCallable image
        }

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}