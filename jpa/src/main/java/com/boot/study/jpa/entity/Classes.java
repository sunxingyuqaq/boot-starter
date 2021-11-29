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
 * @date 2020/5/19 14:15
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Entity
@Table(name = "classes")
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class Classes extends BaseEntity{
    private static final long serialVersionUID = 5775120241195699938L;

    @Id
    @Column(name = "classes_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classesId;

    private String classesName;

    private Integer totalCount;

    @ManyToMany(targetEntity = Teacher.class,fetch = FetchType.LAZY,mappedBy = "classes")
    private Set<Teacher> teachers = new HashSet<>();

    @OneToMany(targetEntity = Student.class,fetch = FetchType.LAZY,mappedBy = "classes")
    private Set<Student> students = new HashSet<>();
}
