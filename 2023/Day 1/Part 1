import java.util.ArrayList;
class Main {
  public static boolean isNum(char c){
    if(c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9'){
      return true;
    }
    return false;
  }
  public static void main(String[] args) {
  ArrayList<String> code = Reader.reader();
    int sum = 0;
    int cal = 0;
    int first = 0;
    int last = 0;
    
    for(String a : code){
      char[] s = a.toCharArray();
      for(char c : s){
        if(isNum(c) && first == 0){
          first = Character.getNumericValue(c);
        }
        else if (isNum(c) && first != 0){
          last = Character.getNumericValue(c);
        }
      }
      if(last == 0){
        last = first;
      }
      cal = ((first * 10) + last);
      sum += cal;
      first = 0;
      last = 0;
    }
   System.out.println(sum);
  }
}
