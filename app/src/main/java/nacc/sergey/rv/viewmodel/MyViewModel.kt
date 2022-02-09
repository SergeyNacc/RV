package nacc.sergey.rv.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import nacc.sergey.rv.App
import nacc.sergey.rv.domain.Interactor
import nacc.sergey.rv.domain.UserModel

class MyViewModel : ViewModel() {

    val usersListLiveData: MutableLiveData<List<UserModel>> = MutableLiveData()

    //Инициализируем интерактор
    private var interactor: Interactor = App.instance.interactor

    init {
        interactor.getUsersFromApi(object : ApiCallback{
            override fun onSuccess(users: List<UserModel>) {
                usersListLiveData.postValue(users)
            }

            override fun onFailure() {
            }

        })
    }

    interface ApiCallback {
        fun onSuccess(users: List<UserModel>)
        fun onFailure()
    }

}