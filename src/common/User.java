package common;

public class User {

    String name;
    String ptsd;
    String summary;
    String phone;
    String mail;

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }

    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public User(String name, String ptsd) {
        this.name = name;
        this.ptsd = ptsd;
    }

    public User(String name, String ptsd, String summary) {
        this.name = name;
        this.ptsd = ptsd;
        this.summary = summary;
    }

    public String getPtsd() {
        return ptsd;
    }

    public void setPtsd(String ptsd) {
        this.ptsd = ptsd;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", ptsd='" + ptsd + '\'' +
                '}';
    }

}
