package com.example.datepickertimepicker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.time.Month
import java.time.Year
import java.util.*

class MainActivity : AppCompatActivity() {

    var format = SimpleDateFormat("dd MMMM YYYY", Locale.US)
    var timeFormat = SimpleDateFormat("hh:mm a", Locale.US)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_show_dialog.onClick {

            val now = Calendar.getInstance()
            val datePicker = DatePickerDialog(this@MainActivity, DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                Toast.makeText(this@MainActivity, "Years : " + i + "\n Month : " + i2 + "\n Day : " + i3, Toast.LENGTH_SHORT).show()
            },
                    now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH))
            datePicker.show()
        }

        btn_calender_ver2.onClick {
            val now = Calendar.getInstance()
            val datePicker = DatePickerDialog(this@MainActivity, DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(Calendar.YEAR, i)
                selectedDate.set(Calendar.MONTH, i2)
                selectedDate.set(Calendar.DAY_OF_MONTH, i3)
                val date = format.format(selectedDate.time)
                Toast.makeText(this@MainActivity, "date : " + date, Toast.LENGTH_SHORT).show()
            },
                    now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH))
            datePicker.show()
        }

        btn_calender_ver3.onClick {
            val cal = Calendar.getInstance()
            val datePickerVer = DatePickerDialog(this@MainActivity, android.R.style.Theme_Holo_Light_Dialog_MinWidth, DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(Calendar.YEAR, i)
                selectedDate.set(Calendar.MONTH, i2)
                selectedDate.set(Calendar.DAY_OF_MONTH, i3)
                val date = format.format(selectedDate.time)
                Toast.makeText(this@MainActivity, "date : " + date, Toast.LENGTH_SHORT).show()
            },
                    cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))
            datePickerVer.show()
        }

        btn_time.onClick {
            val now = Calendar.getInstance()
            val timePicker = TimePickerDialog(this@MainActivity, TimePickerDialog.OnTimeSetListener { timePicker, i, i2 ->
                val selectedTime = Calendar.getInstance()
                selectedTime.set(Calendar.HOUR_OF_DAY, i)
                selectedTime.set(Calendar.MINUTE, i2)
                toast("Time : " + timeFormat.format(selectedTime.time))
            },
                    now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), false)
            timePicker.show()
        }
    }
}