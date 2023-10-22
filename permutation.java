public class permutation {
    public void permute( String str ){permute(str.toCharArray(),0,str.length()-1);}
    private void permute( char [ ] str, int low, int high ){
        if(low==high){
            for (char c:str)System.out.print(c);
            System.out.println();
            return;
        }
        for(int i=low;i<=high;i++){
            switchC(str,low,i);
            permute(str,low+1,high);
            switchC(str,low,i);
        }
    }
    private void switchC(char[]chars,int a,int b){
        char temp=chars[a];
        chars[a]=chars[b];
        chars[b]=temp;
    }
}