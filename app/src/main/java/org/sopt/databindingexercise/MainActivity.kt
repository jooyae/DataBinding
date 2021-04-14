package org.sopt.databindingexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        loadDatas()
        initRecyclerview()
    }

    private fun initRecyclerview() {
        youtubeAdapter = RecyclerAdapter()
        binding.recyclerviewYoutube.adapter = youtubeAdapter
        loadYoutubeDatas()
    }

    private fun loadYoutubeDatas() {
        youtubeAdapter.submitLIst(youtubeItems)
    }


    private fun loadDatas() {
        youtubeItems.apply {
            add(
                YoutubeItem(
                    R.drawable.ic_home_img_step3,
                    "Jooyae",
                    "2021.04.13"
                )
            )
            add(
                YoutubeItem(
                    R.drawable.ic_home_img_step3,
                    "Jooyae2",
                    "2021.04.14"
                )
            )
            add(
                YoutubeItem(
                    R.drawable.ic_home_img_step3,
                    "Jooyae3",
                    "2021.04.13"
                )
            )
            add(
                YoutubeItem(
                    R.drawable.ic_home_img_step3,
                    "Jooyae4",
                    "2021.04.13"
                )
            )
            add(
                YoutubeItem(
                    R.drawable.ic_home_img_step3,
                    "Jooyae5",
                    "2021.04.13"
                )
            )
            add(
                YoutubeItem(
                    R.drawable.ic_home_img_step3,
                    "Jooyae6",
                    "2021.04.13"
                )
            )
        }

    }
}