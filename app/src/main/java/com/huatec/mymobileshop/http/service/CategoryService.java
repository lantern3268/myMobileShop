package com.huatec.mymobileshop.http.service;


import com.huatec.mymobileshop.http.entity.CategoryEntity;
import com.huatec.mymobileshop.http.entity.HttpResult;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

//CategoryService接口
public interface CategoryService {

    @GET("cat")
    Observable<HttpResult<List<CategoryEntity>>> getTopList();

    @GET("cat/parent/{parentId}")
    Observable<HttpResult<List<CategoryEntity>>> getSecondList(@Path("parentId") int parentId);

}
