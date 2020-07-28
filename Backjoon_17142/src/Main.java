import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(new InputStreamReader (System.in));
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][n];
		LinkedList<node> virus_can = new LinkedList<node>();
		for(int i = 0 ; i < n ; i++)
		{
			for(int j = 0 ; j < n ; j++)
			{
				int get_v = sc.nextInt();
				if(get_v == 2)
				{
					map[i][j] = 0;
					node v = new node(i,j,0);
					virus_can.add(v);
				}
				if(get_v == 1)
				{
					map[i][j] = -1;
				
				}
				else map[i][j] = 0;	
			}
		}
		int[][] spread = new int[n][n];		//-1은 벽 -2는 바이러스 놓은 위치 -3 바이러스 후보지 중 바이러스 안 놓은 곳
		int min = 999999999;
		int[] virus_position = new int[m];
		for(int c = 0; c < m; c++)
		{
			virus_position[c] = c;
		}
		boolean run_flag = true;
		while(run_flag)
		{
			int resize_count = 0;
			boolean resize_flag = true;
			int t = m-1;
				int set_n = 1;
				for(int tc = t+1; tc < m; tc++)
				{
					virus_position[tc] = virus_position[t]+set_n++;
				}
					LinkedList<node> virus = new LinkedList<node>();
				
					
					int temp_c = 0;
					for(int c = 0 ; c < virus_can.size(); c++)
					{
						
						if( temp_c < m && c == virus_position[temp_c])
						{
							map[virus_can.get(c).y][virus_can.get(c).x] = -2;
							temp_c ++;
						}
						else
							map[virus_can.get(c).y][virus_can.get(c).x] = -3;						 
					}

					for(int c = 0 ; c < m; c++)
						virus.add(virus_can.get(virus_position[c]));

					
					int value = 0;
					for(int a = 0 ; a < n ; a++)
					{
						for(int b = 0; b < n ; b++)
						{
							spread[a][b] = map[a][b];
						}
					}
					int temp_max = 0;
					boolean flag = true;
					while(!virus.isEmpty())
					{
						node temp = virus.pop();
						{
							int y = temp.y;
							int x = temp.x;
							value = temp.value;
							if(y > 0)
							{
								if(spread[y-1][x] == 0)
								{								
									spread[y-1][x] = value+1;
									node new_n = new node(y-1,x,value+1);
									virus.add(new_n);
								}
 
								if(spread[y-1][x] == -3)
								{								
									spread[y-1][x]--;
									node new_n = new node(y-1,x,value+1);
									virus.add(new_n);
								}

							}
							if(y < n-1)
							{
								if(spread[y+1][x] == 0 )
								{
									spread[y+1][x] = value+1;
									node new_n = new node(y+1,x,value+1);
									virus.add(new_n);
								}

								if(spread[y+1][x] == -3)
								{
									spread[y+1][x]--;
									node new_n = new node(y+1,x,value+1);
									virus.add(new_n);
								}

							}
							if(x > 0)
							{
								if(spread[y][x-1] == 0)
								{
									spread[y][x-1] = value+1;
									node new_n = new node(y,x-1,value+1);
									virus.add(new_n);
								}

								if(spread[y][x-1] == -3)
								{
									spread[y][x-1]--;
									node new_n = new node(y,x-1,value+1);
									virus.add(new_n);
								}
								
							}
							if(x < n-1)
							{
								if(spread[y][x+1] ==  0)
								{
									spread[y][x+1] = value + 1;
									node new_n = new node(y,x+1,value+1);
									virus.add(new_n);
								}

								if(spread[y][x+1] ==  -3)
								{
									spread[y][x+1]--;
									node new_n = new node(y,x+1,value+1);
									virus.add(new_n);
								}

							}
						}
						
					}
					temp_max = 0;
					for(int a = 0 ; a < n ; a++)
					{
						for(int b = 0; b < n ; b++)
						{
							if(spread[a][b] == 0)
							{
								flag = false;
								break;
							}
							if(temp_max < spread[a][b])
								temp_max = spread[a][b];
						}
					}
//					System.out.println("temp_max : " + temp_max + flag);

					if(min > temp_max && flag)
					{
/*						for(int a = 0 ; a < n ; a++)
						{
							for(int b = 0; b < n ; b++)	
								System.out.print(spread[a][b]+ "\t");
							System.out.println();							
						}	
						System.out.println();							
*/
						min = temp_max;
					}
					resize_count = 0;
					while(resize_flag)
					{
						resize_flag = false;
						if(t== -1)
						{
							run_flag = false;
							break;
						}
						if(virus_position[t]+1 >=virus_can.size()-resize_count)
						{
							resize_count++;
							t--;
							resize_flag = true;
						}
						else virus_position[t]++;
					}
					int sum_count = 1;
					if(run_flag)
					for(int tc = t+1; tc < m ; tc++)
					{
						virus_position[tc] = virus_position[t]+sum_count++;
					}
		
		}
		if(min == 999999999)
			System.out.println(-1);
		else
			System.out.println(min);
	}
}

class node
{
	int x;
	int y;
	int value;
	node(int Y, int X, int V)
	{
		this.y = Y;
		this.x = X;	
		this.value = V;
	}
}