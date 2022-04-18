#include <iostream>
#include <conio.h>
#include <dos.h>
#include <windows.h>
#include <time.h>

#define SCREEN_WIDTH 90
#define SCREEN_HEIGHT 26
#define WIN_WIDTH 70

using namespace std;

HANDLE console = GetStdHandle(STD_OUTPUT_HANDLE);
COORD CursorPosition;

int enemy_y[3], enemy_x[3], enemyF[3];

char mycar[4][4] = { ' ','±','±',' ','±','±','±','±',
					' ','±','±',' ','±','±','±','±' };

int carPos=WIN_WIDTH/2;
int score=0;

void gotoxy(int x, int y){
	CursorPosition.X=x;
	CursorPosition.Y=y;
	SetConsoleCursorPosition(console, CursorPosition);
}

void setcursor(bool visible, DWORD size){
	if(size==0){
		size=20;
    }
	CONSOLE_CURSOR_INFO lpCursor;
	lpCursor.bVisible = visible;
	lpCursor.dwSize = size;
	SetConsoleCursorInfo(console, &lpCursor);
}

void drawBorder(){
	for(int i = 0; i < SCREEN_HEIGHT; i++){
		for(int j = 0; j < 17; j++){
			gotoxy(0 + j, i); cout << "±";
			gotoxy(WIN_WIDTH - j, i); cout << "±";
		}
	}
	for(int i = 0; i < SCREEN_HEIGHT; i++){
		gotoxy(SCREEN_WIDTH,i); cout << "±";
	}
}

void genEnemy(int ind){
	enemy_x[ind] = 17 + rand() % (33);
}

void drawEnemy(int ind){
	if( enemyF[ind] == true){
		gotoxy(enemy_x[ind], enemy_y[ind]); cout << "****";
		gotoxy(enemy_x[ind], enemy_y[ind] + 1); cout << " ** ";
		gotoxy(enemy_x[ind], enemy_y[ind] + 2); cout << "****";
		gotoxy(enemy_x[ind], enemy_y[ind] + 3); cout << " ** ";
	}
}

void eraseEnemy(int ind){
	if( enemyF[ind]==true){
		gotoxy(enemy_x[ind], enemy_y[ind]); cout << "    ";
		gotoxy(enemy_x[ind], enemy_y[ind] + 1); cout << "    ";
		gotoxy(enemy_x[ind], enemy_y[ind] + 2); cout << "    ";
		gotoxy(enemy_x[ind], enemy_y[ind] + 3); cout << "    ";
	}
}

void resetEnemy(int ind){
	eraseEnemy(ind);
	enemy_y[ind] = 1;
	genEnemy(ind);
}

void drawCar(){
	for(int i = 0; i < 4; i++){
		for(int j = 0; j < 4; j++){
			gotoxy(j + carPos, i + 22); cout << mycar[i][j];
		}
	}
}

void eraseCar(){
	for(int i = 0; i < 4; i++){
		for(int j = 0; j < 4; j++){
			gotoxy(j + carPos, i+22); cout << " ";
		}
	}
}

int collision(){
	if( enemy_y[0] + 4 >= 23){
		if(enemy_x[0] + 4 - carPos >= 0 && enemy_x[0] + 4 - carPos < 9){
			return 1;
		}
	}
	return 0;
}

void gameover(){
	system("cls");
	cout << endl;
	cout << "\t\t--------------------------" << endl;
	cout << "\t\t-------- Game Over -------" << endl;
	cout << "\t\t--------------------------" << endl << endl;
	cout << "\t\tPress any key to go back to menu : ";
	getch();
}

void updateScore(){
	gotoxy(WIN_WIDTH + 7, 5); cout << "Score: " << score << endl;
}

void instructions(){
	system("cls");
	cout << "Instructions";
	cout << "\n----------------";
	cout << "\n Avoid Cars by moving left or right. ";
	cout << "\n\n Press 'a' to move left";
	cout << "\n Press 'd' to move right";
	cout << "\n Press 'escape' to exit";
	cout << "\n\nPress any key to go back to menu";
	getch();
}

void play(){
	carPos = -1 + WIN_WIDTH / 2;
	score=0;
	enemyF[0]=1;
	enemyF[1]=0;
	enemy_y[0]=enemy_y[1]=1;

	system("cls");
	drawBorder();
	updateScore();
	genEnemy(0);
	genEnemy(1);

	gotoxy(WIN_WIDTH + 7, 2); cout << "Car Game";
	gotoxy(WIN_WIDTH + 6, 4); cout << "----------";
	gotoxy(WIN_WIDTH + 6, 6); cout << "----------";
	gotoxy(WIN_WIDTH + 7, 12); cout << "Control ";
	gotoxy(WIN_WIDTH + 7, 13); cout << "-------- ";
	gotoxy(WIN_WIDTH + 2, 14); cout << " A Key - Left";
	gotoxy(WIN_WIDTH + 2, 15); cout << " D Key - Right";

	gotoxy(18, 5); cout << "Press any key to start: ";
	getch();
	gotoxy(18, 5); cout << "                      ";

	while(1){
		if(kbhit()){
			char ch = getch();
			if(ch=='a' || ch=='A'){
				if(carPos>18){
					carPos -= 4;
                }
			}
			if(ch=='d' || ch=='D'){
				if(carPos < 50){
					carPos += 4;
                }
			}
			if(ch==27){
				break;
			}
		}

		drawCar();
		drawEnemy(0);
		drawEnemy(1);

		if(collision() == 1){
			gameover();
			return;
		}

		Sleep(50);
		eraseCar();
		eraseEnemy(0);
		eraseEnemy(1);

		if(enemy_y[0] == 10){
			if(enemyF[1] == 0){
				enemyF[1] = 1;
            }
        }

		if(enemyF[0] == 1){
			enemy_y[0] += 1;
        }

		if(enemyF[1] == 1){
			enemy_y[1] += 1;
        }

		if(enemy_y[0] > SCREEN_HEIGHT-4){
			resetEnemy(0);
			score++;
			updateScore();
		}

		if(enemy_y[1] > SCREEN_HEIGHT-4){
			resetEnemy(1);
			score++;
			updateScore();
		}

	}
}

int main(){
	setcursor(0, 0);
	srand((unsigned)time(NULL));

	do{
		system("cls");
		gotoxy(10, 6); cout << " |    Car Game by C++      | ";
		gotoxy(10, 9); cout << "1. Start Game";
		gotoxy(10, 10); cout << "2. Help";
		gotoxy(10, 11); cout << "3. Quit";
		gotoxy(10, 13); cout << "Select Options : ";
		char op = getche();

		if(op=='1') play();
		else if( op=='2') instructions();
		else if( op=='3') exit(0);

	}while(1);

	return 0;
}
