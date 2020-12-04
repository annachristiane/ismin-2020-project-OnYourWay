package com.ismin.projectapp

import android.animation.ObjectAnimator
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Button
import android.widget.EditText
import androidx.cardview.widget.CardView
import com.google.android.material.transition.FadeThroughProvider

class CreateLineFragment : Fragment() {
    private var activity: LineCreator? = null;
    private lateinit var edtNameLine: EditText
    private lateinit var edtShortname: EditText
    private lateinit var edtTransport: EditText
    private lateinit var card: CardView
    private lateinit var rootLayout: ViewGroup
    private lateinit var blackView: View

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_create_line, container, false)

        rootLayout = rootView.findViewById(R.id.f_create_line_root_layout)
        edtNameLine = rootView.findViewById(R.id.f_create_line_edt_name_line)
        edtShortname = rootView.findViewById(R.id.f_create_line_edt_shortname)
        edtTransport = rootView.findViewById(R.id.f_create_line_edt_transport)
        card = rootView.findViewById(R.id.f_create_line_card)
        blackView = rootView.findViewById(R.id.f_create_line_black_view)

        rootView.setOnClickListener { activity?.closeCreateFragment() }
        rootView.findViewById<Button>(R.id.f_create_line_btn_save).setOnClickListener {
        }

        ObjectAnimator.ofFloat(card, "translationY", 300f, 0f)
                .apply {
                    interpolator = AccelerateDecelerateInterpolator()
                    duration = 300
                    start()
                }

        FadeThroughProvider().createAppear(rootLayout, card)?.start()

        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()

        ObjectAnimator.ofFloat(card, "translationY", 0f, 300f)
                .apply {
                    interpolator = AccelerateDecelerateInterpolator()
                    duration = 100
                    start()
                }

        FadeThroughProvider().createDisappear(rootLayout, card)?.start()
    }

    override fun onAttach(context: Context) {
        if (context is LineCreator) {
            activity = context
        }
        super.onAttach(context)
    }
}

interface LineCreator {
    fun onLineCreated(line: Line)
    fun closeCreateFragment()
}