package com.boot.study.jpa.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/5/19 14:14
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Entity
@Table(name = "school")
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class School extends BaseEntity {
    private static final long serialVersionUID = -7244078121322557561L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_id")
    private Integer schoolId;
    @Column(name = "school_name")
    private String schoolName;
    @Column(name = "school_location")
    private String schoolLocation;
    @Column(name = "school_age")
    private Integer schoolAge;
    @OneToMany(mappedBy = "schoolId",targetEntity = Teacher.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Teacher> teachers = new HashSet<>();
}
