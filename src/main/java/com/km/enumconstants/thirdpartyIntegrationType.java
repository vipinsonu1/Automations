package com.km.enumconstants;

public enum thirdpartyIntegrationType {
    ZENDESK( "Zendesk", 0, "Zendesk"),AGILE_CRM("Agile CRM",0,"Agile CRM"),
    PIPEDRIVE("Pipedrive",0,"Pipedrive"),ZAPIER("Zapier",0,"Zapier"),FACEBOOK("Facebook",0,"Facebook"),
    WHATSAPP("WhatsApp",0,"WhatsApp");
    private String name;
    private Integer index;
    private String platformName;

    thirdpartyIntegrationType(String name, Integer index, String platformName) {
        this.index = index;
        this.name = name;
        this.platformName = platformName;
    }
    public Integer getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }

    public String getPlatformName() {
        return platformName;
    }

    public static thirdpartyIntegrationType getintegrationFromName(String name) {
        for (thirdpartyIntegrationType value : thirdpartyIntegrationType.values()) {
            if (value.getName().equalsIgnoreCase(name)) {
                return value;
            }
        }
        return null;
    }
}
