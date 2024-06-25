package com.spring.jpa_study.chap02.entity;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tbl_student")
public class Student {

    // 랜덤문자로 PK 지정
    @Id
    @Column(name = "stu_id")
    @GeneratedValue(generator = "uid")  // 이 방식으로 할것이다.
    @GenericGenerator(strategy = "uuid", name = "uid") // 방식의 전략과 이름
    private String id;

    @Column(name = "stu_name", nullable = false)
    private String name;

    private String city;

    private String major;
}
