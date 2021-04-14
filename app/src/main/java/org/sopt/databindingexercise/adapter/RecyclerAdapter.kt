package org.sopt.databindingexercise.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import org.sopt.databindingexercise.BR
import org.sopt.databindingexercise.GithubRepo
import org.sopt.databindingexercise.data.YoutubeItem
import org.sopt.databindingexercise.databinding.ItemYoutubeBinding

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    val diffCallback = object : DiffUtil.ItemCallback<GithubRepo>() {
        override fun areItemsTheSame(oldItem: GithubRepo, newItem: GithubRepo): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(oldItem: GithubRepo, newItem: GithubRepo): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    fun submitList(list: List<GithubRepo>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemYoutubeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.binding.setVariable(BR.data, item)
    }

    override fun getItemCount() = differ.currentList.size

    inner class ViewHolder(val binding: ItemYoutubeBinding) :
        RecyclerView.ViewHolder(binding.root)
}