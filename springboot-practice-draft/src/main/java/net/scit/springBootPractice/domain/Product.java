package net.scit.springBootPractice.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


/*
  적절한 코드를 입력해주세요.
*/
@Table(name = "product")
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_seq")
    /*
       적절한 코드를 입력해주세요.
     */

    @Column(name = "name", unique = true, nullable = false)
    /*
       적절한 코드를 입력해주세요.
     */

    @Column(name = "stock", nullable = false)
    /*
       적절한 코드를 입력해주세요.
     */

    @Column(name = "description")
    /*
       적절한 코드를 입력해주세요.
     */

    @Column(name = "category")
    /*
       적절한 코드를 입력해주세요.
     */

    @Column(name = "price", nullable = false)
    /*
       적절한 코드를 입력해주세요.
     */

    @Column(name = "creation_date")
    /*
       적절한 코드를 입력해주세요.
     */

    @Column(name = "update_date")
    /*
       적절한 코드를 입력해주세요.
     */


    /*
       적절한 코드를 입력해주세요.
     */
    private List<Review> reviews = new ArrayList<>();
}
