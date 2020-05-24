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

package com.rezwan.rcalendar.ext

import android.content.Context
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.rezwan.rcalendar.adapters.ViewPagerAdapter
import com.rezwan.rcalendar.callbacks.OnFragmentVisibleListener

private var isPageAlreadyShown = false

fun ViewPager.listener(onFragmentVisibleListener: OnFragmentVisibleListener) = object : ViewPager.OnPageChangeListener{
    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(
        position: Int,
        positionOffset: Float,
        positionOffsetPixels: Int
    ) {
        if (isPageAlreadyShown)
            return

        if (position == this@listener.currentItem){
            isPageAlreadyShown = true
            val adapter = this@listener.adapter as ViewPagerAdapter
            onFragmentVisibleListener.onFragmentVisible(adapter.getItem(position))
        }
    }

    override fun onPageSelected(position: Int) {
        isPageAlreadyShown = false
    }
}

fun AppCompatActivity.hideKeyboard() {
    val view = this.currentFocus
    if (view != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
}

fun Fragment.hideKeyboard() {
    val activity = this.activity
    if (activity is AppCompatActivity) {
        activity.hideKeyboard()
    }
}