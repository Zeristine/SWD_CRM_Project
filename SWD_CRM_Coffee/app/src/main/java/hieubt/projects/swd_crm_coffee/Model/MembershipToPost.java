package hieubt.projects.swd_crm_coffee.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MembershipToPost {
    @SerializedName("include_accounts")
    @Expose
    private Boolean includeAccounts = true;
    @SerializedName("extended_code")
    @Expose
    private String extendedCode = "string";
    @SerializedName("active")
    @Expose
    private Boolean active = true;
    @SerializedName("brand_code")
    @Expose
    private String brandCode = "PASSIO";
    @SerializedName("code")
    @Expose
    private String code = "string";
    @SerializedName("emp_code")
    @Expose
    private String empCode = "string";
    @SerializedName("created_at_store_code")
    @Expose
    private String createdAtStoreCode = "string";
    @SerializedName("created_by")
    @Expose
    private String createdBy = "string";
    @SerializedName("created_time")
    @Expose
    private String createdTime = "2019-03-20T01:28:14.133";
    @SerializedName("customer_code")
    @Expose
    private String customerCode;
    @SerializedName("initial_value")
    @Expose
    private Integer initialValue = 0;
    @SerializedName("is_sample")
    @Expose
    private Boolean isSample = true;
    @SerializedName("status")
    @Expose
    private Integer status = 1;

    public MembershipToPost(String customerCode) {
        this.customerCode = customerCode;
    }

    public Boolean getIncludeAccounts() {
        return includeAccounts;
    }

    public void setIncludeAccounts(Boolean includeAccounts) {
        this.includeAccounts = includeAccounts;
    }

    public String getExtendedCode() {
        return extendedCode;
    }

    public void setExtendedCode(String extendedCode) {
        this.extendedCode = extendedCode;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public Boolean getSample() {
        return isSample;
    }

    public void setSample(Boolean sample) {
        isSample = sample;
    }

}
