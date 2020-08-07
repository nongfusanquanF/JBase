package com.geya.jbase.constant;

public class BaseBean {

    /**
     * PageIndex : page
     * PageSize : page_size
     * IsString : true
     * IntCodes : 200
     * IsSuccess : retcode
     * Message : message
     * ListDatas : data
     * AgainLogin : -888
     * Address : http://www.syiptv.com/api/v1
     */

    private String PageIndex;
    private String PageSize;
    private boolean IsString;
    private String IntCodes;
    private String IsSuccess;
    private String Message;
    private String ListDatas;
    private String AgainLogin;
    private String Address;

    public String getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(String PageIndex) {
        this.PageIndex = PageIndex;
    }

    public String getPageSize() {
        return PageSize;
    }

    public void setPageSize(String PageSize) {
        this.PageSize = PageSize;
    }

    public boolean isIsString() {
        return IsString;
    }

    public void setIsString(boolean IsString) {
        this.IsString = IsString;
    }

    public String getIntCodes() {
        return IntCodes;
    }

    public void setIntCodes(String IntCodes) {
        this.IntCodes = IntCodes;
    }

    public String getIsSuccess() {
        return IsSuccess;
    }

    public void setIsSuccess(String IsSuccess) {
        this.IsSuccess = IsSuccess;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public String getListDatas() {
        return ListDatas;
    }

    public void setListDatas(String ListDatas) {
        this.ListDatas = ListDatas;
    }

    public String getAgainLogin() {
        return AgainLogin;
    }

    public void setAgainLogin(String AgainLogin) {
        this.AgainLogin = AgainLogin;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "PageIndex='" + PageIndex + '\'' +
                ", PageSize='" + PageSize + '\'' +
                ", IsString=" + IsString +
                ", IntCodes='" + IntCodes + '\'' +
                ", IsSuccess='" + IsSuccess + '\'' +
                ", Message='" + Message + '\'' +
                ", ListDatas='" + ListDatas + '\'' +
                ", AgainLogin='" + AgainLogin + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
