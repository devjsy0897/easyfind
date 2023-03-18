package com.devjsy.easyfind.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "save")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class En_save {

    @Id
    private int idx;
    private String userID;
    private String dataName;

   /* @Column(name = "reg_day")
    private String regDay;*/


}
