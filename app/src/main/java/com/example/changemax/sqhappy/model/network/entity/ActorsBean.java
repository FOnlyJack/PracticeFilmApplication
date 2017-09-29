package com.example.changemax.sqhappy.model.network.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by ChangeMax on 2017/3/20.
 */

public class ActorsBean implements MultiItemEntity {
    public static final int DEFULT = 0;
    public static final int ACTOR = 1;
    public static final int DIRECTOR = 2;
    private int itemtype;
    private int actorId;
    private String img;
    private String name;
    private String nameEn;
    private String roleImg;
    private String roleName;


    public ActorsBean(int itemtype) {
        this.itemtype = itemtype;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getRoleImg() {
        return roleImg;
    }

    public void setRoleImg(String roleImg) {
        this.roleImg = roleImg;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public int getItemType() {
        return itemtype;
    }
}
