package com.example.practical_4_19012021095

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.ContactsContract
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText=findViewById<TextInputEditText>(R.id.edit_text)

        val button_call=findViewById<Button>(R.id.button_call)
        button_call.setOnClickListener(View.OnClickListener {
            Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel: "+editText.text)).apply {
                startActivity(this)
            }
        })

        val button_url=findViewById<Button>(R.id.button_url)
        button_url.setOnClickListener(View.OnClickListener {
            Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://"+editText.text)).apply{
                startActivity(this)
            }
        })

        val button_contact=findViewById<Button>(R.id.button_contact)
        button_contact.setOnClickListener(View.OnClickListener {
           intent=Intent(Intent.ACTION_DEFAULT,ContactsContract.Contacts.CONTENT_URI)
            startActivity(intent)
        })

        val button_calllog=findViewById<Button>(R.id.button_calllog)
        button_calllog.setOnClickListener(View.OnClickListener {
            intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("content://call_log/calls")
            startActivity(intent)
        })

        val button_gallery=findViewById<Button>(R.id.button_gallery)
        button_gallery.setOnClickListener(View.OnClickListener {
            intent= Intent()
            intent.setAction(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivity(intent)
        })

        val button_alarm = findViewById<Button>(R.id.button_alarm)
        button_alarm.setOnClickListener(View.OnClickListener {
//            Intent(AlarmClock.ACTION_SET_ALARM).apply {
//                putExtra(AlarmClock.EXTRA_MESSAGE,"New Alarm")
//                putExtra(AlarmClock.EXTRA_HOUR,12)
//                putExtra(AlarmClock.EXTRA_MINUTES,0)
//                startActivity(this)
//            }
            intent= Intent(AlarmClock.ACTION_SET_ALARM).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, "New Alarm")
                putExtra(AlarmClock.EXTRA_HOUR, 12)
                putExtra(AlarmClock.EXTRA_MINUTES, 0)
                startActivity(intent)
            }
//            intent = Intent(AlarmClock.ACTION_SET_ALARM)
//            intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK
//            startActivity(intent)
        })

        val button_camera = findViewById<Button>(R.id.button_camera)
        button_camera.setOnClickListener(View.OnClickListener {
            intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        })
    }
}