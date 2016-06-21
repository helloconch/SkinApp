package com.skin.lib.com.skin.lib.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.skin.lib.R;

/**
 * 自定义FrameLayout
 */
public class SkinnableFrameLayout extends FrameLayout implements Skinnable {
    private AttrsHelper mAttrsHelper;

    public SkinnableFrameLayout(Context context) {
        this(context, null);
    }

    public SkinnableFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkinnableFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        mAttrsHelper = new AttrsHelper();

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SkinnableView, defStyleAttr, 0);

        mAttrsHelper.storeAttributeResource(a, R.styleable.SkinnableView);

        a.recycle();


    }

    @Override
    public void applyDayNight() {

        Context context = getContext();
        int key;

        key = R.styleable.SkinnableView[R.styleable.SkinnableView_android_background];

        Integer backgroundResource = mAttrsHelper.getAttributeResource(key);
        if (backgroundResource != null) {
            Drawable background = ContextCompat.getDrawable(context, backgroundResource);
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                setBackgroundDrawable(background);
            } else {
                setBackground(background);
            }
        }

    }

    @Override
    public boolean isSkinnable() {
        return true;
    }

    @Override
    public void setSkinnable(boolean skinnable) {

    }
}
