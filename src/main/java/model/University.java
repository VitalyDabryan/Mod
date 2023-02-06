package model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;
import allComparator.*;
import enums.*;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "universityEntry")
@XmlType(propOrder = { "id", "fullName", "shortName"  })
public class University implements StudComparator<University> {
    @SerializedName("id")
    String id;
    @SerializedName("universityName")
    public String fullName;
    @SerializedName("shortName")
    String shortName;
    @SerializedName("year")
    double yearOfFoundation;
    @SerializedName("studyProfil")
    StudyProfile mainProfile;
    String profileName;

    public University(String id, String fullName, String shortName, double yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }
    public University() {
    }

    public static StudyProfile fromString (String profileName) {
        if (profileName != null) {
            for (StudyProfile pt : StudyProfile.values())
                if (profileName.equalsIgnoreCase(pt.profileName)) {
                    return pt;
                }
        }
        throw new IllegalArgumentException("No such value");
    }
    @XmlElement(name = "id") public String getId() {
        return id;
    }


    @XmlElement(name = "fullName") public String getFullName() {
        return fullName;
    }

    @XmlElement(name = "shortName")
    public String getShortName() {
        return shortName;
    }

    @XmlTransient public double getYearOfFoundation() {
        return yearOfFoundation;
    }

    @XmlTransient public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public University setId(String id) {
        this.id = id; return this;
    }

    public University setFullName(String fullName) {
        this.fullName = fullName; return this;
    }

    public University setShortName(String shortName) {
        this.shortName = shortName; return this;
    }

    public University setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation; return this;
    }

    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile; return this;
    }

    @Override
    public String toString() {
        return "model.University{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile +
                '}';
    }


    public University setProfileName(StudyProfile mainProfile) {
        this.mainProfile = mainProfile; return  this;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof University that)) return false;
        return Double.compare(that.getYearOfFoundation(), getYearOfFoundation()) == 0 &&
                getId().equals(that.getId()) &&
                getFullName().equals(that.getFullName()) &&
                getShortName().equals(that.getShortName()) &&
                getMainProfile() == that.getMainProfile() &&
                profileName.equals(that.profileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFullName(), getShortName(), getYearOfFoundation(), getMainProfile(), profileName);
    }


    @Override
    public int compare(University o1, University o2) {
        return 0;
    }
}
