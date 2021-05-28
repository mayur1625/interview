package comparator;

import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample
{
  public static void main(String[] args)
  {
    List<Employee> employees = getEmployees();

    //Sort all employees by first name

    //employees.sort(Comparator.comparing(Employee::getFirstName).reversed());
    employees.sort(Comparator.comparing(Employee::getId).thenComparing(Employee::getFirstName));
    System.out.println(employees.toString());
  }

  private static List<Employee> getEmployees()
  {
    List<Employee> employees = new ArrayList<>();
    employees.add(new Employee(6, "Yash", "Chopra", 25));
    employees.add(new Employee(2, "Aman", "Sharma", 28));
    employees.add(new Employee(3, "Aakash", "Yaadav", 52));
    employees.add(new Employee(2, "David", "Kameron", 19));
    employees.add(new Employee(4, "James", "Hedge", 72));
    employees.add(new Employee(8, "Balaji", "Subbu", 88));
    employees.add(new Employee(7, "Karan", "Johar", 59));
    employees.add(new Employee(1, "Lokesh", "Gupta", 32));
    employees.add(new Employee(9, "Vishu", "Bissi", 33));
    employees.add(new Employee(10, "Lokesh", "Ramachandran", 60));
    return employees;

  }
}

@Data
class Employee
{
  private int id;
  private String firstName;
  private String lastName;
  private int age;

  public Employee(int id, String firstName, String lastName, int age)
  {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public int getAge()
  {
    return age;
  }

  public void setAge(int age)
  {
    this.age = age;
  }

  @Override public String toString()
  {
    return "Employee{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", age=" + age +
        '}' + "\n";
  }
}
