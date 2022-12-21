import java.util.Objects;

public class University implements Comparator<University> {
    String id;
    String fullName;
    String shortName;
    double yearOfFoundation;
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
    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public double getYearOfFoundation() {
        return yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
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
        return "University{" +
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
