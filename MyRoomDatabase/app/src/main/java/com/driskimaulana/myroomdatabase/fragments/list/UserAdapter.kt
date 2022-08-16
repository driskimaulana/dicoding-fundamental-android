package com.driskimaulana.myroomdatabase.fragments.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.driskimaulana.myroomdatabase.model.User
import com.driskimaulana.myroomdatabase.databinding.UserItemBinding

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer<User>(this, diffCallback)

    private var userList : List<User>
        get() = differ.currentList
        set(value) {differ.submitList(value)}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        return UserHolder(UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val user = userList[position]
        holder.binding.apply {
            tvId.text = user.id.toString()
            tvFirstname.text = user.firstName
            tvLastname.text = user.lastName
            tvAge.text = "(${user.age.toString()})"

            userItem.setOnClickListener{
                val action = ListFragmentDirections.actionListFragmentToUpdateFragment(user)
                holder.itemView.findNavController().navigate(action)
            }

        }
//        holder.binding.tvId.text = user.id.toString()
//        holder.binding.tvFirstname.text = user.firstName
//        holder.binding.tvLastname.text = user.lastName
//        holder.binding.tvAge.text = "(${user.age.toString()})"




    }


    fun addData(userList : List<User>){
        this.userList = userList
        notifyDataSetChanged()
    }

    override fun getItemCount() = userList.size

    inner class UserHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {

    }
}