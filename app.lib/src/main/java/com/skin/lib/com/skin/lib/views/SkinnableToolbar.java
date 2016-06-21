package com.skin.lib.com.skin.lib.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;

import com.skin.lib.R;

/**
 * 自定义Toolbar
 */
public class SkinnableToolbar extends Toolbar implements Skinnable {
    private AttrsHelper mAttrsHelper;

    public SkinnableToolbar(Context context) {
        this(context, null);
    }

    public SkinnableToolbar(Context context, AttributeSet attrs) {
        this(context, attrs, android.support.v7.appcompat.R.attr.toolbarStyle);
    }

    public SkinnableToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        mAttrsHelper = new AttrsHelper();

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SkinnableView, defStyleAttr, 0);

        mAttrsHelper.storeAttributeResource(a, R.styleable.SkinnableView);

        a.recycle();

        a = context.obtainStyledAttributes(attrs, R.styleable.Toolbar, defStyleAttr, 0);
        mAttrsHelper.storeAttributeResource(a, R.styleable.Toolbar);
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
            setBackgroundDrawable(background);
        }

        key = R.styleable.Toolbar[R.styleable.Toolbar_titleTextAppearance];
        Integer titleTextApperance = mAttrsHelper.getAttributeResource(key);
        if (titleTextApperance != null) {
            setTitleTextAppearance(context, titleTextApperance);

        }

        key = R.styleable.Toolbar[R.styleable.Toolbar_subtitleTextAppearance];
        Integer subtitleTextAppearance = mAttrsHelper.getAttributeResource(key);
        if (subtitleTextAppearance != null) {
            setSubtitleTextAppearance(context, subtitleTextAppearance);
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
