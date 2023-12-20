package org.example;

public class GameWinStrategy_HVD {
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
						cells[j][i] == cells[1 + j][i] && cells[1 + j][i] == cells[2 + j][i]) {
					winChar = cells[j][i];
					break;
				}
				j++;
			}
		}
		int j = 0;
		while (size - j >= 3) {
			int i=0;
			while (size - i >= 3) {
				if (winChar == 0 && cells[j+1][i+1] != '_' &&
						((cells[j][i] == cells[1 + j][1 + i] && cells[1 + j][1 + i] == cells[2 + j][2 + i])
								|| (cells[j][2 + i] == cells[1 + j][1 + i] && cells[1 + j][1 + i] == cells[2 + j][i]))) {
					winChar = cells[1 + j][1 + i];
					break;
				}
				i++;
			}
			j++;
		}
		switch (winChar) {
			case 'X' -> {return Result0.X_WIN;}
			case 'O' -> {return Result0.O_WIN;}
		}
		for (int i = 0; i < size; ++i) for (int i1 = 0; i1 < size; ++i1) if (cells[i][i1] == '_') return Result0.GAMING;
		return Result0.DRAW;
	}
}