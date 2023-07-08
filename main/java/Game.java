public class Game {
    public Result0 playGame(String s){
        String[] strings = s.split(",");
        boolean flag = true;
        int[][]qi_pan = {{0,0,0},{0,0,0},{0,0,0}};
        int w1,w2;
        char[] chars;
        StringBuilder stringBuilder;
        for (String a:strings){
            chars = a.toCharArray();
            qi_pan[((int) chars[1])-49][((int) chars[0])-65] = flag?1:-1;
            flag = !flag;
            System.out.println("  A B C");
            for (int i = 0; i < 3;i++){
                stringBuilder = new StringBuilder();
                stringBuilder.append(i+1).append(" ");
                for (int j:qi_pan[i])
                    stringBuilder.append(j<0?"O ":j==0?"_ ":"X ");
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                System.out.println(stringBuilder);
            }
        }
        for (int a=0;a<3;a++) {
            w1=qi_pan[a][0]+qi_pan[a][1]+qi_pan[a][2];
            w2=qi_pan[0][a]+qi_pan[1][a]+qi_pan[2][a];
            if (w1==3||w2==3)return Result0.X_WIN;
            if (w1==-3||w2==-3)return Result0.O_WIN;
            flag=qi_pan[a][0]==0||qi_pan[a][1]==0||qi_pan[a][2]==0;
        }
        w1=qi_pan[0][0]+qi_pan[1][1]+qi_pan[2][2];
        w2=qi_pan[0][2]+qi_pan[1][1]+qi_pan[2][0];
        if (w1==3||w2==3)return Result0.X_WIN;
        if (w1==-3||w2==-3)return Result0.O_WIN;
		return flag? Result0.GAMING: Result0.DRAW;
    }
    public static void main(String[] args){
        Game game = new Game();
        Result0 result = game.playGame("B2,C2,C1,A3,B3,B1,A2,B2,C3,A1,A3,B3,C2,B1,B2,A2,A1,C1,C3");
        System.out.println(result);
    }
}