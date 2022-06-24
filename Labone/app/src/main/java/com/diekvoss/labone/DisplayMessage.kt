package com.diekvoss.labone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayMessage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)
    }

    val message = intent.getStringExtra(EXTRA_MESSAGE)

    val textView = findViewById<TextView>(R.id.textView).apply {
        text = message
    }
}
