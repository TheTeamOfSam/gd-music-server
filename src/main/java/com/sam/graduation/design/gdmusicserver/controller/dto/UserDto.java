package com.sam.graduation.design.gdmusicserver.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sam.graduation.design.gdmusicserver.model.pojo.User;

import java.util.Date;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/2/28 15:49:45
 */
public class UserDto {

    // User id
    @JsonProperty("id")
    private Long id;

    // 邮箱
    @JsonProperty("email")
    private String email;

    // 昵称
    @JsonProperty("nickname")
    private String nickname;

    // 密码
    @JsonProperty("password")
    private String password;

    // 介绍
    @JsonProperty("introduction")
    private String introduction;

    // 性别
    @JsonProperty("sex")
    private Byte sex;

    // 出生日期
    @JsonProperty("date_of_birth")
    private Date dateOfBirth;

    @JsonProperty("str_date_of_birth")
    private String strDateOfBirth;

    // 省
    @JsonProperty("province")
    private String province;

    // 市
    @JsonProperty("city")
    private String city;

    // 头像
    @JsonProperty("head_photo")
    private String headPhoto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHeadPhoto() {
        return headPhoto;
    }

    public void setHeadPhoto(String headPhoto) {
        this.headPhoto = headPhoto;
    }

    public String getStrDateOfBirth() {
        return strDateOfBirth;
    }

    public void setStrDateOfBirth(String strDateOfBirth) {
        this.strDateOfBirth = strDateOfBirth;
    }

    public User to() {
        User user = new User();
        user.setEmail(this.email);
        user.setNickname(this.nickname);
        user.setPassword(this.password);
        user.setIntroduction(this.introduction);
        user.setSex(this.sex);
        user.setDateOfBirth(this.dateOfBirth);
        user.setProvince(this.province);
        user.setCity(this.city);
        user.setHeadPhoto(this.headPhoto);
        return user;
    }

    public void from(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.nickname = user.getNickname();
        this.password = user.getPassword();
        this.introduction = user.getIntroduction();
        this.sex = user.getSex();
        this.dateOfBirth = user.getDateOfBirth();
        this.province = user.getProvince();
        this.city = user.getCity();
        this.headPhoto = user.getHeadPhoto();
    }
}
