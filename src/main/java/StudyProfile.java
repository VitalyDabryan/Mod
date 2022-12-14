public enum StudyProfile {
    MEDICINE("Медицина"),
    PHILOSOPHY("Философия"),
    TELECOMMUNICATIONS("Телекоммуникации");
    private String profileName;
    StudyProfile(String profileName){
        this.profileName = profileName;
    }
    public String getProfileName(){ return profileName;}

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }
}
