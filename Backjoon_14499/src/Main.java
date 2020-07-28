import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int y = sc.nextInt();
		int x = sc.nextInt();
		int k = sc.nextInt();
		int[][] map = new int[N][M];
		int[] dice_ver = {0,0,0,0};
		int[] dice_hor = {0,0,0,0};
		 sc.nextLine();
		for(int i = 0; i < N; i++)
		{
			String[] temp = sc.nextLine().split(" ");
			for(int j = 0 ; j< M; j++)
			{
				if(j < temp.length)
				{
					map[i][M-1-j] = Integer.parseInt(temp[temp.length-1-j]);
				}
				else map[i][j] = 0;
			}
		}
		for(int l =0 ; l < k ; l++)
		{
			int move = sc.nextInt();
			switch(move)
			{
			case 1:
				if(x + 1 >= M );
				else
				{
					int temp = 0;
					temp = dice_hor[0];
					dice_hor[0] = dice_hor[1];
					dice_hor[1] = dice_hor[2];
					dice_hor[2] = dice_hor[3];
					dice_hor[3] = temp;
					dice_ver[1] = dice_hor[1];
					dice_ver[3] = dice_hor[3];
					x++;
					if(map[y][x] != 0)
					{
						dice_ver[1] = map[y][x];
						dice_hor[1] = map[y][x];
						map[y][x] = 0;
					}
					else map[y][x] = dice_ver[1];
					System.out.println(dice_ver[3]);
				}
				break;
			case 2:
				if(x - 1 < 0);
				else
				{
					int temp = 0;

					temp = dice_hor[3];
					dice_hor[3] = dice_hor[2];
					dice_hor[2] = dice_hor[1];
					dice_hor[1] = dice_hor[0];
					dice_hor[0] = temp;
					dice_ver[1] = dice_hor[1];
					dice_ver[3] = dice_hor[3];

					x--;
					if(map[y][x] != 0)
					{
						dice_ver[1] = map[y][x];
						dice_hor[1] = map[y][x];
						map[y][x] = 0;

					}
					else map[y][x] = dice_ver[1];

					System.out.println(dice_ver[3]);
				}
				break;

			case 3:
				if(y - 1 < 0);
				else
				{
					int temp = 0;
					temp = dice_ver[3];
					dice_ver[3] = dice_ver[2];
					dice_ver[2] = dice_ver[1];
					dice_ver[1] = dice_ver[0];
					dice_ver[0] = temp;
					dice_hor[1] = dice_ver[1];
					dice_hor[3] = dice_ver[3];
					y--;
					if(map[y][x] != 0)
					{
						dice_ver[1] = map[y][x];
						dice_hor[1] = map[y][x];
						map[y][x] = 0;

					}
					else map[y][x] = dice_ver[1];

					System.out.println(dice_ver[3]);
				}
				
				break;

			case 4:
				if(y + 1 >= N );
				else
				{
					int temp = 0;
					temp = dice_ver[0];
					dice_ver[0] = dice_ver[1];
					dice_ver[1] = dice_ver[2];
					dice_ver[2] = dice_ver[3];
					dice_ver[3] = temp;
					dice_hor[1] = dice_ver[1];
					dice_hor[3] = dice_ver[3];
					y++;
					if(map[y][x] != 0)
					{
						dice_ver[1] = map[y][x];
						dice_hor[1] = map[y][x];
						map[y][x] = 0;
					}
					else map[y][x] = dice_ver[1];

					System.out.println(dice_ver[3]);
				}

				break;
			default: break;
			}
		}
	}
}
