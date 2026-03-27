package POJO;

import java.util.ArrayList;
import java.util.List;

public class CreateUserPOJO {

    int jobId;
    String jobTitle;
    String jobDescription;
    List<String> experience;
    List<Project> project;

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public List<String> getExperience() {
        return experience;
    }

    public void setExperience(ArrayList<String> experience) {
        this.experience = experience;
    }

    public List<Project> getProject() {
        return project;
    }

    public void setProject(ArrayList<Project> project) {
        this.project = project;
    }
}
