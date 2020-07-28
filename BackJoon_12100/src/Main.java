import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		int N;
		int[][] map;
		Run run = new Run();
		
	}
}
class node
{
	int x;
	int y;
	int value;
	public void set(int Y, int X, int Value)
	{
		this.x = X;
		this.y = Y;
		this.value = Value;
		
	}
}

class Run
{
	int[][] input_map;
	int[][] cur_map;
	int N;
	Integer count = 0;
	Integer cur_count = 0;

	Queue<int[][]> queue = new LinkedList<int[][]>();
	Queue<Integer> run_count = new LinkedList<Integer>();

	Run()
	{
		this.input();
		System.out.println(this.bfs());
	}
	public void setting()
	{
		cur_map = new int[N+1][N+1];
		queue.add(input_map);
		run_count.add(count);
	}
	public int bfs()
	{
		int max_val = 0;
		while(!queue.isEmpty())
		{
			cur_map = queue.poll();
			for(int i = 1; i <=N; i++)
			{
				for(int j = 1; j<=N; j++)
				{
					if(max_val < cur_map[i][j])
						max_val = cur_map[i][j];
				}
			}
			cur_count = run_count.poll();
			if(cur_count >5)
				break;
			this.left(cur_map);
			run_count.add(cur_count+1);
			this.right(cur_map);
			run_count.add(cur_count+1);
			this.down(cur_map);
			run_count.add(cur_count+1);
			this.up(cur_map);
			run_count.add(cur_count+1);

		}
		return max_val;
	}
	public void left(int[][] map)
	{
		int[][] m = new int[N+1][N+1];
		int find_non_zero = 0;
		int new_x = 1;
		int[][] new_map = new int[N+1][N+1];
		for(int  i= 1; i<= N; i ++)
		{
			new_x = 1;
			for(int j= 1; j <= N ; j++)
			{
				m[i][j] = map[i][j];
			}
			for(int j= 1; j <= N ; j++)
			{
				if(m[i][j] == 0)
				{
					new_map[i][j] = 0;
				}
				else
				{
					find_non_zero = 0;
					for(find_non_zero = j+1; find_non_zero <= N && m[i][find_non_zero]== 0; find_non_zero++);
						if(find_non_zero > N)	//뒤에 더 없다.
							new_map[i][new_x++] = m[i][j];
						else if(m[i][j] == m[i][find_non_zero])
						{
							new_map[i][new_x++]= m[i][j]*2;
							m[i][find_non_zero] = 0;
						}
						else new_map[i][new_x++] = m[i][j];
				}
			}
		}
		queue.add(new_map);
	}
	public void right(int[][] map)
	{
		int[][] m = new int[N+1][N+1];

		int find_non_zero = 0;
		int new_x = N;
		int[][] new_map = new int[N+1][N+1];
		for(int  i= N; i>= 1; i --)
		{
			new_x = N;
			for(int j= N; j >= 1 ; j--)
			{
				m[i][j] = map[i][j];
			}
			for(int j= N; j >= 1 ; j--)
			{
				if(m[i][j] == 0)
				{
					new_map[i][j] = 0;
				}
				else
				{
					find_non_zero = 0;
					for(find_non_zero = j-1; find_non_zero >= 1 && m[i][find_non_zero]== 0; find_non_zero--);
						if(find_non_zero < 1)	//뒤에 더 없다.
							new_map[i][new_x--] = m[i][j];
						else if(m[i][j] == m[i][find_non_zero])
						{
							new_map[i][new_x--]= m[i][j]*2;
							m[i][find_non_zero] = 0;
						}
						else new_map[i][new_x--] = m[i][j];
				}
			}
		}
		queue.add(new_map);
	}
	public void up(int[][] map)
	{
		int[][] m = new int[N+1][N+1];
		int find_non_zero = 0;
		int new_y = 1;
		int[][] new_map = new int[N+1][N+1];
		for(int j= 1; j <= N ; j++)
		{
			new_y = 1;
			for(int  i= 1; i<= N; i ++)
			{
				m[i][j] = map[i][j];
			}
			for(int  i= 1; i<= N; i ++)
			{
				if(m[i][j] == 0)
				{
					new_map[i][j] = 0;
				}
				else
				{
					find_non_zero = 0;
					for(find_non_zero = i+1; find_non_zero <= N && m[find_non_zero][j]== 0; find_non_zero++);
						if(find_non_zero > N)	//뒤에 더 없다.
							new_map[new_y++][j] = m[i][j];
						else if(m[i][j] == m[find_non_zero][j])
						{
							new_map[new_y++][j]= m[i][j]*2;
							m[find_non_zero][j] = 0;
						}
						else new_map[new_y++][j] = m[i][j];
				}
			}
		}
		queue.add(new_map);

	}
	public void down(int[][] map)
	{
		int[][] m = new int[N+1][N+1];
		int find_non_zero = 0;
		int new_y = N;
		int[][] new_map = new int[N+1][N+1];
		for(int j= N; j >= 1 ; j--)
		{
			new_y = N;
			for(int  i= N; i>= 1; i --)
			{
				m[i][j] = map[i][j];
			}
			for(int  i= N; i>= 1; i --)
			{
				if(m[i][j] == 0)
				{
					new_map[i][j] = 0;
				}
				else
				{
					find_non_zero = 0;
					for(find_non_zero = i-1; find_non_zero >= 1 && m[find_non_zero][j]== 0; find_non_zero--);
						if(find_non_zero < 1)	//뒤에 더 없다.
							new_map[new_y--][j] = m[i][j];
						else if(m[i][j] == m[find_non_zero][j])
						{
							new_map[new_y--][j]= m[i][j]*2;
							m[find_non_zero][j] = 0;
						}
						else new_map[new_y--][j] = m[i][j];
				}
			}
		}
		queue.add(new_map);
		
	}
	public void input()
	{
		Scanner sc = new Scanner(System.in);
		try {
			this.N = Integer.parseInt(sc.nextLine());
			input_map = new int[this.N+1][];
		for(int i = 1 ; i <= this.N; i++)
		{
			input_map[i] = new int[this.N+1];
			String[] temp = sc.nextLine().split(" ");
			for(int j = 1 ; j <= this.N; j++)
			{
				int insert_temp = Integer.parseInt(temp[j-1]);
				input_map[i][j] = insert_temp;
			}
		}
		}
		catch(Exception e)
		{			
		}
		this.setting();
	}
}