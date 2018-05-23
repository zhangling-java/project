package com.ccydsz.ysec.obd.model.db;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
@Entity
//@DiscriminatorValue("DBTestTypeModel")
public class DBTestTypeModel extends DBBaseModel {
    @Entity
//    @DiscriminatorValue("DBTestTypeItemModel")
    static public class DBTestTypeItemModel extends DBBaseModel{
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        private String title;
        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        private String path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<DBTestTypeItemModel> getModels() {
        return models;
    }

    public void setModels(List<DBTestTypeItemModel> models) {
        this.models = models;
    }

    private String title;


    @OneToMany
    @Cascade(value={org.hibernate.annotations.CascadeType.ALL})
    @JoinColumn(name = "typeId")
    private List<DBTestTypeItemModel> models;

}