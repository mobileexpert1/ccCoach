package com.cccoach.ui.fragments.coach.pending_appointment


import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import com.cccoach.R
import com.cccoach.databinding.CalendarDayTextBinding
import com.cccoach.databinding.FragmentPendingAppointmentBinding
import com.cccoach.ui.base.BaseFragment
import com.cccoach.utils.HandleClickListener
import com.kizitonwose.calendar.core.*
import com.kizitonwose.calendar.view.MonthDayBinder
import com.kizitonwose.calendar.view.ViewContainer
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.util.*


class PendingAppointmentFragment : BaseFragment(), HandleClickListener{

    var binding: FragmentPendingAppointmentBinding?=null
    lateinit var calendarView: com.kizitonwose.calendar.view.CalendarView
    lateinit var currentMonth: YearMonth

    val toolbar: Toolbar? = null

    val titleRes: Int? = null

    private val selectedDates = mutableSetOf<LocalDate>()
    @RequiresApi(Build.VERSION_CODES.O)
    private val today = LocalDate.now()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        if (binding == null)
            binding = FragmentPendingAppointmentBinding.inflate(inflater, container, false)
        initUI()
        return binding!!.root
    }

    private fun initUI() {

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.handleClick = this
        val daysOfWeek = daysOfWeek()
        currentMonth = YearMonth.now()
        val startMonth = currentMonth.minusMonths(100)
        val endMonth = currentMonth.plusMonths(100)

        initCalendar()

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
                        dateClicked(date = day.date)
                    }
//                    dialogDate()

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


/*    private fun dialogDate(){
        val dialog = Dialog(requireContext(), R.style.CustomBottomSheetDialogTheme)
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.calendar_day)
        dialog.show()
        val window = dialog.window
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window!!.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
    }*/

    private fun dateClicked(date: LocalDate) {

        if (selectedDates.contains(date)) {
            selectedDates.remove(date)
        } else {
            selectedDates.add(date)
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
        }
    }


}
