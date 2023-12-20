package org.example;

public class GameWinStrategy_HV {
	public Result0 check(char[][] cells, int size) {
		char winChar = 0;
		for (int i = 0; i < size; i++) {
			int j = 0;
			while (size - j >= 3) {
				if (cells[i][j] != '_' &&
						cells[i][j] == cells[i][1 + j] && cells[i][1 + j] == cells[i][2 + j]) {
					winChar = cells[i][j];
					break;
				}
				j++;
			}
		}
		for (int i = 0; winChar == 0 && i < size; i++) {
			int j = 0;
			while (size - j >= 3) {
				if (cells[j][i] != '_' &&
						cells[j][i] == cells[1+j][i] && cells[1+j][i] == cells[2+j][i]) {
					winChar = cells[j][i];
					break;
				}
				j++;
			}
		}
		switch (winChar) {
			case 'X' -> {return Result0.X_WIN;}
			case 'O' -> {return Result0.O_WIN;}
		}
		for (int i = 0; i < 3; ++i) for (int j = 0; j < 3; ++j) if (cells[i][j] == '_') return Result0.GAMING;
		return Result0.DRAW;
	}
}