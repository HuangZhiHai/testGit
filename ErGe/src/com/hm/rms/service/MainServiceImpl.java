package com.hm.rms.service;

import com.hm.rms.dao.MainDao;
import com.hm.rms.entity.ProductionTask;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Transactional
@Service
public class MainServiceImpl implements MainService {
    @Resource
    private MainDao mainDao;
    @Override
    public List<ProductionTask> findDataList(int rows, int page) {
        return mainDao.findDataList(rows,page);
    }

    @Override
    public int findDataListCounts() {
        return mainDao.findDataListCounts();
    }
}
