package cn.wdsoft.flyapp.internal.model;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.View;
import java.util.ArrayList;

import cn.wdsoft.flyapp.internal.view.PresentableView;

/**
 * List item that has no children.
 * This item is directly linked to a PresentableView.
 * This should be used to present a first level item in a ListView that does not belong to a Group
 */

public class SingleItem extends GroupHeader {

    private final @NonNull Class<? extends PresentableView> linkedViewClass;

    public SingleItem(@StringRes int titleStringId, @NonNull Class<? extends PresentableView> linkedViewClass) {
        super(titleStringId, new GroupItem[1]);
        if (View.class.isAssignableFrom(linkedViewClass)) {
            this.linkedViewClass = linkedViewClass;
        } else {
            throw new RuntimeException("Class "
                                           + linkedViewClass.getClass().getSimpleName()
                                           + " needs to extend from a View!");
        }
    }

    @NonNull
    public Class<? extends PresentableView> getLinkedViewClass() {
        return linkedViewClass;
    }
}