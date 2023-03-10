// Generated by view binder compiler. Do not edit!
package ru.iteco.fmhandroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ru.iteco.fmhandroid.R;

public final class ClaimFilteringDialogBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final MaterialButton claimFilterCancelMaterialButton;

  @NonNull
  public final MaterialTextView claimFilterDialogTitle;

  @NonNull
  public final MaterialButton claimListFilterOkMaterialButton;

  @NonNull
  public final MaterialCheckBox itemFilterCancelled;

  @NonNull
  public final MaterialCheckBox itemFilterExecuted;

  @NonNull
  public final MaterialCheckBox itemFilterInProgress;

  @NonNull
  public final MaterialCheckBox itemFilterOpen;

  private ClaimFilteringDialogBinding(@NonNull ScrollView rootView,
      @NonNull MaterialButton claimFilterCancelMaterialButton,
      @NonNull MaterialTextView claimFilterDialogTitle,
      @NonNull MaterialButton claimListFilterOkMaterialButton,
      @NonNull MaterialCheckBox itemFilterCancelled, @NonNull MaterialCheckBox itemFilterExecuted,
      @NonNull MaterialCheckBox itemFilterInProgress, @NonNull MaterialCheckBox itemFilterOpen) {
    this.rootView = rootView;
    this.claimFilterCancelMaterialButton = claimFilterCancelMaterialButton;
    this.claimFilterDialogTitle = claimFilterDialogTitle;
    this.claimListFilterOkMaterialButton = claimListFilterOkMaterialButton;
    this.itemFilterCancelled = itemFilterCancelled;
    this.itemFilterExecuted = itemFilterExecuted;
    this.itemFilterInProgress = itemFilterInProgress;
    this.itemFilterOpen = itemFilterOpen;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ClaimFilteringDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ClaimFilteringDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.claim_filtering_dialog, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ClaimFilteringDialogBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.claim_filter_cancel_material_button;
      MaterialButton claimFilterCancelMaterialButton = ViewBindings.findChildViewById(rootView, id);
      if (claimFilterCancelMaterialButton == null) {
        break missingId;
      }

      id = R.id.claim_filter_dialog_title;
      MaterialTextView claimFilterDialogTitle = ViewBindings.findChildViewById(rootView, id);
      if (claimFilterDialogTitle == null) {
        break missingId;
      }

      id = R.id.claim_list_filter_ok_material_button;
      MaterialButton claimListFilterOkMaterialButton = ViewBindings.findChildViewById(rootView, id);
      if (claimListFilterOkMaterialButton == null) {
        break missingId;
      }

      id = R.id.item_filter_cancelled;
      MaterialCheckBox itemFilterCancelled = ViewBindings.findChildViewById(rootView, id);
      if (itemFilterCancelled == null) {
        break missingId;
      }

      id = R.id.item_filter_executed;
      MaterialCheckBox itemFilterExecuted = ViewBindings.findChildViewById(rootView, id);
      if (itemFilterExecuted == null) {
        break missingId;
      }

      id = R.id.item_filter_in_progress;
      MaterialCheckBox itemFilterInProgress = ViewBindings.findChildViewById(rootView, id);
      if (itemFilterInProgress == null) {
        break missingId;
      }

      id = R.id.item_filter_open;
      MaterialCheckBox itemFilterOpen = ViewBindings.findChildViewById(rootView, id);
      if (itemFilterOpen == null) {
        break missingId;
      }

      return new ClaimFilteringDialogBinding((ScrollView) rootView, claimFilterCancelMaterialButton,
          claimFilterDialogTitle, claimListFilterOkMaterialButton, itemFilterCancelled,
          itemFilterExecuted, itemFilterInProgress, itemFilterOpen);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
