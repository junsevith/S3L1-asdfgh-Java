package org.lista1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class ElementNotacji {
   public enum Type {
      OPERATION, NUMBER
   }

   private static final Map<String, BiFunction<Double, Double, Double>> functionMap = new HashMap<>();

   static {
      functionMap.put("ADD", Double::sum);
      functionMap.put("SUBTRACT", (x, y) -> y - x);
      functionMap.put("MULTIPLY", (x, y) -> y * x);
      functionMap.put("DIVIDE", (x, y) -> y / x);
   }

   private final Type type;
   private String operation = null;
   private Double value = null;

   public ElementNotacji(String operation) {
      this.operation = operation;
      type = Type.OPERATION;
   }

   public ElementNotacji(Number number) {
      value = number.doubleValue();
      type = Type.NUMBER;
   }

   public ElementNotacji operate(ElementNotacji x, ElementNotacji y) {
      return new ElementNotacji(functionMap.get(operation).apply(x.getValue(), y.getValue()));

   }

   public boolean isNumber(){
      return type == Type.NUMBER;
   }

   public Double getValue(){
      return value;
   }

   @Override
   public String toString() {
      switch (type){
         case NUMBER -> {
            return value.toString();
         }
         case OPERATION -> {
            return operation;
         }
      }
      return null;
   }
}
