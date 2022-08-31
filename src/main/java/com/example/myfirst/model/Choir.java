package com.example.myfirst.model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Choir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
   private String name;

    @Column(name = "registered_at")
    private Date registeredAt;
}
