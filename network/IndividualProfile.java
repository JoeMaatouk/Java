package chapter9.network;

public class IndividualProfile extends Profile {
    private String jobPosition;

    public IndividualProfile (String name, String industry, String jobPosition){
        super(name, industry);
        this.jobPosition = jobPosition;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }
    // lamma ma ykoun fi duplicates besta3mel set
}