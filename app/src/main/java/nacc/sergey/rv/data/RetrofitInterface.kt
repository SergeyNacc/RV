package nacc.sergey.rv.data

import io.reactivex.Observable
import nacc.sergey.rv.data.entity.UsersData
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {

    @GET ("api/users?page=2")
    fun getUsers(): Call<UsersData>
}