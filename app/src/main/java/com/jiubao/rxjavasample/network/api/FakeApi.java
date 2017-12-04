package com.jiubao.rxjavasample.network.api;

import com.jiubao.rxjavasample.model.FakeThing;
import com.jiubao.rxjavasample.model.FakeToken;

import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2017/12/4.
 */

public class FakeApi {
    Random random = new Random();

    public Observable<FakeToken> getFakeToken(final String fakeAuth){
        return Observable.just(fakeAuth)
                .map(new Function<String, FakeToken>() {
                    @Override
                    public FakeToken apply(String s) throws Exception {
                        int fakeNetWorkTimeCost = random.nextInt(500) + 500;
                        try {
                            Thread.sleep(fakeNetWorkTimeCost);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }

                        FakeToken fakeToken = new FakeToken();
                        fakeToken.token = createToken();
                        return fakeToken;
                    }
                });
    }

    private static String createToken(){
        return "fake_token_" + System.currentTimeMillis() % 10000;
    }

    public Observable<FakeThing> getFakeData(FakeToken fakeToken){
        return Observable.just(fakeToken)
                .map(new Function<FakeToken, FakeThing>() {
                    @Override
                    public FakeThing apply(FakeToken fakeToken) throws Exception {
                        int fakeNetworkTimeCost = random.nextInt(500) + 500;
                        try{
                            Thread.sleep(fakeNetworkTimeCost);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }

                        FakeThing fakeData = new FakeThing();
                        fakeData.id = (int)(System.currentTimeMillis() % 1000);
                        fakeData.name = "FAKE_USER_" + fakeData.id;
                        return fakeData;
                    }
                });
    }

}
