package nacc.sergey.rv.domain

import nacc.sergey.rv.App
import nacc.sergey.rv.data.RetrofitInterface
import nacc.sergey.rv.data.entity.UsersData
import nacc.sergey.rv.utils.Converter.convertApiListToDtoList
import nacc.sergey.rv.viewmodel.MyViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Interactor(private val retrofitService: RetrofitInterface) {

    fun getUsersFromApi(callback: MyViewModel.ApiCallback) {

        retrofitService.getUsers().enqueue(object : Callback<UsersData> {

            override fun onResponse(call: Call<UsersData>, response: Response<UsersData>) {
                callback.onSuccess(convertApiListToDtoList(response.body()?.data))
            }

            override fun onFailure(call: Call<UsersData>, t: Throwable) {
                callback.onFailure()
            }
        })
    }
}