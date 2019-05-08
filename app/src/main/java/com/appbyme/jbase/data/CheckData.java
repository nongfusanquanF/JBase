package com.appbyme.jbase.data;

import com.google.gson.annotations.SerializedName;

public class CheckData {


    /**
     * retcode : 200
     * ios : {"version":"2.0","image":"","url":"http://m.10yan.com","title":"伙计,有新版本更新啦","content":"IOS的版本更新提示现在不能使用了,现在先占位"}
     * android : {"version":"20036","image":"","url":"http://aisy.oss-cn-shanghai.aliyuncs.com/appdownload/app-2.1.15.apk","title":"有新版本更新啦","content":"若干细节优化及BUG修复！"}
     * ads : {"id":35,"type":"2","image":"http://syiptv-media-center.oss-cn-shanghai.aliyuncs.com/other/20190507/15572161477LBEFICO.png","title":"2019牡丹花海摄影大赛","url":"http://funcwaposs.syiptv.com/#/vote-v2/203"}
     * pop : {"title":"","image":"","url":""}
     * float : {"title":"","image":"","type":"","url":""}
     */

    private String retcode;
    private IosBean ios;
    private AndroidBean android;
    private AdsBean ads;
    private PopBean pop;
    @SerializedName("float")
    private FloatBean floatX;

    @Override
    public String toString() {
        return "CheckData{" +
                "retcode='" + retcode + '\'' +
                ", ios=" + ios +
                ", android=" + android +
                ", ads=" + ads +
                ", pop=" + pop +
                ", floatX=" + floatX +
                '}';
    }

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public IosBean getIos() {
        return ios;
    }

    public void setIos(IosBean ios) {
        this.ios = ios;
    }

    public AndroidBean getAndroid() {
        return android;
    }

    public void setAndroid(AndroidBean android) {
        this.android = android;
    }

    public AdsBean getAds() {
        return ads;
    }

    public void setAds(AdsBean ads) {
        this.ads = ads;
    }

    public PopBean getPop() {
        return pop;
    }

    public void setPop(PopBean pop) {
        this.pop = pop;
    }

    public FloatBean getFloatX() {
        return floatX;
    }

    public void setFloatX(FloatBean floatX) {
        this.floatX = floatX;
    }

    public static class IosBean {
        /**
         * version : 2.0
         * image :
         * url : http://m.10yan.com
         * title : 伙计,有新版本更新啦
         * content : IOS的版本更新提示现在不能使用了,现在先占位
         */

        private String version;
        private String image;
        private String url;
        private String title;
        private String content;

        @Override
        public String toString() {
            return "IosBean{" +
                    "version='" + version + '\'' +
                    ", image='" + image + '\'' +
                    ", url='" + url + '\'' +
                    ", title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public static class AndroidBean {
        /**
         * version : 20036
         * image :
         * url : http://aisy.oss-cn-shanghai.aliyuncs.com/appdownload/app-2.1.15.apk
         * title : 有新版本更新啦
         * content : 若干细节优化及BUG修复！
         */

        private String version;
        private String image;
        private String url;
        private String title;
        private String content;

        @Override
        public String toString() {
            return "AndroidBean{" +
                    "version='" + version + '\'' +
                    ", image='" + image + '\'' +
                    ", url='" + url + '\'' +
                    ", title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public static class AdsBean {
        /**
         * id : 35
         * type : 2
         * image : http://syiptv-media-center.oss-cn-shanghai.aliyuncs.com/other/20190507/15572161477LBEFICO.png
         * title : 2019牡丹花海摄影大赛
         * url : http://funcwaposs.syiptv.com/#/vote-v2/203
         */

        private int id;
        private String type;
        private String image;
        private String title;
        private String url;

        @Override
        public String toString() {
            return "AdsBean{" +
                    "id=" + id +
                    ", type='" + type + '\'' +
                    ", image='" + image + '\'' +
                    ", title='" + title + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
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
    }

    public static class PopBean {
        /**
         * title :
         * image :
         * url :
         */

        private String title;
        private String image;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class FloatBean {
        /**
         * title :
         * image :
         * type :
         * url :
         */

        private String title;
        private String image;
        private String type;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
