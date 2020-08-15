import java.util.*;
class ZAlgo{
  public static void main(String args[]){
    char[] string = "xabcabzabc".toCharArray();
    char[] ss = "abc".toCharArray();
    char[] str = new char[string.length + ss.length + 1];
    int i;
    for(i = 0 ; i < ss.length ; i++){
      str[i] = ss[i];
    }
    str[i++] = '$';
    for(int j = 0 ; j < string.length ; j++){
      str[i+j] = string[j];
    }

  //  char[] str = "abaxabab".toCharArray();
    int[] z = getZ(str);
    System.out.println(Arrays.toString(z));
    for(i = 0 ; i < z.length ; i++){
      if(z[i] == ss.length){
        System.out.println("Substring found at index : " + (i-1-ss.length));
      }
    }
  }

  static int[] getZ(char[] c){
    int[] z = new int[c.length];
    int ctr = 0;
    for(int k = 1, i = 1, j = 0 ; k < c.length ; ){
      if(i < c.length && c[i] == c[j]){
        ctr++;
        i++;
        j++;
      } else if(j == 0){
        z[k] = ctr;
        ctr = 0;
        k++;
        i++;
      } else{
        z[k] = ctr;
        k++;
        int cnt = 1;
        j = 0;
        boolean flag = false;
        while(cnt < ctr){
          if(z[cnt] + cnt < ctr){
          //  System.out.println(Arrays.toString(z) + "--" + z[cnt] + "--" + cnt + "--" + ctr);
            z[k] = z[cnt];
            k++;
          } else{
            ctr = i-k;
            j = ctr;
            flag = true;
            break;
          }
          cnt++;
        }
        if(!flag)
          ctr = 0;
      }
    }
    return z;
  }
}
