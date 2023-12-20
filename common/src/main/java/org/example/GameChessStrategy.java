package org.example;

public class GameChessStrategy {
	String[] a = new String[20];
	int b=0,c=0;
	public void putChess(char[][] cells, Player currentPlayer, String chessPos,String game_mode) {
		int i = chessPos.charAt(1) - '1';
		int j = chessPos.charAt(0) - 'A';
		cells[i][j] = currentPlayer == Player.X ? 'X' : 'O';
		a[c]=chessPos;
		c++;
		if (game_mode.charAt(0)=='1'&&c>10) {
			cells[a[b].charAt(1) - '1'][a[b].charAt(0) - 'A'] = '_';
			b++;
		}
	}
}