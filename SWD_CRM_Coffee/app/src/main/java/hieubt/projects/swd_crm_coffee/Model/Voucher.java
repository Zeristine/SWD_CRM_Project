package hieubt.projects.swd_crm_coffee.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Voucher {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("amount_child_unused")
    @Expose
    private Object amountChildUnused;
    @SerializedName("apply_range")
    @Expose
    private Integer applyRange;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("created_time")
    @Expose
    private String createdTime;
    @SerializedName("expired_time")
    @Expose
    private Object expiredTime;
    @SerializedName("getted_time")
    @Expose
    private Object gettedTime;
    @SerializedName("is_getted")
    @Expose
    private Boolean isGetted;
    @SerializedName("is_parent")
    @Expose
    private Object isParent;
    @SerializedName("issued_store_code")
    @Expose
    private Object issuedStoreCode;
    @SerializedName("issued_time")
    @Expose
    private Object issuedTime;
    @SerializedName("latest_used_time")
    @Expose
    private Object latestUsedTime;
    @SerializedName("membership_code")
    @Expose
    private Object membershipCode;
    @SerializedName("parent_id")
    @Expose
    private Object parentId;
    @SerializedName("promotion_code")
    @Expose
    private Object promotionCode;
    @SerializedName("promotion_detail_code")
    @Expose
    private Object promotionDetailCode;
    @SerializedName("promotion_detail_id")
    @Expose
    private Object promotionDetailId;
    @SerializedName("promotion_id")
    @Expose
    private Integer promotionId;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("used_quantity")
    @Expose
    private Integer usedQuantity;

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

    public Object getAmountChildUnused() {
        return amountChildUnused;
    }

    public void setAmountChildUnused(Object amountChildUnused) {
        this.amountChildUnused = amountChildUnused;
    }

    public Integer getApplyRange() {
        return applyRange;
    }

    public void setApplyRange(Integer applyRange) {
        this.applyRange = applyRange;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public Object getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Object expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Object getGettedTime() {
        return gettedTime;
    }

    public void setGettedTime(Object gettedTime) {
        this.gettedTime = gettedTime;
    }

    public Boolean getIsGetted() {
        return isGetted;
    }

    public void setIsGetted(Boolean isGetted) {
        this.isGetted = isGetted;
    }

    public Object getIsParent() {
        return isParent;
    }

    public void setIsParent(Object isParent) {
        this.isParent = isParent;
    }

    public Object getIssuedStoreCode() {
        return issuedStoreCode;
    }

    public void setIssuedStoreCode(Object issuedStoreCode) {
        this.issuedStoreCode = issuedStoreCode;
    }

    public Object getIssuedTime() {
        return issuedTime;
    }

    public void setIssuedTime(Object issuedTime) {
        this.issuedTime = issuedTime;
    }

    public Object getLatestUsedTime() {
        return latestUsedTime;
    }

    public void setLatestUsedTime(Object latestUsedTime) {
        this.latestUsedTime = latestUsedTime;
    }

    public Object getMembershipCode() {
        return membershipCode;
    }

    public void setMembershipCode(Object membershipCode) {
        this.membershipCode = membershipCode;
    }

    public Object getParentId() {
        return parentId;
    }

    public void setParentId(Object parentId) {
        this.parentId = parentId;
    }

    public Object getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(Object promotionCode) {
        this.promotionCode = promotionCode;
    }

    public Object getPromotionDetailCode() {
        return promotionDetailCode;
    }

    public void setPromotionDetailCode(Object promotionDetailCode) {
        this.promotionDetailCode = promotionDetailCode;
    }

    public Object getPromotionDetailId() {
        return promotionDetailId;
    }

    public void setPromotionDetailId(Object promotionDetailId) {
        this.promotionDetailId = promotionDetailId;
    }

    public Integer getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getUsedQuantity() {
        return usedQuantity;
    }

    public void setUsedQuantity(Integer usedQuantity) {
        this.usedQuantity = usedQuantity;
    }
}
