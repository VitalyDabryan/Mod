public class University implements Comparable<University> {
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
    public int compareTo(University o) {
        return 0;
    }
}
