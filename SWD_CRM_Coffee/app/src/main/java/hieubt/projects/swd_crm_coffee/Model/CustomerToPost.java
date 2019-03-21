package hieubt.projects.swd_crm_coffee.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CustomerToPost {
    @SerializedName("active")
    @Expose
    private Boolean active = true;
    @SerializedName("address")
    @Expose
    private String address = "14 ABC";
    @SerializedName("brand_code")
    @Expose
    private String brandCode;
    @SerializedName("city")
    @Expose
    private String city = "TPHCM";
    @SerializedName("code")
    @Expose
    private String code = "CUSTOMER123";
    @SerializedName("district")
    @Expose
    private String district = "Q1";
    @SerializedName("do_b")
    @Expose
    private String doB = "1999-03-15T08:58:43.544Z";
    @SerializedName("email")
    @Expose
    private String email = "string@gmail.com";
    @SerializedName("gender")
    @Expose
    private Boolean gender = true;
    @SerializedName("idcard")
    @Expose
    private String idcard = "123";
    @SerializedName("name")
    @Expose
    private String name = "Tran Van A";
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("customer_metadata")
    @Expose
    private List<CustomerMetadataToPost> customerMetadatumToPosts = new ArrayList<>();

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<CustomerMetadataToPost> getCustomerMetadatumToPosts() {
        return customerMetadatumToPosts;
    }

    public void setCustomerMetadatumToPosts(List<CustomerMetadataToPost> customerMetadatumToPosts) {
        this.customerMetadatumToPosts = customerMetadatumToPosts;
    }

    public CustomerToPost() {
        CustomerMetadataToPost customerMetadataToPost = new CustomerMetadataToPost();
        this.customerMetadatumToPosts.add(customerMetadataToPost);
    }
}
