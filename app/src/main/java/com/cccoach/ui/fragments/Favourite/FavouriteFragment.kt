package com.cccoach.ui.fragments.Favourite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.cccoach.R
import com.cccoach.databinding.FragmentFavouriteBinding
import com.cccoach.ui.activities.MainActivity
import com.cccoach.ui.adapter.learner.CoachAdapter
import com.cccoach.ui.base.BaseFragment
import com.cccoach.utils.HandleClickListener


class FavouriteFragment : BaseFragment(), HandleClickListener,CoachAdapter.ClickListeners {

    var binding : FragmentFavouriteBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (binding == null)  binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        initUI()
        return binding!!.root
    }

    private fun initUI() {
        binding!!.handleClick=this
        //Bottom navigation hide
        (baseActivity as MainActivity).setIcon()
        (baseActivity as MainActivity).setToolbar(
            baseActivity!!.getString(R.string.ll),
            isTitle = true, isToolbar = false, isBottom = false
        )
        val rvCoachList = binding!!.rvCoachList
        val coachAdapter = CoachAdapter(requireContext(),this)
        val linearLayoutManager = LinearLayoutManager(context)
        rvCoachList.adapter = coachAdapter
        rvCoachList.layoutManager = linearLayoutManager
    }

    override fun onViewClick(view: View) {
            when (view.id) {
                R.id.backIV->{
                    requireActivity().supportFragmentManager.popBackStack()

            }

        }
    }

    override fun onclick(position: Int) {
    }

}