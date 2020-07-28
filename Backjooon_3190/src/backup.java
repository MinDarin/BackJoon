/*import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		int N = 0;
		int L = 0;
	
		Scanner sc = new Scanner(System.in);
		LinkedList<node> apple_position= new LinkedList<node>();
		LinkedList<node> action= new LinkedList<node>();
		LinkedList<node> snake = new LinkedList<node>();
		N = sc.nextInt();
		L = sc.nextInt();
		int[][] snake_map = new int[N+1][N+1];
		snake_map[1][1] = 1;
		for(int i = 1 ; i <=N; i++)
			for(int j = 1; j <=N; j++)
				snake_map[i][j] = 0;

			for(int j = 0; j < L ; j ++)
			{
				int temp_y = sc.nextInt();
				int temp_x = sc.nextInt();
				snake_map[temp_y][temp_x] = -1;
			}
			int L2 = sc.nextInt();
			for(int j = 1 ; j <= L2 ; j++)
			{
				int temp_x = sc.nextInt();
				char temp_y = sc.next().charAt(0);
				node action_n = new node(temp_x,temp_y);
				action.add(action_n);				
			}
		node n = new node(1,1);
		snake.add(n);
		char direction = 'N';
		int timer = 0;
		boolean need_new_action = true;
		boolean need_new_apple = true;
		node new_action = null;
		while(true)
		{	
			node snake_head = snake.get(0);
			node snake_tail = new node(-1,-1);
			snake_tail.x = snake.get(0).x;
			snake_tail.y = snake.get(0).y;

			if(!action.isEmpty() &&need_new_action)
			{
				new_action = action.poll();
				need_new_action = false;
			}
			if(timer == new_action.t)
			{
				direction = new_action.lr;
				need_new_action = true;
			}
			else direction = 'N'; // D L U B

			int before_x = snake_head.x;
			int before_y = snake_head.y;
			
		if(direction == 'N')
		{

				if(snake_head.lr == 'D')
					snake_head.x++;
				else if(snake_head.lr == 'U')
					snake_head.y--;
				else if(snake_head.lr == 'L')
					snake_head.x--;
				else if(snake_head.lr == 'B')
					snake_head.y++;
				
/*				if(new_apple.x == snake_head.x && new_apple.y == snake_head.y)
				{
					node n_s = new node(before_x,before_y);
					snake.add(1,n_s);
					snake_map[snake_head.y][snake_head.x] = 1;
						need_new_apple = true;
				}
				else
				{
					if(snake_head.x < 1 || snake_head.x >N || snake_head.y < 1 || snake_head.y > N)	
						break;
					if(snake_map[snake_head.y][snake_head.x] == 1)
						break;
					else
					{
						for(int i = 0; i< snake.size()-1; i++)
						{
							node p_node = snake.get(i);
							node p_node2 = snake.get(i+1);
							int new_x_value = p_node.x;
							int new_y_value = p_node.y;
							p_node2.x = new_x_value;
							p_node2.y = new_y_value;
							
						}
						
					snake_map[snake_tail.y][snake_tail.x] = 0;
					}
				}

				else
				{
				if(snake_tail.lr == 'D')
					snake_tail.x++;
				else if(snake_tail.lr == 'U')
					snake_tail.y--;
				else if(snake_tail.lr == 'L')
					snake_tail.x--;
				else if(snake_tail.lr == 'B')
					snake_tail.y++;
				}*/
		}
		else if(direction == 'D')
		{
				if(snake_head.lr == 'D')
				{
					snake_head.y++;
					snake_head.lr = 'B';
				}
				else if(snake_head.lr == 'U')
				{
					snake_head.x++;
					snake_head.lr = 'D';
				}
				else if(snake_head.lr == 'L')
				{
					snake_head.y--;
					snake_head.lr= 'U';
				}
				else if(snake_head.lr == 'B')
				{
					snake_head.x--;
					snake_head.lr = 'L';
				}
				/*
			if(new_apple.x == snake_head.x && new_apple.y == snake_head.y)
			{
				node n_s = new node(snake_tail.x,snake_tail.y);
				snake.add(n_s);
				snake_map[snake_head.y][snake_head.x] = 1;
					need_new_apple = true;
			}
			else
			{
				if(snake_head.x < 1 || snake_head.x >N || snake_head.y < 1 || snake_head.y > N)	
					break;

				if(snake_map[snake_head.y][snake_head.x] == 1)
					break;
				else
				{
				snake_map[snake_head.y][snake_head.x] = 1;
				snake_map[snake_tail.y][snake_tail.x] = 0;
				}
			}
			else
			{
				if(snake_tail.lr == 'D')
				{
					snake_tail.y++;
					snake_tail.lr = 'B';
				}
				else if(snake_tail.lr == 'U')
				{
					snake_tail.x++;
					snake_tail.lr = 'D';
				}
				else if(snake_tail.lr == 'L')
				{
					snake_tail.y--;
					snake_tail.lr= 'U';
				}
				else if(snake_tail.lr == 'B')
				{
					snake_tail.x--;
					snake_tail.lr = 'L';
				}
			}*/
		}
		else if(direction == 'L')
		{
					if(snake_head.lr == 'D')
					{
						snake_head.y--;
						snake_head.lr = 'U';
					}
					else if(snake_head.lr == 'U')
					{
						snake_head.x--;
						snake_head.lr = 'L';
					}
					else if(snake_head.lr == 'L')
					{
						snake_head.y++;
						snake_head.lr= 'D';
					}
					else if(snake_head.lr == 'B')
					{
						snake_head.x++;
						snake_head.lr = 'D';
					}
					
/*					if(new_apple.x == snake_head.x && new_apple.y == snake_head.y)
					{
						node n_s = new node(snake_tail.x,snake_tail.y);
						snake.add(n_s);
						snake_map[snake_head.y][snake_head.x] = 1;
							need_new_apple = true;
					}
					else
					{
						if(snake_head.x < 1 || snake_head.x >N || snake_head.y < 1 || snake_head.y > N)	
							break;

						if(snake_map[snake_head.y][snake_head.x] == 1)
							break;
						else
						{
						snake_map[snake_head.y][snake_head.x] = 1;
						snake_map[snake_tail.y][snake_tail.x] = 0;
						}
					}


				else
				{
					if(snake_tail.lr == 'D')
					{
						snake_tail.y--;
						snake_tail.lr = 'U';
					}
					else if(snake_tail.lr == 'U')
					{
						snake_tail.x--;
						snake_tail.lr = 'L';
					}
					else if(snake_tail.lr == 'L')
					{
						snake_tail.y++;
						snake_tail.lr= 'D';
					}
					else if(snake_tail.lr == 'B')
					{
						snake_tail.x++;
						snake_tail.lr = 'D';
					}
				}*/
		}
		if(snake_head.x < 1 || snake_head.x >N || snake_head.y < 1 || snake_head.y > N)	
			break;
		if(snake_map[snake_head.y][snake_head.x] == -1)
		{
			node n_s = new node(before_x,before_y);
			snake.add(1,n_s);
			snake_map[snake_head.y][snake_head.x] = 1;
				need_new_apple = true;
		}
		else
		{
			if(snake_map[snake_head.y][snake_head.x] == 1)
				break;
			else
			{
			snake_map[snake_head.y][snake_head.x] = 1;
				int before_x2 = 0;
				int before_y2 = 0;			//¿Å±â±â Àü ÁÂÇ¥	before_x,before_y´Â ¿Å°Ü¾ß µÇ´Â ÁÂÇ¥..
				for(int i = 1; i< snake.size(); i++)
				{
					node p_node = snake.get(i);
					before_x2 = p_node.x;	
					before_y2 = p_node.y;
					p_node.x = before_x;
					p_node.y = before_y;
					snake_map[before_y][before_x] = 1;
					before_x = before_x2;
					before_y = before_y2;
				}				
			
			snake_map[before_y2][before_x2] = 0;
			}
		}

		System.out.println();
		for(int i = 1 ; i <N+1; i++)
		{
			for(int j = 1 ; j <N+1; j++)
				System.out.print(snake_map[i][j]);
			System.out.println();
		}
		timer++;				
		}
		System.out.println(timer+1);
	}
}

class node	//°Á °°ÀÌ¾²Áö ¹¹
{
	int x = 0;
	int y = 0;
	
	int t = 0;
	char lr = 'D';
	node(int X, int Y)
	{
		this.x = X;
		this.y = Y;
	}
	node(int T,char UD)
	{
		this.t = T;
		this.lr = UD;
	}
}*/