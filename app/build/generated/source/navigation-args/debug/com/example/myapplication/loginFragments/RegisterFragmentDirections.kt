package com.example.myapplication.loginFragments

import android.os.Bundle
import androidx.navigation.NavDirections
import com.example.myapplication.R
import kotlin.Int
import kotlin.String

public class RegisterFragmentDirections private constructor() {
  private data class ActionRegisterFragmentToCategoriesFragment(
    public val name: String
  ) : NavDirections {
    public override val actionId: Int = R.id.action_registerFragment_to_categoriesFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("name", this.name)
        return result
      }
  }

  public companion object {
    public fun actionRegisterFragmentToCategoriesFragment(name: String): NavDirections =
        ActionRegisterFragmentToCategoriesFragment(name)
  }
}
