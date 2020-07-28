import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int n = sc.nextInt();
		int min = sc.nextInt();
		int max = sc.nextInt();
		int[][] map = new int[n][n];
		int[][] color = new int[n][n];
		for(int i = 0 ; i < n; i ++)
		{
			for(int j = 0 ; j < n ; j++)
			{
				map[i][j] = sc.nextInt();
			}
		}
		LinkedList<node> queue= new LinkedList<node>();
		int total_count = 0;
		int count = 1;
		boolean run_flag = false;
		do
		{
			run_flag = false;
			for(int i = 0 ; i < n; i ++)
			{
				for(int j = 0 ; j < n ; j++)
				{
					color[i][j] = 0;		//0 white 1 gray 2 black
				}
			}
			
			for(int a = 0 ; a < n; a ++)
			{
				for(int b = 0 ; b < n ; b++)
				{
					count = 1;
					if(color[a][b] == 0)
					{
					node start = new node(a,b);
					queue.add(start);
					int sum = map[start.y][start.x];
					int index = 0;
					while(index < queue.size())
					{
						node temp = queue.get(index++);
						int i = temp.y;
						int j = temp.x;
						if(i != 0)//위를 본다.
						{
							if(Math.abs(map[i][j] - map[i-1][j]) >= min && Math.abs(map[i][j] - map[i-1][j]) <= max && color[i-1][j] == 0)
							{
								node temp_n = new node(i-1,j);
								queue.add(temp_n);
								color[i-1][j] = 1;
								sum+=map[i-1][j];
								count++;
							}
						}
						if(i != n-1) //아래쪽을 본다.
						{
							if(Math.abs(map[i][j] - map[i+1][j]) >= min && Math.abs(map[i][j] - map[i+1][j]) <= max && color[i+1][j] == 0)
							{
								node temp_n = new node(i+1,j);
								queue.add(temp_n);
								color[i+1][j] = 1;
								sum+=map[i+1][j];
								count++;
							}					
						}
						if(j != 0)// 왼쪽을 본다.
						{
							if(Math.abs(map[i][j] - map[i][j-1]) >= min && Math.abs(map[i][j] - map[i][j-1]) <= max && color[i][j-1] == 0)
							{
								node temp_n = new node(i,j-1);
								queue.add(temp_n);
								sum+=map[i][j-1];
								color[i][j-1] = 1;
								count++;
							}					
						}
						if(j != n-1) //오른쪽을 본다.
						{
							if(Math.abs(map[i][j] - map[i][j+1]) >= min && Math.abs(map[i][j] - map[i][j+1]) <= max && color[i][j+1] == 0 )
							{
								node temp_n = new node(i,j+1);
								queue.add(temp_n);
								sum+=map[i][j+1];
								color[i][j+1] = 1;
								count++;
							}										
						}
						color[i][j] = 2;
					}

					int new_val = sum / count;
					while(!queue.isEmpty())
					{
						node renew = queue.pop();
						map[renew.y][renew.x] = new_val;
					}
				}
			if(count > 1)
			{
				run_flag = true;
/*				for(int k = 0 ; k < n ; k++)
				{
					for(int l = 0 ; l < n ; l++)
					{
						System.out.print(map[k][l] + " ");
					}
					System.out.println();
				}
				System.out.println();*/
			}
			}
		}
		if(run_flag)	
			total_count++;
		}while(run_flag);
		System.out.println(total_count);
	}
	
}
class node
{
	int x =0;
	int y = 0;
	node(int Y,int X)
	{
		this.x = X;
		this.y = Y;
	}
}
