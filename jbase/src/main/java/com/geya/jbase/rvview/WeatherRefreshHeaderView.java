package com.geya.jbase.rvview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.SwipeRefreshHeaderLayout;
import com.geya.jbase.R;

public class WeatherRefreshHeaderView  extends SwipeRefreshHeaderLayout {

    private ImageView img;
    private TextView wd, address,weather,wd2;
    private Context mContext;

    public WeatherRefreshHeaderView(Context context) {
        super(context);
    }

    public WeatherRefreshHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WeatherRefreshHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    //初始化
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        img = findViewById(R.id.img);
        wd = findViewById(R.id.wd);
        address = findViewById(R.id.address);
        weather = findViewById(R.id.weather);
        wd2 = findViewById(R.id.wd2);
    }

    private int i=0;
    //开始
    @Override
    public void onPrepare() {
        super.onPrepare();
        System.out.println("------------ onPrepare()");
//        Glide.with(mContext)
//                .load(HTMLConfig.TQ_IMGURL)
//                .into(img);
        i++;
        wd.setText("xxx"+i);
        address.setText("xxxx");
        weather.setText("xxxx");
        wd2.setText("xxxx");

    }

    //结束
    @Override
    public void onReset() {
        super.onReset();


    }

}
