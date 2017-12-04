package com.jiubao.rxjavasample.module.zip_3;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.jiubao.rxjavasample.BaseFragment;
import com.jiubao.rxjavasample.R;
import com.jiubao.rxjavasample.adapter.ItemListAdapter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/12/4.
 */

public class ZipFragment extends BaseFragment {
    @BindView(R.id.gridRv)
    RecyclerView gridRv;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    ItemListAdapter adapter = new ItemListAdapter();

    @OnClick(R.id.ziploadBt)
    void load(){
        
    }

    @Override
    protected int getDialogRes() {
        return R.layout.dialog_zip;
    }

    @Override
    protected int getTitleRes() {
        return R.string.title_zip;
    }
}
