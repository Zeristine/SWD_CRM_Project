package hieubt.projects.swd_crm_coffee.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Promotion {
    @SerializedName("list_days_of_week")
    @Expose
    private List<Integer> listDaysOfWeek = null;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("allow_apply_with_others")
    @Expose
    private Boolean allowApplyWithOthers;
    @SerializedName("allow_auto_create_voucher")
    @Expose
    private Object allowAutoCreateVoucher;
    @SerializedName("applied_quantity")
    @Expose
    private Object appliedQuantity;
    @SerializedName("apply_level")
    @Expose
    private Integer applyLevel;
    @SerializedName("apply_quantity")
    @Expose
    private Object applyQuantity;
    @SerializedName("begin_time")
    @Expose
    private Object beginTime;
    @SerializedName("brand_code")
    @Expose
    private String brandCode;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("days_of_week")
    @Expose
    private String daysOfWeek;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("detail_apply_type")
    @Expose
    private Integer detailApplyType;
    @SerializedName("end_time")
    @Expose
    private Object endTime;
    @SerializedName("event_type")
    @Expose
    private Object eventType;
    @SerializedName("event_type_detail")
    @Expose
    private Object eventTypeDetail;
    @SerializedName("detail_object")
    @Expose
    private Object detailObject;
    @SerializedName("from_date")
    @Expose
    private String fromDate;
    @SerializedName("has_event_attributes")
    @Expose
    private Object hasEventAttributes;
    @SerializedName("has_payment_attributes")
    @Expose
    private Object hasPaymentAttributes;
    @SerializedName("has_sale_mode_attributes")
    @Expose
    private Object hasSaleModeAttributes;
    @SerializedName("has_time_attributes")
    @Expose
    private Object hasTimeAttributes;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("is_apply_once")
    @Expose
    private Boolean isApplyOnce;
    @SerializedName("is_for_member")
    @Expose
    private Boolean isForMember;
    @SerializedName("is_public")
    @Expose
    private Boolean isPublic;
    @SerializedName("is_stamp")
    @Expose
    private Boolean isStamp;
    @SerializedName("is_voucher")
    @Expose
    private Boolean isVoucher;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("order_type")
    @Expose
    private Object orderType;
    @SerializedName("payment_partner_code")
    @Expose
    private Object paymentPartnerCode;
    @SerializedName("payment_type")
    @Expose
    private Object paymentType;
    @SerializedName("postfix")
    @Expose
    private Object postfix;
    @SerializedName("prefix")
    @Expose
    private Object prefix;
    @SerializedName("stamp_award_of_promotion_code")
    @Expose
    private Object stampAwardOfPromotionCode;
    @SerializedName("stamp_children_amount")
    @Expose
    private Object stampChildrenAmount;
    @SerializedName("to_date")
    @Expose
    private String toDate;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("voucher_allow_use_quantity")
    @Expose
    private Object voucherAllowUseQuantity;
    @SerializedName("voucher_expired_after_hours")
    @Expose
    private Object voucherExpiredAfterHours;
    @SerializedName("voucher_length")
    @Expose
    private Object voucherLength;
    @SerializedName("voucher_pattern")
    @Expose
    private Object voucherPattern;
    @SerializedName("voucher_quantity")
    @Expose
    private Object voucherQuantity;
    @SerializedName("voucher_used_quantity")
    @Expose
    private Object voucherUsedQuantity;

    public List<Integer> getListDaysOfWeek() {
        return listDaysOfWeek;
    }

    public void setListDaysOfWeek(List<Integer> listDaysOfWeek) {
        this.listDaysOfWeek = listDaysOfWeek;
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

    public Boolean getAllowApplyWithOthers() {
        return allowApplyWithOthers;
    }

    public void setAllowApplyWithOthers(Boolean allowApplyWithOthers) {
        this.allowApplyWithOthers = allowApplyWithOthers;
    }

    public Object getAllowAutoCreateVoucher() {
        return allowAutoCreateVoucher;
    }

    public void setAllowAutoCreateVoucher(Object allowAutoCreateVoucher) {
        this.allowAutoCreateVoucher = allowAutoCreateVoucher;
    }

    public Object getAppliedQuantity() {
        return appliedQuantity;
    }

    public void setAppliedQuantity(Object appliedQuantity) {
        this.appliedQuantity = appliedQuantity;
    }

    public Integer getApplyLevel() {
        return applyLevel;
    }

    public void setApplyLevel(Integer applyLevel) {
        this.applyLevel = applyLevel;
    }

    public Object getApplyQuantity() {
        return applyQuantity;
    }

    public void setApplyQuantity(Object applyQuantity) {
        this.applyQuantity = applyQuantity;
    }

    public Object getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Object beginTime) {
        this.beginTime = beginTime;
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

    public String getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(String daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDetailApplyType() {
        return detailApplyType;
    }

    public void setDetailApplyType(Integer detailApplyType) {
        this.detailApplyType = detailApplyType;
    }

    public Object getEndTime() {
        return endTime;
    }

    public void setEndTime(Object endTime) {
        this.endTime = endTime;
    }

    public Object getEventType() {
        return eventType;
    }

    public void setEventType(Object eventType) {
        this.eventType = eventType;
    }

    public Object getEventTypeDetail() {
        return eventTypeDetail;
    }

    public void setEventTypeDetail(Object eventTypeDetail) {
        this.eventTypeDetail = eventTypeDetail;
    }

    public Object getDetailObject() {
        return detailObject;
    }

    public void setDetailObject(Object detailObject) {
        this.detailObject = detailObject;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public Object getHasEventAttributes() {
        return hasEventAttributes;
    }

    public void setHasEventAttributes(Object hasEventAttributes) {
        this.hasEventAttributes = hasEventAttributes;
    }

    public Object getHasPaymentAttributes() {
        return hasPaymentAttributes;
    }

    public void setHasPaymentAttributes(Object hasPaymentAttributes) {
        this.hasPaymentAttributes = hasPaymentAttributes;
    }

    public Object getHasSaleModeAttributes() {
        return hasSaleModeAttributes;
    }

    public void setHasSaleModeAttributes(Object hasSaleModeAttributes) {
        this.hasSaleModeAttributes = hasSaleModeAttributes;
    }

    public Object getHasTimeAttributes() {
        return hasTimeAttributes;
    }

    public void setHasTimeAttributes(Object hasTimeAttributes) {
        this.hasTimeAttributes = hasTimeAttributes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getIsApplyOnce() {
        return isApplyOnce;
    }

    public void setIsApplyOnce(Boolean isApplyOnce) {
        this.isApplyOnce = isApplyOnce;
    }

    public Boolean getIsForMember() {
        return isForMember;
    }

    public void setIsForMember(Boolean isForMember) {
        this.isForMember = isForMember;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public Boolean getIsStamp() {
        return isStamp;
    }

    public void setIsStamp(Boolean isStamp) {
        this.isStamp = isStamp;
    }

    public Boolean getIsVoucher() {
        return isVoucher;
    }

    public void setIsVoucher(Boolean isVoucher) {
        this.isVoucher = isVoucher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getOrderType() {
        return orderType;
    }

    public void setOrderType(Object orderType) {
        this.orderType = orderType;
    }

    public Object getPaymentPartnerCode() {
        return paymentPartnerCode;
    }

    public void setPaymentPartnerCode(Object paymentPartnerCode) {
        this.paymentPartnerCode = paymentPartnerCode;
    }

    public Object getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Object paymentType) {
        this.paymentType = paymentType;
    }

    public Object getPostfix() {
        return postfix;
    }

    public void setPostfix(Object postfix) {
        this.postfix = postfix;
    }

    public Object getPrefix() {
        return prefix;
    }

    public void setPrefix(Object prefix) {
        this.prefix = prefix;
    }

    public Object getStampAwardOfPromotionCode() {
        return stampAwardOfPromotionCode;
    }

    public void setStampAwardOfPromotionCode(Object stampAwardOfPromotionCode) {
        this.stampAwardOfPromotionCode = stampAwardOfPromotionCode;
    }

    public Object getStampChildrenAmount() {
        return stampChildrenAmount;
    }

    public void setStampChildrenAmount(Object stampChildrenAmount) {
        this.stampChildrenAmount = stampChildrenAmount;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Object getVoucherAllowUseQuantity() {
        return voucherAllowUseQuantity;
    }

    public void setVoucherAllowUseQuantity(Object voucherAllowUseQuantity) {
        this.voucherAllowUseQuantity = voucherAllowUseQuantity;
    }

    public Object getVoucherExpiredAfterHours() {
        return voucherExpiredAfterHours;
    }

    public void setVoucherExpiredAfterHours(Object voucherExpiredAfterHours) {
        this.voucherExpiredAfterHours = voucherExpiredAfterHours;
    }

    public Object getVoucherLength() {
        return voucherLength;
    }

    public void setVoucherLength(Object voucherLength) {
        this.voucherLength = voucherLength;
    }

    public Object getVoucherPattern() {
        return voucherPattern;
    }

    public void setVoucherPattern(Object voucherPattern) {
        this.voucherPattern = voucherPattern;
    }

    public Object getVoucherQuantity() {
        return voucherQuantity;
    }

    public void setVoucherQuantity(Object voucherQuantity) {
        this.voucherQuantity = voucherQuantity;
    }

    public Object getVoucherUsedQuantity() {
        return voucherUsedQuantity;
    }

    public void setVoucherUsedQuantity(Object voucherUsedQuantity) {
        this.voucherUsedQuantity = voucherUsedQuantity;
    }
}
