package com.jiubao.rxjavasample.util;

import android.util.Log;

import com.jiubao.rxjavasample.model.GankBeauty;
import com.jiubao.rxjavasample.model.GankBeautyResult;
import com.jiubao.rxjavasample.model.Item;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2017/12/4.
 */

public class GankBeautyResultToItemsMapper implements Function<GankBeautyResult,List<Item>>{
    private final static String TAG = GankBeautyResultToItemsMapper.class.getSimpleName();
    private GankBeautyResultToItemsMapper(){
    }
    private static GankBeautyResultToItemsMapper instance = new GankBeautyResultToItemsMapper();
    public static GankBeautyResultToItemsMapper getInstance(){
        return instance;
    }

    @Override
    public List<Item> apply(GankBeautyResult gankBeautyResult) throws Exception {
        List<GankBeauty> gankBeauties = gankBeautyResult.beauties;
        Log.d(TAG, "apply: 1");
        List<Item> items = new ArrayList<>(gankBeauties.size());
        Log.d(TAG, "apply: 2");
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
        for (GankBeauty gankBeauty : gankBeauties) {
            Item item = new Item();
            try {
                Date date = inputFormat.parse(gankBeauty.createdAt);
                item.description = outputFormat.format(date);
            }catch (ParseException e){
                e.printStackTrace();
                item.description = "unknow date";
            }
            item.imageUrl = gankBeauty.url;
            items.add(item);
        }
        return items;
    }
}
