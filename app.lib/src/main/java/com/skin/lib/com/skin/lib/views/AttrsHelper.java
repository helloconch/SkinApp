package com.skin.lib.com.skin.lib.views;

import android.content.res.TypedArray;
import android.util.SparseArray;

/**
 * Created by cheyanxu on 16/6/21.
 */
public class AttrsHelper {
    private SparseArray<Integer> mResourceMap;

    public AttrsHelper() {
        this.mResourceMap = new SparseArray<>();
    }

    /**
     * 对数据进行存储
     *
     * @param a
     * @param styleable
     */
    public void storeAttributeResource(TypedArray a, int[] styleable) {

        int size = a.getIndexCount();
        for (int i = 0; i < size; i++) {
            int resourceId = a.getResourceId(i, -1);
            int key = styleable[i];
            if (resourceId != -1) {
                mResourceMap.put(key, resourceId);
            }
        }

    }

    /**
     * 获取数据
     *
     * @param attr
     * @return
     */
    public Integer getAttributeResource(int attr) {
        return mResourceMap.get(attr);
    }
}
