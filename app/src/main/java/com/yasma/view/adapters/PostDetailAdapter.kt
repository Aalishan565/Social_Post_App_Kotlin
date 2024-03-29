package com.yasma.view.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yasma.R
import com.yasma.appUtils.MyAppConstant
import com.yasma.dto.PostDetail
import com.yasma.view.activity.PostDetailActivity
import com.yasma.view.activity.UserDetailActivity
import kotlinx.android.synthetic.main.row_item_post.view.tvBody
import kotlinx.android.synthetic.main.row_item_post_detail.view.*

class PostDetailAdapter(private val postList: List<PostDetail>, private val context: Context) :
    RecyclerView.Adapter<PostDetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.row_item_post_detail,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = postList[position].name
        holder.tvEmail.text = postList[position].email
        holder.tvBody.text = postList[position].body
        holder.cardPost.setOnClickListener {
            val intent = Intent(context, UserDetailActivity::class.java)
            intent.putExtra(MyAppConstant.USER_ID, postList[position].id)
            context.startActivity(intent)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName = view.tvName!!
        val tvEmail = view.tvEmail!!
        val tvBody = view.tvBody!!
        val cardPost = view.cardPost!!

    }
}