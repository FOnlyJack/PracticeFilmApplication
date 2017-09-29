package com.example.changemax.sqhappy.model.network.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by ChangeMax on 2017/3/14.
 * 正在热映
 */

public class FilmIsHitingBean {



    private String bImg;
    private String date;
    private int lid;
    private int newActivitiesTime;
    private int totalComingMovie;
    private String voucherMsg;
    private List<MsBean> ms;

    public String getBImg() {
        return bImg;
    }

    public void setBImg(String bImg) {
        this.bImg = bImg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getNewActivitiesTime() {
        return newActivitiesTime;
    }

    public void setNewActivitiesTime(int newActivitiesTime) {
        this.newActivitiesTime = newActivitiesTime;
    }

    public int getTotalComingMovie() {
        return totalComingMovie;
    }

    public void setTotalComingMovie(int totalComingMovie) {
        this.totalComingMovie = totalComingMovie;
    }

    public String getVoucherMsg() {
        return voucherMsg;
    }

    public void setVoucherMsg(String voucherMsg) {
        this.voucherMsg = voucherMsg;
    }

    public List<MsBean> getMs() {
        return ms;
    }

    public void setMs(List<MsBean> ms) {
        this.ms = ms;
    }

    public static class MsBean {

        private int NearestCinemaCount;
        private int NearestDay;
        private int NearestShowtimeCount;
        private String aN1;
        private String aN2;
        private int cC;
        private String commonSpecial;
        private String d;
        private String dN;
        private int def;
        private int id;
        private String img;
        private boolean is3D;
        private boolean isDMAX;
        private boolean isFilter;
        private boolean isHot;
        private boolean isIMAX;
        private boolean isIMAX3D;
        private boolean isNew;
        private boolean isTicket;
        private String m;
        private String movieType;
        private double r;
        private int rc;
        private String rd;
        private int rsC;
        private int sC;
        private String t;
        private String tCn;
        private String tEn;
        private int ua;
        private int wantedCount;
        private List<String> p;
        private List<VersionsBean> versions;

        public int getNearestCinemaCount() {
            return NearestCinemaCount;
        }

        public void setNearestCinemaCount(int NearestCinemaCount) {
            this.NearestCinemaCount = NearestCinemaCount;
        }

        public int getNearestDay() {
            return NearestDay;
        }

        public void setNearestDay(int NearestDay) {
            this.NearestDay = NearestDay;
        }

        public int getNearestShowtimeCount() {
            return NearestShowtimeCount;
        }

        public void setNearestShowtimeCount(int NearestShowtimeCount) {
            this.NearestShowtimeCount = NearestShowtimeCount;
        }

        public String getAN1() {
            return aN1;
        }

        public void setAN1(String aN1) {
            this.aN1 = aN1;
        }

        public String getAN2() {
            return aN2;
        }

        public void setAN2(String aN2) {
            this.aN2 = aN2;
        }

        public int getCC() {
            return cC;
        }

        public void setCC(int cC) {
            this.cC = cC;
        }

        public String getCommonSpecial() {
            return commonSpecial;
        }

        public void setCommonSpecial(String commonSpecial) {
            this.commonSpecial = commonSpecial;
        }

        public String getD() {
            return d;
        }

        public void setD(String d) {
            this.d = d;
        }

        public String getDN() {
            return dN;
        }

        public void setDN(String dN) {
            this.dN = dN;
        }

        public int getDef() {
            return def;
        }

        public void setDef(int def) {
            this.def = def;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public boolean isIs3D() {
            return is3D;
        }

        public void setIs3D(boolean is3D) {
            this.is3D = is3D;
        }

        public boolean isIsDMAX() {
            return isDMAX;
        }

        public void setIsDMAX(boolean isDMAX) {
            this.isDMAX = isDMAX;
        }

        public boolean isIsFilter() {
            return isFilter;
        }

        public void setIsFilter(boolean isFilter) {
            this.isFilter = isFilter;
        }

        public boolean isIsHot() {
            return isHot;
        }

        public void setIsHot(boolean isHot) {
            this.isHot = isHot;
        }

        public boolean isIsIMAX() {
            return isIMAX;
        }

        public void setIsIMAX(boolean isIMAX) {
            this.isIMAX = isIMAX;
        }

        public boolean isIsIMAX3D() {
            return isIMAX3D;
        }

        public void setIsIMAX3D(boolean isIMAX3D) {
            this.isIMAX3D = isIMAX3D;
        }

        public boolean isIsNew() {
            return isNew;
        }

        public void setIsNew(boolean isNew) {
            this.isNew = isNew;
        }

        public boolean isIsTicket() {
            return isTicket;
        }

        public void setIsTicket(boolean isTicket) {
            this.isTicket = isTicket;
        }

        public String getM() {
            return m;
        }

        public void setM(String m) {
            this.m = m;
        }

        public String getMovieType() {
            return movieType;
        }

        public void setMovieType(String movieType) {
            this.movieType = movieType;
        }

        public double getR() {
            return r;
        }

        public void setR(double r) {
            this.r = r;
        }

        public int getRc() {
            return rc;
        }

        public void setRc(int rc) {
            this.rc = rc;
        }

        public String getRd() {
            return rd;
        }

        public void setRd(String rd) {
            this.rd = rd;
        }

        public int getRsC() {
            return rsC;
        }

        public void setRsC(int rsC) {
            this.rsC = rsC;
        }

        public int getSC() {
            return sC;
        }

        public void setSC(int sC) {
            this.sC = sC;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getTCn() {
            return tCn;
        }

        public void setTCn(String tCn) {
            this.tCn = tCn;
        }

        public String getTEn() {
            return tEn;
        }

        public void setTEn(String tEn) {
            this.tEn = tEn;
        }

        public int getUa() {
            return ua;
        }

        public void setUa(int ua) {
            this.ua = ua;
        }

        public int getWantedCount() {
            return wantedCount;
        }

        public void setWantedCount(int wantedCount) {
            this.wantedCount = wantedCount;
        }

        public List<String> getP() {
            return p;
        }

        public void setP(List<String> p) {
            this.p = p;
        }

        public List<VersionsBean> getVersions() {
            return versions;
        }

        public void setVersions(List<VersionsBean> versions) {
            this.versions = versions;
        }

        public static class VersionsBean {

            @JSONField(name = "enum")
            private int enumX;
            private String version;

            public int getEnumX() {
                return enumX;
            }

            public void setEnumX(int enumX) {
                this.enumX = enumX;
            }

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }
        }
    }
}
