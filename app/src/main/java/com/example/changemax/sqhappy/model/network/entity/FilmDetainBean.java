package com.example.changemax.sqhappy.model.network.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by ChangeMax on 2017/3/14.
 * 电影详情
 */

public class FilmDetainBean {







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


    public static class DataBean implements MultiItemEntity {
        /**
         * advertisement : {"advList":[{"advTag":"","endDate":1514649599,"isHorizontalScreen":false,"isOpenH5":false,"startDate":1451577600,"tag":"商城3c+商城美女与野兽","type":"203","typeName":"影片详情页banner2","url":"https://static4da.mtime.cn/feature/mobile/banner/2017/0317/3cmvyys750210m.html"}],"count":1,"error":"","success":true}
         * basic : {"actors":[{"actorId":913378,"img":"http://img31.mtime.cn/ph/2014/09/01/170748.64755972_1280X720X2.jpg","name":"范·迪塞尔","nameEn":"Vin Diesel","roleImg":"http://img5.mtime.cn/mg/2017/01/05/162613.85098094.jpg","roleName":"桑德·凯奇"},{"actorId":893008,"img":"http://img31.mtime.cn/ph/2014/03/13/164116.22404345_1280X720X2.jpg","name":"甄子丹","nameEn":"Donnie Yen","roleImg":"http://img5.mtime.cn/mg/2017/01/05/162631.30237748.jpg","roleName":"项"},{"actorId":1403701,"img":"http://img31.mtime.cn/ph/2016/04/05/153734.26333599_1280X720X2.jpg","name":"迪皮卡·帕度柯妮","nameEn":"Deepika Padukone","roleImg":"http://img5.mtime.cn/mg/2017/01/05/163611.99195116.jpg","roleName":"赛琳娜"},{"actorId":1763914,"img":"http://img5.mtime.cn/ph/2017/02/08/172048.77104443_1280X720X2.jpg","name":"鲁比·罗丝","nameEn":"Ruby Rose","roleImg":"http://img5.mtime.cn/mg/2017/01/05/162801.28633700.jpg","roleName":"阿黛尔"},{"actorId":1981491,"img":"http://img31.mtime.cn/ph/2016/06/15/141117.21300390_1280X720X2.jpg","name":"吴亦凡","nameEn":"Kris Wu","roleImg":"http://img5.mtime.cn/mg/2017/01/05/162650.25424635.jpg","roleName":"DJ尼克斯"},{"actorId":1266158,"img":"http://img31.mtime.cn/ph/2016/05/04/162943.45619387_1280X720X2.jpg","name":"妮娜·杜波夫","nameEn":"Nina Dobrev","roleImg":"http://img5.mtime.cn/mg/2017/01/05/163459.85286563.jpg","roleName":"贝基"},{"actorId":913101,"img":"http://img31.mtime.cn/ph/2014/03/14/152328.88324192_1280X720X2.jpg","name":"塞缪尔·杰克逊","nameEn":"Samuel L. Jackson","roleImg":"http://img5.mtime.cn/mg/2017/02/09/143611.45346521.jpg","roleName":"吉布森"},{"actorId":938310,"img":"http://img31.mtime.cn/ph/2014/02/22/202102.28239250_1280X720X2.jpg","name":"托尼·贾","nameEn":"Tony Jaa","roleImg":"http://img5.mtime.cn/mg/2017/01/05/163434.84663336.jpg","roleName":"塔隆"},{"actorId":915029,"img":"http://img5.mtime.cn/ph/2017/01/12/165011.48068899_1280X720X2.jpg","name":"托妮·科莱特","nameEn":"Toni Collette","roleImg":"http://img5.mtime.cn/mg/2017/01/05/163402.87655748.jpg","roleName":"马珂"},{"actorId":926008,"img":"http://img31.mtime.cn/ph/2016/04/07/144735.68017937_1280X720X2.jpg","name":"罗伊·麦克凯恩","nameEn":"Rory McCann","roleImg":"http://img5.mtime.cn/mg/2017/01/05/163308.86236332.jpg","roleName":"泰尼逊"},{"actorId":2201494,"img":"http://img5.mtime.cn/ph/2016/11/02/092530.84997401_1280X720X2.jpg","name":"尼基·詹姆","nameEn":"Nicky Jam","roleImg":"http://img5.mtime.cn/mg/2017/01/05/163152.53635568.jpg","roleName":"拉撒路"},{"actorId":1416487,"img":"http://img31.mtime.cn/ph/2016/08/29/184141.26902742_1280X720X2.jpg","name":"迈克尔·比斯平","nameEn":"Michael Bisping","roleImg":"http://img5.mtime.cn/mg/2017/01/05/163040.43362207.jpg","roleName":"霍克"},{"actorId":2098727,"img":"http://img31.mtime.cn/ph/2015/07/01/114143.59711468_1280X720X2.jpg","name":"内马尔","nameEn":"Neymar","roleImg":"http://img5.mtime.cn/mg/2017/01/05/163524.98203922.jpg","roleName":"内马尔"},{"actorId":903983,"img":"http://img31.mtime.cn/ph/2014/02/22/194147.64436994_1280X720X2.jpg","name":"艾斯·库珀","nameEn":"Ice Cube","roleImg":"","roleName":"达里斯"},{"actorId":2084677,"img":"http://img31.mtime.cn/ph/2015/09/09/101940.19419320_1280X720X2.jpg","name":"赫敏·科菲尔德","nameEn":"Hermione Corfield","roleImg":"","roleName":"安斯利"},{"actorId":921201,"img":"http://img31.mtime.cn/ph/2014/04/15/111254.75720606_1280X720X2.jpg","name":"艾尔·斯帕恩扎","nameEn":"Al Sapienza","roleImg":"","roleName":"CIA Director"},{"actorId":1232892,"img":"http://img5.mtime.cn/ph/2017/01/05/145035.65755647_1280X720X2.jpg","name":"","nameEn":"Helena-Alexis Seymour","roleImg":"","roleName":"Ainsley's Girls"},{"actorId":2218074,"img":"http://img31.mtime.cn/ph/2016/08/29/184313.10828827_1280X720X2.jpg","name":"","nameEn":"Megan Soo","roleImg":"","roleName":"Ainsley's Girls"},{"actorId":2218075,"img":"http://img5.mtime.cn/ph/2017/01/05/144739.37346974_1280X720X2.jpg","name":"","nameEn":"Kristen Kurnik","roleImg":"","roleName":"Ainsley's Girls"},{"actorId":1023991,"img":"http://img5.mtime.cn/ph/2017/01/05/144625.10720932_1280X720X2.jpg","name":"","nameEn":"Gary 'Si-Jo' Foo","roleImg":"","roleName":"NSA Contractor       (uncredited)"}],"award":{"awardList":[],"totalNominateAward":0,"totalWinAward":0},"commentSpecial":"中国功夫PK极限运动","community":{},"director":{"directorId":903521,"img":"http://img5.mtime.cn/ph/2017/02/17/182200.43454182_1280X720X2.jpg","name":"D·J·卡卢索","nameEn":"D.J. Caruso"},"festivals":[],"hotRanking":-1,"img":"http://img5.mtime.cn/mt/2017/01/05/105822.16893974_1280X720X2.jpg","is3D":true,"isDMAX":true,"isEggHunt":false,"isFilter":false,"isIMAX":false,"isIMAX3D":true,"isTicket":true,"message":"该操作将清除您对该片的评分！是否确认？","mins":"107分钟","movieId":125805,"name":"极限特工：终极回归","nameEn":"xXx: The Return of Xander Cage","overallRating":6.7,"personCount":205,"quizGame":{},"releaseArea":"中国","releaseDate":"20170210","showCinemaCount":20,"showDay":1489996800,"showtimeCount":42,"stageImg":{"count":194,"list":[{"imgId":7176277,"imgUrl":"http://img31.mtime.cn/pi/2016/02/23/094309.19731831_1280X720X2.jpg"},{"imgId":7326885,"imgUrl":"http://img5.mtime.cn/pi/2017/01/25/165612.20210487_1280X720X2.jpg"},{"imgId":7326886,"imgUrl":"http://img5.mtime.cn/pi/2017/01/25/165620.12577306_1280X720X2.jpg"},{"imgId":7326887,"imgUrl":"http://img5.mtime.cn/pi/2017/01/25/165625.43047270_1280X720X2.jpg"}]},"story":"范·迪塞尔扮演的桑德·凯奇在被认为已经死亡后又奇迹般归来，极度危险的反派研制出了能够毁灭世界的终极武器，在这一大危机下，凯奇重出江湖，并招募了一支各有所长、热爱刺激的团队。他们与甄子丹领衔的另一队人马争夺一个叫做\u201c潘多拉魔盒\u201d的武器，最终一起携手拯救世界。才华横溢的导演D·J·卡卢索动作场景拍得非常精彩，其中包括滑滑板下坡的镜头、摩托车冲浪的场景、一场徒步高速公路追逐戏、零重力飞机上的搏斗片段，还有可以终结一切枪战的boss级枪战。","style":{"isLeadPage":0,"leadImg":"https://img2.mtime.cn/mg/.jpg","leadUrl":""},"totalNominateAward":0,"totalWinAward":0,"type":["动作","冒险","惊悚"],"url":"https://movie.mtime.com/125805/","video":{"count":40,"hightUrl":"https://vfx.mtime.cn/Video/2017/01/05/mp4/170105105137886980.mp4","img":"http://img5.mtime.cn/mg/2017/01/05/105124.57142324_235X132X4.jpg","title":"极限特工：终极回归 中国版预告片","url":"https://vfx.mtime.cn/Video/2017/01/05/mp4/170105105137886980_480.mp4","videoId":64107}}
         * boxOffice : {"movieId":125805,"ranking":10,"todayBox":6289045,"todayBoxDes":"6.29","todayBoxDesUnit":"今日实时(万)","totalBox":111941954627,"totalBoxDes":"11.19","totalBoxUnit":"累计票房(亿)"}
         * live : {"count":1,"img":"http://img5.mtime.cn/mg/2017/02/04/165331.18709160.jpg","liveId":224,"playNumTag":"82.3万次播放","playTag":"","status":4,"title":"电影《极限特工：终极回归》中国首映礼"}
         * related : {"goodsCount":0,"goodsList":[],"relateId":0,"relatedUrl":"https://mall-wv.mtime.cn/#!/commerce/list/","type":0}
         */

