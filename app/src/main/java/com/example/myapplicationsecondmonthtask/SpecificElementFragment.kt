package com.example.myapplicationsecondmonthtask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.myapplicationsecondmonthtask.databinding.FragmentSpecificElementBinding

class SpecificElementFragment : Fragment() {

    lateinit var binding: FragmentSpecificElementBinding
    private var viewModel = FullListFragmentViewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSpecificElementBinding.inflate(inflater,container, false)
        val view = binding.root

        binding.apply {
            //textBoxUserId.text = viewModel.vmid
            //textBoxBody.text = viewModel.vmbody
           // textBoxID.text = viewModel.vmid
            //textBoxTitle.text = viewModel.vmtitle
        }
        binding.btnGoBack.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_specificElementFragment_to_fullListFragment)
        }







                // Inflate the layout for this fragment
        return view
    }


}