import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

//start : 1시 10분 stop 2시 54분 시간초과
public class Main { 
	public static void main(String[] args)
	{
		run r = new run();
		System.out.println(r._run());
	}
}

class run
{
	int N;
	int M;
	int K;
	LinkedList<node> tree_alive = new LinkedList<node>();
	MAP [][] map ;
	int [][] add_map;
	int season = 0 ; //0 봄 1 여름 2 가을 3 겨울
	int num = 0;
	run()
	{
	}
	public int _run()
	{		
		
	this.read();
	MyComparator mycomparator = new MyComparator();
	Collections.sort(tree_alive,mycomparator);
	
	while(season < 4*K)
	{
		if(tree_alive.size() == 0)
			return 0;
		switch(season % 4)
		{
		
		case 0:
		for(int k = 0; k < tree_alive.size(); k++)
		{

				int i = tree_alive.get(k).i;
				int j = tree_alive.get(k).j;
				int temp_age = tree_alive.get(k).tree_old;					

				if(map[i][j].can_eat >= temp_age)
				{
						map[i][j].can_eat -= temp_age;
						tree_alive.get(k).tree_old ++;
				}
				else //양분 없으면 k부터 다죽임.
				{
					map[i][j].die_sum += temp_age;
					tree_alive.remove(k);
					k--;
				}
		}
		break;

		case 1:
			for(int k = 0; k < tree_alive.size(); k++)
			{

					int i = tree_alive.get(k).i;
					int j = tree_alive.get(k).j;
					map[i][j].can_eat += (int)map[i][j].die_sum / 2;
					map[i][j].die_sum = 0;
			}
		break;						

		case 2:
			
			int cur_size = tree_alive.size();
			for(int k = 0; k < cur_size; k++)
			{
				int i = tree_alive.get(k).i;
				int j = tree_alive.get(k).j;
				int temp_age = tree_alive.get(k).tree_old;				
				if(temp_age%5 == 0)
				{
					if(i == 1)
					{
						if(j == 1)
						{
								node n1 = new node();
								n1.add(1,i,j+1); //age, r, c순서
								tree_alive.add(n1);

								node n2 = new node();
								n2.add(1,i+1,j+1); //age, r, c순서
								tree_alive.add(n2);

								node n3 = new node();
								n3.add(1,i+1,j); //age, r, c순서
								tree_alive.add(n3);
						}
						else if(j == N)
						{
							node n1 = new node();
							n1.add(1,i,j-1); //age, r, c순서
							tree_alive.add(n1);

							node n2 = new node();
							n2.add(1,i+1,j-1); //age, r, c순서
							tree_alive.add(n2);

							node n3 = new node();
							n3.add(1,i+1,j); //age, r, c순서
							tree_alive.add(n3);
						}
						else
						{
							node n1 = new node();
							n1.add(1,i,j-1); //age, r, c순서
							tree_alive.add(n1);

							node n2 = new node();
							n2.add(1,i+1,j-1); //age, r, c순서
							tree_alive.add(n2);

							node n3 = new node();
							n3.add(1,i+1,j); //age, r, c순서
							tree_alive.add(n3);

							node n4 = new node();
							n4.add(1,i+1,j+1); //age, r, c순서
							tree_alive.add(n4);

							node n5 = new node();
							n5.add(1,i,j+1); //age, r, c순서
							tree_alive.add(n5);
						}
				}
				else if(i == N)
				{
					if(j == 1)
					{
						node n1 = new node();
						n1.add(1,i,j+1); //age, r, c순서
						tree_alive.add(n1);

						node n2 = new node();
						n2.add(1,i-1,j+1); //age, r, c순서
						tree_alive.add(n2);

						node n3 = new node();
						n3.add(1,i-1,j); //age, r, c순서
						tree_alive.add(n3);

					}
					else if(j == N)
					{
						
						node n1 = new node();
						n1.add(1,i,j-1); //age, r, c순서
						tree_alive.add(n1);

						node n2 = new node();
						n2.add(1,i-1,j-1); //age, r, c순서
						tree_alive.add(n2);

						node n3 = new node();
						n3.add(1,i-1,j); //age, r, c순서
						tree_alive.add(n3);

					}
					else
					{
						
						node n1 = new node();
						n1.add(1,i,j-1); //age, r, c순서
						tree_alive.add(n1);

						node n2 = new node();
						n2.add(1,i-1,j-1); //age, r, c순서
						tree_alive.add(n2);

						node n3 = new node();
						n3.add(1,i-1,j); //age, r, c순서
						tree_alive.add(n3);

						node n4 = new node();
						n4.add(1,i-1,j+1); //age, r, c순서
						tree_alive.add(n4);

						node n5 = new node();
						n5.add(1,i,j+1); //age, r, c순서
						tree_alive.add(n5);
						
					}
				}
				else 
				{
					if(j == 1)
					{
						
						node n1 = new node();
						n1.add(1,i-1,j); //age, r, c순서
						tree_alive.add(n1);

						node n2 = new node();
						n2.add(1,i-1,j+1); //age, r, c순서
						tree_alive.add(n2);

						node n3 = new node();
						n3.add(1,i,j+1); //age, r, c순서
						tree_alive.add(n3);

						node n4 = new node();
						n4.add(1,i+1,j+1); //age, r, c순서
						tree_alive.add(n4);

						node n5 = new node();
						n5.add(1,i+1,j); //age, r, c순서
						tree_alive.add(n5);
					}
					else if(j == N)
					{

						node n1 = new node();
						n1.add(1,i-1,j); //age, r, c순서
						tree_alive.add(n1);

						node n2 = new node();
						n2.add(1,i-1,j-1); //age, r, c순서
						tree_alive.add(n2);

						node n3 = new node();
						n3.add(1,i,j-1); //age, r, c순서
						tree_alive.add(n3);

						node n4 = new node();
						n4.add(1,i+1,j-1); //age, r, c순서
						tree_alive.add(n4);

						node n5 = new node();
						n5.add(1,i+1,j); //age, r, c순서
						tree_alive.add(n5);
					}
					else
					{
						node n1 = new node();
						n1.add(1,i-1,j); //age, r, c순서
						tree_alive.add(n1);

						node n2 = new node();
						n2.add(1,i-1,j-1); //age, r, c순서
						tree_alive.add(n2);

						node n3 = new node();
						n3.add(1,i,j-1); //age, r, c순서
						tree_alive.add(n3);

						node n4 = new node();
						n4.add(1,i+1,j-1); //age, r, c순서
						tree_alive.add(n4);

						node n5 = new node();
						n5.add(1,i+1,j); //age, r, c순서
						tree_alive.add(n5);

						node n6 = new node();
						n6.add(1,i+1,j+1); //age, r, c순서
						tree_alive.add(n6);

						node n7 = new node();
						n7.add(1,i,j+1); //age, r, c순서
						tree_alive.add(n7);

						node n8 = new node();
						n8.add(1,i-1,j+1); //age, r, c순서
						tree_alive.add(n8);
						}																	
					}
				}
			}
			Collections.sort(tree_alive,mycomparator);

			break;

			case 3:
			for(int i = 1 ; i <=N; i++)
			{
				for(int j = 1; j <= N; j ++)
				{
					this.map[i][j].can_eat += add_map[i][j];
				}	
			}
			break;			
			
			}	
			season++;
	}
		
		
			
		return tree_alive.size();
}
	public void read()
	{
		Scanner sc = new Scanner(new InputStreamReader (System.in));
		this.N = sc.nextInt();
		this.M = sc.nextInt();
		this.K = sc.nextInt();
		this.map = new MAP[N+1][N+1];
		this.add_map = new int[N+1][N+1];
		for(int i = 1 ; i <=N; i++)
		{
			for(int j = 1; j <= N; j ++)
			{
				map[i][j] = new MAP();
				int temp = sc.nextInt();
				this.add_map[i][j] = temp;
			}
		}
		for (int k = 0; k < M; k++)
		{
			int i = sc.nextInt();
			int j = sc.nextInt();
			int t_n = sc.nextInt();
			node n = new node();
			n.add(t_n,i,j);
			tree_alive.add(n);
		}
	}
}
//수정시작 3시 4분 
class MyComparator implements Comparator<node>
{
	@Override
	public int compare(node o1, node o2) {
		if(o1.tree_old < o2.tree_old) return -1;
		else if(o1.tree_old > o2.tree_old) return 1;
		else return 0;
	}
}
class MAP
{
	int can_eat = 5; //양분
	int die_sum = 0;	
}

class node
{
	int tree_old = 1;
	int i = 0;
	int j = 0;
	public void add(int age,int r, int c)
	{
		this.i = r;
		this.j = c;
		this.tree_old = age;
	}
}
