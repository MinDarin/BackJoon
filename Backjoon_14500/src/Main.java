import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
			{
				int temp = sc.nextInt();
				map[i][j] = temp;
			}
		}
		int max = 0;
		{
			for(int i = 0; i <N; i++)	//¤ÑÂ¦´ë±â ÇüÅÂ
			{
				int temp_v = 0;
				for(int j = 0 ; j+3<M; j++)
				{
				temp_v = map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3];
				if(temp_v > max)
				{
					max = temp_v;
				}
				}
			}
			for(int i = 0 ; i+3<N; i++)
			{
				int temp_v = 0;
				for(int j = 0; j < M; j++)	// ¤Ó Â¦´ë±â ÇüÅÂ
				{
				temp_v = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j];
				if(temp_v > max)
				{
					max = temp_v;
				}	
				}
			}
			for(int i = 0; i+1 < N; i++)	//³×¸ð
			{
				int temp_v = 0;
				for(int j = 0 ; j+1<M; j++)
				{
				temp_v = map[i][j] + map[i][j+1] + map[i+1][j] + map[i+1][j+1];
				if(temp_v > max)
				{
					max = temp_v;
				}	
				}
			}

			for(int i = 0; i+2 < N; i++)	//L
			{
				int temp_v = 0;
				for(int j = 0 ; j+1<M; j++)
				{	
				temp_v = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+2][j+1];
				if(temp_v > max)
				{
					max = temp_v;
				}
				}
			}
			for(int i = 0; i+2 < N; i++)	//L µÚÁý
			{
				int temp_v = 0;
				for(int j = 0 ; j+1<M; j++)
				{
					temp_v = map[i+2][j] + map[i+2][j+1] + map[i+1][j+1] + map[i][j+1];
				if(temp_v > max)
				{
					max = temp_v;
				}	
			}
			}

			for(int i = 0; i+1 < N; i++)	//¤¤_
			{
				int temp_v = 0;
				for(int j = 0 ; j+2<M; j++)
				{
					temp_v = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2];
				if(temp_v > max)
				{
					max = temp_v;
				}
				}
			}

			for(int i = 0; i+1 < N; i++)	//¤¤_ µÚÁý
			{
				int temp_v = 0;
				for(int j = 0 ; j+2<M; j++)
				{
					temp_v = map[i][j+2] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2];
				if(temp_v > max)
				{
					max = temp_v;
				}
				}
			}
			
			for(int i = 0; i+1 < N; i++)	//-¤¡ 
			{
				int temp_v = 0;
				for(int j = 0 ; j+2<M; j++)
				{
					temp_v = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+2];
				if(temp_v > max)
				{
					max = temp_v;
				}}		
			}

			for(int i = 0; i+1 < N; i++)	//-¤¡ µÚÁý
			{
				int temp_v = 0;
				for(int j = 0 ; j+2<M; j++)
				{
					temp_v = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j];
				if(temp_v > max)
				{
					max = temp_v;
				}
				}
			}
			for(int i = 0; i+2 < N; i++)	//¤¡
			{								//|
			
				int temp_v = 0;
				for(int j = 0 ; j+1<M; j++)
				{
					temp_v = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+2][j+1];
				if(temp_v > max)
				{
					max = temp_v;
				}
				}
			}

			for(int i = 0; i+2 < N; i++)	//¤¡ µÚÁý
			{								//|
			
				int temp_v = 0;
				for(int j = 0 ; j+1<M; j++)
				{
					temp_v = map[i][j] + map[i][j+1] + map[i+1][j] + map[i+2][j];
				if(temp_v > max)
				{
					max = temp_v;
				}		
				}
			}

			
			
			for(int i = 0; i+2 < N; i++)	//s¶ö±î
			{
				int temp_v = 0;
				for(int j = 0 ; j+1<M; j++)
				{
					temp_v = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j+1];
				if(temp_v > max)
				{
					max = temp_v;
				}
				}
			}
			for(int i = 0; i+2 < N; i++)	//s¶ö±î µÚÁý
			{
				int temp_v = 0;
				for(int j = 0 ; j+1<M; j++)
				{
					temp_v = map[i][j+1] + map[i+1][j] + map[i+1][j+1] + map[i+2][j];
				if(temp_v > max)
				{
					max = temp_v;
				}
				}
			}
			for(int i = 0; i+1 < N; i++)	//z¶ö±î 
			{
				int temp_v = 0;
				for(int j = 0 ; j+2<M; j++)
				{
					temp_v = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+1][j+2];
				if(temp_v > max)
				{
					max = temp_v;
				}		
			}
			}
			for(int i = 0; i+1 < N; i++)	//z¶ö±î  µÚÁý
			{
				int temp_v = 0;
				for(int j = 0 ; j+2<M; j++)
				{
					temp_v = map[i][j+2] + map[i][j+1] + map[i+1][j+1] + map[i+1][j];
				if(temp_v > max)
				{
					max = temp_v;
				}
				}
			}
			for(int i = 0; i+2 < N; i++)	//¤Ã
			{
				int temp_v = 0;
				for(int j = 0 ; j+1<M; j++)
				{
					temp_v = map[i][j+1] + map[i+1][j+1] + map[i+2][j+1] + map[i+1][j];
				if(temp_v > max)
				{
					max = temp_v;
				}
				}
			}
			for(int i = 0; i+2 < N; i++)	//¤¿
			{
				int temp_v = 0;
				for(int j = 0 ; j+1<M; j++)
				{
					temp_v = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j+1];
				if(temp_v > max)
				{
					max = temp_v;
				}
			}
			}
			for(int i = 0; i+1 < N; i++)	//¤Ç
			{
				int temp_v = 0;
				for(int j = 0 ; j+2<M; j++)
				{
					temp_v = map[i+1][j] + map[i+1][j+1] + map[i+1][j+2] + map[i][j+1];
				if(temp_v > max)
				{
					max = temp_v;
				}
			}
			}
			for(int i = 0; i+1 < N; i++)	//¤Ì
			{
				int temp_v = 0;
				for(int j = 0 ; j+2<M; j++)
				{
					temp_v = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+1];
				if(temp_v > max)
				{
					max = temp_v;
				}
			}
			}
			System.out.println(max);
			
		}
	}
}
