package org.lista1;

import java.util.HashMap;
import java.util.Map;

public final class NotationParser {

   private NotationParser() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
   /**
    * Map that matches characters to operator names.
    */
   private static final Map<Character, String> OPERATION_MAP = new HashMap<>();

   static {
      OPERATION_MAP.put('+', "ADD");

      OPERATION_MAP.put('-', "SUBTRACT");

      OPERATION_MAP.put('*', "MULTIPLY");
      OPERATION_MAP.put('×', "MULTIPLY");
      OPERATION_MAP.put('x', "MULTIPLY");
      OPERATION_MAP.put('X', "MULTIPLY");

      OPERATION_MAP.put('/', "DIVIDE");
      OPERATION_MAP.put(':', "DIVIDE");
   }

   /**
    * Parses provided string to Polish notation.
    * @param input string to be parsed
    * @return polish notation object
    */
   public static PolishNotation parse(final String input) {
      PolishNotation polishNotation = new PolishNotation();

      String[] elements = input.split("\\s+");
      for (String element : elements
      ) {
         String operator = OPERATION_MAP.get(element.charAt(0));
         if (operator != null) {
            polishNotation.write(operator);
         } else {
            polishNotation.write(Double.parseDouble(element));
         }
      }
      return polishNotation;
   }
}
