package hieubt.projects.swd_crm_coffee.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountToPost {
    @SerializedName("account_level")
    @Expose
    private Integer accountLevel = 0;
    @SerializedName("active")
    @Expose
    private Boolean active = true;
    @SerializedName("balance")
    @Expose
    private Integer balance = 0;
    @SerializedName("brand_code")
    @Expose
    private String brandCode = "PASSIO";
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("end_date")
    @Expose
    private String endDate = "2019-03-20T01:28:14.133";
    @SerializedName("membership_id")
    @Expose
    private Integer membershipId = 1;
    @SerializedName("name")
    @Expose
    private String name = "string";
    @SerializedName("policy")
    @Expose
    private Integer policy = 0;
    @SerializedName("start_date")
    @Expose
    private String startDate = "2019-03-20T01:28:14.133";
    @SerializedName("type")
    @Expose
    private Integer type = 1;

    public Integer getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(Integer accountLevel) {
        this.accountLevel = accountLevel;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(Integer membershipId) {
        this.membershipId = membershipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPolicy() {
        return policy;
    }

    public void setPolicy(Integer policy) {
        this.policy = policy;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
