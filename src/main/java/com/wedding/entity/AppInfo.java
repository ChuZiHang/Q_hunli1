package com.wedding.entity;

import javax.persistence.*;

/**
 * @ClassName AppInfo
 * @Description TODO
 * @Author Q_先生
 * @Date 2018/8/2 10:09
 **/
@Entity
@Table(name = "app_info")
public class AppInfo {

    private long id;

    private String appId;

    private String secret;

    private String describe;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table-generator")
    @TableGenerator(name = "table-generator", pkColumnValue = "app_info")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "app_id")
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Basic
    @Column(name = "secret")
    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Basic
    @Column(name = "describe")
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
