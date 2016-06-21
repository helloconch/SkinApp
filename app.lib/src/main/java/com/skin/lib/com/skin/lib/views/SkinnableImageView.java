package com.skin.lib.com.skin.lib.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.skin.lib.R;

/**
 * 自定义ImageView
 */
public class SkinnableImageView extends AppCompatImageView implements Skinnable {
    private AttrsHelper mAttrsHelper;

    public SkinnableImageView(Context context) {
        this(context, null);
    }

    public SkinnableImageView(Context context, AttributeSet attrs) {
        this(context, attrs, android.support.v7.appcompat.R.attr.imageButtonStyle);
    }

    public SkinnableImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        mAttrsHelper = new AttrsHelper();

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SkinnableImageView, defStyleAttr, 0);

        mAttrsHelper.storeAttributeResource(a, R.styleable.SkinnableImageView);

        a.recycle();


    }

    @Override
    public void applyDayNight() {
        Context context = getContext();
        int key;

        key = R.styleable.SkinnableImageView[R.styleable.SkinnableImageView_android_background];

        Integer backgroundResource = mAttrsHelper.getAttributeResource(key);
        if (backgroundResource != null) {
            Drawable background = ContextCompat.getDrawable(context, backgroundResource);
            setBackgroundDrawable(background);
        }

        key = R.styleable.SkinnableImageView[R.styleable.SkinnableImageView_android_src];
        Integer srcResource = mAttrsHelper.getAttributeResource(key);
        if (srcResource != null) {
            setImageResource(srcResource);
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
