package com.example.mvvm_countries.viewmodel

import androidx.lifecycle.*
import com.example.mvvm_countries.data.*
import com.example.mvvm_countries.di.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.*
import io.reactivex.observers.*
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListViewModel : ViewModel() {

    @Inject
    lateinit var countriesService: CountriesService

    init {
        DaggerApiComponent.create().inject(this)
    }
    //private val countriesService = CountriesService()
    private val disposable = CompositeDisposable()

    var countries = MutableLiveData<List<Country>>()
    var countryLoader = MutableLiveData<Boolean>()
    var loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchCountries()
    }

    private fun fetchCountries() {
        loading.value = true
        disposable.add(
            countriesService.getCountries()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Country>>() {
                    /**
                     * Notifies the SingleObserver with a single item and that the [Single] has finished sending
                     * push-based notifications.
                     * The [Single] will not call this method if it calls [.onError].
                     * @param t
                     * the item emitted by the Single
                     */
                    override fun onSuccess(values: List<Country>) {
                        countries.value = values
                        countryLoader.value = false
                        loading.value = false
                    }
                    /**
                     * Notifies the SingleObserver that the [Single] has experienced an error condition.
                     * If the [Single] calls this method, it will not thereafter call [.onSuccess].
                     * @param e
                     * the exception encountered by the Single
                     */
                    override fun onError(e: Throwable) {
                        countryLoader.value = false
                        loading.value = false
                        e.printStackTrace()
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
    /* val mockData = listOf(Country("County A"),
                           Country("County B"),
                           Country("County C"),
                           Country("County D"),
                           Country("County E"),
                           Country("County F"),
                           Country("County G"),
                           Country("County H"),
                           Country("County I"),
                           Country("County J"))
     countryLoader.value = false
     loading.value = false
     countries.value = mockData
     }

*/

}