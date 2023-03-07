package com.naa.uz.dialogwithtext

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.naa.uz.dialogwithtext.databinding.FragmentCustomTextDialogBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CustomTextFragmentDialog.newInstance] factory method to
 * create an instance of this fragment.
 */
class CustomTextFragmentDialog : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentCustomTextDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCustomTextDialogBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment

        binding.btnOkay.setOnClickListener{
            if (onClick!=null){
                onClick?.onClick(binding.btnOkay.text.toString())
            }
            dismiss()
        }

        binding.btnCancel.setOnClickListener {
            if (onClick!=null){
                onClick?.onClick(binding.btnCancel.text.toString())
            }
            dismiss()
        }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CustomTextFragmentDialog().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    private var onClick: OnClick?=null

    interface OnClick{
        fun onClick(str:String)
    }
    fun setOnClick(onClick: OnClick){
        this.onClick = onClick
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}