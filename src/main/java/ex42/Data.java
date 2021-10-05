package ex42;

public class Data {
    private String fName;
    private String lName;
    private String salary;

    public Data(String fName, String lName, String salary) {
        this.fName = fName;
        this.lName = lName;
        this.salary = salary;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
