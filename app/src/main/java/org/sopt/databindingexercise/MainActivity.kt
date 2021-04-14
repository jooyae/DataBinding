package org.sopt.databindingexercise

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.sopt.databindingexercise.adapter.RecyclerAdapter
import org.sopt.databindingexercise.data.YoutubeItem
import org.sopt.databindingexercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var youtubeAdapter: RecyclerAdapter
    private val youtubeItems = mutableListOf<YoutubeItem>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerview()
        setGithubProfile()
    }


    private fun initRecyclerview() {
        youtubeAdapter = RecyclerAdapter()
        binding.recyclerviewYoutube.adapter = youtubeAdapter
    }

    @SuppressLint("CheckResult")
    fun setGithubProfile(){
        RetrofitService.githubApi.getRepos("jooyae")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                youtubeAdapter.submitList(it)
            },{
                it.printStackTrace()
            })
    }


}