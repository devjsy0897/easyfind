package com.devjsy.easyfind.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Data
@Entity
@Table(name = "member")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class En_member {

    @Id
    private int idx;
    private String id;
    private String password;
    private String name;
    private String level;

   /* @Column(name = "reg_day")
    private String regDay;*/


}
