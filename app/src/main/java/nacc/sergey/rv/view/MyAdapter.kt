package nacc.sergey.rv.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nacc.sergey.rv.R
import nacc.sergey.rv.domain.UserModel


class MyAdapter() : RecyclerView.Adapter<MyHolder>() {

    //Здесь хранится список элементов для RV
    var items = mutableListOf<UserModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        when (holder) {
            is MyHolder ->
            holder.bind(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    //Метод для добавления объектов в список
    fun addItems(list: List<UserModel>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

}