package net.scit.springBootPractice.domain;

import jakarta.persistence.*;


@Table(name = "review")
public class Review {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_seq")
    /*
       적절한 코드를 입력해주세요.
     */

    /*
       적절한 코드를 입력해주세요.
     */
    @JoinColumn(name = "product_seq")
    /*
       적절한 코드를 입력해주세요.
     */


    @Column(name = "title", nullable = false)
    /*
       적절한 코드를 입력해주세요.
     */

    @Column(name = "content", nullable = false)
    /*
       적절한 코드를 입력해주세요.
     */


    @Column(name = "create_date")
    /*
       적절한 코드를 입력해주세요.
     */

    @Column(name = "update_date")
    /*
       적절한 코드를 입력해주세요.
     */
}
