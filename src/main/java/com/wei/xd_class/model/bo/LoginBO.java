package com.wei.xd_class.model.bo;

/**
 * @author www
 * @date 2022/6/26 16:56
 * @description:
 */
public class LoginBO {
    private String phone;
    private String pwd;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "LoginVO{" +
                "phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
