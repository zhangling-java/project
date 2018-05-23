package com.ccydsz.ysec.obd.service;

import com.ccydsz.ysec.obd.exception.ServiceException;
import com.ccydsz.ysec.obd.model.CardModel;
import com.ccydsz.ysec.obd.model.ClientInfoModel;
import com.ccydsz.ysec.obd.model.db.UserModel;
import com.ccydsz.ysec.obd.model.WeiXinModel;
import com.ccydsz.ysec.obd.model.ex.EXServerModel;
import com.ccydsz.ysec.obd.repository.CardRepository;
import com.ccydsz.ysec.obd.repository.ClientInfoReponsitory;
import com.ccydsz.ysec.obd.repository.UserRepository;
import com.ccydsz.ysec.obd.repository.WeiXinReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceHander implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClientInfoReponsitory clientInfoReponsitory;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private WeiXinReponsitory weiXinReponsitory;


    @Override
    public Boolean verifyPhoneNumberRegister(UserModel userModel) throws ServiceException, RuntimeException {
        try {
            UserModel u = userRepository.findByAccount(userModel.getAccount());
            if (u==null){
                return true;
            }else {
                return false;
            }
        } catch (RuntimeException exception){
            throw exception;
        }
    }

    @Override
    public UserModel register(UserModel userModel) throws ServiceException, RuntimeException {
        try {
            UserModel u = userRepository.findByAccount(userModel.getAccount());
            if (u !=null){
                throw new ServiceException(new EXServerModel(EXServerModel.CodeEnum.DidRegister));
            }else {
                u = userModel;
                if (u.getClientInfoModel() != null){
                    u.setClientInfoModel(clientInfoReponsitory.save(u.getClientInfoModel())) ;
                }
            }
            if (u.getAccount() == null) {
                u.setAccount(UUID.randomUUID().toString());
            }
            u=userRepository.save(u);
            return u;
        } catch (RuntimeException exception){
            throw exception;
        }
    }

    @Override
    public UserModel login(UserModel userModel) throws ServiceException , RuntimeException{
        try {
            UserModel u = userRepository.findByAccount(userModel.getAccount());
            if (u ==null){
                throw new ServiceException(new EXServerModel(EXServerModel.CodeEnum.NoUser));
            }
            if (u.getPassword().equals(userModel.getPassword())){
                if (userModel.getClientInfoModel() != null) {
                    ClientInfoModel clientInfoModel = clientInfoReponsitory.save(userModel.getClientInfoModel());
                    u.setClientInfoModel(clientInfoModel);
                    u=userRepository.save(u);
                }
                return u;
            }else {
                throw new ServiceException(new EXServerModel(EXServerModel.CodeEnum.ErrorPassword));
            }
        } catch (RuntimeException exception){
            throw exception;
        }
    }

    @Override
    public UserModel weiXinLogin(UserModel userModel) throws ServiceException, RuntimeException {
        try {

            UserModel u = userRepository.findByAccount(userModel.getAccount());
            WeiXinModel weiXinModel = userModel.getWeiXinModel();
            if (u.getWeiXinModel() != null){
                weiXinModel.setId(u.getWeiXinModel().getId());
            }
            u.setWeiXinModel(weiXinModel);
            userRepository.save(u);
            return u;

        } catch (RuntimeException exception){
            throw exception;
        }
    }

    @Override
    public CardModel searchCard(UserModel userModel) throws ServiceException , RuntimeException{
        return null;
    }

    @Override
    public CardModel addInCard(UserModel userModel) throws ServiceException , RuntimeException{


        try {

            UserModel u = userRepository.findByAccount(userModel.getAccount());
            CardModel cardModel = userModel.getCardModel();
            if (u.getCardModel() != null){
                cardModel.setId(u.getCardModel().getId());
            }
            u.setCardModel(cardModel);
            userRepository.save(u);
            return cardModel;

        } catch (RuntimeException exception){
            throw exception;
        }
    }


}
