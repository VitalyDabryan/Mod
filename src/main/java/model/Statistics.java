package model;

import enums.StudyProfile;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "statisticEntry")
@XmlType(propOrder = {"avgExamScore", "mainProfile"})
public class Statistics {
    StudyProfile mainProfile;
    double avgExamScore;
    int amountOfStudentsByProfile;
    int amountOfUniversitiesByProfile;
    String mostPopularUniversity;

    public Statistics(StudyProfile mainProfile, double avgExamScore, int amountOfStudentsByProfile,
                      int amountOfUniversitiesByProfile, String mostPopularUniversity) {
        this.mainProfile = mainProfile;
        this.avgExamScore = avgExamScore;
        this.amountOfStudentsByProfile = amountOfStudentsByProfile;
        this.amountOfUniversitiesByProfile = amountOfUniversitiesByProfile;
        this.mostPopularUniversity = mostPopularUniversity;
    }

    public Statistics() {
    }

    @XmlElement(name = "mainProfile") public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    @XmlElement(name = "avgExamScore")     public double getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(double avgExamScore) {
        this.avgExamScore = avgExamScore;
    }


    @XmlTransient public int getAmountOfStudentsByProfile() {
        return amountOfStudentsByProfile;
    }

    public void setAmountOfStudentsByProfile(int amountOfStudentsByProfile) {
        this.amountOfStudentsByProfile = amountOfStudentsByProfile;
    }

    @XmlTransient public int getAmountOfUniversitiesByProfile() {
        return amountOfUniversitiesByProfile;
    }

    public void setAmountOfUniversitiesByProfile(int amountOfUniversitiesByProfile) {
        this.amountOfUniversitiesByProfile = amountOfUniversitiesByProfile;
    }

    @XmlTransient public String getMostPopularUniversity() {
        return mostPopularUniversity;
    }

    public void setMostPopularUniversity(String mostPopularUniversity) {
        this.mostPopularUniversity = mostPopularUniversity;
    }

    @Override
    public String toString() {
        return "model.Statistics{" +
                "mainProfile=" + mainProfile +
                ", avgExamScore=" + avgExamScore +
                ", amountOfStudentsByProfile=" + amountOfStudentsByProfile +
                ", amountOfUniversitiesByProfile=" + amountOfUniversitiesByProfile +
                ", mostPopularUniversity='" + mostPopularUniversity + '\'' +
                '}';
    }
}
