package com.ccydsz.ysec.obd.model.db;
import com.ccydsz.ysec.obd.model.*;

import javax.persistence.*;

@Entity
public class UserModel extends BaseModel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Column(unique=true,nullable=false,length = 32)
    private String account;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String phoneNumber;

    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(nullable=false)
    private String password;

    private String salt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //单项 一对一 关联
    /**
     * @OneToOne：一对一关联
     * cascade：级联配置
     * CascadeType.PERSIST: 级联新建
     * CascadeType.REMOVE : 级联删除
     * CascadeType.REFRESH: 级联刷新
     * CascadeType.MERGE  : 级联更新
     * CascadeType.ALL    : 以上全部四项
     * @JoinColumn:主表外键字段
     * cid：Care所映射的表中的一个字段(会在User表创建一个cid字段,与Care外键关系)
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cardId",unique=true)
    private CardModel cardModel;
    public CardModel getCardModel() {
        return cardModel;
    }
    public void setCardModel(CardModel cardModel) {
        this.cardModel = cardModel;
    }

    //双向 一对一 关联
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userTokenId",unique=true) //"主方"提供一个数据库Id，"次方"若双向，则需要"mappedBy"主方的一个属性，若单向什么都不需要做
    private UserTokenModel userTokenModel;
    public UserTokenModel getUserTokenModel() {
        return userTokenModel;
    }
    public void setUserTokenModel(UserTokenModel userTokenModel) {
        this.userTokenModel = userTokenModel;
    }




    //单项 一对一
    @OneToOne
    @JoinColumn(name = "userId")
    private ClientInfoModel clientInfoModel;
    public ClientInfoModel getClientInfoModel() {
        return clientInfoModel;
    }

    public void setClientInfoModel(ClientInfoModel clientInfoModel) {
        this.clientInfoModel = clientInfoModel;
    }





    public WeiXinModel getWeiXinModel() {
        return weiXinModel;
    }

    public void setWeiXinModel(WeiXinModel weiXinModel) {
        this.weiXinModel = weiXinModel;
    }
    //双向 一对一 关联
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weiXinId",unique=true)
    private WeiXinModel weiXinModel;



}
