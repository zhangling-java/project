package com.ccydsz.ysec.obd.repository;

import com.ccydsz.ysec.obd.model.db.config.CGTestTypeModel;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TestConfigReponsitory extends PagingAndSortingRepository<CGTestTypeModel, Long> {
    CGTestTypeModel findById(Long id);
}
