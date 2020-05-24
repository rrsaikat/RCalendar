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

package com.rezwan.rcalendar.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.rezwan.rcalendar.R
import com.rezwan.rcalendar.adapters.ViewPagerAdapter
import com.rezwan.rcalendar.callbacks.OnFragmentVisibleListener
import com.rezwan.rcalendar.ext.listener
import com.rezwan.rcalendar.ui.fragments.DayFragment
import com.rezwan.rcalendar.ui.fragments.WeekFragment
import com.rezwan.rcalenderlib.ext.error
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_day.*
import kotlinx.android.synthetic.main.fragment_week.*

class MainActivity : AppCompatActivity(), OnFragmentVisibleListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pagerAdapter = ViewPagerAdapter(this, supportFragmentManager)
        with(pagerAdapter) {
            clear()
            addFragment(WeekFragment.newInstance())
            addFragment(DayFragment.newInstance())
        }

        with(view_pager){
            adapter = pagerAdapter
            addOnPageChangeListener(this.listener(this@MainActivity))
            tabs.setupWithViewPager(this)
        }
    }

    override fun onFragmentVisible(fragment: Fragment) {
        when (fragment) {
            is WeekFragment -> {
                subtitle.text = "${yearRangeWeekCalendarView?.getStartYear()} - ${yearRangeWeekCalendarView?.getEndYear()}"
                error("fffffffffff", fragment)
            }

            is DayFragment -> {
                subtitle.text = "${yearRangeDayCalendarView.getStartYear()} - ${yearRangeDayCalendarView.getEndYear()}"
                error("fffffffffff", fragment)
            }
        }
    }
}