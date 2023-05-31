package com.cccoach.ui.fragments.FAQs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import com.cccoach.R
import com.cccoach.databinding.FragmentFAQsBinding
import com.cccoach.ui.adapter.ExpandableList.ThreeLevelListAdapter
import com.cccoach.ui.base.BaseFragment
import com.cccoach.utils.HandleClickListener

class FAQsFragment : BaseFragment(), HandleClickListener{

    var binding:FragmentFAQsBinding?=null
    var secondLevel: MutableList<Array<String>>? = ArrayList()
    var data: MutableList<LinkedHashMap<String, Array<String>>> = ArrayList()
    var thirdLevelOne = LinkedHashMap<String, Array<String>>()
    var thirdLevelTwo = LinkedHashMap<String, Array<String>>()
    var thirdLevelThree = LinkedHashMap<String, Array<String>>()
    var thirdLevelFour = LinkedHashMap<String, Array<String>>()
    var thirdLevelFive = LinkedHashMap<String, Array<String>>()
    var thirdLevelSix = LinkedHashMap<String, Array<String>>()

    var parent = arrayOf("Frequently asked questions","Frequently asked questions","Frequently asked questions","Frequently asked questions","Frequently asked questions","Frequently asked questions")
    var FrequentlyOne = arrayOf("Frequently asked questions")
    var FrequentlyOneInner = arrayOf("Frequently asked questions\n\n" +"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor\n"+"incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis \n" + "nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.")


    var FrequentlyTwo =  arrayOf("Frequently asked questions")
    var FrequentlyTwoInner = arrayOf("Frequently asked questions\n\n"+"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor\n" +"incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis \n" + "nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.")


    var FrequentlyThree=  arrayOf("Frequently asked questions")
    var FrequentlyThreeInner=  arrayOf("Frequently asked questions\n\n"+"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor\n" +"incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis \n" + "nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.")


    var FrequentlyFour= arrayOf("Frequently asked questions")
    var FrequentlyFourInner= arrayOf("Frequently asked questions\n\n" + "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor\n" + "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis \n" + "nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.")

    var FrequentlyFive= arrayOf("Frequently asked questions")
    var FrequentlyFiveInner= arrayOf("Frequently asked questions\n\n" + "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor\n" + "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis \n" + "nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.")

    var FrequentlySix= arrayOf("Frequently asked questions")
    var FrequentlySixInner= arrayOf("Frequently asked questions\n\n" + "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor\n" + "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis \n" + "nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.")


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        if (binding == null)
            binding = FragmentFAQsBinding.inflate(inflater, container, false)
        initUI()
        return binding!!.root
    }

    private fun initUI() {

        binding!!.handleClick=this
        // parent adapter
        val threeLevelListAdapterAdapter = ThreeLevelListAdapter(requireContext(), parent, secondLevel, data)
        // set adapter
        binding!!.expandibleListview.setAdapter(threeLevelListAdapterAdapter)
        // OPTIONAL : Show one list at a time
        binding!!.expandibleListview.setOnGroupExpandListener(object :
            ExpandableListView.OnGroupExpandListener {
            var previousGroup = -1
            override fun onGroupExpand(groupPosition: Int) {
                if (groupPosition != previousGroup) binding!!.expandibleListview.collapseGroup(previousGroup)
                previousGroup = groupPosition
            }
        })

        secondLevel!!.add(FrequentlyOne)
        secondLevel!!.add(FrequentlyTwo)
        secondLevel!!.add(FrequentlyThree)
        secondLevel!!.add(FrequentlyFour)
        secondLevel!!.add(FrequentlyFive)
        secondLevel!!.add(FrequentlySix)

        thirdLevelOne[FrequentlyOne[0]] = FrequentlyOneInner
        thirdLevelTwo[FrequentlyTwo[0]] = FrequentlyTwoInner
        thirdLevelThree[FrequentlyThree[0]]=FrequentlyThreeInner
        thirdLevelFour[FrequentlyFour[0]]=FrequentlyFourInner
        thirdLevelFive[FrequentlyFive[0]]=FrequentlyFiveInner
        thirdLevelSix[FrequentlySix[0]]=FrequentlySixInner

        data.add(thirdLevelOne)
        data.add(thirdLevelTwo)
        data.add(thirdLevelThree)
        data.add(thirdLevelFour)
        data.add(thirdLevelFive)
        data.add(thirdLevelSix)
    }

    override fun onViewClick(view: View) {

        when (view.id) {
            R.id.ivBackpress -> {
                requireActivity().supportFragmentManager.popBackStack()
            }

        }

    }


}