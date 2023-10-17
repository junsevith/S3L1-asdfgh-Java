package org.lista1;

import java.util.HashMap;
import java.util.Map;

public class NotacjaParser {
   private static final Map<Character, String> operationMap = new HashMap<>();

   static {
      operationMap.put('+', "ADD");

      operationMap.put('-', "SUBTRACT");

      operationMap.put('*', "MULTIPLY");
      operationMap.put('×', "MULTIPLY");
      operationMap.put('x', "MULTIPLY");
      operationMap.put('X', "MULTIPLY");

      operationMap.put('/', "DIVIDE");
      operationMap.put(':', "DIVIDE");
   }

   public static NotacjaPolska parse(String input) {
      NotacjaPolska notacjaPolska = new NotacjaPolska();

      String[] elements = input.split("\\s+");
      for (String element : elements
      ) {
         String operator = operationMap.get(element.charAt(0));
         if (operator != null) {
            notacjaPolska.write(operator);
         } else {
            notacjaPolska.write(Double.parseDouble(element));
         }
      }
      return notacjaPolska;
   }
}
