import java.util.ArrayList;
class Day1Part2 {
  public static boolean isNum(char c){
    if(c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9'){
      return true;
    }
    return false;
  }
  public static String fixWord(String s){
    s = s.replaceAll("one", "o1ne");
    s = s.replaceAll("two", "t2wo");
    s = s.replaceAll("three", "thre3e");
    s = s.replaceAll("four", "fou4r");
    s = s.replaceAll("five", "fiv5e");
    s = s.replaceAll("six","si6x");
    s = s.replaceAll("seven","seve7n");
    s = s.replaceAll("eight","eigh8t");
    s = s.replaceAll("nine","ni9ne");
    return s;
  }
  public static void main(String[] args) {
  ArrayList<String> code = Reader.reader();
    int sum = 0;
    int cal = 0;
    int first = 0;
    int last = 0;
    
    for(String a : code){
      String x = Main.fixWord(a);
     // System.out.println(a);
        for(int i = 0; i < x.length(); i++){
          char c = x.charAt(i);
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
      //System.out.println(first + " " + last + "    " + cal);
        sum += cal;
      first = 0;
      last = 0;
    }
   System.out.println(sum);
  }
}