        private AdvertisementBean advertisement;
        private BasicBean basic;
        private BoxOfficeBean boxOffice;
        private LiveBean live;
        private RelatedBean related;



        private int itemtype=1;
        public AdvertisementBean getAdvertisement() {
            return advertisement;
        }

        public void setAdvertisement(AdvertisementBean advertisement) {
            this.advertisement = advertisement;
        }

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public BoxOfficeBean getBoxOffice() {
            return boxOffice;
        }

        public void setBoxOffice(BoxOfficeBean boxOffice) {
            this.boxOffice = boxOffice;
        }

        public LiveBean getLive() {
            return live;
        }

        public void setLive(LiveBean live) {
            this.live = live;
        }

        public RelatedBean getRelated() {
            return related;
        }

        public void setRelated(RelatedBean related) {
            this.related = related;
        }

        @Override
        public int getItemType() {
            return itemtype;
        }
        public void setItemtype(int itemtype) {
            this.itemtype = itemtype;
        }

        public static class AdvertisementBean {
            /**
             * advList : [{"advTag":"","endDate":1514649599,"isHorizontalScreen":false,"isOpenH5":false,"startDate":1451577600,"tag":"商城3c+商城美女与野兽","type":"203","typeName":"影片详情页banner2","url":"https://static4da.mtime.cn/feature/mobile/banner/2017/0317/3cmvyys750210m.html"}]
             * count : 1
             * error :
             * success : true
             */

