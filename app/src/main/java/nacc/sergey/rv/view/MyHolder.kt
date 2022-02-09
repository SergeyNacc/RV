package nacc.sergey.rv.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*
import nacc.sergey.rv.domain.UserModel


class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val firstName = itemView.first_name
    private val lastName = itemView.last_name

    fun bind(user: UserModel) {
        firstName.text = user.firstName
        lastName.text = user.lastName
    }

}