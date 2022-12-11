package com.example.r8_issue_agp_7_3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.r8_issue_agp_7_3.test.TestIssue
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {
  lateinit var test: TestIssue

  @SuppressLint("SetTextI18n")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    test = TestIssue()
    test.launch {
      delay(200L)
      findViewById<TextView>(R.id.tv).text = "update"
    }
  }
}