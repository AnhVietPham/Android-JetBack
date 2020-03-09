package com.example.androidjetback

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(){

    private lateinit var mNavController : NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mNavController = Navigation.findNavController(view)
        initClickListener()
    }

    private fun initClickListener() {
        btn_view_transaction.setOnClickListener {
            mNavController.navigate(R.id.action_mainFragment_to_viewTransactionFragment)
        }

        btn_send_money.setOnClickListener {
            mNavController.navigate(R.id.action_mainFragment_to_chooserRecipientFragment)
        }

        btn_view_balance.setOnClickListener {
            mNavController.navigate(R.id.action_mainFragment_to_viewBalanceFragment)
        }
    }
}