package liangliang.bigdata.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SupportAddressDTO {
    private Long id;
    @JsonProperty(value = "belong_to")
    private String beglongTo;
    @JsonProperty(value = "en_name")
    private String enName;
    @JsonProperty(value = "cn_name")
    private String cnName;
    private String level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBeglongTo() {
        return beglongTo;
    }

    public void setBeglongTo(String beglongTo) {
        this.beglongTo = beglongTo;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
