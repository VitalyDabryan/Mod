public enum StudyProfile {
    MEDICINE("Медицина"),
    MATHEMATICS("Математика"),
    PHYSICS ("Физика"),
    LINGUISTICS ("Лингвистика");

    String profileName;
    StudyProfile(String profileName){
        this.profileName = profileName;
    }
    public String getProfileName(){ return profileName;}

    public static StudyProfile setProfileName(StudyProfile valueOf) {
        return valueOf(valueOf.profileName);
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }
}
