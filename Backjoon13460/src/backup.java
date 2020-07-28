import java.util.Scanner;

/*
import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		int hor_ver = 1; //1 은 좌우, -1은 위아래
		int start_count = 0;
		solution_13460 s = new solution_13460();
		s.read();
		int temp = s.run(s.Rx,s.Ry,s.Bx,s.By,start_count,hor_ver);
		System.out.println(temp);
	}
	
}

class solution_13460
{
	int N = 0;
	int M = 0;
	int Rx = 0, Ry = 0;
	int Bx = 0, By = 0;
	String temp;
	char [][] map;

	public void read()
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		map = new char[N][];
		for(int i = 0 ; i < N ; i++)
		{
			map [i] = new char[M];
			temp = sc.nextLine();
			map[i] = temp.toCharArray();
			for(int j = 0 ; j < M ; j++)			
			{
				if(map[i][j] == 'R')
				{
					Ry = i;
					Rx = j;
				}
				else if(map[i][j] == 'B')
				{
					By = i;
					Bx = j;
				}
			}
		}
	
	}
	int r_plus = 1 , b_plus = 1;
	boolean r_flag = false, b_flag = false;
	static boolean total_flag = true;
	
	public int run(int rx,int ry, int bx, int by, int count, int hor_ver)
	{
		r_plus = 1;
		b_plus = 1;
		
		while(count < 10)
		{
			if(hor_ver == 1)
			{
			if(rx > bx && rx < M -1) // 오른쪽
			{
				r_plus = R_right(rx,ry,bx,by);
				b_plus = B_right(rx,ry,bx,by);
				if(r_flag == true)
				{
					if(b_flag == false)
						break;
				}
				else
					this.run(rx+r_plus, ry, bx+b_plus, by,count+1,hor_ver*(-1));		
			}
			else if( bx < M-1)
			{
				b_plus = B_right(rx,ry,bx,by);
				r_plus = R_right(rx,ry,bx,by);
				if(r_flag == true)
				{
					if(b_flag == false)
						break;

				}
				else
					this.run(rx+r_plus, ry, bx+b_plus, by,count+1,hor_ver*(-1));		
			}
			
			if(rx < bx && rx>1) // 왼쪽
			{
				r_plus = R_left(rx,ry,bx,by);
				b_plus = B_left(rx,ry,bx,by);
				if(r_flag == true)
				{
					if(b_flag == false)
						break;
				}
				else
					this.run(rx-r_plus, ry, bx-b_plus, by,count+1,hor_ver*(-1));		
			}
			else if(bx > 1)
			{
			b_plus = 	B_left(rx,ry,bx,by);
			r_plus = 	R_left(rx,ry,bx,by);
				if(r_flag == true)
				{
					if(b_flag == false)
						break;

				}
				else
					this.run(rx-r_plus, ry, bx-b_plus, by,count+1,hor_ver*(-1));		
			}
		}
			if(hor_ver == -1)
			{
			if(ry < by && ry>1) // 위쪽
			{
			r_plus = 	R_up(rx,ry,bx,by);
		b_plus = 		B_up(rx,ry,bx,by);
				if(r_flag == true)
				{
					if(b_flag == false)
						break;
				}
				else
					this.run(rx, ry-r_plus, bx, by-b_plus,count+1,hor_ver*(-1));		
			}
			else if(by > 1)
			{
			b_plus = B_up(rx,ry,bx,by);
			r_plus = R_up(rx,ry,bx,by);
				if(r_flag == true)
				{
					if(b_flag == false)
						break;

				}
				else
					this.run(rx, ry-r_plus, bx, by-b_plus,count+1,hor_ver*(-1));		
			}
			
			if(ry > by && ry < N-1) // 아래쪽
			{
		r_plus = R_down(rx,ry,bx,by);
		b_plus = B_down(rx,ry,bx,by);
				if(r_flag == true)
				{
					if(b_flag == false)
						break;

				}
				else
					this.run(rx, ry+r_plus, bx, by+b_plus,count+1,hor_ver*(-1));		
			}
			else if(by < N-1)
			{
	b_plus = 		B_down(rx,ry,bx,by);
	r_plus = 		R_down(rx,ry,bx,by);
				if(r_flag == true)
				{
					if(b_flag == false)
						break;

				}
				else
					this.run(rx, ry+r_plus, bx, by+b_plus,count+1,hor_ver*(-1));		
			}
			}
			
			
		}
		return count;
	}
	
	
	public int R_right(int rx,int ry, int bx, int by)
	{
		while(map[ry][rx+r_plus] == '.' || map[ry][rx+r_plus] == 'O')
		{
			if(map[ry][rx+r_plus] == 'O')
			{
				r_flag = true;
				break;
			}
			r_plus++;
		}
		return r_plus;
	}
	public int B_right(int rx,int ry, int bx, int by)
	{	
	while(map[by][bx+b_plus] == '.' || map[by][bx+b_plus] == 'O')
	{
		if(map[by][bx+b_plus] == 'O')
		{
			b_flag = true;
			break;
		}
		b_plus++;
	}
	return b_plus;
	}
	public int R_left(int rx,int ry, int bx, int by)
	{
		while(map[ry][rx-r_plus] == '.' || map[ry][rx-r_plus] == 'O')
		{
			if(map[ry][rx-r_plus] == 'O')
			{
				r_flag = true;
				break;
			}
			r_plus++;
		}
		return r_plus;
	}
	public int B_left(int rx,int ry, int bx, int by)
	{	
	while(map[by][bx-b_plus] == 'O' || map[by][bx-b_plus] == 'O')
	{
		if(map[by][bx-b_plus] == 'O')
		{
			b_flag = true;
			break;
		}
		b_plus++;
	}
	return b_plus;
	}
	
	public int R_up(int rx,int ry, int bx, int by)
	{
		while(map[ry-r_plus][rx] == '.' || map[ry-r_plus][rx] == 'O')
		{
			if(map[ry-r_plus][rx] == 'O')
			{
				r_flag = true;
				break;
			}
			r_plus++;
		}
		return r_plus;
	}
	public int B_up(int rx,int ry, int bx, int by)
	{	
	while(map[by-b_plus][bx] == '.' || map[by-b_plus][bx] == 'O')
	{
		if(map[by-b_plus][bx] == 'O')
		{
			b_flag = true;
			break;
		}
		b_plus++;
	}
	return b_plus;
	}
	
	public int R_down(int rx,int ry, int bx, int by)
	{
		while(map[ry+r_plus][rx] == '.' || map[ry+r_plus][rx] == 'O')
		{
			if(map[ry+r_plus][rx] == 'O')
			{
				r_flag = true;
				break;
			}
			r_plus++;
		}
		return r_plus;
	}
	public int B_down(int rx,int ry, int bx, int by)
	{	
	while(map[by+b_plus][bx] == '.' || map[by+b_plus][bx] == 'O')
	{
		if(map[by+b_plus][bx] == 'O')
		{
			b_flag = true;
			break;
		}
		b_plus++;
	}
	return b_plus;
	}
	
	
	
	
}
*/

