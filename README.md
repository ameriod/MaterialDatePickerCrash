MaterialDatePicker Crash
===

Steps to reproduce:

1. Go to the max on the calendar, Oct 2020
2. Then click the year selection and select 2019
3. The App crashes with:

```
java.lang.IllegalArgumentException: Invalid target position
        at androidx.recyclerview.widget.RecyclerView$SmoothScroller.start(RecyclerView.java:11807)
        at androidx.recyclerview.widget.RecyclerView$LayoutManager.startSmoothScroll(RecyclerView.java:8470)
        at com.google.android.material.datepicker.SmoothCalendarLayoutManager.smoothScrollToPosition(SmoothCalendarLayoutManager.java:49)
        at androidx.recyclerview.widget.RecyclerView.smoothScrollToPosition(RecyclerView.java:1790)
        at com.google.android.material.datepicker.MaterialCalendar$10.run(MaterialCalendar.java:453)
        at android.os.Handler.handleCallback(Handler.java:873)
        at android.os.Handler.dispatchMessage(Handler.java:99)
        at android.os.Looper.loop(Looper.java:193)
        at android.app.ActivityThread.main(ActivityThread.java:6669)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:493)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:858)
```