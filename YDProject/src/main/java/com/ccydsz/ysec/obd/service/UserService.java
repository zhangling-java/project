package com.ccydsz.ysec.obd.service;

import com.ccydsz.ysec.obd.exception.ServiceException;
import com.ccydsz.ysec.obd.model.CardModel;
import com.ccydsz.ysec.obd.model.db.UserModel;

public interface UserService {
    public Boolean verifyPhoneNumberRegister(UserModel userModel) throws ServiceException , RuntimeException;
    public UserModel register(UserModel userModel) throws ServiceException , RuntimeException;
    public UserModel login(UserModel userModel) throws ServiceException , RuntimeException;
    public UserModel weiXinLogin(UserModel userModel) throws ServiceException , RuntimeException;
    public CardModel searchCard(UserModel userModel) throws ServiceException , RuntimeException;
    public CardModel addInCard(UserModel userModel) throws ServiceException , RuntimeException;

}
