package com.example.androidjetback


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_chooser_recipient.*


class ChooserRecipientFragment : Fragment() {

    private lateinit var mNavController : NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chooser_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mNavController = Navigation.findNavController(view)
        initClickListener()
    }

    private fun initClickListener() {
        btn_next.setOnClickListener {
            mNavController.navigate(R.id.action_chooserRecipientFragment_to_specifyAmountFragment)
        }

        btn_cancel.setOnClickListener {
            activity?.onBackPressed()
        }
    }


}
