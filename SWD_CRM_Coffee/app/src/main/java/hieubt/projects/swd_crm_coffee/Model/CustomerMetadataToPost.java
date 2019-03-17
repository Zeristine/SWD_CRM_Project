package hieubt.projects.swd_crm_coffee.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class CustomerMetadataToPost {
    @SerializedName("metadata_key")
    @Expose
    private String metadataKey =  "IsOk";
    @SerializedName("active")
    @Expose
    private Boolean active = true;
    @SerializedName("value")
    @Expose
    private String value = "true";

    public String getMetadataKey() {
        return metadataKey;
    }

    public void setMetadataKey(String metadataKey) {
        this.metadataKey = metadataKey;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
