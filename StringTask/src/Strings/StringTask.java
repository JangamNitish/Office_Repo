package Strings;
import java.util.*;
public class StringTask
{
    public static void main(String[] args)
    {
        Implementationstring ob = new Implementationstring();
        //ob.duplicate();
        //ob.reverse();
        //ob.occurrence();
        //ob.permutation();
        //ob.longest();
        ob.length();


    }
}

class Implementationstring {
    void duplicate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string:");
        String str = sc.nextLine();
        char st[] = str.toCharArray();
        for (int i = 0; i < st.length; i++)
        {
            for (int j = i + 1; j < st.length; j++)
            {
                if (st[i] == st[j])
                {
                    System.out.println(st[i] + " ");
                }
            }
        }
    }
    void reverse()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string :");
        String s1=sc.next();
        System.out.println("reversed string : "+rever(s1));
    }
    static String rever(String s1) {
        if(s1.equals("")) {
            return s1;
        }
        else {
            return rever(s1.substring(1))+s1.charAt(0);
        }
    }
    void occurrence()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string:");
        String str = sc.nextLine();

        int count;
        char string[] = str.toCharArray();
        for(int i = 0; i <string.length; i++) {
            count = 1;
            for(int j = i+1; j <string.length; j++) {
                if(string[i] == string[j]) {
                    count++;
                    string[j] = '0';
                }
            }
            if(count > 0 && string[i] != '0')
                System.out.print(string[i]+" "+count);
        }
    }
    void longest() {
        Scanner sc = new Scanner(System.in);
        String str=sc.next();
        String y = "";
        int lng = 0;
        for (char c : str.toCharArray()) {
            String x = str.valueOf(c);
            if (y.contains(x)) {
                y="";
            }
            y = y + String.valueOf(c);
            if(y.length()>=lng) {
                lng=y.length();
            }
        }
        System.out.println(lng);
    }

    void permutation(){
        String str = "msf";
        int n = str.length();
        Implementationstring permutation = new Implementationstring();
        permutation.permute(str, 0, n - 1);
    }
        private void permute(String str, int l, int r)
        {
            if (l == r)
                System.out.println(str);
            else {
                for (int i = l; i <= r; i++) {
                    str = swap(str, l, i);
                    permute(str, l + 1, r);
                    str = swap(str, l, i);
                }
            }
        }
        public String swap(String a, int i, int j)
        {
            char temp;
            char[] charArray = a.toCharArray();
            temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            return String.valueOf(charArray);
        }
    int longest(String str) {
        String s="marketsimplified";
        Implementationstring ob=new Implementationstring();
        System.out.println(ob.longest(s));
        String y = "";
        int lng = 0;
        for (char c : str.toCharArray()) {
            String x = str.valueOf(c);
            if (y.contains(x)) {
                y="";
            }
            y = y + String.valueOf(c);
            if(y.length()>=lng) {
                lng=y.length();
            }
        }
        return lng;

    }

    void length()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter string 1:");
        String s1=sc.next();
        System.out.println("enter string 2:");
        String s2=sc.next();
        String s3=s1+s2;
        if(s1.length()==s2.length()) {
            System.out.println(s3);
        }
        else {
            if(s1.length()>s2.length()) {
                int x=s1.length()-s2.length();
                System.out.println(s1.substring(x)+s2);
            }
            else {
                int z=s2.length()-s1.length();
                System.out.println(s1+s2.substring(z));
            }
        }

    }
}