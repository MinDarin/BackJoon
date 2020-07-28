import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public int N;
	node[] IDT;
	public static void main(String[] args)
	{
		run r = new run();
	}
}

class run
{
	public int N;
	node[] IDT;
	int base;
	run()
	{
		this.read();
		Arrays.sort(IDT, base, base+N);
		update();
		System.out.println(N-IDT[1].r_idx);
	}
	public void update()
	{
		int c = base/2;
		int c_max = base;
		
		for(int i = c; i < c_max; i++)		// 초기 리프 노드의 parent 부분만.
		{

			
			if(IDT[i*2] == null)
				continue;
			if(IDT[i*2+1] == null)
			{
				node n = new node();
				n.arr_set(N);
				IDT[i] = n;				
				IDT[i].r_val_arr[IDT[i].r_idx++] = IDT[i*2].right;
				IDT[i].r_max =  IDT[i*2].right;
				IDT[i].r_min = 	IDT[i*2].right;
				continue;
			}
			else
			{
				node n = new node();
				n.arr_set(N);
				IDT[i] = n;				
			}
			if(IDT[i*2].right < IDT[i*2+1].right)
			{
				IDT[i].r_val_arr[IDT[i].r_idx++] = IDT[i*2].right;
				IDT[i].r_val_arr[IDT[i].r_idx++] = IDT[i*2+1].right;

				IDT[i].r_max =  IDT[i*2+1].right;
				IDT[i].r_min = 	IDT[i*2].right;
			}
			else
			{
				int l_gap = Math.abs(IDT[i*2].right - IDT[i*2].left);
				int r_gap = Math.abs(IDT[i*2+1].right - IDT[i*2+1].left);
				if(l_gap < r_gap)	
				{
					IDT[i].r_val_arr[IDT[i].r_idx++] = IDT[i*2].right;
					IDT[i].r_max =  IDT[i*2].right;
					IDT[i].r_min = 	IDT[i*2].right;
				}
				else
				{
					IDT[i].r_val_arr[IDT[i].r_idx++] = IDT[i*2+1].right;
					IDT[i].r_max =  IDT[i*2+1].right;
					IDT[i].r_min = 	IDT[i*2+1].right;
				}
			}
		}

		c_max /= 2;
		c = c_max /2;
		int l_num = 0;
		int r_num = 0;

		while(c >= 1)
		{

			for(int cur = c; cur < c_max; cur++)
			{

			if(IDT[cur*2] == null)
					continue;
			if(IDT[cur*2+1] == null)
			{
				node n = new node();
				n.arr_set(N);
				IDT[cur] = n;				

				for(int i = 0; i < IDT[cur*2].r_idx; i++)
						IDT[cur].r_val_arr[IDT[cur].r_idx++] = IDT[cur*2].r_val_arr[i];
					IDT[cur].r_max =  IDT[cur*2].right;
					IDT[cur].r_min = 	IDT[cur*2].right;
					continue;
			}
			node n = new node();
			n.arr_set(N);
			IDT[cur] = n;				

				
			int[] l_arr = IDT[cur*2].r_val_arr;
			int[] r_arr = IDT[cur*2+1].r_val_arr;
			int before_l_num = IDT[cur*2].r_idx;
			int before_r_num = IDT[cur*2+1].r_idx;

			int l_start = 0;
			int r_start = 0;
			int l_end = IDT[cur*2].r_idx-1;
			int r_end = IDT[cur*2+1].r_idx-1;
			boolean skip = false;
	
			while(l_arr[l_end] >= r_arr[r_start])
			{
				if(l_arr[l_end] >= r_arr[r_start])
				{
					l_end--;
				}
				else if(l_arr[l_end] < r_arr[r_start])
				{
					r_start++;
				}				
				if(l_end == -1 || r_start > r_end)
				{
					if(before_l_num > before_r_num)
					{
						for(int j = 0 ; j < IDT[cur*2].r_idx; j++)
						{
							IDT[cur].r_val_arr[IDT[cur].r_idx++] = IDT[cur*2].r_val_arr[j];
 						}
					}
					else if(before_l_num >= before_r_num)
					{
						for(int j = 0 ; j < IDT[cur*2+1].r_idx; j++)
						{
							IDT[cur].r_val_arr[IDT[cur].r_idx++] = IDT[cur*2+1].r_val_arr[j];							
						}
					}
					skip = true;
					break;
				}
			}
			
			if(!skip)
			{
				for(int i = l_start; i <= l_end; i++)
					IDT[cur].r_val_arr[IDT[cur].r_idx++] = IDT[cur*2].r_val_arr[i];

				for(int i = r_start; i <= r_end; i++)
					IDT[cur].r_val_arr[IDT[cur].r_idx++] = IDT[cur*2+1].r_val_arr[i];
				}
			}
			c_max /= 2;
			c = c_max /2;
		}
}
	
	public void read()
	{
		FileReader fr = null;
		try {
//			fr = new FileReader("input.txt");
//			Scanner sc = new Scanner(fr);
			Scanner sc = new Scanner(new InputStreamReader(System.in));
			N = sc.nextInt();

			for(base = 1; base<N; base*=2);
			
			IDT = new node[2*base+1];
			for(int i = base; i < base+N; i++)
			{
				int l = sc.nextInt();
				int r = sc.nextInt();
				node n = new node();
				n.set(l, r,i,N);
				IDT[i] = n;
			}
		}
		catch (Exception e) {}
	}
}

class MyComparator implements Comparator<node>
{
	public int compare(node o1, node o2) {
		if(o1.left < o2.left) return -1;
		else if(o1.left > o2.left) return 1;
		else
		return 0;
	}
	
}

class node implements Comparable<node>
{
	int left;
	int right;
	int[] r_val_arr;
	int r_idx = 0;
	int r_max = -1;
	int r_min = -1;
	public void arr_set(int N)
	{
		r_val_arr = new int[N];		
	}
	public void set(int l, int r, int index, int N)
	{
		this.left = l;
		this.right = r;
		this.r_max = r;
		this.r_min = r;
		r_val_arr = new int[N];
		this.r_val_arr[this.r_idx++] = r;
	}
	@Override
	public int compareTo(node o) {
		if(this.left < o.left) return -1;
		else if(this.left > o.left) return 1;
		else
		return 0;
	}
	
}

