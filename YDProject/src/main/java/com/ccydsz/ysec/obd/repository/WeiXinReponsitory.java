package com.ccydsz.ysec.obd.repository;

import com.ccydsz.ysec.obd.model.WeiXinModel;
import org.springframework.data.repository.CrudRepository;
public interface WeiXinReponsitory extends CrudRepository <WeiXinModel, Long>{
    WeiXinModel findById(Long id);
}
