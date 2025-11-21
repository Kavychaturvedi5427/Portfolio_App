package com.example.portfolio_app;

public class certificateModel {

    int image;
    String organizationName;
    String CredentialId;
    public certificateModel(int img, String orgName, String credId){
        this.image = img;
        this.organizationName = orgName;
        this.CredentialId = credId;
    }

    public certificateModel(String Orgname, String CredId){
        this.organizationName = Orgname;
        this.CredentialId = CredId;
    }


}
