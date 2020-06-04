package com.appbyme.jbase;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import com.appbyme.jbase.Event.EventMsg;
import com.appbyme.jbase.data.BaseClick;
import com.appbyme.jbase.databinding.ActivityMainBinding;
import com.appbyme.jbase.ui.CoordinatorLayoutActivity2;
import com.appbyme.jbase.ui.DetailsActivity;
import com.appbyme.jbase.ui.FragmentListActivity;
import com.appbyme.jbase.ui.FragmentObjActivity;
import com.appbyme.jbase.ui.ListActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setOnclick(new UiClick());
//        mBinding.btLike.init(this);
//        mBinding.btLike.setEnabled(false);
//        mBinding.btLike.setOnClickListener();
        SpannableStringBuilder spannableString = new SpannableStringBuilder();
        spannableString.append("#AAA");
        spannableString.append("#BBB");
        spannableString.append("#CCC");

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                System.out.println("------------------- 1");
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
//                ds.setColor(Color.RED);//文本颜色
                ds.setUnderlineText(false);//是否有下划线
                ds.bgColor = Color.WHITE;//背景颜色
            }
        };

        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                System.out.println("------------------- 2");
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
//                ds.setColor(Color.RED);//文本颜色
                ds.setUnderlineText(false);//是否有下划线
                ds.bgColor = Color.WHITE;//背景颜色
            }
        };
        ClickableSpan clickableSpan3 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                System.out.println("------------------- 3");
            }

        };

        spannableString.setSpan(clickableSpan1, 0, 4, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        spannableString.setSpan(clickableSpan2, 4, 7, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        spannableString.setSpan(clickableSpan3, 8, 11, Spannable.SPAN_INTERMEDIATE);

//        mBinding.title.setText(spannableString);
////        mBinding.title.setTextColor(0xff000000);
//        mBinding.title.setMovementMethod(LinkMovementMethod.getInstance());
        String[] arr = {"key1", "key2", "key3"};
        initKeys(arr, mBinding.title);
        //注册事件
        EventBus.getDefault().register(this);
    }

    List<BaseClick> mSpanList = new ArrayList<>();

    private void initKeys(String[] arr, TextView title) {

        int start = 0;
        SpannableStringBuilder spannableString = new SpannableStringBuilder();

        for (int i = 0; i < arr.length; i++) {
            spannableString.append("#" + arr[i]);
            final String str = arr[i];
            ClickableSpan clickableSpan = new ClickableSpan() {
                @Override
                public void onClick(View view) {
                    System.out.println("------------------- 1 " + str);
                }

                @Override
                public void updateDrawState(@NonNull TextPaint ds) {
//                ds.setColor(Color.RED);//文本颜色
                    ds.setUnderlineText(false);//是否有下划线
                    ds.bgColor = Color.WHITE;//背景颜色
                }
            };
            mSpanList.add(new BaseClick(start, spannableString.length(), clickableSpan));
            start = spannableString.length();
        }
        for (BaseClick click : mSpanList) {
            spannableString.setSpan(click.getClickableSpan(), click.getStart(), click.getEnt(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        }

        title.setText(spannableString);
        title.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private int zan = 0;
    public class UiClick {

        public void uiClick(View v) {

            switch (v.getId()) {
                case R.id.list_activity:
                    startActivity(new Intent(MainActivity.this, ListActivity.class));
                    break;

                case R.id.list_fragment:
                    startActivity(new Intent(MainActivity.this, FragmentListActivity.class));
                    break;

                case R.id.details_activity:
                    startActivity(new Intent(MainActivity.this, DetailsActivity.class));
                    break;

                case R.id.details_fragment:
                    startActivity(new Intent(MainActivity.this, FragmentObjActivity.class));
//                    mBinding.btLike.setCancel();
//                    mBinding.btLike.setChecked(false);
                    break;
                case R.id.details_c:
//                    String str3 = new ExeCommand().run("file:///android_asset/deamon_log.sh", 10000).getResult();
                    startActivity(new Intent(MainActivity.this, CoordinatorLayoutActivity2.class));
//                    mBinding.btLike.showAnim();
//                    mBinding.btLike.setChecked(true);
                    break;



            }
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void eventMsg(EventMsg msg) {
        mBinding.title.setText(msg.getMsg());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除注册
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }

    }
}
