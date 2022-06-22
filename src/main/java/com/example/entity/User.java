package com.example.entity;

import javax.persistence.*;

@Entity//是个实体
@Table(name = "user")//告诉框架用哪个表
public class User {
    @Id//表明主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增的主键
    private Long id;
    private String name;
    private Integer age;
    private String sex;
    private String address;
    private String phone;
    @Column(name = "create_time")//表示直接映射上表里的属性
    private String createTime;

    //设置get set方法

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
