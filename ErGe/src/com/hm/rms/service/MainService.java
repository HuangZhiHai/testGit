package com.hm.rms.service;

import com.hm.rms.entity.ProductionTask;

import java.util.List;

public interface MainService {

    List<ProductionTask> findDataList(int page,int rows);

    int findDataListCounts();

}
