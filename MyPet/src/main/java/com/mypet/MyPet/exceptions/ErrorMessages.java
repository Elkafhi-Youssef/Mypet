package com.mypet.MyPet.exceptions;

public enum ErrorMessages {

    MISSING_REQUIRED_FILED("Missing required field."),
    INTERNAL_SERVER_ERROR("INTERNAL SAJO SERVER ERROR"),
    THE_USER_DONT_EXIST("the user doesn't exixt "),
    THE_PASSWORD_DOESNT_CORRECT("The password incorrect");

    private String errormessage;

    ErrorMessages(String errormessage) {
        this.errormessage = errormessage;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }


}
