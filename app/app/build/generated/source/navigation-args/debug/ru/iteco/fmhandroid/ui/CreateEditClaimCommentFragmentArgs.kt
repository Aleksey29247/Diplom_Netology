package ru.iteco.fmhandroid.ui

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress
import kotlin.jvm.JvmStatic
import ru.iteco.fmhandroid.dto.ClaimComment

public data class CreateEditClaimCommentFragmentArgs(
  public val argClaimId: Int,
  public val argComment: ClaimComment? = null
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(ClaimComment::class.java)) {
      result.putParcelable("argComment", this.argComment as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(ClaimComment::class.java)) {
      result.putSerializable("argComment", this.argComment as Serializable?)
    }
    result.putInt("argClaimId", this.argClaimId)
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(ClaimComment::class.java)) {
      result.set("argComment", this.argComment as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(ClaimComment::class.java)) {
      result.set("argComment", this.argComment as Serializable?)
    }
    result.set("argClaimId", this.argClaimId)
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): CreateEditClaimCommentFragmentArgs {
      bundle.setClassLoader(CreateEditClaimCommentFragmentArgs::class.java.classLoader)
      val __argComment : ClaimComment?
      if (bundle.containsKey("argComment")) {
        if (Parcelable::class.java.isAssignableFrom(ClaimComment::class.java) ||
            Serializable::class.java.isAssignableFrom(ClaimComment::class.java)) {
          __argComment = bundle.get("argComment") as ClaimComment?
        } else {
          throw UnsupportedOperationException(ClaimComment::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        __argComment = null
      }
      val __argClaimId : Int
      if (bundle.containsKey("argClaimId")) {
        __argClaimId = bundle.getInt("argClaimId")
      } else {
        throw IllegalArgumentException("Required argument \"argClaimId\" is missing and does not have an android:defaultValue")
      }
      return CreateEditClaimCommentFragmentArgs(__argClaimId, __argComment)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        CreateEditClaimCommentFragmentArgs {
      val __argComment : ClaimComment?
      if (savedStateHandle.contains("argComment")) {
        if (Parcelable::class.java.isAssignableFrom(ClaimComment::class.java) ||
            Serializable::class.java.isAssignableFrom(ClaimComment::class.java)) {
          __argComment = savedStateHandle.get<ClaimComment?>("argComment")
        } else {
          throw UnsupportedOperationException(ClaimComment::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        __argComment = null
      }
      val __argClaimId : Int?
      if (savedStateHandle.contains("argClaimId")) {
        __argClaimId = savedStateHandle["argClaimId"]
        if (__argClaimId == null) {
          throw IllegalArgumentException("Argument \"argClaimId\" of type integer does not support null values")
        }
      } else {
        throw IllegalArgumentException("Required argument \"argClaimId\" is missing and does not have an android:defaultValue")
      }
      return CreateEditClaimCommentFragmentArgs(__argClaimId, __argComment)
    }
  }
}
