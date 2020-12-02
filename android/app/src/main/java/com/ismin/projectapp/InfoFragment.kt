package com.ismin.projectapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class InfoFragment : Fragment() {
    private var activity: OnFragmentInteractionListener? = null;

    interface OnFragmentInteractionListener {
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onAttach(context: Context) {
        if (context is OnFragmentInteractionListener) {
            activity = context
        }
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
        activity = null
    }
}
