package com.driskimaulana.myroomdatabase.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.driskimaulana.myroomdatabase.R
import com.driskimaulana.myroomdatabase.databinding.FragmentUpdateBinding
import com.driskimaulana.myroomdatabase.model.User
import com.driskimaulana.myroomdatabase.viewmodel.UserViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateFragment : Fragment() {

    private lateinit var binding: FragmentUpdateBinding

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var userViewModel: UserViewModel
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUpdateBinding.inflate(layoutInflater)

        // initialize viewmodel
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        // initialize input filed with selected user data
        binding.apply {
            edtUpdateFirstname.setText(args.updatedUser.firstName)
            edtUpdateLastname.setText(args.updatedUser.lastName)
            edtUpdateAge.setText(args.updatedUser.age.toString())

            btnUpdate.setOnClickListener {
                updateUserData()
            }
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun updateUserData() {

        // get the current input
        val updatedFirstName = binding.edtUpdateFirstname.text.toString()
        val updatedLastName = binding.edtUpdateLastname.text.toString()
        val updatedAge = binding.edtUpdateAge.text
        if(validateData(updatedFirstName, updatedLastName, updatedAge))
        {
            // create new user
            val updatedUser = User(args.updatedUser.id ,updatedFirstName, updatedLastName, updatedAge.toString().toInt())
            lifecycleScope.launch {
                try {
                    userViewModel.updateUser(updatedUser)
                    Toast.makeText(requireContext(), "Succesfully update", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_updateFragment_to_listFragment)
                }catch(e: Exception){
                    e.printStackTrace()
                }
            }
        }else {
            Toast.makeText(requireContext(), "Succesfully update", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateData(firstName: String, lastname: String, age: Editable): Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastname) && age.isEmpty())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.my_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.item_delete){
            deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteUser() {
        val dialog = AlertDialog.Builder(requireContext())
        dialog.setPositiveButton("Yes"){_, _->
            lifecycleScope.launch {
                try {
                    userViewModel.deleteUser(args.updatedUser)
                    Toast.makeText(requireContext(), "Succesfully remove ${args.updatedUser.firstName}", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_updateFragment_to_listFragment)
                }catch (e: Exception){
                    e.printStackTrace()
                }
            }
        }

        dialog.setNegativeButton("No"){_, _ ->}

        dialog.setTitle("Delete ${args.updatedUser.firstName}")
        dialog.setMessage("Are you sure delete ${args.updatedUser.firstName}?")
        dialog.create().show()

    }

}