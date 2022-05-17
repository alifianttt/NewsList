package com.assessment.newspost.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assessment.newspost.R
import com.assessment.newspost.databinding.ItemCommentBinding
import com.assessment.newspost.model.CommentModel

class CommentAdapter(private var dataComment: ArrayList<CommentModel> = arrayListOf()) : RecyclerView.Adapter<CommentAdapter.CommentHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CommentHolder {
        return CommentHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_comment, parent, false))
    }

    override fun onBindViewHolder(holder: CommentHolder, position: Int) {
        holder.bind(dataComment[position])
    }

    fun update(newList: ArrayList<CommentModel>){
        val initSize = this.dataComment.size
        this.dataComment.clear()
        notifyItemRangeRemoved(0, initSize)
        this.dataComment.addAll(newList)
        notifyItemRangeInserted(0, this.dataComment.size)
    }

    override fun getItemCount(): Int = dataComment.size

    class CommentHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(comment: CommentModel) = with(itemView){
            val binding = ItemCommentBinding.bind(itemView)

            binding.authorText.text = comment.name
            binding.commentBody.text = comment.body
        }
    }
}