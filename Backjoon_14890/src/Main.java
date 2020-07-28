import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		String[] temp;
		int count = 0;
		int N,  L;
		int[][] map;
		int[] climb;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		sc.nextLine();
		map = new int[N+1][N+1];
		climb = new int[N+1];

		for(int i = 1; i <N+1; i++)
		{
			temp = sc.nextLine().split(" ");
			climb[i] = 0;
			for(int j = 1; j<N+1; j++)
			{
				map[i][j] = Integer.parseInt(temp[j-1]);
			}
		}
	boolean flag = true;	
	for(int i = 1; i<=N; i++)
	{
		flag = true;
		int gap = 0;

		for(int j = 1; j < N; j++)
		{
			gap = map[i][j]- map[i][j+1]; 
			if( gap == 1)		//��ĭ ����
			{
				for(int k = j+1; k <= j+L ; k++)
				{
					if(k > N)
					{
						flag = false;
						break;
					}
					else if((map[i][j] - map[i][k] ==  1) && (climb[k] != -1))
					{
						climb[k] = -1;
					}
					else 
					{
						flag = false;
						break;
					}
				}
			}
			else if (gap > 1)
				flag = false;
			if(flag == false)
			{
					for(int g = 1; g<=N; g++)
					{
						climb[g] = 0;
					}
					break;
			}				
/*			else if(map[i][j] == map[i][j+1]+1)	//��ĭ ����
			{
				for(int k = j+1; k <= j+L ; k++)
				{
					if(k > N)
					{
						flag = false;
						break;
					}
					else if((map[i][j] - map[i][k] ==  1) && (climb[k] != -1))
					{
						climb[k] = -1;
					}
					else 
					{
						flag = false;
						break;
					}
				}
				if(flag == false)
				{
						for(int g = 1; g<=N; g++)
						{
							climb[g] = 0;
						}
					break;				
				}
			}*/
		}
	if(flag == true)	//��->���� �Ǵ� ��->�޵� �Ǵ��� ����
	{
		for(int j = N; j > 1; j--)
		{
			gap = map[i][j]- map[i][j-1];
				if(gap == 1)
				{
					for(int k = j-1 ; k >= j-L ; k--)
					{
						if(k < 1)
						{
							flag = false;
							break;
						}
						else if((map[i][j] - map[i][k] ==  1 )&& (climb[k] != -1))
						{
							climb[k] = -1;
					}
						else 
						{
							flag = false;
							break;
						}
					}
				}
				else if(gap > 1) flag = false;
				if(flag== false)
				{
					for(int g = 1; g<=N; g++)
					{
						climb[g] = 0;
					}
					break;
				}

/*				else if(map[i][j] == map[i][j-1]+1)
				{
					for(int k = j-1; k >= j-L ; k--)
					{
						if(k < 1)
						{
							flag = false;
							break;
						}
						else if((map[i][j] - map[i][k] ==  1) && (climb[k] != -1))
						{
							climb[k] = -1;
						}
						else 
						{
							flag = false;
							break;
						}
					}
					if(flag== false)
					{
						for(int g = 1; g<=N; g++)
						{
							climb[g] = 0;
						}
						break;
					}
				}*/
			}
		}
		if(flag == true)	//������ �̰� ��� �̱��� �Դٴ°� ��->�� ��->�� �� �ȴٴ°Ŵ� ī��Ʈ �÷��� ��
		{
			for(int g = 1; g<=N; g++)	//�� �� �� ������ �ʱ�ȭ
			{
				climb[g] = 0;
			}
			count++;			
		}
	}	//���� ���� ��

	for(int j = 1; j <= N; j++)
	{
		int gap = 0;
		flag = true;
		for(int i = 1; i<N; i++)
		{
			gap = map[i][j] - map[i+1][j];
			if(gap == 1)
			{
				for(int k = i+1; k <= i+L ; k++)
				{
					if(k > N)
					{
						flag = false;
						break;
					}
					else if((map[i][j] - map[k][j] ==  1) && (climb[k] != -1))
					{
						climb[k] = -1;
					}
					else 
					{
						flag = false;
						break;
					}
				}
			}
			else if(gap > 1)
				flag = false;
			if(flag == false)
			{
				for(int g = 1; g<=N; g++)
				{
					climb[g] = 0;
				}
				break;
			}

/*			else if(map[i][j] == map[i+1][j]+1)
			{
				for(int k = i+1; k <= i+L ; k++)
				{
					if(k > N)
					{
						flag = false;
						break;
					}
					else if((map[i][j] - map[k][j] ==  1 )&& (climb[k] != -1))
					{
						climb[k] = -1;
					}
					else 
					{
						flag = false;
						break;
					}
				}
				if(flag == false)
				{
					for(int g = 1; g<=N; g++)
					{
						climb[g] = 0;
					}
					break;
				}
			}*/
		}
		if(flag == true)
		{
		for(int i = N; i > 1; i--)
		{
			gap = map[i][j] - map[i-1][j];
			if(gap == 1)
			{
				for(int k = i-1 ; k >= i-L ; k--)
				{
					if(k < 1)
					{
						flag = false;
						break;
					}
					else if((map[i][j] - map[k][j] ==  1 )&& (climb[k] != -1))
					{
						climb[k] = -1;
					}
					else 
					{
						flag = false;
						break;
					}
				}
			}
			else if(gap >1)
				flag = false;
			if(flag == false)
			{
				for(int g = 1; g<=N; g++)
				{
					climb[g] = 0;
				}
				break;
			}

/*			else if(map[i][j] == map[i-1][j]+1)
			{
				for(int k = i-1; k >= i-L ; k--)
				{
					if(k < 1)
					{
						flag = false;
						break;
					}
					else if((map[i][j] - map[k][j] ==  1) && (climb[k] != -1))
					{
						climb[k] = -1;
					}
					else 
					{
						flag = false;
						break;
					}
				}
				if(flag == false)
				{
					for(int g = 1; g<=N; g++)
					{
						climb[g] = 0;
					}
					break;
				}

			}*/
			}
		}

		if(flag == true)
		{
			for(int g = 1; g<=N; g++)
			{
				climb[g] = 0;
			}
			count++;
		}
	}
	System.out.println(count);
	}	
}
