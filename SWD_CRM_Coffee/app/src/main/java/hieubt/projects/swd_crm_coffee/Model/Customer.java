package hieubt.projects.swd_crm_coffee.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Customer {
    @SerializedName("filters_id")
    @Expose
    private Object filtersId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("brand_code")
    @Expose
    private String brandCode;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("district")
    @Expose
    private String district;
    @SerializedName("do_b")
    @Expose
    private String doB;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("gender")
    @Expose
    private Boolean gender;
    @SerializedName("image_url")
    @Expose
    private Object imageUrl;
    @SerializedName("idcard")
    @Expose
    private String idcard;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("parent_id")
    @Expose
    private Object parentId;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("customer_metadata")
    @Expose
    private List<CustomerMetadata> customerMetadata = null;

    public Object getFiltersId() {
        return filtersId;
    }

    public void setFiltersId(Object filtersId) {
        this.filtersId = filtersId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDoB() {
        return doB;
    }

    public void setDoB(String doB) {
        this.doB = doB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Object getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Object imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getParentId() {
        return parentId;
    }

    public void setParentId(Object parentId) {
        this.parentId = parentId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<CustomerMetadata> getCustomerMetadata() {
        return customerMetadata;
    }

    public void setCustomerMetadata(List<CustomerMetadata> customerMetadata) {
        this.customerMetadata = customerMetadata;
    }
}
