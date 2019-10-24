package com.appbyme.jbase.adapter;

import android.app.Activity;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.appbyme.jbase.R;
import com.shizhefei.view.indicator.IndicatorViewPager;

import java.util.List;

public class ViewPageAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {

    private List<String> names;
    private List<Fragment> mList;
    private Activity mContext;
    public ViewPageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }
    public ViewPageAdapter(FragmentManager fragmentManager, Activity context, List<String> names, List<Fragment> list) {
        super(fragmentManager);
        mContext = context;
        this.names = names;
        mList = list;
    }

    @Override
    public int getCount() {
        return names.size();
    }


    @Override
    public View getViewForTab(int position, View convertView, ViewGroup container) {
        if (convertView == null) {
            convertView = mContext.getLayoutInflater().inflate(R.layout.tab_top, container, false);
        }
        TextView textView = (TextView) convertView;
        textView.setText(names.get(position));

        int witdh = getTextWidth(textView);
        int padding = DisplayUtil.px2sp(mContext, 8);
//            因为wrap的布局 字体大小变化会导致textView大小变化产生抖动，这里通过设置textView宽度就避免抖动现象
//            1.3f是根据上面字体大小变化的倍数1.3f设置
        textView.setWidth((int) (witdh * 1.3f) + padding);
//
//        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);
//        System.out.println("--------------  " + names.get(position));
        return textView;
    }

    @Override
    public Fragment getFragmentForPage(int position) {

        return mList.get(position);
    }

    @Override
    public int getItemPosition(Object object) {

        return PagerAdapter.POSITION_NONE;
    }

    private int getTextWidth(TextView textView) {
        if (textView == null) {
            return 0;
        }
        Rect bounds = new Rect();
        String text = textView.getText().toString();
        Paint paint = textView.getPaint();
        paint.getTextBounds(text, 0, text.length(), bounds);
        int width = bounds.left + bounds.width();
        return width;
    }

}
