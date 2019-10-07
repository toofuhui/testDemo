package com.hui.vo;

import java.util.Date;
//@ApiModelProperty()用于方法，字段； 表示对model属性的说明或者数据操作更改
public class UserVO {
    private Integer user_id;
    private String real_name;
    private String mobile;
    private String user_name;
    private String password;
    private String statusaLabel;
    private Date create_time;
    private Date update_time;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatusaLabel() {
        return statusaLabel;
    }

    public void setStatusaLabel(String statusaLabel) {
        this.statusaLabel = statusaLabel;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }


}
