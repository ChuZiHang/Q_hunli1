package com.wedding.entity;

import javax.persistence.*;

/**
 * @ClassName WedInfo
 * @Description TODO
 * @Author Q_先生
 * @Date 2018/8/2 16:08
 **/
@Entity
@Table(name = "wed_info")
public class WedInfo {

    private long id;

    private String bridegroomName;

    private String bridegroomMobile;

    private String brideName;

    private String brideMobile;

    private String weddingDate;

    private String weddingLunar;

    private String bgm;

    private String address;

    private String signImg;

    private String imgs;

    private Double lon;

    private Double lat;

    private String shareTitle;

    private String shareImg;

    private Long appId;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table-generator")
    @TableGenerator(name = "table-generator", pkColumnValue = "wed_info")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "bridegroom_name")
    public String getBridegroomName() {
        return bridegroomName;
    }

    public void setBridegroomName(String bridegroomName) {
        this.bridegroomName = bridegroomName;
    }

    @Basic
    @Column(name = "bridegroom_mobile")
    public String getBridegroomMobile() {
        return bridegroomMobile;
    }

    public void setBridegroomMobile(String bridegroomMobile) {
        this.bridegroomMobile = bridegroomMobile;
    }

    @Basic
    @Column(name = "bride_name")
    public String getBrideName() {
        return brideName;
    }

    public void setBrideName(String brideName) {
        this.brideName = brideName;
    }

    @Basic
    @Column(name = "bride_mobile")
    public String getBrideMobile() {
        return brideMobile;
    }

    public void setBrideMobile(String brideMobile) {
        this.brideMobile = brideMobile;
    }

    @Basic
    @Column(name = "wedding_date")
    public String getWeddingDate() {
        return weddingDate;
    }

    public void setWeddingDate(String weddingDate) {
        this.weddingDate = weddingDate;
    }

    @Basic
    @Column(name = "wedding_lunar")
    public String getWeddingLunar() {
        return weddingLunar;
    }

    public void setWeddingLunar(String weddingLunar) {
        this.weddingLunar = weddingLunar;
    }

    @Basic
    @Column(name = "bgm")
    public String getBgm() {
        return bgm;
    }

    public void setBgm(String bgm) {
        this.bgm = bgm;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "sign_img")
    public String getSignImg() {
        return signImg;
    }

    public void setSignImg(String signImg) {
        this.signImg = signImg;
    }

    @Basic
    @Column(name = "imgs")
    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    @Basic
    @Column(name = "lon")
    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    @Basic
    @Column(name = "lat")
    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    @Basic
    @Column(name = "share_title")
    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    @Basic
    @Column(name = "share_img")
    public String getShareImg() {
        return shareImg;
    }

    public void setShareImg(String shareImg) {
        this.shareImg = shareImg;
    }

    @Basic
    @Column(name = "app_id")
    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }
}
