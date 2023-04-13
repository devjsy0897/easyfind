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
    @Column(name = "data_number")
    private int dataNum;

    @Column(name = "data_name")
    private String dataName;

    private String userId;

    private String location1;
    private String location2;
    private String location3;

    @Column(name = "in_date")
    private String inDate;

    @Column(name = "out_date")
    private String outDate;
}
