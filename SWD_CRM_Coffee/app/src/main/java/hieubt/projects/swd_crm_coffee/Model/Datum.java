package hieubt.projects.swd_crm_coffee.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("list_store")
    @Expose
    private List<ListStore> listStore = null;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("brand_name")
    @Expose
    private String brandName;
    @SerializedName("create_date")
    @Expose
    private String createDate;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("company_name")
    @Expose
    private String companyName;
    @SerializedName("contact_person")
    @Expose
    private String contactPerson;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("fax")
    @Expose
    private String fax;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("vat_code")
    @Expose
    private String vatCode;
    @SerializedName("vat_template")
    @Expose
    private Integer vatTemplate;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("pgp_password")
    @Expose
    private String pgpPassword;
    @SerializedName("pgp_privavte_key")
    @Expose
    private String pgpPrivavteKey;
    @SerializedName("pgp_publickey")
    @Expose
    private String pgpPublickey;
    @SerializedName("des_key")
    @Expose
    private String desKey;
    @SerializedName("des_vector")
    @Expose
    private String desVector;
    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("tax_code")
    @Expose
    private String taxCode;
    @SerializedName("api_sms_key")
    @Expose
    private String apiSmsKey;
    @SerializedName("security_api_sms_key")
    @Expose
    private String securityApiSmsKey;
    @SerializedName("sms_type")
    @Expose
    private Integer smsType;
    @SerializedName("brand_name_sms")
    @Expose
    private String brandNameSms;
    @SerializedName("json_config_url")
    @Expose
    private String jsonConfigUrl;
    @SerializedName("brand_feature_filter")
    @Expose
    private String brandFeatureFilter;
    @SerializedName("wisky_id")
    @Expose
    private Integer wiskyId;
    @SerializedName("default_dash_board")
    @Expose
    private String defaultDashBoard;
    @SerializedName("rsa_private_key")
    @Expose
    private String rsaPrivateKey;
    @SerializedName("rsa_public_key")
    @Expose
    private String rsaPublicKey;

    public List<ListStore> getListStore() {
        return listStore;
    }

    public void setListStore(List<ListStore> listStore) {
        this.listStore = listStore;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getVatCode() {
        return vatCode;
    }

    public void setVatCode(String vatCode) {
        this.vatCode = vatCode;
    }

    public Integer getVatTemplate() {
        return vatTemplate;
    }

    public void setVatTemplate(Integer vatTemplate) {
        this.vatTemplate = vatTemplate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPgpPassword() {
        return pgpPassword;
    }

    public void setPgpPassword(String pgpPassword) {
        this.pgpPassword = pgpPassword;
    }

    public String getPgpPrivavteKey() {
        return pgpPrivavteKey;
    }

    public void setPgpPrivavteKey(String pgpPrivavteKey) {
        this.pgpPrivavteKey = pgpPrivavteKey;
    }

    public String getPgpPublickey() {
        return pgpPublickey;
    }

    public void setPgpPublickey(String pgpPublickey) {
        this.pgpPublickey = pgpPublickey;
    }

    public String getDesKey() {
        return desKey;
    }

    public void setDesKey(String desKey) {
        this.desKey = desKey;
    }

    public String getDesVector() {
        return desVector;
    }

    public void setDesVector(String desVector) {
        this.desVector = desVector;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getApiSmsKey() {
        return apiSmsKey;
    }

    public void setApiSmsKey(String apiSmsKey) {
        this.apiSmsKey = apiSmsKey;
    }

    public String getSecurityApiSmsKey() {
        return securityApiSmsKey;
    }

    public void setSecurityApiSmsKey(String securityApiSmsKey) {
        this.securityApiSmsKey = securityApiSmsKey;
    }

    public Integer getSmsType() {
        return smsType;
    }

    public void setSmsType(Integer smsType) {
        this.smsType = smsType;
    }

    public String getBrandNameSms() {
        return brandNameSms;
    }

    public void setBrandNameSms(String brandNameSms) {
        this.brandNameSms = brandNameSms;
    }

    public String getJsonConfigUrl() {
        return jsonConfigUrl;
    }

    public void setJsonConfigUrl(String jsonConfigUrl) {
        this.jsonConfigUrl = jsonConfigUrl;
    }

    public String getBrandFeatureFilter() {
        return brandFeatureFilter;
    }

    public void setBrandFeatureFilter(String brandFeatureFilter) {
        this.brandFeatureFilter = brandFeatureFilter;
    }

    public Integer getWiskyId() {
        return wiskyId;
    }

    public void setWiskyId(Integer wiskyId) {
        this.wiskyId = wiskyId;
    }

    public String getDefaultDashBoard() {
        return defaultDashBoard;
    }

    public void setDefaultDashBoard(String defaultDashBoard) {
        this.defaultDashBoard = defaultDashBoard;
    }

    public String getRsaPrivateKey() {
        return rsaPrivateKey;
    }

    public void setRsaPrivateKey(String rsaPrivateKey) {
        this.rsaPrivateKey = rsaPrivateKey;
    }

    public String getRsaPublicKey() {
        return rsaPublicKey;
    }

    public void setRsaPublicKey(String rsaPublicKey) {
        this.rsaPublicKey = rsaPublicKey;
    }

    @Override
    public String toString() {
        return "Datum{" +
                "listStore=" + listStore +
                ", id=" + id +
                ", brandName='" + brandName + '\'' +
                ", description='" + description + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
