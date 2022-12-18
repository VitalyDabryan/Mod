public enum StudyProfile {
    MEDICINE("Медицина"),
    MATHEMATICS("Математика"),
    PHYSICS ("Физика"),
    LINGUISTICS ("Лингвистика");

    private String profileName;
    StudyProfile(String profileName){
        this.profileName = profileName;
    }
    public String getProfileName(){ return profileName;}

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }
}
