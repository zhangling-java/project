package com.ccydsz.ysec.obd.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ClientInfoModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Date loginDate;//登录时间
    private String deviceBrand;//设备品牌

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceMode() {
        return deviceMode;
    }

    public void setDeviceMode(String deviceMode) {
        this.deviceMode = deviceMode;
    }

    private String deviceName;//设备名称
    private String deviceMode;//设备型号

}
