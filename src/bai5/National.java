package bai5;

import java.io.Serializable;

public class National implements Serializable {
    private int nationalID;
    private String nationalName;
    private String nationalCode;

    public National() {
    }

    public National(int nationalID, String nationalName, String nationalCode) {
        this.nationalID = nationalID;
        this.nationalName = nationalName;
        this.nationalCode = nationalCode;
    }

    public int getNationalID() {
        return nationalID;
    }

    public void setNationalID(int nationalID) {
        this.nationalID = nationalID;
    }

    public String getNationalName() {
        return nationalName;
    }

    public void setNationalName(String nationalName) {
        this.nationalName = nationalName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    @Override
    public String toString() {
        return String.format("ID : %d, Name : %s, Code : %s", nationalID, nationalName, nationalCode);
    }
}
