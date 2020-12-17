package com.geya.jbase.baseactivity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.geya.jbase.R;
import com.geya.jbase.constant.PageParams;
import com.geya.jbase.constant.RequestType;
import com.geya.jbase.mvp.presenter.BasePresenter;
import com.geya.jbase.mvp.view.IMvpView;

import com.geya.jbase.rvadapter.UniversalItemDecoration;
import com.geya.jbase.uiview.ProgressActivity;
import com.lzy.okgo.model.HttpHeaders;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Administrator on 2016/12/26.
 * BGARefreshLayout.BGARefreshLayoutDelegate
 * 列表型Activity
 */

public abstract class BaseRVActivity<T, P extends BasePresenter> extends BaseFragmentActivity implements IMvpView, OnRefreshListener, OnLoadMoreListener {


    public abstract P newP();

    public abstract Class setClass();


    public abstract BaseQuickAdapter initAdapter(List<T> list);

    /**
     * 友好状态提示
     */
    protected ProgressActivity mProgress;

    /**
     * 是否可以加载更多
     */
    private boolean isCanLoadMore = true;

    /**
     * 是否在下拉刷新
     */
    private boolean isRefresh = false;

    protected boolean newsSwitch = false;

    public void setNewsSwitch(boolean newsSwitch) {
        this.newsSwitch = newsSwitch;
    }

    public void setLoadMoreEnabled(boolean loadMoreEnabled) {
        mSwipeToLoadLayout.setLoadMoreEnabled(loadMoreEnabled);
        isLoadMoreEnabled = loadMoreEnabled;
    }

    /**
     * 是否开启加载更多功能
     */
    private boolean isLoadMoreEnabled = true;

    /**
     * 是否是在加载更多
     */
    protected boolean isLoadMore = false;
    /**
     * 刷新控件
     */
    protected SwipeToLoadLayout mSwipeToLoadLayout;

    protected RecyclerView mListView;
    /**
     * 数据源
     */
    protected List<T> mList;
    /**
     * 适配器
     */
    protected BaseQuickAdapter mQuickAdapter;


    /**
     * 分页数据
     */
    protected PageParams pageParams;

    /**
     * ListView点击事件 itme下标
     */
    private int mPosition = -1;

    /**
     * 数据类型
     */
    private Class mClass;

    /**
     * 列表类Presennter
     */
    public P mPresennter;


    private View view;

    private LinearLayout mLayout;

    //列表接口相关
    protected HashMap<String, Object> listMap = new HashMap<>();
    protected HttpHeaders headers;
    private String adderss;
    private String url;
    private String method;
    private Class classType;


    /**
     * 初始化数据
     */
    public void initBaseView() {
        initTitle();
        //友好界面
        if (findViewById(R.id.progress_activity) != null) {
            mProgress = findViewById(R.id.progress_activity);
        }
        //获取ListView对象
        mListView = findViewById(R.id.swipe_target);
        //ListView数据
        mList = new ArrayList<>();
        //列表类Presennter 对象
        mPresennter = newP();
        mClass = setClass();
        //这里设置默认的页容量
        pageParams = new PageParams(20);
//        mAdapter = initAdapter(mList);
        mQuickAdapter = initAdapter(mList);
        //设置加载动画
//        mQuickAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        //点击事件
        mQuickAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                onListItemClick(mList.get(position), position);
            }
        });
        //长安事件
        mQuickAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                onListItemLongClick(mList.get(position), position);
                return true;
            }
        });

        //子项点击事件
        mQuickAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                OnListChildClickListener(mList.get(position), adapter, view, position);
            }
        });


        if (findViewById(R.id.swipeToLoadLayout) != null) {
            mSwipeToLoadLayout = findViewById(R.id.swipeToLoadLayout);
            mSwipeToLoadLayout.setOnRefreshListener(this);
            mSwipeToLoadLayout.setOnLoadMoreListener(this);
        }
    }

    @Override
    public void onRefresh() {
        isRefresh = true;
        isLoadMore = false;
        isCanLoadMore = true;
        isLoadMoreEnabled(true);
        if (view != null) {
//                        mLayout.setVisibility(View.GONE);
            mQuickAdapter.removeFooterView(view);
        }

        //页码重置为1
        pageParams.reset();
//                    //重新传如页码
//                    mPresennter.setParams(RequestType.PAGE_INDEX, String.valueOf(pageParams.getPageNo()));
//                    //访问服务器
//                    mPresennter.accessServer();

        listMap.put(RequestType.PAGE_INDEX, String.valueOf(pageParams.getPageNo()));
//        listMap.put("timestamp", new Date().getTime()+"");
//                    mPresennter.accessServer(method, adderss, url,classType ,listMap);
//        if (headers != null) {
//            mPresennter.accessServers(method, adderss, url, classType, listMap, headers);
//        } else {
//            mPresennter.accessServers(method, adderss, url, classType, listMap);
//        }
        if (headers != null) {
            mPresennter.accessServers(method, adderss, url, classType, listMap, headers);
        } else {
            mPresennter.accessServers(method, adderss, url, classType, listMap);
        }


    }

    @Override
    public void onLoadMore() {
        isRefresh = false;
        isLoadMore = true;
        //页码增加
        pageParams.addPage();
        //传入新页码
//                    System.out.println("----------------------------------------------  页码 " + pageParams.getPageNo());
//                    mPresennter.setParams(RequestType.PAGE_INDEX, String.valueOf(pageParams.getPageNo()));
//                    //访问服务器
//                    mPresennter.accessServer();
        listMap.put(RequestType.PAGE_INDEX, String.valueOf(pageParams.getPageNo()));
//                    mPresennter.accessServer(method, adderss, url,classType ,listMap);
//        if (headers != null) {
//            mPresennter.accessServers(method, adderss, url, classType, listMap, headers);
//        } else {
//            mPresennter.accessServers(method, adderss, url, classType, listMap);
//        }
        if (headers != null) {
            mPresennter.accessServers(method, adderss, url, classType, listMap, headers);
        } else {
            mPresennter.accessServers(method, adderss, url, classType, listMap);
        }
    }

    /**
     * 初始化RecyclerView
     *
     * @param row   列数 大于1为gridview
     * @param color 颜色 16进制色值  0xfff6f6f6
     */
    protected void initRV(final int row, final int color) {
        final int sColor = color == 0 ? RequestType.DIVISION_COLOR : color;
        if (row < 1) {
            //设置RecyclerView的显示模式  当前List模式
            mListView.setLayoutManager(new LinearLayoutManager(this));
            //设置分割线
//            mListView.addItemDecoration(new RecycleViewDivider(
//                    this, LinearLayoutManager.VERTICAL, 2, Color.RED));
//            mListView.addItemDecoration(new UniversalItemDecoration() {
//                @Override
//                public Decoration getItemOffsets(int position) {
//
//                    ColorDecoration decoration = new ColorDecoration();
//                    decoration.bottom = 2;
//                    decoration.decorationColor = position == mList.size() ? 0x00ffffff : sColor;
//                    return decoration;
//                }
//            });

        } else {
            //多列形设置 GridLayoutManager
            GridLayoutManager manager = new GridLayoutManager(this, row);
            manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return position == mList.size() ? row : 1;
                }
            });
            mListView.setLayoutManager(manager);

