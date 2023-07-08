import java.util.Scanner;

public class ZTransformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int NL = scanner.nextInt();
        int[] pos;
        pos = new int[]{0, 0, 0};
        char[][] NChar = new char[NL][(str.length()/(NL+NL-1)+1)*(NL)*2];
        for (char c:str.toCharArray()){
            if(pos[0]<0)pos[0]=0;
            NChar[pos[0]][pos[1]] = c;
            if(pos[0]==0)pos[2]=0;
            if(pos[2] == 0) pos[0] ++;
            else {
                pos[0]--;
                pos[1]+=2;
            }
            if(pos[0] == NL){
                pos[1]+=2;
                pos[0]-=2;
                pos[2]++;
            }
        }
        int a =Math.min(NL, str.length());
        for (int i = 0; i<a; i++){
            boolean flag=false;
            for (int j=NChar[0].length-1;j>=0;j--){
                if (NChar[i][j]!='\0')flag=true;
                if (flag&&NChar[i][j]=='\0')NChar[i][j]=' ';
            }
            String str0 = new String(NChar[i]);
            if(str.length()<NL){
                if(i<a-1)System.out.println(str0.substring(0,str0.indexOf(0)));
                else System.out.print(str0.substring(0,str0.indexOf(0)));
            }
            else System.out.println(str0.substring(0,str0.indexOf(0)));
        }
    }
}