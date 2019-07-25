package main.utility;

public enum Subject {

    COMPUTER_SCIENCE("COMP"), MATHEMATICS("MATH"), BIOLOGY("BIOL");
    private String abbreviation;

    private Subject(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }


}
