package info.ds.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        List<String> set = empList.stream()
                                    .map(e -> e.getHobbies())
                                    .flatMap(e -> e.stream())
                                    .distinct()
                                    .collect(Collectors.toList());
    }

}

class Employee {
    int empId;
    String empName;
    List<String> hobbies;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}