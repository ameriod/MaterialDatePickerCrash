package com.material.datepicker.crash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.activity_main.*
import org.threeten.bp.LocalDate
import org.threeten.bp.Month
import org.threeten.bp.ZoneOffset

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPicker.setOnClickListener {
            // Jan 14 2020
            val openAtTime: Long = LocalDate.of(2020, Month.JANUARY, 14)
                .atStartOfDay()
                .toEpochSecond(ZoneOffset.UTC) * 1000
            // Nov 26 2019
            val startTime: Long =
                LocalDate.of(2019, Month.NOVEMBER, 26)
                    .atStartOfDay()
                    .toEpochSecond(ZoneOffset.UTC) * 1000
            // Oct 16 2020
            val endTime: Long = LocalDate.of(2020, Month.OCTOBER, 16)
                .atStartOfDay()
                .toEpochSecond(ZoneOffset.UTC) * 1000

            MaterialDatePicker.Builder.datePicker()
                .setCalendarConstraints(
                    CalendarConstraints.Builder()
                        .setOpenAt(openAtTime)
                        .setStart(startTime)
                        .setEnd(endTime)
                        .setValidator(
                            DayRangeValidator(
                                startTimeMilliseconds = startTime,
                                endTimeMilliseconds = endTime
                            )
                        )
                        .build()
                )
                .build()
                .show(supportFragmentManager, "DatePicker")

        }

    }
}

@Parcelize
data class DayRangeValidator(
    private val startTimeMilliseconds: Long,
    private val endTimeMilliseconds: Long
) : CalendarConstraints.DateValidator {

    override fun isValid(date: Long): Boolean =
        (startTimeMilliseconds..endTimeMilliseconds).contains(date) || startTimeMilliseconds == date || endTimeMilliseconds == date

}

