package com.example.androidjetback


import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_specify_amount.*
import java.math.BigDecimal

/**
 * A simple [Fragment] subclass.
 */
class SpecifyAmountFragment : Fragment() {
    private lateinit var mNavController: NavController
    private lateinit var mRecipient: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRecipient = arguments?.getString("recipient") ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mNavController = Navigation.findNavController(view)
        val message = "Sending money to $mRecipient"
        recipient.text = message
        initClickListener()
    }

    private fun initClickListener() {
        btn_send.setOnClickListener {
            if (!TextUtils.isEmpty(input_amount.text.toString())) {
                val amount = Money(BigDecimal(input_amount.text.toString()))
                val bundle = bundleOf(
                    "recipient" to mRecipient,
                    "amount" to amount
                )
                mNavController.navigate(
                    R.id.action_specifyAmountFragment_to_confirmationFragment,
                    bundle
                )
            } else {
                Toast.makeText(activity, "Enter an amount", Toast.LENGTH_LONG).show()
            }
        }

        btn_cancel.setOnClickListener {
            activity?.onBackPressed()
        }
    }
}
