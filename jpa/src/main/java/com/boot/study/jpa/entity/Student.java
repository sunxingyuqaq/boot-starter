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
@Table(name = "student")
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class Student extends BaseEntity{
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    private String studentName;
    @ManyToMany(targetEntity = Teacher.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "students")
    private Set<Teacher> teachers = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "classes_id",referencedColumnName = "classes_id",foreignKey = @ForeignKey(name = "FK_STUDENT_CLASSES_CLASSES_ID"))
    private Classes classes;
}
