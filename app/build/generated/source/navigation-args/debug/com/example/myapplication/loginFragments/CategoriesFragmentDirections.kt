package com.example.myapplication.loginFragments

import android.os.Bundle
import androidx.navigation.NavDirections
import com.example.myapplication.R
import kotlin.Int
import kotlin.String

public class CategoriesFragmentDirections private constructor() {
  private data class ActionCategoriesFragmentToBolicheFragment(
    public val name: String
  ) : NavDirections {
    public override val actionId: Int = R.id.action_categoriesFragment_to_bolicheFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("name", this.name)
        return result
      }
  }

  public companion object {
    public fun actionCategoriesFragmentToBolicheFragment(name: String): NavDirections =
        ActionCategoriesFragmentToBolicheFragment(name)
  }
}
