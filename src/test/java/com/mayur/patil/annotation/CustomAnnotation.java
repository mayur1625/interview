package com.mayur.patil.annotation;

public @interface CustomAnnotation
{
  /*
  Java Annotation properties are also called as 'elements'
   */
  String name() default "Patil";

  int count();

  String[] tags();
}
