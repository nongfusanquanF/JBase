package com.geya.jbase.uiview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by jiang on 2017/7/8.
 *     配合头部上滑动隐藏使用
 */

public class MyRecyclerView extends RecyclerView {
    private float startY = 0;//按下时y值
    private int mTouchSlop;//系统值
    private boolean isSlide; //是否可以下拉刷新

    public void setSlide(boolean slide) {
        isSlide = slide;
    }

    public MyRecyclerView(Context context) {
        super(context);
        isSlide=true;
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        isSlide=true;
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        isSlide=true;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                startY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                if (Math.abs(ev.getY() - startY) > mTouchSlop) {
                    if (ev.getY() - startY >= 0) {
//                        System.out.println("!!!!!!!!!!!!!!!!!!!!! 向下滑动");
                        View firstChild = this.getChildAt(0);

                        if ( getChildCount()!=0) {
                            if ( getChildCount()==0){
//                                System.out.println("已经到达顶部了1");
                                getParent().requestDisallowInterceptTouchEvent(false);
                            }

                            if (firstChild.getTop() == 0) {
//                                System.out.println("已经到达顶部了2"+isSlide);
                                if (isSlide) {
                                    getParent().requestDisallowInterceptTouchEvent(false);
                                }else {
                                    getParent().requestDisallowInterceptTouchEvent(true);
                                }


                            }
                        }
                    } else {
                        getParent().requestDisallowInterceptTouchEvent(false);
//                        System.out.println("!!!!!!!!!!!!!!!!!!!!! 向上滑动");
                    }
                }
                startY = ev.getY();
                break;
        }


        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {



        return super.onInterceptTouchEvent(ev);
    }

}
