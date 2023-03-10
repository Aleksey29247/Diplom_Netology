// Generated by view binder compiler. Do not edit!
package ru.iteco.fmhandroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ru.iteco.fmhandroid.R;

public final class FragmentAuthBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TopCustomAppBarBinding containerCustomAppBarIncludeOnFragmentMain;

  @NonNull
  public final Button enterButton;

  @NonNull
  public final TextInputLayout loginTextInputLayout;

  @NonNull
  public final TextInputLayout passwordTextInputLayout;

  private FragmentAuthBinding(@NonNull LinearLayout rootView,
      @NonNull TopCustomAppBarBinding containerCustomAppBarIncludeOnFragmentMain,
      @NonNull Button enterButton, @NonNull TextInputLayout loginTextInputLayout,
      @NonNull TextInputLayout passwordTextInputLayout) {
    this.rootView = rootView;
    this.containerCustomAppBarIncludeOnFragmentMain = containerCustomAppBarIncludeOnFragmentMain;
    this.enterButton = enterButton;
    this.loginTextInputLayout = loginTextInputLayout;
    this.passwordTextInputLayout = passwordTextInputLayout;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAuthBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAuthBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_auth, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAuthBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.container_custom_app_bar_include_on_fragment_main;
      View containerCustomAppBarIncludeOnFragmentMain = ViewBindings.findChildViewById(rootView, id);
      if (containerCustomAppBarIncludeOnFragmentMain == null) {
        break missingId;
      }
      TopCustomAppBarBinding binding_containerCustomAppBarIncludeOnFragmentMain = TopCustomAppBarBinding.bind(containerCustomAppBarIncludeOnFragmentMain);

      id = R.id.enter_button;
      Button enterButton = ViewBindings.findChildViewById(rootView, id);
      if (enterButton == null) {
        break missingId;
      }

      id = R.id.login_text_input_layout;
      TextInputLayout loginTextInputLayout = ViewBindings.findChildViewById(rootView, id);
      if (loginTextInputLayout == null) {
        break missingId;
      }

      id = R.id.password_text_input_layout;
      TextInputLayout passwordTextInputLayout = ViewBindings.findChildViewById(rootView, id);
      if (passwordTextInputLayout == null) {
        break missingId;
      }

      return new FragmentAuthBinding((LinearLayout) rootView,
          binding_containerCustomAppBarIncludeOnFragmentMain, enterButton, loginTextInputLayout,
          passwordTextInputLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
