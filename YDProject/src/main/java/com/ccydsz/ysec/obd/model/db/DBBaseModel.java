package com.ccydsz.ysec.obd.model.db;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
////指定继承映射的策略
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
////在数据库表中加上一个字段，用以区分是哪个子类,name表示表的字段名字，discriminatorType
////表示name字段的数据类型
//@DiscriminatorColumn(name="dis",discriminatorType=DiscriminatorType.STRING)
////指定这个类存到数据库中用什么区分，value表明dis的值
//@DiscriminatorValue(value="DBBaseModel")
public class DBBaseModel{
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
