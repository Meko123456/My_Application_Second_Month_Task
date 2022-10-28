package com.example.myapplicationsecondmonthtask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationsecondmonthtask.databinding.ListItemBinding

class NameAdapter :
    RecyclerView.Adapter<NameAdapter.NameViewHolder>() {

    var newList = ArrayList<Posts>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {

        return NameViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    fun setData(arrayList: ArrayList<Posts>) {
        this.newList = arrayList
        notifyDataSetChanged()
    }

    //lateinit var posts : ArrayList < Posts>


    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.bindItem(newList[position])
    }


    class NameViewHolder(private val itemBinding: ListItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(post: Posts) {
            itemBinding.idTv.text = post.id.toString()
            itemBinding.titleTv.text = post.title
            itemBinding.itemList.setOnClickListener {
                Navigation.findNavController(itemBinding.root).navigate(R.id.action_fullListFragment_to_specificElementFragment)

            }
        }
    }

    override fun getItemCount(): Int {
        return newList.size
    }


}