            private int count;
            private String error;
            private boolean success;
            private List<AdvListBean> advList;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getError() {
                return error;
            }

            public void setError(String error) {
                this.error = error;
            }

            public boolean isSuccess() {
                return success;
            }

            public void setSuccess(boolean success) {
                this.success = success;
            }

            public List<AdvListBean> getAdvList() {
                return advList;
            }

            public void setAdvList(List<AdvListBean> advList) {
                this.advList = advList;
            }

            public static class AdvListBean {
                /**
                 * advTag :
                 * endDate : 1514649599
                 * isHorizontalScreen : false
                 * isOpenH5 : false
                 * startDate : 1451577600
                 * tag : 商城3c+商城美女与野兽
                 * type : 203
                 * typeName : 影片详情页banner2
                 * url : https://static4da.mtime.cn/feature/mobile/banner/2017/0317/3cmvyys750210m.html
                 */

                private String advTag;
                private int endDate;
                private boolean isHorizontalScreen;
                private boolean isOpenH5;
                private int startDate;
                private String tag;
                private String type;
                private String typeName;
                private String url;

                public String getAdvTag() {
                    return advTag;
                }

                public void setAdvTag(String advTag) {
                    this.advTag = advTag;
                }

                public int getEndDate() {
                    return endDate;
                }

