package com.ccydsz.ysec.obd.model.db.config;

import com.ccydsz.ysec.obd.model.db.DBBaseModel;
import org.hibernate.annotations.Cascade;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;
@Entity
public class CGTestTypeModel extends DBBaseModel {
    @Entity
    static public class CGTestTypeItemModel extends DBBaseModel{
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

    public List<CGTestTypeItemModel> getModels() {
        return models;
    }

    public void setModels(List<CGTestTypeItemModel> models) {
        this.models = models;
    }

    private String title;


    @OneToMany
    @Cascade(value={org.hibernate.annotations.CascadeType.ALL})
    @JoinColumn(name = "typeId")
    private List<CGTestTypeItemModel> models;

}