/*
 import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		int hor_ver = 0; //1 은 좌우, -1은 위아래 초기에는 4방향 다보게 0으로
		int start_count = 0;
		solution_13460 s = new solution_13460();
		s.read();
		int temp = s.bfs(s.Rx,s.Ry,s.Bx,s.By,start_count,hor_ver);
		System.out.println(temp);
	}
	
}
class node
{
	int Rx = 0, Ry = 0;
	int Bx = 0, By = 0;
	int count = 0;
	int hor_ver = 0;
	public void set(int rx,int ry, int bx, int by, int c, int h_v)
	{
		this.Rx = rx;
		this.Ry = ry;
		this.Bx = bx;
		this.By = by;
		this.count = c;
		this.hor_ver = h_v;
	}
}
class solution_13460
{
	int N = 0;
	int M = 0;
	int Rx = 0, Ry = 0;
	int Bx = 0, By = 0;
	String temp;
	char [][] map;
	LinkedList<node> linked = new LinkedList<node>();
	
	public void read()
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		map = new char[N][];
		for(int i = 0 ; i < N ; i++)
		{
			map [i] = new char[M];
			temp = sc.nextLine();
			map[i] = temp.toCharArray();
			for(int j = 0 ; j < M ; j++)			
			{
				if(map[i][j] == 'R')
				{
					Ry = i;
					Rx = j;
				}
				else if(map[i][j] == 'B')
				{
					By = i;
					Bx = j;
				}
			}
		}
	
	}
	boolean r_flag = false, b_flag = false;
	static boolean total_flag = true;
	
	public int bfs(int rx,int ry, int bx, int by, int count, int hor_ver)
	{
		int r_plus = 1;
		int b_plus = 1;
		node n = new node();
		n.set(rx, ry, bx, by, count, hor_ver);
		linked.add(n);
		node temp = new node();
		while(true)
		{
			temp = linked.poll();
			hor_ver = temp.hor_ver;
			rx = temp.Rx;
			ry = temp.Ry;
			bx = temp.Bx;
			by = temp.By;
			count = temp.count;
			System.out.println("running!" + temp.count + ry +" " + rx + " "+ by + " "+ bx);

			if(temp.count > 10) break;

		if(hor_ver >=0 )
		{
			if(rx > bx) // 오른쪽
			{
				r_plus = R_right(rx,ry,bx,by);
				b_plus = B_right(rx,ry,bx,by);
				if(r_flag == true)
				{
					if(b_flag == false)
					{
						temp.count++;
						break;
					}

				}
			}
			else
			{
				b_plus = B_right(rx,ry,bx,by);
				r_plus = R_right(rx,ry,bx,by);
				if(r_flag == true)
				{
					if(b_flag == false)
					{
						temp.count++;
						break;
					}


				}
			}
			if(r_plus != 0 || b_plus != 0)
			{
			node insert_node = new node();
			insert_node.set(rx+r_plus, ry, bx+b_plus, by,count+1,(hor_ver = -1));
			linked.add(insert_node);
			}
			
			if(rx < bx) // 왼쪽
			{
				r_plus = R_left(rx,ry,bx,by);
				b_plus = B_left(rx,ry,bx,by);
				if(r_flag == true)
				{
					if(b_flag == false)
					{
						temp.count++;
						break;
					}

				}
			}
			else 
			{
			b_plus = 	B_left(rx,ry,bx,by);
			r_plus = 	R_left(rx,ry,bx,by);
				if(r_flag == true)
				{
					if(b_flag == false)
					{
						temp.count++;
						break;
					}


				}
			}
			if(r_plus != 0 || b_plus != 0)
			{
			node insert_node2 = new node();
			insert_node2.set(rx-r_plus, ry, bx-b_plus, by,count+1,(hor_ver = -1));
			linked.add(insert_node2);
			}
		}
		if(hor_ver <= 0)
		{
			if(ry < by) // 위쪽
			{
				r_plus = R_up(rx,ry,bx,by);
				b_plus = B_up(rx,ry,bx,by);
				if(r_flag == true)
				{
					if(b_flag == false)
					{
						temp.count++;
						break;
					}

				}
			}
			else
			{
				b_plus = B_up(rx,ry,bx,by);
				r_plus = R_up(rx,ry,bx,by);
				if(r_flag == true)
				{
					if(b_flag == false)
					{
						temp.count++;
						break;
					}


				}
			}
			if(r_plus != 0 || b_plus != 0)
			{
			node insert_node = new node();
			insert_node.set	(rx, ry-r_plus, bx, by-b_plus,count+1,(hor_ver = 1));		
			linked.add(insert_node);
			}
			if(ry > by) // 아래쪽
			{
				r_plus = R_down(rx,ry,bx,by);
				b_plus = B_down(rx,ry,bx,by);
				if(r_flag == true)
				{
					if(b_flag == false)
					{
						temp.count++;
						break;
					}
				}
			}
			else
			{
				b_plus = B_down(rx,ry,bx,by);
				r_plus = R_down(rx,ry,bx,by);
				if(r_flag == true)
				{
					if(b_flag == false)
					{
						temp.count++;
						break;
					}


				}
			}
			if(r_plus != 0 || b_plus != 0)
			{

			node insert_node2 = new node();
			insert_node2.set(rx, ry+r_plus, bx, by+b_plus,count+1,(hor_ver = 1));		
			linked.add(insert_node2);
			}
			
			}
			
			
		}
		if(temp.count >=10)
			return -1;
		return temp.count;
	}
	
	
	public int R_right(int rx,int ry, int bx, int by)
	{
		int r_plus = 0;
		while(map[ry][rx+(r_plus+1)] == '.' || map[ry][rx+(r_plus+1)] == 'O')
		{
			if(map[ry][rx+(r_plus+1)] == 'O')
			{
				r_flag = true;
				break;
			}
			r_plus++;
		}
		return r_plus;
	}
	public int B_right(int rx,int ry, int bx, int by)
	{	
	int b_plus = 0;
	while(map[by][bx+(b_plus+1)] == '.' || map[by][bx+(b_plus+1)] == 'O')
	{
		if(map[by][bx+(b_plus+1)] == 'O')
		{
			b_flag = true;
			break;
		}
		b_plus++;
	}
	return b_plus;
	}
	public int R_left(int rx,int ry, int bx, int by)
	{
		int r_plus = 0;
		while(map[ry][rx-(r_plus+1)] == '.' || map[ry][rx-(r_plus+1)] == 'O')
		{
			if(map[ry][rx-(r_plus+1)] == 'O')
			{
				r_flag = true;
				break;
			}
			r_plus++;
		}
		return r_plus;
	}
	public int B_left(int rx,int ry, int bx, int by)
	{	
	int b_plus =0;
	while(map[by][bx-(b_plus+1)] == '.' || map[by][bx-(b_plus+1)] == 'O')
	{
		if(map[by][bx-(b_plus+1)] == 'O')
		{
			b_flag = true;
			break;
		}
		b_plus++;
	}
	return b_plus;
	}
	public int R_up(int rx,int ry, int bx, int by)
	{
		int r_plus =0;
		while(map[ry-(r_plus+1)][rx] == '.' || map[ry-(r_plus+1)][rx] == 'O')
		{
			if(map[ry-(r_plus+1)][rx] == 'O')
			{
				r_flag = true;
				break;
			}
			r_plus++;
		}
		return r_plus;
	}
	public int B_up(int rx,int ry, int bx, int by)
	{	
	int b_plus = 0;
	while(map[by-(b_plus+1)][bx] == '.' || map[by-(b_plus+1)][bx] == 'O')
	{
		if(map[by-(b_plus+1)][bx] == 'O')
		{
			b_flag = true;
			break;
		}
		b_plus++;
	}
	return b_plus;
	}
	public int R_down(int rx,int ry, int bx, int by)
	{
		int r_plus = 0;
		while(map[ry+(r_plus+1)][rx] == '.' || map[ry+(r_plus+1)][rx] == 'O')
		{
			if(map[ry+(r_plus+1)][rx] == 'O')
			{
				r_flag = true;
				break;
			}
			r_plus++;
		}
		return r_plus;
	}
	public int B_down(int rx,int ry, int bx, int by)
	{	
	int b_plus = 0;
	while(map[by+(b_plus+1)][bx] == '.' || map[by+(b_plus+1)][bx] == 'O')
	{
		if(map[by+(b_plus+1)][bx] == 'O')
		{
			b_flag = true;
			break;
		}
		b_plus++;
	}
	return b_plus;
	}

}
 */