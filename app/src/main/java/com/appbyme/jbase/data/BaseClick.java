package com.appbyme.jbase.data;

import android.text.style.ClickableSpan;

public class BaseClick {
    private int start;
    private int ent;
    private ClickableSpan mClickableSpan;

    public BaseClick(int start,int ent ,ClickableSpan mClickableSpan){
        this.start = start;
        this.ent = ent;
        this.mClickableSpan = mClickableSpan;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnt() {
        return ent;
    }

    public void setEnt(int ent) {
        this.ent = ent;
    }

    public ClickableSpan getClickableSpan() {
        return mClickableSpan;
    }

    public void setClickableSpan(ClickableSpan clickableSpan) {
        mClickableSpan = clickableSpan;
    }
}
