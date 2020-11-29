package com.ismin.projectapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ARG_LINES = "ARG_LINES"

class LineListFragment : Fragment() {
    private lateinit var lines:ArrayList<Line>
    private lateinit var rcvLines: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            lines = it.getSerializable(ARG_LINES) as ArrayList<Line>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_line_list, container, false)

        this.rcvLines=rootView.findViewById(R.id.f_line_list_rcv_lines)
        this.rcvLines.adapter = LineAdapter(lines)
        val linearLayoutManager = LinearLayoutManager(context)
        this.rcvLines.layoutManager=linearLayoutManager

        val dividerItemDecoration = DividerItemDecoration(context, linearLayoutManager.orientation)
        this.rcvLines.addItemDecoration(dividerItemDecoration)

        return rootView;
    }

    companion object {
        @JvmStatic
        fun newInstance(lines:List<Line>) =
            LineListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_LINES, ArrayList(lines))
                }
            }
    }
}