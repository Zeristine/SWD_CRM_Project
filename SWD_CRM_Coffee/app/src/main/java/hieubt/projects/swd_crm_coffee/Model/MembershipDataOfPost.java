package hieubt.projects.swd_crm_coffee.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MembershipDataOfPost {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("brand_code")
    @Expose
    private Object brandCode;
    @SerializedName("store_code")
    @Expose
    private String storeCode;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("creator")
    @Expose
    private Object creator;
    @SerializedName("detail_added_point")
    @Expose
    private Object detailAddedPoint;
    @SerializedName("detail_amount")
    @Expose
    private Object detailAmount;
    @SerializedName("detail_currency")
    @Expose
    private Object detailCurrency;
    @SerializedName("detail_rollback_of_event_code")
    @Expose
    private Object detailRollbackOfEventCode;
    @SerializedName("detail_from_level")
    @Expose
    private Object detailFromLevel;
    @SerializedName("detail_from_status")
    @Expose
    private Object detailFromStatus;
    @SerializedName("detail_from_type_id")
    @Expose
    private Object detailFromTypeId;
    @SerializedName("detail_gained_point")
    @Expose
    private Object detailGainedPoint;
    @SerializedName("detail_to_level")
    @Expose
    private Object detailToLevel;
    @SerializedName("detail_to_status")
    @Expose
    private Object detailToStatus;
    @SerializedName("detail_to_type_id")
    @Expose
    private Object detailToTypeId;
    @SerializedName("happened_time")
    @Expose
    private String happenedTime;
    @SerializedName("is_checked")
    @Expose
    private Object isChecked;
    @SerializedName("is_promo_checked")
    @Expose
    private Object isPromoChecked;
    @SerializedName("membership_code")
    @Expose
    private String membershipCode;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("account_code")
    @Expose
    private Object accountCode;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("description")
    @Expose
    private Object description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(Object brandCode) {
        this.brandCode = brandCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getCreator() {
        return creator;
    }

    public void setCreator(Object creator) {
        this.creator = creator;
    }

    public Object getDetailAddedPoint() {
        return detailAddedPoint;
    }

    public void setDetailAddedPoint(Object detailAddedPoint) {
        this.detailAddedPoint = detailAddedPoint;
    }

    public Object getDetailAmount() {
        return detailAmount;
    }

    public void setDetailAmount(Object detailAmount) {
        this.detailAmount = detailAmount;
    }

    public Object getDetailCurrency() {
        return detailCurrency;
    }

    public void setDetailCurrency(Object detailCurrency) {
        this.detailCurrency = detailCurrency;
    }

    public Object getDetailRollbackOfEventCode() {
        return detailRollbackOfEventCode;
    }

    public void setDetailRollbackOfEventCode(Object detailRollbackOfEventCode) {
        this.detailRollbackOfEventCode = detailRollbackOfEventCode;
    }

    public Object getDetailFromLevel() {
        return detailFromLevel;
    }

    public void setDetailFromLevel(Object detailFromLevel) {
        this.detailFromLevel = detailFromLevel;
    }

    public Object getDetailFromStatus() {
        return detailFromStatus;
    }

    public void setDetailFromStatus(Object detailFromStatus) {
        this.detailFromStatus = detailFromStatus;
    }

    public Object getDetailFromTypeId() {
        return detailFromTypeId;
    }

    public void setDetailFromTypeId(Object detailFromTypeId) {
        this.detailFromTypeId = detailFromTypeId;
    }

    public Object getDetailGainedPoint() {
        return detailGainedPoint;
    }

    public void setDetailGainedPoint(Object detailGainedPoint) {
        this.detailGainedPoint = detailGainedPoint;
    }

    public Object getDetailToLevel() {
        return detailToLevel;
    }

    public void setDetailToLevel(Object detailToLevel) {
        this.detailToLevel = detailToLevel;
    }

    public Object getDetailToStatus() {
        return detailToStatus;
    }

    public void setDetailToStatus(Object detailToStatus) {
        this.detailToStatus = detailToStatus;
    }

    public Object getDetailToTypeId() {
        return detailToTypeId;
    }

    public void setDetailToTypeId(Object detailToTypeId) {
        this.detailToTypeId = detailToTypeId;
    }

    public String getHappenedTime() {
        return happenedTime;
    }

    public void setHappenedTime(String happenedTime) {
        this.happenedTime = happenedTime;
    }

    public Object getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Object isChecked) {
        this.isChecked = isChecked;
    }

    public Object getIsPromoChecked() {
        return isPromoChecked;
    }

    public void setIsPromoChecked(Object isPromoChecked) {
        this.isPromoChecked = isPromoChecked;
    }

    public String getMembershipCode() {
        return membershipCode;
    }

    public void setMembershipCode(String membershipCode) {
        this.membershipCode = membershipCode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Object getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(Object accountCode) {
        this.accountCode = accountCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }
}
