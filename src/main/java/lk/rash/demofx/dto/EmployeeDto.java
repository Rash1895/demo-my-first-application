package lk.rash.demofx.dto;

public class EmployeeDto {
    private int idNo;
    private String name;
    private String adress;
    private String position;

    public EmployeeDto(int idNo, String name, String adress, String position) {
        this.idNo = idNo;
        this.name = name;
        this.adress = adress;
        this.position = position;
    }

    public int getIdNo() {
        return idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
