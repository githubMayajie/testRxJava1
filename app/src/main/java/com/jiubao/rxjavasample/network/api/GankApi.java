package com.jiubao.rxjavasample.network.api;

import com.jiubao.rxjavasample.model.GankBeautyResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017/12/4.
 */

public interface GankApi {
    @GET("data/福利/{number}/{page}")
    Observable<GankBeautyResult> getBeauties(@Path("number") int number, @Path("page") int page);
//    Observable<GankBeautyResult> getBeauties(@Path("number") int number,@Path("page") int page);
}
