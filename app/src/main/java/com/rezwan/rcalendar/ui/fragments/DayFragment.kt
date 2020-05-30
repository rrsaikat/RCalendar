/*
 * Copyright 2020 RRsaikat. All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rezwan.rcalendar.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.rezwan.rcalenderlib.callbacks.YearRangeListener
import com.rezwan.rcalenderlib.ext.addToLifecycle
import com.rezwan.rcalenderlib.ext.error
import com.rezwan.rcalenderlib.models.RCalendar

import com.rezwan.rcalendar.R
import com.rezwan.rcalendar.ext.hideKeyboard
import kotlinx.android.synthetic.main.fragment_day.*
import kotlinx.android.synthetic.main.fragment_week.*
import kotlinx.android.synthetic.main.fragment_week.btnGotoDate
import kotlinx.android.synthetic.main.fragment_week.btnGotoDay
import kotlinx.android.synthetic.main.fragment_week.btnGotoEnd
import kotlinx.android.synthetic.main.fragment_week.btnGotoStart
import kotlinx.android.synthetic.main.fragment_week.btnNext
import kotlinx.android.synthetic.main.fragment_week.btnPrev
import kotlinx.android.synthetic.main.fragment_week.btnToday
import kotlinx.android.synthetic.main.fragment_week.edtDate
import kotlinx.android.synthetic.main.fragment_week.tvDateRange
import kotlinx.android.synthetic.main.fragment_week.tvDate_1
import kotlinx.android.synthetic.main.fragment_week.tvDate_2
import org.joda.time.LocalDate
import java.lang.Exception


class DayFragment : Fragment(), YearRangeListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_day, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        yearRangeDayCalendarView.addToLifecycle(lifecycle, savedInstanceState)
        btnPrev.setOnClickListener {
            yearRangeDayCalendarView.navigateToPrevious()
        }
        btnNext.setOnClickListener {
            yearRangeDayCalendarView.navigateToNext()
        }

        btnGotoStart.setOnClickListener {
            yearRangeDayCalendarView.navigateToStart()
        }

        btnGotoEnd.setOnClickListener {
            yearRangeDayCalendarView.navigateToEnd()
        }

        btnToday.setOnClickListener {
            yearRangeDayCalendarView.navigateToday()
        }

        btnGotoDay.setOnClickListener {
            yearRangeDayCalendarView.navigateToPage(20)
        }

        btnGotoDate.setOnClickListener {
            try {
                hideKeyboard()
                edtDate?.text.let {
                    yearRangeDayCalendarView.gotoDate(it.toString())
                }
            } catch (ex: Exception) {
                Toast.makeText(context, ex.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }

        yearRangeDayCalendarView.setYearRangeListener(this)
    }

    companion object {
        @JvmStatic
        fun newInstance(): DayFragment {
            return DayFragment()
        }
    }

    override fun OnDateClicked(rCalendar: RCalendar, position: Int) {
        error(this, "OnDateClicked  ${rCalendar.date}")
    }

    override fun OnSelectedDateFound(
        rCalendar: RCalendar,
        firstDayOfWeek: String,
        lastDayOfWeek: String,
        dayPosition: Int,
        currentPageNum: Int
    ) {
        error(this, "OnSelectedDateFound  ${rCalendar.date}")
        yearRangeDayCalendarView?.post {
            tvDayNo.text = "Day $currentPageNum"
            tvDateRange.text = "$firstDayOfWeek - $lastDayOfWeek"

            tvDate_1.text = "${rCalendar.date.dayOfMonth}"
            tvDate_2.text =
                "${rCalendar.date.monthOfYear().asText}, ${rCalendar.date.dayOfWeek().asShortText} ${rCalendar.date.year}"

        }
    }
}
