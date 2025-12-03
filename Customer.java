package bankapp_project.src.model;

public class Customer {
    private int id;
    private String name;
    private String idNumber;
    private String phone;

    public Customer(int id, String name, String idNumber, String phone) {
        this.id=id; this.name=name; this.idNumber=idNumber; this.phone=phone;
    }
    public int getId(){return id;}
    public String getName(){return name;}
    public String getIdNumber(){return idNumber;}
    public String getPhone(){return phone;}

    public void setName(String n){name=n;}
    public void setIdNumber(String n){idNumber=n;}
    public void setPhone(String p){phone=p;}
}