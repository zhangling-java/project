package com.ccydsz.ysec.obd.service;

import com.ccydsz.ysec.obd.exception.ServiceException;
import com.ccydsz.ysec.obd.model.db.DBTestTypeModel;
import com.ccydsz.ysec.obd.model.db.config.CGTestTypeModel;


import java.io.IOException;
import java.util.List;

public interface TestService {
    public List<CGTestTypeModel> createOrupdate(List<CGTestTypeModel> models) throws ServiceException, RuntimeException;
    public List<CGTestTypeModel> getConfigAllTest() throws ServiceException, RuntimeException, IOException;
    public List<DBTestTypeModel> create(List<DBTestTypeModel> models) throws ServiceException, RuntimeException;
    public DBTestTypeModel findLatest() throws ServiceException, RuntimeException;
}