//            mListView.addItemDecoration(new UniversalItemDecoration() {
//                @Override
//                public Decoration getItemOffsets(int position) {
//
//                    ColorDecoration decoration = new ColorDecoration();
//                    decoration.right = 2;
//                    decoration.left = 2;
//                    decoration.top = 2;
//                    decoration.bottom = 2;
//                    decoration.decorationColor = position == mList.size() ? 0x00ffffff : sColor;
//                    return decoration;
//                }
//            });

        }

        //如果Item高度固定  增加该属性能够提高效率
        mListView.setHasFixedSize(true);

    }


    /**
     * @param adderss   服务器地址
     * @param url       接口地址
     * @param method    接口类型
     * @param classType 实体类
     */
    protected void requestData(String adderss, String url, String method, Class classType) {

        if (mQuickAdapter != null && !isLoadMore) {
            mList.clear();
            mQuickAdapter.notifyDataSetChanged();
        }
        listMap.put(RequestType.PAGE_INDEX, String.valueOf(pageParams.getPageNo()));
        listMap.put(RequestType.PAGE_SIZE, String.valueOf(pageParams.getPageSize()));
        this.adderss = adderss;
        this.url = url;
        this.method = method;
        this.classType = classType;

//        mPresennter.accessServer(this.method, this.adderss, this.url,this.classType ,listMap);
    }

    /**
     * @param adderss   服务器地址
     * @param url       接口地址
     * @param method    接口类型
     * @param classType 实体类
     */
    protected void requestData(String method, String adderss, String url, Class classType, HashMap<String, Object> map) {

        if (mQuickAdapter != null && !isLoadMore) {
            mList.clear();
            mQuickAdapter.notifyDataSetChanged();
        }
        if (map != null) {
            listMap.putAll(map);
        }
        isRefresh = true;
        isLoadMore = false;
        isCanLoadMore = true;
        isLoadMoreEnabled(true);
        if (mLayout != null) {
//                        mLayout.setVisibility(View.GONE);
            mQuickAdapter.removeAllFooterView();
        }

        //页码重置为1
        pageParams.reset();
        listMap.put(RequestType.PAGE_INDEX, String.valueOf(pageParams.getPageNo()));
        listMap.put(RequestType.PAGE_SIZE, String.valueOf(pageParams.getPageSize()));
//        listMap.put("timestamp", new Date().getTime()+"");
        this.adderss = adderss;
        this.url = url;
        this.method = method;
        this.classType = classType;

            mProgress.showLoading(newsSwitch);

        mPresennter.accessServers(this.method, this.adderss, this.url, this.classType, listMap);
    }

    /**
     * @param adderss   服务器地址
     * @param url       接口地址
     * @param method    接口类型
     * @param classType 实体类
     */
    protected void requestData(String method, String adderss, String url, Class classType, HashMap<String, Object> map, HttpHeaders headers) {

        if (mQuickAdapter != null && !isLoadMore) {
            mList.clear();
            mQuickAdapter.notifyDataSetChanged();
        }
        if (map != null) {
            listMap.putAll(map);
        }
        isRefresh = true;
        isLoadMore = false;
        isCanLoadMore = true;
        isLoadMoreEnabled(true);
        if (mLayout != null) {
//                        mLayout.setVisibility(View.GONE);
            mQuickAdapter.removeAllFooterView();
        }

        //页码重置为1
        pageParams.reset();
        listMap.put(RequestType.PAGE_INDEX, String.valueOf(pageParams.getPageNo()));
        listMap.put(RequestType.PAGE_SIZE, String.valueOf(pageParams.getPageSize()));
        this.adderss = adderss;
        this.url = url;
        this.method = method;
        this.classType = classType;
        this.headers = headers;

            mProgress.showLoading(newsSwitch);

        mPresennter.accessServers(this.method, this.adderss, this.url, this.classType, listMap, this.headers);
    }


    // 重写 点击事件
    protected void onListItemClick(T object, int position) {
    }

    //子控件点击事件
    protected void OnListChildClickListener(T object, BaseQuickAdapter adapter, View view, int position) {
    }


    //长按事件
    protected void onListItemLongClick(T object, int position) {
    }


    @Override
    public void showServerError(int errorCode, String errorDesc) {
        mProgress.showContent();
        mProgress.showEmpty(getResources().getDrawable(RequestType.IMG_DRAWABLE),//设置错误页面图片
                errorDesc,    //  错误信息1
                "",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//
//                        mPresennter.accessServer();
//                        mProgress.showLoading();
                    }
                });           //  错误信息2
