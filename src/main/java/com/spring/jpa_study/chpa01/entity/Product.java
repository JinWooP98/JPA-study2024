package com.spring.jpa_study.chpa01.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode(of = "id") // id가 pk 이므로 id 만 가지고 객체가 같은지 판단해라! 라는 코드, 여러개를 쓰려면 {"id", "name"}안에 묶기
@NoArgsConstructor
@AllArgsConstructor
@Builder
// 자동으로 table을 생성해줌..
@Entity
// 테이블 명 지정하기
@Table(name = "tbl_product")
public class Product {

    // PK 지정하기
    @Id
    // GenerationType.SEQUENCE -- 오라클일 경우에
    // GenerationType.IDENTITY -- mariaDB일 경우에
    // AUTO INCREMENT 역할을 함
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 컬럼 명 지정하기
    @Column(name = "prod_id")
    private Long id; // PK

    @Column(name = "prod_nm", length = 30, nullable = false)
    private String name; // 상품명

    @Column(name = "price")
    private int price; // 상품 각격

    @Column(nullable = false)
    // enum 을 타입으로 설정할때 기본적인 설정값 = EnumType.ORDINAL
    // 따라서 아래와 같은 코드를 써주어야 함
    @Enumerated(EnumType.STRING)
    private Category category;

    @CreationTimestamp // 이는 INSERT 시에 자동으로 서버시간을 저장한다.
    @Column(updatable = false) // 수정 가능/불가 여부
    private LocalDateTime createdAt; // 상품 등록시간

    @UpdateTimestamp // UPDATE 문 실행시 자동으로 시간이 저장
    private LocalDateTime updatedAt; // 상품 수정시간

    // 데이터베이스에는 저장안하고 클래스 내부에서만 사용할 필드
    @Transient // DB에 저장을 막음
    private String nickName;

    public enum Category {
        FOOD, FASHION, ELECTRONIC
    }
}
