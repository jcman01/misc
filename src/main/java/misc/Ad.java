package misc;

public class Ad {
    private Integer nid;
    private String cms_key1;
    private String cms_key2;
    private String deadline_day;
    private String deadline_time;

    public String getCms_key1() {
        return cms_key1;
    }

    public void setCms_key1(String cms_key1) {
        this.cms_key1 = cms_key1;
    }

    public String getCms_key2() {
        return cms_key2;
    }

    public void setCms_key2(String cms_key2) {
        this.cms_key2 = cms_key2;
    }

    public String getDeadline_day() {
        return deadline_day;
    }

    public void setDeadline_day(String deadline_day) {
        this.deadline_day = deadline_day;
    }

    public String getDeadline_time() {
        return deadline_time;
    }

    public void setDeadline_time(String deadline_time) {
        this.deadline_time = deadline_time;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    @Override
    public String toString() {
        return this.cms_key1 + " : "
                + this.cms_key2 + " : "
                + this.deadline_day + " : "
                + this.deadline_time;
    }
}