package com.driskimaulana.myroomdatabase.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.driskimaulana.myroomdatabase.R
import com.driskimaulana.myroomdatabase.model.User
import com.driskimaulana.myroomdatabase.viewmodel.UserViewModel
import com.driskimaulana.myroomdatabase.databinding.FragmentAddBinding
import kotlinx.coroutines.launch

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding

    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(inflater)

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]

        binding.btnAdd.setOnClickListener{
            addUserToDatabase()
        }

        return binding.root
    }

    private fun addUserToDatabase() {
        val firstname = binding.edtAddFirstName.text.toString()
        val lastname = binding.edtAddLastName.text.toString()
        val age = binding.edtAddAge.text

        if(validateInput(firstname, lastname, age)){
            // create user object
            val user = User(0, firstname, lastname, age.toString().toInt())

            lifecycleScope.launch{
                try {
                    viewModel.addUser(user)
                    Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_addFragment_to_listFragment)
                }catch (e: Exception){
                    e.printStackTrace()
                }
            }

        }else {
            Toast.makeText(requireContext(), "Add user failed! Please complete the required field.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateInput(firstname: String, lastname: String, age: Editable) : Boolean {

        return !(TextUtils.isEmpty(firstname) && TextUtils.isEmpty(lastname) && age.isEmpty())

    }

}