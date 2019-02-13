package be.dragoncave.clients.entitys;

public enum Gender {


    MALE("M"),
    FEMALE("F");


    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getLevelCode() {
        return this.gender;
    }


}
