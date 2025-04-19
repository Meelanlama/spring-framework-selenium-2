package com.milan.model_attribute_method_level;

public class WebsiteInfoDTO {
    private String websiteName;
    private String websiteCategory;

    public WebsiteInfoDTO() {
        System.out.println("Constructor: Object created");
    }

    // getters setters
    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getWebsiteCategory() {
        return websiteCategory;
    }

    public void setWebsiteCategory(String websiteCategory) {
        this.websiteCategory = websiteCategory;
    }
}
