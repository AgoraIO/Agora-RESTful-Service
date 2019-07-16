package io.agora.demo.restfulapi.license;

import java.sql.Timestamp;
import java.util.List;

public class LicenseInfo {
    public static class Record {
        private Timestamp createdTime;
        private Integer validityPeriod;
        private Timestamp activatedTime;
        private Boolean activated;

        public Timestamp getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(Timestamp createdTime) {
            this.createdTime = createdTime;
        }

        public Integer getValidityPeriod() {
            return validityPeriod;
        }

        public void setValidityPeriod(Integer validityPeriod) {
            this.validityPeriod = validityPeriod;
        }

        public Timestamp getActivatedTime() {
            return activatedTime;
        }

        public void setActivatedTime(Timestamp activatedTime) {
            this.activatedTime = activatedTime;
        }

        public Boolean getActivated() {
            return activated;
        }

        public void setActivated(Boolean activated) {
            this.activated = activated;
        }
    }

    private String custom;
    private List<Record> records;

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }
}
