import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int n = sc.nextInt();
		int[][] map = new int[n+1][n+1];
		int[][] color = new int[n+1][n+1];
		for(int i = 1 ; i <= n ; i++)
		{
			for(int j = 1 ; j <= n ; j++)
			{
				map[i][j] = sc.nextInt();				
			}
		}
		
		int total_min = 99999999;
		for(int x = 1 ; x <= n ; x++) //이문제에서 x가 행 y가 열이다.
		{
			for(int y = 1 ; y <= n ; y++)
			{
				int d1 = 1;
				int d2 = 1;
				int part_min = 999999999;
				int part_max = -1;
				
//				for(; x< x+d1+d2 && x+d1+d2 <=n && 1<=y-d1 && y-d1 < y; d1++)
				for(; x+d1+d2 <=n && 1<=y-d1; d1++)
				{
//					for(; x<x+d1+d2 &&x+d1+d2<=n && y<y+d2 && y+d2 <= n; d2++)
					for(; x+d1+d2<=n && y+d2 <= n; d2++)
					{
						for(int i = 1; i <= n ; i++)
							for(int j = 1 ; j <=n; j++)
								color[i][j] = 0;
						int p_min = 9999999;
						int p_max = -1;
						
						int temp1 = 0;
						int count = 1;
						for(int r = 1 ; r <x+d1; r++)
						{
							if(r < x)	
							{
								for(int c = 1 ; c <= y; c++)
								{
									temp1+= map[r][c];
									color[r][c] = -1;
								}
							}
							else
							{
								for(int c = 1 ; c <= y-count; c++)
								{
									temp1+= map[r][c];
									color[r][c] = -1;
								}							
								count++;
							}
						}
						if(temp1 < p_min)
							p_min = temp1;
						if(temp1 > p_max)
							p_max = temp1;
						
						int temp2 = 0;
						count = 1;
						for(int r = 1 ; r <= x+d2; r++)
						{
							if(r<=x)
							{
								for(int c = y+1 ; c <= n; c++)
								{
									temp2+= map[r][c];
									color[r][c] = -1;
								
								}
							}
							else
							{
								for(int c = y+1+count ; c <= n; c++)
								{
									temp2+= map[r][c];
									color[r][c] = -1;
									
								}
								count++;
							}
						}
						if(temp2 < p_min)
							p_min = temp2;
						if(temp2 > p_max)
							p_max = temp2;

						int temp3 = 0;
						count = 0;
						for(int r = x+d1 ; r <= n; r++)
						{
							if(r>=x+d1+d2)
							{
							for(int c = 1 ; c < y+d2-d1; c++)
							{
								temp3+= map[r][c];
								color[r][c] = -1;
							}
							}
							else
							{
								for(int c = 1 ; c < y-d1+count; c++)
								{
									temp3+= map[r][c];
									color[r][c] = -1;									
								}
								count++;
							}
						}
						if(temp3 < p_min)
							p_min = temp3;
						if(temp3 > p_max)
							p_max = temp3;

						int temp4 = 0;
						count = 0;
						for(int r = x+d2+1 ; r <= n; r++)
						{
							if(r <= x +d1+d2)
							{
								for(int c = n ; c >= y+d2-count; c--)
								{
									temp4+= map[r][c];
									color[r][c] = -1;									
								}
								count++;
							}
							else
							{
							for(int c = y-d1+d2 ; c <= n; c++)
							{
								temp4+= map[r][c];
								color[r][c] = -1;

							}
							}
						}
						if(temp4 < p_min)
							p_min = temp4;
						if(temp4 > p_max)
							p_max = temp4;
						
						int temp5 = 0;
						for(int i = 1; i <= n ; i++)
						{
							for(int j = 1 ; j <=n; j++)
							{
								if(color[i][j] == 0)
									temp5 += map[i][j];	
							}
						}
						if(temp5 < p_min)
							p_min = temp5;
						if(temp5 > p_max)
							p_max = temp5;
						
						int gap = p_max - p_min;
						if(gap < total_min)
						{
							System.out.println(d1+" "+d2+" "+x+" "+y);
							System.out.println(temp1);
							System.out.println(temp2);
							System.out.println(temp3);
							System.out.println(temp4);
							System.out.println(temp5);
							System.out.println();

							total_min = gap;
						}
					}
					d2 = 1;

				}
				d1 = 1;
			}
		}
		System.out.println(total_min);
	}
}
