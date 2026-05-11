package g1.domain;

public enum CategoryEnum {
    Electronic("Put in recycling bin for Electronics"),
    Combustible("Put in recycling bin for Combustibles"),
    Plastic("Put in recycling bin for Plastics"),
    Metal("Put in recycling bin for Metals"),
    Glass("Put in recycling bin for Glass"),
    Cardboard("Put in recycling bin for CardBoard"),

    MIXEDMATERIAL("Släng i blandat");

    private final String instruction;

    CategoryEnum(String instruction){
        this.instruction = instruction;
    }

    public String getInstruction(){
        return instruction;
    }

}
