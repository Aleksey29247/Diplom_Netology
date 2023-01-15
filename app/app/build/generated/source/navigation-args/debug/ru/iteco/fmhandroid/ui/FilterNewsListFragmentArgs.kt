package ru.iteco.fmhandroid.ui

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic
import ru.iteco.fmhandroid.`enum`.FragmentsTags

public data class FilterNewsListFragmentArgs(
  public val fragmentName: FragmentsTags
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(FragmentsTags::class.java)) {
      result.putParcelable("fragmentName", this.fragmentName as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(FragmentsTags::class.java)) {
      result.putSerializable("fragmentName", this.fragmentName as Serializable)
    } else {
      throw UnsupportedOperationException(FragmentsTags::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(FragmentsTags::class.java)) {
      result.set("fragmentName", this.fragmentName as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(FragmentsTags::class.java)) {
      result.set("fragmentName", this.fragmentName as Serializable)
    } else {
      throw UnsupportedOperationException(FragmentsTags::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): FilterNewsListFragmentArgs {
      bundle.setClassLoader(FilterNewsListFragmentArgs::class.java.classLoader)
      val __fragmentName : FragmentsTags?
      if (bundle.containsKey("fragmentName")) {
        if (Parcelable::class.java.isAssignableFrom(FragmentsTags::class.java) ||
            Serializable::class.java.isAssignableFrom(FragmentsTags::class.java)) {
          __fragmentName = bundle.get("fragmentName") as FragmentsTags?
        } else {
          throw UnsupportedOperationException(FragmentsTags::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__fragmentName == null) {
          throw IllegalArgumentException("Argument \"fragmentName\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"fragmentName\" is missing and does not have an android:defaultValue")
      }
      return FilterNewsListFragmentArgs(__fragmentName)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        FilterNewsListFragmentArgs {
      val __fragmentName : FragmentsTags?
      if (savedStateHandle.contains("fragmentName")) {
        if (Parcelable::class.java.isAssignableFrom(FragmentsTags::class.java) ||
            Serializable::class.java.isAssignableFrom(FragmentsTags::class.java)) {
          __fragmentName = savedStateHandle.get<FragmentsTags?>("fragmentName")
        } else {
          throw UnsupportedOperationException(FragmentsTags::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__fragmentName == null) {
          throw IllegalArgumentException("Argument \"fragmentName\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"fragmentName\" is missing and does not have an android:defaultValue")
      }
      return FilterNewsListFragmentArgs(__fragmentName)
    }
  }
}
