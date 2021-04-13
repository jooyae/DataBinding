package org.sopt.databindingexercise.data

import android.view.View
import android.widget.Toast

class YoutubeItem(
    val youtubeImage : String,
    val youtubeTitle : String,
    val youtubeDate : String
){
    fun onClickListener(view: View) {
        Toast.makeText(view.context ,"Clicked: $youtubeTitle",Toast.LENGTH_SHORT).show()
    }
}