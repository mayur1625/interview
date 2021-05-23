package annotation.processor;

/** Main class to test the Annotations
 *   @author Y.Kamesh Rao
 */
public class AnnotationExample
{
  @NullValueValidate(paramName = "testVar1") private String testVar1;
  @NullValueValidate(paramName = "testVar2") private String testVar2;

  public AnnotationExample()
  {
    testVar2 = "Testing the Null Value Validation...It Works...!";

    // Calling the processor to process the annotations applied
    // on this class object.
    NullValueValidateAnnotationProcessor.processAnnotations(this);
  }

  public static void main(String args[])
  {
    AnnotationExample ae = new AnnotationExample();
  }
}
