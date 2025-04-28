package com.example.virtualgarden3.model;


public enum SoilType {
    NORMAL("Generic Potting Mix"),
    CACTUS("Cactus/Succulent Mix"),
    //AFRICAN_VIOLET("African Violet Mix", "Light, airy soil with extra acidity"), //either this one or the light soil
    LIGHT_SOIL("Light soil"),
    SAND("Sand");

    // Enum fields
    private final String displayName;

    // Constructor
    SoilType(String displayName) {
        this.displayName = displayName;
    }

    // Getters
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Helper method to find by display name
     * @param displayName of the type of soil
     * @return the soil
     */
    public static SoilType fromDisplayName(String displayName) {
        for (SoilType soil : values()) {
            if (soil.displayName.equals(displayName)) {
                return soil;
            }
        }
        throw new IllegalArgumentException("No soil type with display name: " + displayName);
    }
}
