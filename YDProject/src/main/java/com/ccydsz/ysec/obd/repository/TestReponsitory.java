package com.ccydsz.ysec.obd.repository;
import com.ccydsz.ysec.obd.model.db.DBTestTypeModel;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TestReponsitory extends PagingAndSortingRepository<DBTestTypeModel, Long> {
    DBTestTypeModel findById(Long id);

}
