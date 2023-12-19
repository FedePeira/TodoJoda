package com.example.myapplication.loginFragments

import android.os.Bundle
import androidx.navigation.NavDirections
import com.example.myapplication.R
import kotlin.Int
import kotlin.String

public class MainPageFragmentDirections private constructor() {
  private data class ActionMainPageFragmentToRegisterFragment(
    public val name: String
  ) : NavDirections {
    public override val actionId: Int = R.id.action_mainPageFragment_to_registerFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("name", this.name)
        return result
      }
  }

  public companion object {
    public fun actionMainPageFragmentToRegisterFragment(name: String): NavDirections =
        ActionMainPageFragmentToRegisterFragment(name)
  }
}
