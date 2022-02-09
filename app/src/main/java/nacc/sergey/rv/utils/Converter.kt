package nacc.sergey.rv.utils

import nacc.sergey.rv.data.entity.User
import nacc.sergey.rv.domain.UserModel

object Converter {

    fun convertApiListToDtoList(list: List<User>?): List<UserModel> {
        val result = mutableListOf<UserModel>()
        list?.forEach {
            result.add(
                    UserModel(
                            firstName = it.firstName,
                            lastName = it.lastName
                    )
            )
        }
        return result
    }
}