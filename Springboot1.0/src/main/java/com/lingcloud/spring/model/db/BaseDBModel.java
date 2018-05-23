package com.lingcloud.spring.model.db;

import java.util.Date;
import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class BaseDBModel {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private Long id;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    private Date createAt = new Date();

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    private Date updateAt;
}
