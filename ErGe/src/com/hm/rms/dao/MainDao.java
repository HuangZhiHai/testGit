package com.hm.rms.dao;

import com.hm.rms.entity.ProductionTask;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MainDao {
    List<ProductionTask> findDataList(@Param("page") int page, @Param("rows") int rows);
    int findDataListCounts();
}
