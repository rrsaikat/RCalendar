# RCalendar
![Feature Image](https://blog.rrsaikat.com/wp-content/uploads/2020/05/banner.png)

An android package that provides horizontal date picker as week and day mode within a given range of year. This library extends Recyclerview and JodaTime. Feel free to use it all you want in your Android apps provided that you cite this project and include the license in your app.


<p align="start">
  <img src="https://github.com/rrsaikat/RCalendar/blob/master/app/GIF-200526_172126.gif" alt="" width="237" height="458""/>
  <img src="https://github.com/rrsaikat/RCalendar/blob/master/app/GIF-200526_171721.gif"" alt="" width="237" height="458"/>
</p>

<p align="start">
  <img src="https://blog.rrsaikat.com/wp-content/uploads/2020/05/GIF-200526_172126.gif" width="237" height="458"/>
  <img src="https://blog.rrsaikat.com/wp-content/uploads/2020/05/GIF-200526_171721.gif" width="237" height="458"/>
</p>

Demo App:

[![Get it on Google Play](https://play.google.com/intl/en_us/badges/images/badge_new.png)](https://play.google.com/store/apps/details?id=com.rezwan.rcalendar)


Usage Guide
-----------------
Have to enable Kotlin and AndroidX, because this project only works into this configuration and not available for java.

STEP 1:  Download rcalenderlib_vX.X.X.aar from here:    

<a href="https://github.com/rrsaikat/RCalendar/raw/master/app/libs/rcalenderlib_v2.6.0.aar" title="Download">
    <img alt="Download" src="https://img.pngio.com/free-icon-download-png-182575-download-icon-download-png-182575-icon-png-download-600_400.jpg" height="80" width="100">
</a>


STEP 2: Put the downloaded library file into libs folder like this:

<img src="https://blog.rrsaikat.com/wp-content/uploads/2020/05/lib_example.png" height="200" width="220"/>

        
   nb: Don't forget to navigate the library into projects build.gradle:
        
            allprojects {
                repositories {
                    google()
                    jcenter()
                    flatDir {
                        dirs 'libs'
                      }
                  }
              }      
        
STEP 3: Reference the library itself in your module-level build.gradle:      

        api(name: 'rcalenderlib_v2.5.0', ext: 'aar')

STEP 4: Add more required libraries into your module-level build.gradle:

        implementation 'com.google.android.material:material:1.1.0'
        implementation 'joda-time:joda-time:2.10.1'
        

STEP 5: Finally sync and build.



Usage Example
-----------------

In XML :

      <com.rezwan.rcalenderlib.views.YearRangeCalendarView
              android:id="@+id/yearRangeCalendarView"
              android:layout_width="match_parent"
              android:layout_height="wrap_content"
              app:month_name_maxlength="two"
              app:date_start_name="Wednesday"
              app:highlight_today_at_startup="true"
              app:sticky_date="false"
              app:calendar_style="light"
              app:show_month="false"
              app:start_year="2020"
              app:end_year="2021"
              app:calendar_mode="week"/>
              


In Activity/Fragment:

              yearRangeCalendarView.setYearRangeListener(this)
                   override fun OnDateClicked(rCalendar: RCalendar, position: Int) {

                   }

                   override fun OnSelectedDateFound(
                        rCalendar: RCalendar,
                        firstDayOfWeek: String,
                        lastDayOfWeek: String,
                        dayPosition: Int,
                        currentPageNum: Int) {

                      }
            
              

#### Methods
Methods | Return | Description
--- | --- | ---
setYearRange(startYear: Int, endYear: Int) | void | set the start and end year.
setMonthTextLength(textLength: Int) | void | set the text length of month.
setIsDateSticky(isSticky: Boolean) | void | tracks your previous selected date position.
navigateToPrevious() | void | go to previous week/day .
navigateToNext() | void | go to next week/day.
navigateToday() | void | highlight or go to at today's date position.
navigateToStart() | void | go to starting week/day.
navigateToEnd() | void | go to ending week/day.
navigateToPage(pageNumber: Int) | void | go to specific week/day position.
gotoDate(date:LocalDate) | void | go to specific date in between the year range.
currentFirtDayOfWeek() | String | get current first day of visible week/day.
currentLastDayOfWeek() | String | get current last day of visible week/day.
getIsDateSticky() | boolean | get if selected date will remains sticky or not.
getTotalDays() | Int | get total number of days(start year ~ end year).
getTotalWeeks() | Int | get total number of weeks.
getCurrentPagePos() | Int | get current visible position of week/day.
getStartYear() | Int | get starting year.
getEndYear() | Int | get ending year.
getStartDate() | LocalDate | get first day from the year range.
getEndDate() | LocalDate | get last day from the year range.
today() | LocalDate | get today's date

#### Attributes
Attributes | Default | Description
--- | --- | ---
month_name_maxlength | two | set the month text length.
date_start_name | starting day of starting year | customize the starting day of starting year.
highlight_today_at_startup | false | highlights date of today at startup.
calendar_style | dark | available styles are dark and light.
show_month | false | hide/show text of months.
start_year | current year | should be smaller than end year.
end_year | current year | should be bigger than start year.
calendar_mode | week | can set to week or day mode.
sticky_date | false | only available for week view and it tracks of your previous selected date position if its true.
                                    


Project example is here for better understanding: 

[GO TO WeekView Example](https://github.com/rrsaikat/RCalendar/blob/master/app/src/main/java/com/rezwan/rcalendar/ui/fragments/WeekFragment.kt)

[GO TO DayView Example](https://github.com/rrsaikat/RCalendar/blob/master/app/src/main/java/com/rezwan/rcalendar/ui/fragments/DayFragment.kt)

Video Sample (Installaion or setup)
------------------
<a href="https://www.youtube.com/watch?v=AN_V5__3VNc" target="_blank"><img src="https://i9.ytimg.com/vi/AN_V5__3VNc/mqdefault.jpg?time=1591080997879&sqp=CMTv1_YF&rs=AOn4CLAI_KxwYDY2LhRfKLQWEn1SxhyQoA"
alt="" border="0" /></a>

[GO TO Tutorial](https://www.youtube.com/watch?v=AN_V5__3VNc)
        

## Author

👤 **RRSaikat**

- FaceBook: [@engr.rezwan](https://www.facebook.com/engr.rezwan)
- Youtube: [Rezwanrehman](http://www.youtube.com/c/Rezwanrehman)
- Blog: [blog.rrsaikat.com](https://blog.rrsaikat.com)


# Copyright
Copyright 2020 RRsaikat. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
