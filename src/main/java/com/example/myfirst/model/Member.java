package com.example.myfirst.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Setter
@Getter
@Table(name = "member")
public class Member extends  BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


@Column(length = 100,nullable = false)
    public  String firstName;

    @Column(length = 100)
    @NotNull
    public  String middleName;


    @Column(length = 100)
    public  String lastName;

    @Column(length = 10)
    public  String gender;


    public Date dateOfBirth;



    @ManyToOne
    @JoinColumn(name="father_id", nullable=true)
    public Member  father;

    @ManyToOne
    @JoinColumn(name="mother_id", nullable=true)
    public  Member mother;


    public  Date registeredAt;


}
