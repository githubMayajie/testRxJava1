package com.jiubao.rxjavasample;

import android.app.AlertDialog;
import android.app.Fragment;

import butterknife.OnClick;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/12/4.
 */

public abstract class BaseFragment extends Fragment {
    protected Disposable disposable;

    @OnClick(R.id.tipBt)
    void tip(){
        new AlertDialog.Builder(getActivity())
                .setTitle(getTitleRes())
                .setView(getActivity().getLayoutInflater().inflate(getDialogRes(),null))
                .show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    protected void unsubscribe(){
        if (disposable != null && !disposable.isDisposed()){
            disposable.dispose();
        }
    }

    protected abstract int getDialogRes();
    protected abstract int getTitleRes();
}
