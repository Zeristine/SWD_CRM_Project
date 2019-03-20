package hieubt.projects.swd_crm_coffee.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Membership {
    @SerializedName("extended_code")
    @Expose
    private String extendedCode;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("brand_code")
    @Expose
    private String brandCode;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("created_at_store_code")
    @Expose
    private String createdAtStoreCode;
    @SerializedName("created_by")
    @Expose
    private String createdBy;
    @SerializedName("created_time")
    @Expose
    private String createdTime;
    @SerializedName("customer_code")
    @Expose
    private String customerCode;
    @SerializedName("initial_value")
    @Expose
    private Integer initialValue;
    @SerializedName("is_sample")
    @Expose
    private Boolean isSample;
    @SerializedName("membership_level")
    @Expose
    private Object membershipLevel;
    @SerializedName("membership_type_id")
    @Expose
    private Integer membershipTypeId;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("membership_type")
    @Expose
    private Object membershipType;
    @SerializedName("account")
    @Expose
    private Object account;
    @SerializedName("customer")
    @Expose
    private Object customer;

    public String getExtendedCode() {
        return extendedCode;
    }

    public void setExtendedCode(String extendedCode) {
        this.extendedCode = extendedCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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

    public String getCreatedAtStoreCode() {
        return createdAtStoreCode;
    }

    public void setCreatedAtStoreCode(String createdAtStoreCode) {
        this.createdAtStoreCode = createdAtStoreCode;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Integer getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(Integer initialValue) {
        this.initialValue = initialValue;
    }

    public Boolean getIsSample() {
        return isSample;
    }

    public void setIsSample(Boolean isSample) {
        this.isSample = isSample;
    }

    public Object getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(Object membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    public Integer getMembershipTypeId() {
        return membershipTypeId;
    }

    public void setMembershipTypeId(Integer membershipTypeId) {
        this.membershipTypeId = membershipTypeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(Object membershipType) {
        this.membershipType = membershipType;
    }

    public Object getAccount() {
        return account;
    }

    public void setAccount(Object account) {
        this.account = account;
    }

    public Object getCustomer() {
        return customer;
    }

    public void setCustomer(Object customer) {
        this.customer = customer;
    }
}