//        mProgress.showError(getResources().getDrawable(R.drawable.network_error), //设置错误页面图片
//                "errorDesc",      //  错误信息1
//                "请稍后在试",      //  错误信息2
//                "重试",           //  按钮文字
//                new View.OnClickListener() { //按钮点击事件
//                    @Override
//                    public void onClick(View v) {
//                        //重新加载逻辑
//                        mPresennter.accessServer();
//                    }
//                });

    }

    @Override
    public void showNetworkError(int errorCode, String errorDesc, String type) {
        mProgress.showEmpty(getResources().getDrawable(RequestType.IMG_DRAWABLE),//设置错误页面图片
                errorDesc,    //  错误信息1
                "请稍后在试");           //  错误信息2

    }

    @Override
    public void showProgress(boolean show) {
        if (isRefresh) {
            mProgress.showContent();
            return;
        }

        if (!isLoadMore) {
            if (show) {
                mProgress.showLoading();
            } else {
                mProgress.showContent();
            }
        }
    }


    @Override
    public void showSucceed(boolean isSucceed) {

    }

    @Override
    public void getDatas(String json, String type) {

        List<T> list = null;
        try {
            list = JSON.parseArray(json.toString(), mClass);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "数据解析异常", Toast.LENGTH_SHORT).show();
        }
        if (list == null) return;

        if (isRefresh) {
            mList.clear();
        }

        if (list.size() != 0) {
            mList.addAll(list);

        }


        //是否在加载跟多
        if (isLoadMore) {
            //是否有数据
            if (list.size() == 0) {
                //显示页脚
//                mAdapter.notifyDataChangedAfterLoadMore(false);

                if (view == null) {
                    view = getLayoutInflater().inflate(R.layout.not_loading, (ViewGroup) mListView.getParent(), false);
                    mLayout = view.findViewById(R.id.loading_view);
                }
//                mAdapter.addFooterView(view);

                mQuickAdapter.addFooterView(view);
//                mLayout.setVisibility(View.VISIBLE);

                isCanLoadMore = false;

                mSwipeToLoadLayout.setLoadingMore(false);
                isLoadMoreEnabled(false);

            } else {
                //添加数据
//                mList.addAll(list);
//                mQuickAdapter.setNewData(mList);
                mQuickAdapter.notifyLoadMoreToLoading();
            }

        } else {
            //是否有数据
            if (list.size() == 0) {
                showServerError(RequestType.NO_DATA, "暂无内容");
//                mProgress.showEmpty(getResources().getDrawable(R.drawable.nodata),//设置错误页面图片
//                        "木有数据~",    //  错误信息1
//                        "");           //  错误信息2

            } else {

                if (mQuickAdapter == null) {
                    mQuickAdapter = initAdapter(mList);
                }
//                mQuickAdapter.setNewData(mList);
                mListView.setAdapter(mQuickAdapter);
                mQuickAdapter.notifyLoadMoreToLoading();
                mProgress.showContent();
            }

        }

        //关闭刷新
        mSwipeToLoadLayout.setRefreshing(false);
        //关闭 加载更多
        mSwipeToLoadLayout.setLoadingMore(false);

    }

    protected void isLoadMoreEnabled(boolean loadMore) {
        if (isLoadMoreEnabled) {
            mSwipeToLoadLayout.setLoadMoreEnabled(loadMore);
        }
    }

    @Override
    protected void onDestroy() {
        if (mPresennter != null) {
            mPresennter.dealloc();
            mPresennter = null;
        }
        super.onDestroy();
    }
}
