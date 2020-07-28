import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int n = sc.nextInt();
		LinkedList<node> list = new LinkedList<node>();
		int[] num = new int[n];
		int[] op = new int[4];
		
		for(int i = 0 ; i < n ; i++)
		{
			num[i] = sc.nextInt();
		}

		for(int i = 0 ; i < 4 ; i++)
		{
			op[i] = sc.nextInt();
		}
		node new_node = new node(n,op,num[0],0);
		list.add(new_node);
		int min = 99999999;
		int max = -999999999;
		while(!list.isEmpty())
		{
			node temp = list.pop();
			int sum = temp.sum;
			int[] new_op = new int[4];
			int new_idx = temp.index;
			for(int i = 0 ; i < 4 ; i++)
			{
				new_op[i] = temp.op[i];
			}
			if(temp.index == n-1)
			{
				if(temp.sum < min)
					min = temp.sum;
				if(temp.sum > max)
					max = temp.sum;
				continue;
			}
			if(temp.op[0] > 0)
			{
				new_op[0]--;
				node updated_node = new  node( n,new_op,sum + num[temp.index+1],new_idx+1);
				list.add(updated_node);
				new_op[0]++;
			}
			if(temp.op[1] > 0)
			{
				new_op[1]--;
				node updated_node = new  node( n,new_op,sum - num[temp.index+1],new_idx+1);
				list.add(updated_node);
				new_op[1]++;
			}
			if(temp.op[2] > 0)
			{
				new_op[2]--;
				node updated_node = new  node( n,new_op,sum * num[temp.index+1],new_idx+1);
				list.add(updated_node);				
				new_op[2]++;
			}
			if(temp.op[3] > 0)
			{
				new_op[3]--;
				node updated_node = new  node( n,new_op,sum / num[temp.index+1],new_idx+1);
				list.add(updated_node);				
				new_op[3]++;
			}
		}
		System.out.println(max);
		System.out.println(min);
	}
}
class node
{
	int sum = 0;
	int[] op = new int[4];
	int index = 0;
	node(int n, int[] operation, int first, int idx)
	{
		for(int i = 0; i < 4 ; i++)
			op[i] = operation[i];
		this.sum = first;
		this.index = idx;
	}
	
	void sum()
	{
		
	}
}
