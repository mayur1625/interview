package clone;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class Main
{
  public static void main(String[] args) throws CloneNotSupportedException
  {
    List<String> list = new ArrayList<>();
    list.add("A");
    list.add("B");
    Address address = new Address();
    address.setAddress(list);
    Employee emp = new Employee();
    emp.setId(1);
    emp.setName("Mayur");
    emp.setAddress(address);

    System.out.println(emp);

    Employee clone = (Employee) emp.clone();
    list.add("C");
    System.out.println("clone: " + emp);
  }
}

@Data
class Employee implements Cloneable
{
  private int id;
  private String name;
  private Address address;

  @Override protected Employee clone() throws CloneNotSupportedException
  {
    Employee employee = (Employee) super.clone();
    employee.address = employee.getAddress().clone();
    return employee;
  }

}

@Data
class Address implements Cloneable
{
  private List<String> address;

  @Override protected Address clone() throws CloneNotSupportedException
  {
    return (Address) super.clone();
  }

  public void setAddress(List<String> address)
  {
    this.address = (List<String>) ((ArrayList) address).clone();
  }
}
