package com.cccoach.ui.activities

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.cccoach.R
import com.cccoach.databinding.ActivityMainBinding
import com.cccoach.ui.base.BaseActivity
import com.cccoach.ui.extensions.addFragment
import com.cccoach.ui.extensions.replaceFragment
import com.cccoach.ui.extensions.setColor
import com.cccoach.ui.extensions.visibleView
import com.cccoach.ui.fragments.learner.home.HomeFragment
import com.cccoach.ui.fragments.learner.myrequest.MyRequestFragment
import com.cccoach.ui.fragments.learner.notification.NotificationFragment
import com.cccoach.ui.fragments.learner.sidemenu.SideMenuFragment
import com.cccoach.ui.fragments.timebooking.TimeBookingFragment
import com.cccoach.utils.HandleClickListener

class MainActivity : BaseActivity(), HandleClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()
        initToolbar()

    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolBarTB)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun setToolbar(
        title: String,
        isTitle: Boolean,
        isToolbar: Boolean,
        toolbarColor: Int,
        textColor: Int,
        isBottom: Boolean,
    ) {
        binding.titleTV.setColor(toolbarColor)
        binding.titleTV.setColor(toolbarColor)
        binding.toolBarTB.background = ContextCompat.getDrawable(this, toolbarColor)
        binding.titleTV.setColor(textColor)
        binding.titleTV.text = title
        if (isTitle) {
            binding.titleTV.visibleView(true)
        } else {
            binding.titleTV.visibleView(false)
        }
        if (isToolbar) {
            binding.toolRL.visibleView(true)
        } else {
            binding.toolRL.visibleView(false)
        }
        if (isBottom) {
            binding.bottomLL.visibleView(true)
        } else {
            when (supportFragmentManager.findFragmentById(R.id.frame_container)) {
                /*is HomeFragment, is MyRequestFragment, is TimeBookingFragment, is SideMenuFragment -> {
                    binding.bottomLL.visibleView(true)
                }*/is HomeFragment, is MyRequestFragment, is NotificationFragment, is SideMenuFragment -> {
                    binding.bottomLL.visibleView(true)
                }
                else -> {
                    binding.bottomLL.visibleView(false)
                }
            }
        }
    }


    private fun init() {
        setToolbar()
        binding.clickHandler = this

        replaceFragment(HomeFragment())

    }

    fun setIcon() {
        setDefault()
        when (supportFragmentManager.findFragmentById(R.id.frame_container)) {
            is HomeFragment -> {
                binding.homeIV.setImageResource(R.drawable.home_blue)
            }
            is MyRequestFragment -> {
                binding.requestIV.setImageResource(R.drawable.car_blue)
            }
            /*is TimeBookingFragment -> {
                binding.notificationIV.setImageResource(R.drawable.notification_blue)
            }*/is NotificationFragment -> {
                binding.notificationIV.setImageResource(R.drawable.notification_blue)
            }
            is SideMenuFragment -> {
                binding.sidemenuIV.setImageResource(R.drawable.sidemenu_blue)
            }

        }
    }


    private fun setDefault() {
        binding.homeIV.setImageResource(R.drawable.home_grey)
        binding.requestIV.setImageResource(R.drawable.car_grey)
        binding.notificationIV.setImageResource(R.drawable.notification_grey)
        binding.sidemenuIV.setImageResource(R.drawable.sidemenu_grey)
    }

    override fun onViewClick(view: View) {
        when (view.id) {
            R.id.homeLL -> {
                setDefault()
                binding.homeIV.setImageResource(R.drawable.home_blue)
                replaceFragment(HomeFragment())
            }
            R.id.requestLL -> {
                setDefault()
                binding.requestIV.setImageResource(R.drawable.car_blue)
                replaceFragment(MyRequestFragment())
            }
            /*R.id.notificationLL -> {
                setDefault()
                binding.notificationIV.setImageResource(R.drawable.notification_blue)
                replaceFragment(TimeBookingFragment())
            }*/ R.id.notificationLL -> {
                setDefault()
                binding.notificationIV.setImageResource(R.drawable.notification_blue)
                replaceFragment(NotificationFragment())
            }
            R.id.sidemenuLL -> {
                setDefault()
                binding.sidemenuIV.setImageResource(R.drawable.sidemenu_blue)
                replaceFragment(SideMenuFragment())
            }

        }
    }

}