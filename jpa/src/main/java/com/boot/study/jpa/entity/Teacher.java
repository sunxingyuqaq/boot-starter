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
@Table(name = "teacher")
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class Teacher extends BaseEntity {
    private static final long serialVersionUID = -5141515515345007077L;
    @Id
    @Column(name = "teacher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;
    @Column(name = "teacher_name")
    private String teacherName;
    @ManyToOne(targetEntity = School.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id", referencedColumnName = "school_id", foreignKey = @ForeignKey(name = "FK_SCHOOL_TEACHER"))
    private School schoolId;
    @ManyToMany(targetEntity = Student.class)
    @JoinTable(name = "sys_teacher_student",
            joinColumns = {@JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id", foreignKey = @ForeignKey(name = "FK_TEACHER_STUDENT_TEACHER_ID"))},
            inverseJoinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "student_id", foreignKey = @ForeignKey(name = "FK_TEACHER_STUDENT_STUDENT_ID"))})
    private Set<Student> students = new HashSet<>();

    @ManyToMany(targetEntity = Classes.class)
    @JoinTable(name = "sys_teacher_classes",
            joinColumns = {@JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id", foreignKey = @ForeignKey(name = "FK_TEACHER_CLASSES_TEACHER_ID"))},
            inverseJoinColumns = {@JoinColumn(name = "classes_id", referencedColumnName = "classes_id", foreignKey = @ForeignKey(name = "FK_TEACHER_CLASSES_CLASSES_ID"))})
    private Set<Classes> classes = new HashSet<>();
}
