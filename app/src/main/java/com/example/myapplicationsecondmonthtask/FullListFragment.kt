package com.example.myapplicationsecondmonthtask

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationsecondmonthtask.databinding.FragmentFullListBinding


class FullListFragment : Fragment() {

    private lateinit var binding: FragmentFullListBinding
    private var filteredArrayList = arrayListOf<Posts>()
    private var dataArrayList = arrayListOf<Posts>()
    private var recyclerViewAdapter = NameAdapter()
    private lateinit var viewModel: FullListFragmentViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFullListBinding.inflate(inflater, container, false)
        val view = binding.root

        viewModel = ViewModelProvider(this)[FullListFragmentViewModel::class.java]
        getData()

        binding.recyclerView.adapter = recyclerViewAdapter

        /*val call: Call<ArrayList<Posts>> = RetrofitInstance.api.getPosts()

        call.enqueue(object : Callback<ArrayList<Posts>> {
            override fun onResponse(
                call: Call<ArrayList<Posts>>,
                response: Response<ArrayList<Posts>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    recyclerViewAdapter.setData(response.body()!!)
                    dataArrayList = response.body()!!
                }
            }

            override fun onFailure(call: Call<ArrayList<Posts>>, t: Throwable) {
                Log.e(TAG, "Response Not Successful")
            }

        })*/
        //dataArrayList = Posts


        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(inputText: CharSequence?, p1: Int, p2: Int, p3: Int) {
                filteredArrayList = dataArrayList.filter {
                    it.id.toString().startsWith(inputText.toString())
                } as ArrayList<Posts>
                if (inputText.toString().isEmpty()) {
                    recyclerViewAdapter.setData(dataArrayList)
                } else {
                    recyclerViewAdapter.setData(filteredArrayList)
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        }
        )
        return view
    }

    private fun getData () {
        viewModel.getFullListDate().observe(viewLifecycleOwner) {
            dataArrayList = it
            recyclerViewAdapter.setData(dataArrayList)
        }
    }
}