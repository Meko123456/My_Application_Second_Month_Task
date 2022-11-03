package com.example.myapplicationsecondmonthtask

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout.Spec
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import com.example.myapplicationsecondmonthtask.FullListFragmentRepository.item
import com.example.myapplicationsecondmonthtask.databinding.FragmentSpecificElementBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpecificElementFragment : Fragment() {

    private lateinit var binding: FragmentSpecificElementBinding
    private var viewModel = FullListFragmentViewModel()
    private var specificId = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSpecificElementBinding.inflate(inflater, container, false)
        val view = binding.root

        val args: SpecificElementFragmentArgs = SpecificElementFragmentArgs.fromBundle(requireArguments())
        specificId = args.id.toInt()



        val call: Call<Posts> = RetrofitInstance.api.getSeparatePost(specificId)

        call.enqueue(object : Callback<Posts> {
            override fun onResponse(call: Call<Posts>, response: Response<Posts>) {
                if (response.isSuccessful && response.body() != null) {
                    binding.apply {
                       textBoxID.text = response.body()!!.id.toString()
                        textBoxBody.text = response.body()!!.body
                        textBoxTitle.text = response.body()!!.title
                        textBoxUserId.text = response.body()!!.userId.toString()
                    }

                }
            }

            override fun onFailure(call: Call<Posts>, t: Throwable) {
                Log.e(TAG, "Response Not Successful")
            }


        })

        binding.btnGoBack.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_specificElementFragment_to_fullListFragment)
        }


        // Inflate the layout for this fragment
        return view
    }


}