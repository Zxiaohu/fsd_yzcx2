package com.fsd.owner.property.model.bean;

/**
 * Created by zxh on 2016/2/23.
 */
public class UserAllInfo {
    private int flag;
    private String info;
    /**面积**/
    private String chargearea;
    /**物业费单价**/
    private String unitprice;
    /**物业费月缴费额**/
    private String administratesum;
    /**物业费到期时间**/
    private String moneyenddate;
    /**第二个联系方式**/
    private String faxnumber;
    /**电子邮箱***/
    private String email;
    /**默认登录密码***/
    private String loginpassword;
    /***备注***/
    private String ramak;
    /***预存水费**/
    private String WaterBalance;
    /***预存电费**/
    private String ElectricBalance;
    /**房间的类型**/
    private String ResidentType;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getChargearea() {
        return chargearea;
    }

    public void setChargearea(String chargearea) {
        this.chargearea = chargearea;
    }

    public String getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(String unitprice) {
        this.unitprice = unitprice;
    }

    public String getAdministratesum() {
        return administratesum;
    }

    public void setAdministratesum(String administratesum) {
        this.administratesum = administratesum;
    }

    public String getMoneyenddate() {
        return moneyenddate;
    }

    public void setMoneyenddate(String moneyenddate) {
        this.moneyenddate = moneyenddate;
    }

    public String getFaxnumber() {
        return faxnumber;
    }

    public void setFaxnumber(String faxnumber) {
        this.faxnumber = faxnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginpassword() {
        return loginpassword;
    }

    public void setLoginpassword(String loginpassword) {
        this.loginpassword = loginpassword;
    }

    public String getRamak() {
        return ramak;
    }

    public void setRamak(String ramak) {
        this.ramak = ramak;
    }

    public String getWaterBalance() {
        return WaterBalance;
    }

    public void setWaterBalance(String waterBalance) {
        WaterBalance = waterBalance;
    }

    public String getElectricBalance() {
        return ElectricBalance;
    }

    public void setElectricBalance(String electricBalance) {
        ElectricBalance = electricBalance;
    }

    public String getResidentType() {
        return ResidentType;
    }

    public void setResidentType(String residentType) {
        ResidentType = residentType;
    }
}
