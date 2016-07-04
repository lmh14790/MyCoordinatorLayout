package com.education.myrecyclerview;

/**
 * Created by zhonghang on 16/6/29.
 */

public class NewsData {
    private String title;
    private String imgUrl;
    private String subTitle;

    public NewsData() {
    }

    public NewsData(String title, String imgUrl, String subTitle) {
        this.title = title;
        this.imgUrl = imgUrl;
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
