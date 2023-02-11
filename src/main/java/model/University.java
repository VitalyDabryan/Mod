package model;

import allComparator.StudComparator;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;
import enums.StudyProfile;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "universityEntry")
@XmlType(propOrder = {"id", "uniFullName", "mainProfile"})
public class University implements StudComparator<University> {
    @SerializedName("id")
    String id;
    @SerializedName("universityName")
    public String uniFullName;
    @SerializedName("shortName")
    String shortName;
    @SerializedName("year")
    double yearOfFoundation;
    @SerializedName("studyProfil")
    StudyProfile mainProfile;
    String profileName;

    public University(String id, String uniFullName, String shortName, double yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.uniFullName = uniFullName;
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


    @XmlTransient public String getUniFullName() {
        return uniFullName;
    }

    @XmlTransient
    public String getShortName() {
        return shortName;
    }

    @XmlTransient public double getYearOfFoundation() {
        return yearOfFoundation;
    }

    @XmlElement(name = "mainProfile") public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public University setId(String id) {
        this.id = id; return this;
    }

    public University setUniFullName(String uniFullName) {
        this.uniFullName = uniFullName; return this;
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
                ", fullName='" + uniFullName + '\'' +
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
                getUniFullName().equals(that.getUniFullName()) &&
                getShortName().equals(that.getShortName()) &&
                getMainProfile() == that.getMainProfile() &&
                profileName.equals(that.profileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUniFullName(), getShortName(), getYearOfFoundation(), getMainProfile(), profileName);
    }


    @Override
    public int compare(University o1, University o2) {
        return 0;
    }
}
