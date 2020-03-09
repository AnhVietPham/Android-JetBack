package com.example.androidjetback


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_specify_amount.*

/**
 * A simple [Fragment] subclass.
 */
class SpecifyAmountFragment : Fragment() {
    private lateinit var mNavController : NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mNavController = Navigation.findNavController(view)
        initClickListener()
    }

    private fun initClickListener() {
        btn_send.setOnClickListener {
            mNavController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment)
        }

        btn_cancel.setOnClickListener {
            activity?.onBackPressed()
        }
    }
}
