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
		while(!linked.isEmpty())
		{
			temp = linked.poll();
			hor_ver = temp.hor_ver;
			rx = temp.Rx;
			ry = temp.Ry;
			bx = temp.Bx;
			by = temp.By;
			count = temp.count;
			r_flag = false;
			b_flag = false;
			if(temp.count > 10) break;
//			System.out.println(count+" "+ry+" "+rx+" "+by+" "+bx+" ");
			if(hor_ver >= 0)
			{
			if(rx > bx) // 오른쪽
			{
				r_plus = R_right(rx,ry,bx,by);
				b_plus = B_right(rx+r_plus,ry,bx,by);
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
				r_plus = R_right(rx,ry,bx+b_plus,by);
				if(r_flag == true)
				{
					if(b_flag == false)
					{
						temp.count++;
						break;
					}

				}
			}
			if((r_plus != 0 || b_plus != 0)&& b_flag != true)
			{
			node insert_node = new node();
			insert_node.set(rx+r_plus, ry, bx+b_plus, by,count+1,(hor_ver = -1));
			linked.add(insert_node);
			}
			r_flag = false;
			b_flag = false;
			
			if(rx < bx) // 왼쪽
			{
				r_plus = R_left(rx,ry,bx,by);
				b_plus = B_left(rx-r_plus,ry,bx,by);
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
			r_plus = 	R_left(rx,ry,bx-b_plus,by);
				if(r_flag == true)
				{
					if(b_flag == false)
					{
						temp.count++;
						break;
					}


				}
			}
			if((r_plus != 0 || b_plus != 0)&& b_flag != true)
			{
			node insert_node2 = new node();
			insert_node2.set(rx-r_plus, ry, bx-b_plus, by,count+1,(hor_ver = -1));
			linked.add(insert_node2);
			}
			r_flag = false;
			b_flag = false;
			}
			if(hor_ver <= 0)
			{
			if(ry < by) // 위쪽
			{
				r_plus = R_up(rx,ry,bx,by);
				b_plus = B_up(rx,ry-r_plus,bx,by);
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
				r_plus = R_up(rx,ry,bx,by-b_plus);
				if(r_flag == true)
				{
					if(b_flag == false)
					{
						temp.count++;
						break;
					}


				}
			}
			if((r_plus != 0 || b_plus != 0)&& b_flag != true)
			{
			node insert_node = new node();
			insert_node.set	(rx, ry-r_plus, bx, by-b_plus,count+1,(hor_ver = 1));		
			linked.add(insert_node);
			}
			r_flag = false;
			b_flag = false;

			
			if(ry > by) // 아래쪽
			{
				r_plus = R_down(rx,ry,bx,by);
				b_plus = B_down(rx,ry+r_plus,bx,by);
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
				r_plus = R_down(rx,ry,bx,by+b_plus);
				if(r_flag == true)
				{
					if(b_flag == false)
					{
						temp.count++;
						break;
					}


				}
			}
			if((r_plus != 0 || b_plus != 0)&& b_flag != true)
			{

			node insert_node2 = new node();
			insert_node2.set(rx, ry+r_plus, bx, by+b_plus,count+1,(hor_ver = 1));		
			linked.add(insert_node2);
			}
			r_flag = false;
			b_flag = false;

			}
			
			
		}
		if(temp.count >10 || temp.count <= 0 || r_flag == false)
			return -1;
		return temp.count;
	}
	
	
	public int R_right(int rx,int ry, int bx, int by)
	{
		int r_plus = 0;
		while(map[ry][rx+(r_plus+1)] != '#')
		{

			if(map[ry][rx+(r_plus+1)] == 'O')
			{
				r_flag = true;
				r_plus++;
				break;
			}
			if((ry==by)&&((rx+(r_plus+1)) == bx))
			{
				return r_plus;
			}

			
			r_plus++;
		}
		return r_plus;
	}
	public int B_right(int rx,int ry, int bx, int by)
	{	
	int b_plus = 0;
	while(map[by][bx+(b_plus+1)] != '#')
	{
		if(map[by][bx+(b_plus+1)] == 'O')
		{
			b_flag = true;
			b_plus++;
			break;
		}
		if((ry==by)&&(rx == bx+(b_plus+1)))
		{
			return b_plus;
		}
		b_plus++;
	}
	return b_plus;
	}
	public int R_left(int rx,int ry, int bx, int by)
	{
		int r_plus = 0;
		while(map[ry][rx-(r_plus+1)] != '#' )
		{
			
			if(map[ry][rx-(r_plus+1)] == 'O')
			{
				r_flag = true;
				r_plus++;
				break;
			}
			if((ry==by)&&(rx-(r_plus+1) == bx))
			{
				return r_plus;
			}

			r_plus++;
		}
		return r_plus;
	}
	public int B_left(int rx,int ry, int bx, int by)
	{	
	int b_plus =0;
	while(map[by][bx-(b_plus+1)] != '#')
	{
		
		if(map[by][bx-(b_plus+1)] == 'O')
		{
			b_flag = true;
			b_plus++;
			break;
		}
		if((ry==by)&&(rx == bx-(b_plus+1)))
		{
			return b_plus;
		}

		b_plus++;
	}
	return b_plus;
	}
	public int R_up(int rx,int ry, int bx, int by)
	{
		int r_plus =0;
		while(map[ry-(r_plus+1)][rx] != '#')
		{

			if(map[ry-(r_plus+1)][rx] == 'O')
			{
				r_flag = true;
				r_plus++;
				break;
			}
			if((ry-(r_plus+1)==by)&&(rx == bx))
			{
				return r_plus;
			}

			r_plus++;
		}
		return r_plus;
	}
	public int B_up(int rx,int ry, int bx, int by)
	{	
	int b_plus = 0;
	while(map[by-(b_plus+1)][bx] != '#')
	{


		if(map[by-(b_plus+1)][bx] == 'O')
		{
			b_flag = true;
			b_plus++;
			break;
		}
		if((ry==by-(b_plus+1))&&(rx == bx))
		{
			return b_plus;
		}

		b_plus++;
	}
	return b_plus;
	}
	public int R_down(int rx,int ry, int bx, int by)
	{
		int r_plus = 0;
		while(map[ry+(r_plus+1)][rx] != '#')
		{

			if(map[ry+(r_plus+1)][rx] == 'O')
			{
				r_flag = true;
				r_plus++;
				break;
			}
			if((ry+(r_plus+1)==by)&&(rx == bx))
			{
				return r_plus;
			}

			r_plus++;
		}
		return r_plus;
	}
	public int B_down(int rx,int ry, int bx, int by)
	{	
	int b_plus = 0;
	while(map[by+(b_plus+1)][bx] != '#')
	{

		if(map[by+(b_plus+1)][bx] == 'O')
		{
			b_flag = true;
			b_plus++;
			break;
		}
		if((ry==by+(b_plus+1))&&(rx == bx))
		{
			return b_plus;
		}

		b_plus++;
	}
	return b_plus;
	}

}