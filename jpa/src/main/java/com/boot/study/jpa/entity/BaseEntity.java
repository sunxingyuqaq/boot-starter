package com.boot.study.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/5/20 9:09
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Setter
@Getter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Basic(fetch = FetchType.LAZY)
    @Lob
    @Column(name = "[desc]")
    private String desc;
    private Date creatDate;
    private String creatUser;
    private Date updateDate;
    private String updateUser;
}
