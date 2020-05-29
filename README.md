# RCalendar
![Feature Image](https://github.com/rrsaikat/RCalendar/blob/master/app/banner.png)

An android package that provides horizontal date picker as week and day mode within a given range of year.
<p align="start">
  <img src="https://github.com/rrsaikat/RCalendar/blob/master/app/GIF-200526_172126.gif" height="450" width="220"/>
  <img src="https://github.com/rrsaikat/RCalendar/blob/master/app/GIF-200526_171721.gif" height="450" width="220"/>
</p>


Usage Guide
-----------------

STEP 1:  Download rcalenderlib_vX.X.X.aar from here:    

      
        
STEP 2: Reference the library itself in your module-level build.gradle:      

        api(name: 'rcalenderlib_v2.5.0', ext: 'aar')

STEP 3: Add more required libraries into your module-level build.gradle:

        implementation 'com.google.android.material:material:1.1.0'
        implementation 'joda-time:joda-time:2.10.1'
        
STEP 4:
        
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

                       
                    
## NOTE:
1. Enable Kotlin and AndroidX

STEP 5: Finally sync and build.



Available additinal methods:
-----------------

    *  showKNDialog() - set true for show dialog when net connection goes off.
    *  setConnectivityListener() - connected, disconnected callback into activity
    *  setInAnimation() - custom animation setup
    *  setOutAnimation() - custom animation setup
    *  setViewGroupResId() - targeted viewgroup to show network status views.

Example project is here for better understanding: 

[GO TO WeekView Example](https://github.com/rrsaikat/RCalendar/blob/master/app/src/main/java/com/rezwan/rcalendar/ui/fragments/WeekFragment.kt)

[GO TO DayView Example](https://github.com/rrsaikat/RCalendar/blob/master/app/src/main/java/com/rezwan/rcalendar/ui/fragments/DayFragment.kt)

Video Sample (Installaion or setup)
------------------
<a href="http://www.youtube.com/watch?feature=player_embedded&v=v55QLdqhwKQ
" target="_blank"><img src="http://img.youtube.com/vi/v55QLdqhwKQ/0.jpg" 
alt="IMAGE ALT TEXT HERE" width="240" height="180" border="10" /></a>

[GO TO Tutorial](https://www.youtube.com/watch?v=v55QLdqhwKQ)
        
Demo App:

[![Get it on Google Play](https://play.google.com/intl/en_us/badges/images/badge_new.png)](https://play.google.com/store/apps/details?id=com.rezwan.rcalendar)

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
