package com.appbyme.jbase.data;

import java.util.List;

/**
 * Created by Administrator on 2018/6/8 0008.
 */

public class ListData2 {


    /**
     * retcode : 200
     * massage : 数据读取成功！
     * data : [{"id":30,"title":"测试5.14","descrip":"<p>简介简介简介<\/p>","schoolid":57,"gradeid":105,"classid":263,"url":"www.baidu.com","listorder":99,"price":"5.00","cover":"http://www.newzhihuishijiesy.com/uploads/image/20180514/live2.png","subjectsid":0,"starttime":"2018-05-14 15:03:09","play_num":"0","agree_num":"0","state":1},{"id":29,"title":"测试测试测试测试测试测试","descrip":"<p>hfisdhjiofisdifiogio<\/p>","schoolid":57,"gradeid":105,"classid":263,"url":"www.baidu.com","listorder":99,"price":"10.00","cover":"http://www.newzhihuishijiesy.com/uploads/image/20180514/live2.png","subjectsid":0,"starttime":"2018-05-11 17:53:02","play_num":"0","agree_num":"0","state":1},{"id":28,"title":"测试测试","descrip":"大叔大婶大所","schoolid":58,"gradeid":106,"classid":289,"url":"http://127.0.0.1/smartcampus_server","listorder":0,"price":"400.00","cover":"http://www.newzhihuishijiesy.com/uploads/image/20180514/live2.png","subjectsid":2,"starttime":"2018-05-10 15:21:27","play_num":"0","agree_num":"0","state":0},{"id":27,"title":"大大","descrip":"<p>sdasfdfds<\/p>","schoolid":57,"gradeid":105,"classid":261,"url":"http://127.0.0.1/smartcampus_server","listorder":0,"price":"7.00","cover":"http://www.newzhihuishijiesy.com/uploads/image/20180514/live2.png","subjectsid":5,"starttime":"2018-05-10 16:32:29","play_num":"0","agree_num":"0","state":0},{"id":26,"title":"大大大","descrip":"大萨达撒大刚发的","schoolid":58,"gradeid":106,"classid":288,"url":"http://127.0.0.1/member/account","listorder":0,"price":"1300.00","cover":"http://www.newzhihuishijiesy.com/uploads/image/20180514/live2.png","subjectsid":5,"starttime":"2018-05-10 15:18:16","play_num":"0","agree_num":"0","state":1}]
     */

    private int retcode;
    private String massage;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "ListData2{" +
                "retcode=" + retcode +
                ", massage='" + massage + '\'' +
                ", data=" + data +
                '}';
    }

    public int getRetcode() {
        return retcode;
    }

    public void setRetcode(int retcode) {
        this.retcode = retcode;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 30
         * title : 测试5.14
         * descrip : <p>简介简介简介</p>
         * schoolid : 57
         * gradeid : 105
         * classid : 263
         * url : www.baidu.com
         * listorder : 99
         * price : 5.00
         * cover : http://www.newzhihuishijiesy.com/uploads/image/20180514/live2.png
         * subjectsid : 0
         * starttime : 2018-05-14 15:03:09
         * play_num : 0
         * agree_num : 0
         * state : 1
         */

        private int id;
        private String title;
        private String descrip;
        private int schoolid;
        private int gradeid;
        private int classid;
        private String url;
        private int listorder;
        private String price;
        private String cover;
        private int subjectsid;
        private String starttime;
        private String play_num;
        private String agree_num;
        private int state;

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", descrip='" + descrip + '\'' +
                    ", schoolid=" + schoolid +
                    ", gradeid=" + gradeid +
                    ", classid=" + classid +
                    ", url='" + url + '\'' +
                    ", listorder=" + listorder +
                    ", price='" + price + '\'' +
                    ", cover='" + cover + '\'' +
                    ", subjectsid=" + subjectsid +
                    ", starttime='" + starttime + '\'' +
                    ", play_num='" + play_num + '\'' +
                    ", agree_num='" + agree_num + '\'' +
                    ", state=" + state +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescrip() {
            return descrip;
        }

        public void setDescrip(String descrip) {
            this.descrip = descrip;
        }

        public int getSchoolid() {
            return schoolid;
        }

        public void setSchoolid(int schoolid) {
            this.schoolid = schoolid;
        }

        public int getGradeid() {
            return gradeid;
        }

        public void setGradeid(int gradeid) {
            this.gradeid = gradeid;
        }

        public int getClassid() {
            return classid;
        }

        public void setClassid(int classid) {
            this.classid = classid;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getListorder() {
            return listorder;
        }

        public void setListorder(int listorder) {
            this.listorder = listorder;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getSubjectsid() {
            return subjectsid;
        }

        public void setSubjectsid(int subjectsid) {
            this.subjectsid = subjectsid;
        }

        public String getStarttime() {
            return starttime;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }

        public String getPlay_num() {
            return play_num;
        }

        public void setPlay_num(String play_num) {
            this.play_num = play_num;
        }

        public String getAgree_num() {
            return agree_num;
        }

        public void setAgree_num(String agree_num) {
            this.agree_num = agree_num;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }
    }
}
