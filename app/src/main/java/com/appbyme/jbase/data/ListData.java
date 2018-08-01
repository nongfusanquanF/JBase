package com.appbyme.jbase.data;

import java.util.List;

/**
 * Created by Administrator on 2018/6/8 0008.
 */

public class ListData {


    /**
     * retcode : 200
     * massage : 数据读取成功！
     * data : [{"id":5,"title":"欢迎来到智慧世界","content":"<p>欢迎来到智慧世界！<\/p><p><br/><\/p>","type":1,"schoolid":58,"gradeid":0,"classesid":0,"createtime":"2018-06-02 16:52:24"}]
     */

    private int retcode;
    private String massage;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "ListData{" +
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
         * id : 5
         * title : 欢迎来到智慧世界
         * content : <p>欢迎来到智慧世界！</p><p><br/></p>
         * type : 1
         * schoolid : 58
         * gradeid : 0
         * classesid : 0
         * createtime : 2018-06-02 16:52:24
         */

        private int id;
        private String title;
        private String content;
        private int type;
        private int schoolid;
        private int gradeid;
        private int classesid;
        private String createtime;

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    ", type=" + type +
                    ", schoolid=" + schoolid +
                    ", gradeid=" + gradeid +
                    ", classesid=" + classesid +
                    ", createtime='" + createtime + '\'' +
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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
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

        public int getClassesid() {
            return classesid;
        }

        public void setClassesid(int classesid) {
            this.classesid = classesid;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }
    }
}
