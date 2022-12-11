package com.example.r8_issue_agp_7_3.test

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class TestIssue {
  private val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())

  fun launch(lambda: suspend () -> Unit) {
    scope.launch {
      lambda()
    }
  }
}