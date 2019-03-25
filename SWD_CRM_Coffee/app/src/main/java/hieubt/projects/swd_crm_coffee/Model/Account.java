package hieubt.projects.swd_crm_coffee.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Account {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("account_level")
    @Expose
    private Integer accountLevel;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("balance")
    @Expose
    private Integer balance;
    @SerializedName("brand_code")
    @Expose
    private String brandCode;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("end_date")
    @Expose
    private String endDate;
    @SerializedName("membership_id")
    @Expose
    private Integer membershipId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("policy")
    @Expose
    private Integer policy;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("membership")
    @Expose
    private Object membership;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Object getMembership() {
        return membership;
    }

    public void setMembership(Object membership) {
        this.membership = membership;
    }
}
