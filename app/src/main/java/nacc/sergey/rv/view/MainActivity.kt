package nacc.sergey.rv.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import nacc.sergey.rv.databinding.ActivityMainBinding
import nacc.sergey.rv.domain.UserModel
import nacc.sergey.rv.viewmodel.MyViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MyAdapter

    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(MyViewModel::class.java)
    }

    private var usersDataBase = listOf<UserModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyckler()

        viewModel.usersListLiveData.observe(this, Observer<List<UserModel>>{
            usersDataBase = it
        })
    }

    private fun initRecyckler() {
        recyclerView = binding.recyclerView
        adapter = MyAdapter()
        recyclerView.adapter = adapter
        adapter.addItems(usersDataBase)
    }
}