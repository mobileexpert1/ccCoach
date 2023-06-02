package com.cccoach.ui.fragments.coach.time_booking

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.cccoach.R
import com.cccoach.databinding.CalendarDayTextBinding
import com.cccoach.databinding.FragmentCoachTimeBookingBinding
import com.cccoach.ui.base.BaseFragment
import com.cccoach.utils.HandleClickListener
import com.kizitonwose.calendar.core.CalendarDay
import com.kizitonwose.calendar.core.DayPosition
import com.kizitonwose.calendar.core.firstDayOfWeekFromLocale
import com.kizitonwose.calendar.core.yearMonth
import com.kizitonwose.calendar.view.CalendarView
import com.kizitonwose.calendar.view.MonthDayBinder
import com.kizitonwose.calendar.view.ViewContainer
import com.skydoves.balloon.*
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter


class CoachTimeBookingFragment : BaseFragment(), HandleClickListener {

    var binding: FragmentCoachTimeBookingBinding?=null
    lateinit var calendarView: CalendarView
    lateinit var currentMonth: YearMonth
    private lateinit var markAvailableBalloon: Balloon
    private lateinit var markBusyBalloon: Balloon
    private val selectedDates = mutableSetOf<LocalDate>()
    @RequiresApi(Build.VERSION_CODES.O)
    private val today = LocalDate.now()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        if (binding == null)
            binding = FragmentCoachTimeBookingBinding.inflate(inflater, container, false)
        initUI()
        return binding!!.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.handleClick = this
        currentMonth = YearMonth.now()
        initCalendar()
        initBalloons()

    }

    private fun initUI() {

    }

    private fun initBalloons() {
        markBusyBalloon = Balloon.Builder(requireContext())
            .setHeight(BalloonSizeSpec.WRAP)
            .setWidth(BalloonSizeSpec.WRAP)
            .setText("Mark as Busy")
            .setTextColorResource(R.color.white)
            .setTextSize(10f)
            .setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
            .setArrowSize(10)
            .setArrowPosition(0.5f)
            .setPaddingVertical(10)
            .setPaddingHorizontal(20)
            .setCornerRadius(4f)
            .setBackgroundColorResource(R.color.dark_blue)
            .setBalloonAnimation(BalloonAnimation.ELASTIC)
            .setLifecycleOwner(this)
            .build()

        markAvailableBalloon = Balloon.Builder(requireContext())
            .setHeight(BalloonSizeSpec.WRAP)
            .setWidth(BalloonSizeSpec.WRAP)
            .setText("Mark as Available")
            .setTextColorResource(R.color.white)
            .setTextSize(10f)
            .setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
            .setArrowSize(10)
            .setArrowPosition(0.5f)
            .setPaddingVertical(10)
            .setPaddingHorizontal(20)
            .setCornerRadius(4f)
            .setBackgroundColorResource(R.color.dark_blue)
            .setBalloonAnimation(BalloonAnimation.ELASTIC)
            .setLifecycleOwner(this)
            .build()

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initCalendar() {
        calendarView = binding!!.calendarView

        val currentMonth = YearMonth.now()
        val startMonth = currentMonth.minusMonths(100)  // Adjust as needed
        val endMonth = currentMonth.plusMonths(100)  // Adjust as needed
        val firstDayOfWeek = firstDayOfWeekFromLocale() // Available from the library
        calendarView.setup(startMonth, endMonth, firstDayOfWeek)
        calendarView.scrollToMonth(currentMonth)

        calendarView.monthScrollListener = { month ->

            val firstDate = month.weekDays.first().first().date
            val lastDate = month.weekDays.last().last().date
            Log.e("==>","First date ${firstDate} ${lastDate}")

            val date = month.yearMonth
            val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("LLL yyyy")
            val text = date.format(formatter)
//            val parsedDate = LocalDate.parse(text, formatter)

            binding!!.tvMonthYear.text = text
            this.currentMonth = month.yearMonth
        }

        class DayViewContainer(view: View) : ViewContainer(view) {
            // Will be set when this container is bound. See the dayBinder.
            lateinit var day: CalendarDay
            val textView = CalendarDayTextBinding.bind(view).exEightDayText

            init {
                view.setOnClickListener {
                    if (day.position == DayPosition.MonthDate) {
                        dateClicked(date = day.date, textView)
                    }
                    markBusyBalloon.setOnBalloonClickListener {
                       dateMarked(day.date)
                    }
                    markAvailableBalloon.setOnBalloonClickListener {
                       dateMarked(day.date)
                    }
                }
            }
        }

        binding!!.calendarView.apply {
            dayBinder = object : MonthDayBinder<DayViewContainer> {
                override fun create(view: View) = DayViewContainer(view)
                override fun bind(container: DayViewContainer, data: CalendarDay) {
                    container.day = data
                    bindDate(data.date, container.textView, data.position == DayPosition.MonthDate)
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun bindDate(date: LocalDate, textView: TextView, isSelectable: Boolean) {
        textView.text = date.dayOfMonth.toString()
        if (isSelectable) {
            when {
                selectedDates.contains(date) -> {
                    textView.setTextColor(resources.getColor(R.color.red_btn))
                    textView.setBackgroundResource(R.drawable.bg_calendar_day)
                }
                today == date -> {
                    textView.setTextColor(resources.getColor(R.color.black))
//                    textView.setBackgroundResource(R.drawable.darkblue_rect)
                    textView.background = null
                }
                else -> {
                    textView.setTextColor(resources.getColor(R.color.black))
                    textView.background = null
                }
            }
        } else {
            textView.setTextColor(resources.getColor(R.color.gray))
            textView.background = null
        }
    }

    private fun dateClicked(date: LocalDate, textView: TextView) {

        if (selectedDates.contains(date)) {
            textView.showAlignBottom(balloon = markAvailableBalloon)
        } else {
            textView.showAlignTop(balloon = markBusyBalloon)
        }

        // We want to reload the footer text as well.
//        binding!!.calendarView.notifyMonthChanged(date.yearMonth)
    }

    private fun dateMarked(date: LocalDate) {

        if (selectedDates.contains(date)) {
            selectedDates.remove(date)
            markAvailableBalloon.dismiss()
        } else {
            selectedDates.add(date)
            markBusyBalloon.dismiss()
        }

        // We want to reload the footer text as well.
        binding!!.calendarView.notifyMonthChanged(date.yearMonth)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewClick(view: View) {
        when(view.id) {
            R.id.ivCalendarForward -> {
                calendarView.scrollToMonth(currentMonth.plusMonths(1))
            }
            R.id.ivCalendarBack -> {
                calendarView.scrollToMonth(currentMonth.minusMonths(1))
            }
            R.id.tvAvailable -> {
            }
        }
    }


}