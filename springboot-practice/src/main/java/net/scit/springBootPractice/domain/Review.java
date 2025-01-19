package net.scit.springBootPractice.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * 상품리뷰에 대한 엔티티입니다.
 * 데이터베이스의 리뷰 데이터를 저장하는 테이블과 맵핑되는 엔티티입니다.
 * 클래스 레벨 애노테이션에 대한 설명은 Product 엔티티를 참고해주세요.
 */
@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "review")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_seq")
    private Integer seq;
    /*
        이 애노테이션은
        엔티티간 연관관계 맵핑이라고 하는 것입니다.
        연관관계라는 것은, 원래는 서로에 대한 정보가 아무것도 없는 상태의 두 개의 데이터에
        연결고리를 만들어주는 것입니다.
        두 개의 테이블 간에는 기본적으로 양방향 맵핑이라는 것 밖에 없습니다.
        왜냐하면, 일단 외래키 칼럼을 지정하므로서 관계를 설정하면, 그 칼럼으로 조인을 하게 되는데,
        조인을 할 때는 두 개의 테이블을 join on 절을 이용해서 테이블을 합치게 될 뿐,
        어느 테이블을 먼저 from 절에 써야한다 라는 등의 순서에 대한 제약은 없습니다.
        (물론 레코드 삽입 시에는 반드시 외래키 참조 무결성을 확보해야하는 제약은 있습니다.)
        즉, 두 개의 테이블 중 어느쪽으로부터든지 다른 테이블의 레코드를 참조할 수 있다는 것이죠.
        하지만 두 개의 자바 객체 사이에는 다른 객체에 대한 참조의 보유 여부에 따라
        연관 관게가 단방향이냐 양방향이냐가 달라집니다. 다른 한 쪽 객체의 참조를 보유하지 않은
        객체는 어떤 방법으로도 그 객체의 정보를 조회할 수가 없습니다.
        테이블간에 외래키를 이용해서 관계를 설정할 경우,
        외래키 칼럼을 갖고있는 테이블에 대응하는 엔티티에 반드시
        @ManyToOne 혹은 @OneToOne으로,
        외래키 칼럼이 참조하는 기본키 칼럼을 @Id로 가지는 엔티티의
        참조에 해당하는 필드에 애노테이션을 달아주어야합니다.

        이 연관관계는 배웠듯이
        1:1, 1:다, 다:1, 다:대가 있습니다만,
        다:다의 관계는 사용하지 않습니다.
        왜냐하면, 이는 개념상으로 존재하기에 애노테이션이 있는 것뿐,
        실질적으로 테이블간에는 다대다 관계가 없기 때문입니다.
        우리가 배웠듯이 다대다 관계가 있다면, 중간 테이블을 만들어서 관계를 1:다, 다:1로 나누어야합니다.

        연관관계가 위의 4가지 중에 뭐인지를 판단하는 방법은 간단합니다.
        중학교 수학에서 나오는 집합관계를 그대로 적용하면 됩니다.
        두 개의 엔티티 집합을 상정했을 때, 두 집합간 관계가 바로 연관관계가 됩니다.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    /*
        외래 키 컬럼을 지정합니다.
        referencedColumnName을 지정하지 않으면 자동으로
        참조하는 엔티티의 기본키 컬럼에 해당하는 필드(@Id가 달린 필드)의 컬럼으로 지정됩니다.
     */
    @JoinColumn(name = "product_seq")
    private Product product;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @CreationTimestamp
    @Column(name = "create_date")
    private LocalDateTime creationDate;

    @LastModifiedDate
    @Column(name = "update_date")
    private LocalDateTime updateDate;
}
