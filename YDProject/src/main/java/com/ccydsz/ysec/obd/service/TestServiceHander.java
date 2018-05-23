package com.ccydsz.ysec.obd.service;

import com.ccydsz.ysec.obd.exception.ServiceException;
import com.ccydsz.ysec.obd.model.db.DBTestTypeModel;
import com.ccydsz.ysec.obd.model.db.config.CGTestTypeModel;
import com.ccydsz.ysec.obd.repository.TestConfigReponsitory;
import com.ccydsz.ysec.obd.repository.TestReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class TestServiceHander implements TestService {



    @Autowired
    private TestReponsitory testRepository;
    @Autowired
    private TestConfigReponsitory testConfigRepository;


    @Override
    public List<CGTestTypeModel> createOrupdate(List<CGTestTypeModel> requestModels) throws ServiceException, RuntimeException {
        List<CGTestTypeModel> models = new ArrayList<CGTestTypeModel>();
        try {
            for (CGTestTypeModel m : ((List<CGTestTypeModel>)requestModels)){
                testConfigRepository.save(m);
            }
        } catch (RuntimeException exception){
            throw exception;
        }
        return models;
    }

    @Override
    public List<CGTestTypeModel> getConfigAllTest() throws ServiceException, RuntimeException, IOException {
        List<CGTestTypeModel> models = new ArrayList<CGTestTypeModel>();
        try {
            Iterator iterator = testConfigRepository.findAll().iterator();
            while(iterator.hasNext()){
                CGTestTypeModel model = (CGTestTypeModel) iterator.next();
                for (CGTestTypeModel.CGTestTypeItemModel m :model.getModels()) {
                    Resource resource = new ClassPathResource("");
                    resource.getURL();
                    m.setPath("http://"+"192.168.6.88:8080/ydobd"+"/config/test/"+m.getTitle()+".png");
                }
                models.add(model);
            }
        } catch (RuntimeException exception){
            throw exception;
        } catch (IOException e) {
            throw e;
        }
        return models;
    }

    @Override
    public List<DBTestTypeModel> create(List<DBTestTypeModel> requestModels) throws ServiceException, RuntimeException {
        List<DBTestTypeModel> models = new ArrayList<DBTestTypeModel>();
        try {
            for (DBTestTypeModel m : requestModels){
                testRepository.save(m);
            }
        } catch (RuntimeException exception){
            throw exception;
        }
        return models;
    }



    @Override
    public DBTestTypeModel findLatest() throws ServiceException, RuntimeException {
//        testRepository.f
        DBTestTypeModel model = null;
        try {
            Pageable p = new PageRequest(0, 1, new Sort(Sort.Direction.DESC,"createAt"));
            Page<DBTestTypeModel> pResult = testRepository.findAll(p);
            if (pResult.getContent().size() >= 1) {
                model = pResult.getContent().get(0);
            }
        } catch (RuntimeException exception){
            throw exception;
        }
        return model;
    }
}
