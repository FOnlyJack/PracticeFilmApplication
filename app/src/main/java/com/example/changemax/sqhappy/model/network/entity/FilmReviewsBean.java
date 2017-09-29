package com.example.changemax.sqhappy.model.network.entity;

import java.util.List;

/**
 * Created by ChangeMax on 2017/3/14.
 * 影片评论
 */

public class FilmReviewsBean {


    private String code;
    private DataBean data;
    private String msg;
    private String showMsg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getShowMsg() {
        return showMsg;
    }

    public void setShowMsg(String showMsg) {
        this.showMsg = showMsg;
    }

    public static class DataBean {


        private MiniBean mini;
        private PlusBean plus;

        public MiniBean getMini() {
            return mini;
        }

        public void setMini(MiniBean mini) {
            this.mini = mini;
        }

        public PlusBean getPlus() {
            return plus;
        }

        public void setPlus(PlusBean plus) {
            this.plus = plus;
        }

        public static class MiniBean {


            private int total;
            private List<ListBean> list;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {


                private int commentDate;
                private int commentId;
                private String content;
                private String headImg;
                private String img;
                private boolean isHot;
                private boolean isPraise;
                private String locationName;
                private String nickname;
                private int praiseCount;
                private int rating;
                private int replyCount;

                public int getCommentDate() {
                    return commentDate;
                }

                public void setCommentDate(int commentDate) {
                    this.commentDate = commentDate;
                }

                public int getCommentId() {
                    return commentId;
                }

                public void setCommentId(int commentId) {
                    this.commentId = commentId;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getHeadImg() {
                    return headImg;
                }

                public void setHeadImg(String headImg) {
                    this.headImg = headImg;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public boolean isIsHot() {
                    return isHot;
                }

                public void setIsHot(boolean isHot) {
                    this.isHot = isHot;
                }

                public boolean isIsPraise() {
                    return isPraise;
                }

                public void setIsPraise(boolean isPraise) {
                    this.isPraise = isPraise;
                }

                public String getLocationName() {
                    return locationName;
                }

                public void setLocationName(String locationName) {
                    this.locationName = locationName;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public int getPraiseCount() {
                    return praiseCount;
                }

                public void setPraiseCount(int praiseCount) {
                    this.praiseCount = praiseCount;
                }

                public int getRating() {
                    return rating;
                }

                public void setRating(int rating) {
                    this.rating = rating;
                }

                public int getReplyCount() {
                    return replyCount;
                }

                public void setReplyCount(int replyCount) {
                    this.replyCount = replyCount;
                }
            }
        }

        public static class PlusBean {


            private int total;
            private List<ListBeanX> list;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public List<ListBeanX> getList() {
                return list;
            }

            public void setList(List<ListBeanX> list) {
                this.list = list;
            }

            public static class ListBeanX {


                private int commentDate;
                private int commentId;
                private String content;
                private String headImg;
                private boolean isWantSee;
                private String locationName;
                private String nickname;
                private double rating;
                private int replyCount;
                private String title;

                public int getCommentDate() {
                    return commentDate;
                }

                public void setCommentDate(int commentDate) {
                    this.commentDate = commentDate;
                }

                public int getCommentId() {
                    return commentId;
                }

                public void setCommentId(int commentId) {
                    this.commentId = commentId;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getHeadImg() {
                    return headImg;
                }

                public void setHeadImg(String headImg) {
                    this.headImg = headImg;
                }

                public boolean isIsWantSee() {
                    return isWantSee;
                }

                public void setIsWantSee(boolean isWantSee) {
                    this.isWantSee = isWantSee;
                }

                public String getLocationName() {
                    return locationName;
                }

                public void setLocationName(String locationName) {
                    this.locationName = locationName;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public double getRating() {
                    return rating;
                }

                public void setRating(double rating) {
                    this.rating = rating;
                }

                public int getReplyCount() {
                    return replyCount;
                }

                public void setReplyCount(int replyCount) {
                    this.replyCount = replyCount;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }
        }
    }
}
