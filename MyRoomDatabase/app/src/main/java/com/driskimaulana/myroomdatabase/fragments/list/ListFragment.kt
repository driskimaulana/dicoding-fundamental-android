package com.driskimaulana.myroomdatabase.fragments.list

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.driskimaulana.myroomdatabase.R
import com.driskimaulana.myroomdatabase.viewmodel.UserViewModel
import com.driskimaulana.myroomdatabase.databinding.FragmentListBinding
import kotlinx.coroutines.launch

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    private lateinit var userAdapter: UserAdapter

    private lateinit var mcontext: Context

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(inflater)

        binding.addFloatingButton.setOnClickListener{
            // navigate to add fragment
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        // get the context
        mcontext = binding.root.context

        setupRecyclerView()

        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer{ it ->
            userAdapter.addData(it)
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            userAdapter = UserAdapter()
            adapter = userAdapter
            layoutManager = LinearLayoutManager(mcontext)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.my_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.item_delete){
            var dialog = AlertDialog.Builder(mcontext)
            dialog.setPositiveButton("Yes"){_, _ ->
                lifecycleScope.launch {
                    try {
                        mUserViewModel.deleteAllUser()
                        Toast.makeText(mcontext, "Successfully delete all data", Toast.LENGTH_SHORT).show()
                    }catch (e: Exception){
                        e.printStackTrace()
                    }
                }
            }

            dialog.setNegativeButton("No"){_, _ ->}

            dialog.setTitle("Delete All User")
            dialog.setMessage("Are you sure want to remove all user data?")
            dialog.create().show()
        }
        return super.onOptionsItemSelected(item)
    }


}