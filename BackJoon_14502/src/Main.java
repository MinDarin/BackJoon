import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] lab = new int[n][m];
		int[][] spread = new int[n][m];
		LinkedList<node> virus = new LinkedList<node>();
		LinkedList<node> virus_backup = new LinkedList<node>();
		
		for(int i = 0 ; i < n ; i++)
		{
			for(int j = 0; j < m ; j++)
			{
				int temp = sc.nextInt();
				lab[i][j] = temp;

				if(temp == 2)
				{
					node v = new node(i,j);
					virus_backup.add(v);
				}
			}
		}
		int max = 0;
for(int i0 = 0; i0 < n ; i0 ++)
{	
	for(int j0 = 0; j0 < m; j0++)
	{
			if(lab[i0][j0] == 0);
			else continue;

		
		for(int i1 = 0 ; i1< n ; i1++)
		{
			int start = 0;
			if(i0 == i1) start = j0 +1;
			if(start > m || i1 < i0) continue;
			for(int j1 = start ; j1 < m ; j1++)
			{
				if(lab[i1][j1] == 0);
				else continue;
				

				for(int i2 = 0 ; i2 < n; i2++)
				{
					int start2 = 0;
					if(i2 == i1) start2 = j1 +1;
					if(start2 > m || i2 < i1) continue;

					
					for(int j2 = start2; j2 < m ; j2++)
					{
						if(lab[i2][j2] == 0);
						else continue;						
						for(int i = 0; i <n; i++)	//ÃÊ±âÈ­
						{
							for(int j = 0; j < m ; j++)
							{
								spread[i][j] = lab[i][j];
							}
						}
						spread[i0][j0] = 1;
						spread[i1][j1] = 1;
						spread[i2][j2] = 1;
						for(int k = 0 ; k < virus_backup.size(); k++)
						{
							virus.add(virus_backup.get(k));
						}
						
						while(!virus.isEmpty())
						{
							node temp_n = virus.pop();
							if(temp_n.x != 0)
							{
								if(spread[temp_n.y][temp_n.x-1] == 0)
								{
									node new_virus = new node(temp_n.y, temp_n.x-1);
									virus.add(new_virus);
									spread[temp_n.y][temp_n.x-1] = 2;
								}
							}
							if(temp_n.x != m-1)
							{
								if(spread[temp_n.y][temp_n.x+1] == 0)
								{
									node new_virus = new node(temp_n.y, temp_n.x+1);
									virus.add(new_virus);
									spread[temp_n.y][temp_n.x+1] = 2;
								}
								
							}
							if(temp_n.y != 0)
							{
								if(spread[temp_n.y-1][temp_n.x] == 0)
								{
									node new_virus = new node(temp_n.y-1, temp_n.x);
									virus.add(new_virus);
									spread[temp_n.y-1][temp_n.x] = 2;
								}
								
							}
							if(temp_n.y != n-1)
							{
								if(spread[temp_n.y+1][temp_n.x] == 0)
								{
									node new_virus = new node(temp_n.y+1, temp_n.x);
									virus.add(new_virus);
									spread[temp_n.y+1][temp_n.x] = 2;
								}
								
							}

						}
						int zero_zon = 0;
						
						for(int a1 = 0 ; a1< n ; a1++)
						{
							for(int b1 = 0 ; b1 < m ; b1++)
							{
								if(spread[a1][b1] == 0)
									zero_zon ++;
							}
						}

						if(max < zero_zon)
						{
							max = zero_zon;
						}
					}
				}
			}
		}
	}
}
System.out.println(max);

	}
}
class node
{
int x = 0;
int y = 0;
	node(int Y, int X)
	{
		this.y = Y;
		this.x = X;
	}
}