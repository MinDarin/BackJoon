import java.io.BufferedReader;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for(int i = 0; i < N ; i++)
		{
			A[i] = sc.nextInt();
		}
		int B = sc.nextInt();
		int C = sc.nextInt();
		int sum = 0;
		int k = 0;
		QuickSort q = new QuickSort(N,A);
		q.run(0,N-1);
		for(int i= 0 ; i < N ; i++)
		{
			if(i>=1 && A[i] == A[i-1])
			{
				sum += (k+1);
				continue;
			}					
			while(true)
			{
				if(A[i] <= B + C*k)
					break;
				else k++;
			}
			sum+=(k+1);
		}
		System.out.println(sum);
	}
}
class QuickSort
{
	int[] A;
	int N;
	QuickSort(int N, int[] a)
	{
		this.N = N;
		this.A  = a;
	}
	public void run(int start, int end)
	{
		if(start > end);
		else {
			int pivot = this.sorting(start, end);
//			if(pivot <= start) break;
			this.run(start, pivot-1);
			this.run(pivot+1, end);
		}
	}

	public int sorting(int start, int end)
	{
		int j = start+1;
		int pivot_val = A[start];
		int i = start+1;
		while(j <= end)
		{
			if(pivot_val > A[j])
			{
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
				i++;
			}
			j++;
		}
		
		int temp = A[i-1];
		A[i-1] = A[start];
		A[start] = temp;
		
		return i - 1;
	}
}
class node
{
	int n;
	int k;
	node(int K, int N)
	{
	this.n = N;
	this.k = K;
	}
}