                public void setEndDate(int endDate) {
                    this.endDate = endDate;
                }

                public boolean isIsHorizontalScreen() {
                    return isHorizontalScreen;
                }

                public void setIsHorizontalScreen(boolean isHorizontalScreen) {
                    this.isHorizontalScreen = isHorizontalScreen;
                }

                public boolean isIsOpenH5() {
                    return isOpenH5;
                }

                public void setIsOpenH5(boolean isOpenH5) {
                    this.isOpenH5 = isOpenH5;
                }

                public int getStartDate() {
                    return startDate;
                }

                public void setStartDate(int startDate) {
                    this.startDate = startDate;
                }

                public String getTag() {
                    return tag;
                }

                public void setTag(String tag) {
                    this.tag = tag;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getTypeName() {
                    return typeName;
                }

                public void setTypeName(String typeName) {
                    this.typeName = typeName;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }

        public static class BasicBean {


            private AwardBean award;
            private String commentSpecial;
            private CommunityBean community;
            private DirectorBean director;
            private int hotRanking;
            private String img;
            private boolean is3D;
            private boolean isDMAX;
            private boolean isEggHunt;
            private boolean isFilter;
            private boolean isIMAX;
            private boolean isIMAX3D;
            private boolean isTicket;
            private String message;
            private String mins;
            private int movieId;
            private String name;
            private String nameEn;
            private double overallRating;
            private int personCount;
            private QuizGameBean quizGame;
            private String releaseArea;
            private String releaseDate;
            private int showCinemaCount;
            private int showDay;
            private int showtimeCount;
            private StageImgBean stageImg;
            private String story;
            private StyleBean style;
            private int totalNominateAward;
            private int totalWinAward;
            private String url;
            private VideoBean video;
            private List<ActorsBean> actors;
            private List<?> festivals;
            private List<String> type;

            public AwardBean getAward() {
                return award;
            }

            public void setAward(AwardBean award) {
                this.award = award;
            }

            public String getCommentSpecial() {
                return commentSpecial;
            }

            public void setCommentSpecial(String commentSpecial) {
                this.commentSpecial = commentSpecial;
            }

            public CommunityBean getCommunity() {
                return community;
            }

            public void setCommunity(CommunityBean community) {
                this.community = community;
            }

            public DirectorBean getDirector() {
                return director;
            }

            public void setDirector(DirectorBean director) {
                this.director = director;
            }

            public int getHotRanking() {
                return hotRanking;
            }

            public void setHotRanking(int hotRanking) {
                this.hotRanking = hotRanking;
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

            public boolean isIsEggHunt() {
                return isEggHunt;
            }

            public void setIsEggHunt(boolean isEggHunt) {
                this.isEggHunt = isEggHunt;
            }

            public boolean isIsFilter() {
                return isFilter;
            }

            public void setIsFilter(boolean isFilter) {
                this.isFilter = isFilter;
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

            public boolean isIsTicket() {
                return isTicket;
            }

            public void setIsTicket(boolean isTicket) {
                this.isTicket = isTicket;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public String getMins() {
                return mins;
            }

            public void setMins(String mins) {
                this.mins = mins;
            }

            public int getMovieId() {
                return movieId;
            }

            public void setMovieId(int movieId) {
                this.movieId = movieId;
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

            public double getOverallRating() {
                return overallRating;
            }

            public void setOverallRating(double overallRating) {
                this.overallRating = overallRating;
            }

            public int getPersonCount() {
                return personCount;
            }

            public void setPersonCount(int personCount) {
                this.personCount = personCount;
            }

            public QuizGameBean getQuizGame() {
                return quizGame;
            }

            public void setQuizGame(QuizGameBean quizGame) {
                this.quizGame = quizGame;
            }

            public String getReleaseArea() {
                return releaseArea;
            }

            public void setReleaseArea(String releaseArea) {
                this.releaseArea = releaseArea;
            }

            public String getReleaseDate() {
                return releaseDate;
            }

            public void setReleaseDate(String releaseDate) {
                this.releaseDate = releaseDate;
            }

            public int getShowCinemaCount() {
                return showCinemaCount;
            }

            public void setShowCinemaCount(int showCinemaCount) {
                this.showCinemaCount = showCinemaCount;
            }

            public int getShowDay() {
                return showDay;
            }

            public void setShowDay(int showDay) {
                this.showDay = showDay;
            }

            public int getShowtimeCount() {
                return showtimeCount;
            }

            public void setShowtimeCount(int showtimeCount) {
                this.showtimeCount = showtimeCount;
            }

            public StageImgBean getStageImg() {
                return stageImg;
            }

            public void setStageImg(StageImgBean stageImg) {
                this.stageImg = stageImg;
            }

            public String getStory() {
                return story;
            }

            public void setStory(String story) {
                this.story = story;
            }

            public StyleBean getStyle() {
                return style;
            }

            public void setStyle(StyleBean style) {
                this.style = style;
            }

            public int getTotalNominateAward() {
                return totalNominateAward;
            }

            public void setTotalNominateAward(int totalNominateAward) {
                this.totalNominateAward = totalNominateAward;
            }

            public int getTotalWinAward() {
                return totalWinAward;
            }

            public void setTotalWinAward(int totalWinAward) {
                this.totalWinAward = totalWinAward;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public VideoBean getVideo() {
                return video;
            }

            public void setVideo(VideoBean video) {
                this.video = video;
            }

            public List<ActorsBean> getActors() {
                return actors;
            }

            public void setActors(List<ActorsBean> actors) {
                this.actors = actors;
            }

            public List<?> getFestivals() {
                return festivals;
            }

            public void setFestivals(List<?> festivals) {
                this.festivals = festivals;
            }

            public List<String> getType() {
                return type;
            }

            public void setType(List<String> type) {
                this.type = type;
            }

            public static class AwardBean {
            }

            public static class CommunityBean {
            }

            public static class DirectorBean {
                public int getDirectorId() {
                    return directorId;
                }

                public void setDirectorId(int directorId) {
                    this.directorId = directorId;
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

                /**
                 * "directorId":903521,"img":"http://img5.mtime.cn/ph/2017/02/17/182200.43454182_1280X720X2.jpg","name":"D·J·卡卢索","nameEn":"D.J. Caruso"
                 */
                private int directorId;
                private String img;
                private String name;
                private String nameEn;
            }

            public static class QuizGameBean {
            }

            public static class StageImgBean {
                /**
                 * count : 194
                 * list : [{"imgId":7176277,"imgUrl":"http://img31.mtime.cn/pi/2016/02/23/094309.19731831_1280X720X2.jpg"},{"imgId":7326885,"imgUrl":"http://img5.mtime.cn/pi/2017/01/25/165612.20210487_1280X720X2.jpg"},{"imgId":7326886,"imgUrl":"http://img5.mtime.cn/pi/2017/01/25/165620.12577306_1280X720X2.jpg"},{"imgId":7326887,"imgUrl":"http://img5.mtime.cn/pi/2017/01/25/165625.43047270_1280X720X2.jpg"}]
                 */

                private int count;
                private List<ListBean> list;

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public List<ListBean> getList() {
                    return list;
                }

                public void setList(List<ListBean> list) {
                    this.list = list;
                }

                public static class ListBean {
                    /**
                     * imgId : 7176277
                     * imgUrl : http://img31.mtime.cn/pi/2016/02/23/094309.19731831_1280X720X2.jpg
                     */

                    private int imgId;
                    private String imgUrl;

                    public int getImgId() {
                        return imgId;
                    }

                    public void setImgId(int imgId) {
                        this.imgId = imgId;
                    }

                    public String getImgUrl() {
                        return imgUrl;
                    }

                    public void setImgUrl(String imgUrl) {
                        this.imgUrl = imgUrl;
                    }
                }
            }

            public static class StyleBean {
                /**
                 * isLeadPage : 0
                 * leadImg : https://img2.mtime.cn/mg/.jpg
                 * leadUrl :
                 */

                private int isLeadPage;
                private String leadImg;
                private String leadUrl;

                public int getIsLeadPage() {
                    return isLeadPage;
                }

                public void setIsLeadPage(int isLeadPage) {
                    this.isLeadPage = isLeadPage;
                }

                public String getLeadImg() {
                    return leadImg;
                }

                public void setLeadImg(String leadImg) {
                    this.leadImg = leadImg;
                }

                public String getLeadUrl() {
                    return leadUrl;
                }

                public void setLeadUrl(String leadUrl) {
                    this.leadUrl = leadUrl;
                }
            }

            public static class VideoBean {
                /**
                 * count : 40
                 * hightUrl : https://vfx.mtime.cn/Video/2017/01/05/mp4/170105105137886980.mp4
                 * img : http://img5.mtime.cn/mg/2017/01/05/105124.57142324_235X132X4.jpg
                 * title : 极限特工：终极回归 中国版预告片
                 * url : https://vfx.mtime.cn/Video/2017/01/05/mp4/170105105137886980_480.mp4
                 * videoId : 64107
                 */

                private int count;
                private String hightUrl;
                private String img;
                private String title;
                private String url;
                private int videoId;

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public String getHightUrl() {
                    return hightUrl;
                }

                public void setHightUrl(String hightUrl) {
                    this.hightUrl = hightUrl;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getVideoId() {
                    return videoId;
                }

                public void setVideoId(int videoId) {
                    this.videoId = videoId;
                }
            }

            public static class ActorsBean implements MultiItemEntity {
                /**
                 * actorId : 913378
                 * img : http://img31.mtime.cn/ph/2014/09/01/170748.64755972_1280X720X2.jpg
                 * name : 范·迪塞尔
                 * nameEn : Vin Diesel
                 * roleImg : http://img5.mtime.cn/mg/2017/01/05/162613.85098094.jpg
                 * roleName : 桑德·凯奇
                 */
                public static final int ACTOR = 1;
                public static final int DIRECTOR = 2;
                private int actorId;
                private String img;
                private String name;
                private String nameEn;
                private String roleImg;
                private String roleName;

                public void setItemtype(int itemtype) {
                    this.itemtype = itemtype;
                }

                private int itemtype=2;
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
        }

        public static class BoxOfficeBean {
            /**
             * movieId : 125805
             * ranking : 10
             * todayBox : 6289045
             * todayBoxDes : 6.29
             * todayBoxDesUnit : 今日实时(万)
             * totalBox : 111941954627
             * totalBoxDes : 11.19
             * totalBoxUnit : 累计票房(亿)
             */

            private int movieId;
            private int ranking;
            private int todayBox;
            private String todayBoxDes;
            private String todayBoxDesUnit;
            private long totalBox;
            private String totalBoxDes;
            private String totalBoxUnit;

            public int getMovieId() {
                return movieId;
            }

            public void setMovieId(int movieId) {
                this.movieId = movieId;
            }

            public int getRanking() {
                return ranking;
            }

            public void setRanking(int ranking) {
                this.ranking = ranking;
            }

            public int getTodayBox() {
                return todayBox;
            }

            public void setTodayBox(int todayBox) {
                this.todayBox = todayBox;
            }

            public String getTodayBoxDes() {
                return todayBoxDes;
            }

            public void setTodayBoxDes(String todayBoxDes) {
                this.todayBoxDes = todayBoxDes;
            }

            public String getTodayBoxDesUnit() {
                return todayBoxDesUnit;
            }

            public void setTodayBoxDesUnit(String todayBoxDesUnit) {
                this.todayBoxDesUnit = todayBoxDesUnit;
            }

            public long getTotalBox() {
                return totalBox;
            }

            public void setTotalBox(long totalBox) {
                this.totalBox = totalBox;
            }

            public String getTotalBoxDes() {
                return totalBoxDes;
            }

            public void setTotalBoxDes(String totalBoxDes) {
                this.totalBoxDes = totalBoxDes;
            }

            public String getTotalBoxUnit() {
                return totalBoxUnit;
            }

            public void setTotalBoxUnit(String totalBoxUnit) {
                this.totalBoxUnit = totalBoxUnit;
            }
        }

        public static class LiveBean {
            /**
             * count : 1
             * img : http://img5.mtime.cn/mg/2017/02/04/165331.18709160.jpg
             * liveId : 224
             * playNumTag : 82.3万次播放
             * playTag :
             * status : 4
             * title : 电影《极限特工：终极回归》中国首映礼
             */

            private int count;
            private String img;
            private int liveId;
            private String playNumTag;
            private String playTag;
            private int status;
            private String title;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public int getLiveId() {
                return liveId;
            }

            public void setLiveId(int liveId) {
                this.liveId = liveId;
            }

            public String getPlayNumTag() {
                return playNumTag;
            }

            public void setPlayNumTag(String playNumTag) {
                this.playNumTag = playNumTag;
            }

            public String getPlayTag() {
                return playTag;
            }

            public void setPlayTag(String playTag) {
                this.playTag = playTag;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public static class RelatedBean {
            /**
             * goodsCount : 0
             * goodsList : []
             * relateId : 0
             * relatedUrl : https://mall-wv.mtime.cn/#!/commerce/list/
             * type : 0
             */

            private int goodsCount;
            private int relateId;
            private String relatedUrl;
            private int type;
            private List<?> goodsList;

            public int getGoodsCount() {
                return goodsCount;
            }

            public void setGoodsCount(int goodsCount) {
                this.goodsCount = goodsCount;
            }

            public int getRelateId() {
                return relateId;
            }

            public void setRelateId(int relateId) {
                this.relateId = relateId;
            }

            public String getRelatedUrl() {
                return relatedUrl;
            }

            public void setRelatedUrl(String relatedUrl) {
                this.relatedUrl = relatedUrl;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public List<?> getGoodsList() {
                return goodsList;
            }

            public void setGoodsList(List<?> goodsList) {
                this.goodsList = goodsList;
            }
        }
    }
}
