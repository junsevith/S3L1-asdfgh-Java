package org.lista1;

import org.junit.*;


public class AsdfghTest {
   @Test
   public void testNotation() {
      final PolishNotation polishNotation = new PolishNotation();
      polishNotation.write(5);
      polishNotation.write(10);
      polishNotation.write("DIVIDE");
      Assert.assertEquals(0.5, polishNotation.calculate(), 0.0);
   }

   @Test
   public void testParser() {
      final PolishNotation polishNotation = NotationParser.parse("12 2 3 4 × 10 5 / + × +");
      Assert.assertEquals(40, polishNotation.calculate(), 0.0);

   }

}
