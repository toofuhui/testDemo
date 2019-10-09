package com.hui.pojo;


import javax.persistence.*;

/**
 * 注意事项在实体类中导入包时一定要注意在同一个包下的类
 * 例如我当初导错了这个包import javax.persistence.*;
 * 导致我根据id查询结果为null
 */
@Table(name = "user_info")
    public class UserInfo {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;
    private Integer userId;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", address='" + address + '\'' +
                '}';
    }
}
