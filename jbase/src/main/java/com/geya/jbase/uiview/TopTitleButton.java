package com.geya.jbase.uiview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.geya.jbase.R;
import com.geya.jbase.constant.RequestType;

public class TopTitleButton extends RelativeLayout {


    private TextView mTitle;
    private TextView mRButton;
    private ImageView rImg;
    private ImageView imgReturn;
    private ConstraintLayout mRelativeLayout;

    public TextView getTitles() {
        return mTitle;
    }

    public TextView getRButton() {
        return mRButton;
    }

    public ImageView getrImg() {
        return rImg;
    }

    public ConstraintLayout getRelativeLayout() {
        return mRelativeLayout;
    }

    public TopTitleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_titles, this);
        mTitle = findViewById(R.id.tv_title);
        mRButton = findViewById(R.id.tv_title2);
        rImg = findViewById(R.id.img_btn);
        imgReturn = findViewById(R.id.img_return);
        mRelativeLayout = findViewById(R.id.ll);

        mTitle.setTextColor(RequestType.TITLE_COLOR);
        mRButton.setTextColor(RequestType.SUBHEADING_COLOR);
        rImg.setImageResource(RequestType.IMG_BACK);
        mRelativeLayout.setBackgroundColor(RequestType.TOP_BAR_COLOR);
    }


    public void setTitles(String title){
        mTitle.setText(title);
    }

    public void setTitles(String title,int color){

        mTitle.setText(title);
        mTitle.setTextColor(color);

    }


    public void setrImgSrc(int back){
        rImg.setImageResource(back);
    }

    public void setImgReturn(int back){
        imgReturn.setImageResource(back);
    }

    public void setImgReturn(int back,OnClickListener onClickListener){
        imgReturn.setImageResource(back);
        imgReturn.setOnClickListener(onClickListener);
    }
    public void setImgReturnVisibility(int visibility){
        imgReturn.setVisibility(visibility);
    }





    public void setMainColor(int color){
        mRelativeLayout.setBackgroundColor(color);
    }

    public void setBackClickListener(OnClickListener onClickListener){
        rImg.setOnClickListener(onClickListener);
    }

    public void setRButtonText(String text){
        mRButton.setText(text);
    }

    public void setRButtonText(String text,int color){
        mRButton.setText(text);
        mRButton.setTextColor(color);
    }

    public void setRButtonImg(int icon){
        Drawable drawable= getResources().getDrawable(icon);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        mRButton.setCompoundDrawables(null,null,drawable,null);
    }

    public void setTitleImg(int icon){
        Drawable drawable= getResources().getDrawable(icon);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        mTitle.setCompoundDrawables(null,null,drawable,null);
    }


    public void setRButtonClickListener(OnClickListener onClickListener){
        mRButton.setOnClickListener(onClickListener);

    }

}
