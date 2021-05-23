package com.mayur.patil.spring.model;

import lombok.Data;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//import lombok.EqualsAndHashCode;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@EqualsAndHashCode
@Data
public class Employee
{
  /*
  @Data: This annotation is a shortcut annotation and bundles @ToString, @Getter, @Setter, @EqualsAndHashCode and @RequiredArgsConstructor annotations into a single annotation.
   */

  private int id;
  private String name;
  private int salary;

}
