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
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.rezwan.rcalenderlib.callbacks.YearRangeListener
import com.rezwan.rcalenderlib.ext.addToLifecycle
import com.rezwan.rcalenderlib.ext.error
import com.rezwan.rcalenderlib.models.RCalendar
import com.rezwan.rcalendar.R
import com.rezwan.rcalendar.ext.hideKeyboard
import kotlinx.android.synthetic.main.fragment_week.*
import org.joda.time.LocalDate
import java.lang.Exception

class WeekFragment : Fragment(), YearRangeListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_week, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        yearRangeWeekCalendarView.addToLifecycle(lifecycle, savedInstanceState)
        sticky_switch.isChecked = yearRangeWeekCalendarView.getIsDateSticky()
        sticky_switch.setOnCheckedChangeListener { buttonView, isChecked ->
            yearRangeWeekCalendarView.setIsDateSticky(isChecked)
        }
        btnPrev.setOnClickListener {
            yearRangeWeekCalendarView.navigateToPrevious()
        }
        btnNext.setOnClickListener {
            yearRangeWeekCalendarView.navigateToNext()
        }

        btnGotoStart.setOnClickListener {
            yearRangeWeekCalendarView.navigateToStart()
        }

        btnGotoEnd.setOnClickListener {
            yearRangeWeekCalendarView.navigateToEnd()
        }

        btnToday.setOnClickListener {
            yearRangeWeekCalendarView.navigateToday()
        }

        btnGotoDay.setOnClickListener {
            yearRangeWeekCalendarView.navigateToPage(20)
        }

        btnGotoDate.setOnClickListener {
            try {
                hideKeyboard()
                edtDate?.text.let {
                    val ldate = LocalDate.parse(it.toString())
                    yearRangeWeekCalendarView.gotoDate(ldate)
                }
            } catch (ex: Exception) {
                Toast.makeText(context, ex.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }

        yearRangeWeekCalendarView.setYearRangeListener(this)
    }

    override fun OnDateClicked(rCalendar: RCalendar, position: Int) {
        error(this, "OnDateClicked  ${rCalendar.date}")
    }

    override fun OnSelectedDateFound(
        rCalendar: RCalendar,
        firstDayOfWeek: LocalDate,
        lastDayOfWeek: LocalDate,
        dayPosition: Int,
        currentPageNum: Int,
        weekOfWeekYear: Int
    ) {
        error(this, "OnSelectedDateFound  ${rCalendar.date}")
        yearRangeWeekCalendarView?.post {
            when (rCalendar.viewMode) {
                RCalendar.ViewMode.WEEk -> {
                    tvWeekNo.text = "Week $currentPageNum"
                    tvDateRange.text = "$firstDayOfWeek - $lastDayOfWeek"

                    tvDate_1.text = "${rCalendar.date.dayOfMonth}"
                    tvDate_2.text =
                        "${rCalendar.date.monthOfYear().asText}, ${rCalendar.date.dayOfWeek().asShortText} ${rCalendar.date.year}"

                }

                RCalendar.ViewMode.DAY -> {
                    tvWeekNo.text = "Day $currentPageNum"
                    tvDateRange.text = "$firstDayOfWeek - $lastDayOfWeek"

                    tvDate_1.text = "${rCalendar.date.dayOfMonth}"
                    tvDate_2.text =
                        "${rCalendar.date.monthOfYear().asText}, ${rCalendar.date.dayOfWeek().asShortText} ${rCalendar.date.year}"

                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(): WeekFragment {
            return WeekFragment()
        }
    }
}