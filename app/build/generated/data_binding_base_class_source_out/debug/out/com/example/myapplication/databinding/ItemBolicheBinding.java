// Generated by view binder compiler. Do not edit!
package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemBolicheBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout itemBoliche;

  @NonNull
  public final TextView itemDescription;

  @NonNull
  public final TextView itemTitle;

  @NonNull
  public final ImageView nextIcon;

  @NonNull
  public final RatingBar ratingBar;

  @NonNull
  public final TextView ratingCount;

  private ItemBolicheBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout itemBoliche, @NonNull TextView itemDescription,
      @NonNull TextView itemTitle, @NonNull ImageView nextIcon, @NonNull RatingBar ratingBar,
      @NonNull TextView ratingCount) {
    this.rootView = rootView;
    this.itemBoliche = itemBoliche;
    this.itemDescription = itemDescription;
    this.itemTitle = itemTitle;
    this.nextIcon = nextIcon;
    this.ratingBar = ratingBar;
    this.ratingCount = ratingCount;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemBolicheBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemBolicheBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_boliche, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemBolicheBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout itemBoliche = (ConstraintLayout) rootView;

      id = R.id.itemDescription;
      TextView itemDescription = ViewBindings.findChildViewById(rootView, id);
      if (itemDescription == null) {
        break missingId;
      }

      id = R.id.itemTitle;
      TextView itemTitle = ViewBindings.findChildViewById(rootView, id);
      if (itemTitle == null) {
        break missingId;
      }

      id = R.id.nextIcon;
      ImageView nextIcon = ViewBindings.findChildViewById(rootView, id);
      if (nextIcon == null) {
        break missingId;
      }

      id = R.id.ratingBar;
      RatingBar ratingBar = ViewBindings.findChildViewById(rootView, id);
      if (ratingBar == null) {
        break missingId;
      }

      id = R.id.ratingCount;
      TextView ratingCount = ViewBindings.findChildViewById(rootView, id);
      if (ratingCount == null) {
        break missingId;
      }

      return new ItemBolicheBinding((ConstraintLayout) rootView, itemBoliche, itemDescription,
          itemTitle, nextIcon, ratingBar, ratingCount);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
