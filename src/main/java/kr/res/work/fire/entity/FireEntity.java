package kr.res.work.fire.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "info")
public class FireEntity {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "info_id", nullable = false)
     private Long id;

     @Column(name = "title", nullable = false)
     private String title;

    @Column(name = "content", nullable = false)
    private String content;

}
