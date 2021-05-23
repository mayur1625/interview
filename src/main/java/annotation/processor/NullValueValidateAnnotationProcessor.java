package annotation.processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * The class file to actually carry out the validations
 * for the various validate annotations we have declared
 * @author Y.Kamesh Rao
 */
public class NullValueValidateAnnotationProcessor
{
  /**
   * Method to process all the annotations
   * @param obj    The name of the object where
   *               annotations are to be identified and
   *               processed
   */
  public static void processAnnotations(Object obj)
  {
    try
    {
      Class cl = obj.getClass();
      for (Field f : cl.getDeclaredFields())
      {
        try
        {
          // Processing all the annotations on a single field
          for (Annotation a : f.getAnnotations())
          {
            // Checking for a NullValueValidate annotation
            if (a.annotationType() == NullValueValidate.class)
            {
              NullValueValidate nullVal = (NullValueValidate) a;
              System.out.println("Processing the field : " + nullVal.paramName());

              // Setting the field to be accessible from our class
              // is it is a private member of the class under processing
              // (which its most likely going to be)
              // The setAccessible method will not work if you have
              // Java SecurityManager configured and active.
              f.setAccessible(true);
              if (f.get(obj) == null)
                throw new NullPointerException("The value of the field [" + f + "] can't be NULL. ");
              else
                System.out.println("Value of the Object : " + f.get(obj));
            }
          }
        }
        catch (Exception e)
        {
          System.out.println(e.getMessage());
          e.printStackTrace();
        }
      }
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }
}
