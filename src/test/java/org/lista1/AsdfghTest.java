package org.lista1;

import org.junit.*;


public class AsdfghTest {
   @Test
   public void testowanie() {
      PolishNotation polishNotation = new PolishNotation();
      polishNotation.write(5);
      polishNotation.write(10);
      polishNotation.write("DIVIDE");
      Assert.assertEquals(0.5, polishNotation.calculate(), 0.0);
   }

   @Test
   public void testowanie2() {
      PolishNotation polishNotation = NotationParser.parse("12 2 3 4 × 10 5 / + × +");
      assert (polishNotation.calculate() == 40.0);

   }

}
