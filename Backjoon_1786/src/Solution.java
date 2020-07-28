//Kimminseok
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args)
	{
		String[] input_data = new String[2];
		ArrayList<Integer> start_point2 = new ArrayList<Integer>();
		
		input_data = new Read().data_read();
		result_print r = new result_print();
		
		KMP kmp = new KMP(input_data);
		kmp.run_kmp();
		start_point2 = kmp.get_start_position();
		r.KMP_result_print(start_point2);
	}
}
class result_print
{

	public void KMP_result_print(ArrayList<Integer> point)
	{
		System.out.println(point.size());
		for(int i = 0; i < point.size(); i++)
		{
			System.out.println(point.get(i)+1);
		}
	}

}
class Read
{
	String[] Return_String_arr = new String[2];
	String Pattern;
	String Text;
	public String[] data_read()
	{	
	Scanner sc = new Scanner(System.in);
			Text = sc.nextLine();
			Return_String_arr[0] = Text;
			Pattern = sc.nextLine();
			Return_String_arr[1] = Pattern;
		return Return_String_arr;
	}
}

class N_Find
{
	int i = 0;
	int j = 0;
	int start = 0;
	int lasts;
	int lastp;
	int endmatch;
	char[] string;
	char[] pattern;
	ArrayList<Integer> p_start_point = new ArrayList<Integer>();
	public ArrayList<Integer> nfind(String[] input)
	{
		string = input[0].toCharArray();
		pattern = input[1].toCharArray();
		lasts = string.length -1;
		lastp = pattern.length -1;
		endmatch = lastp;
		for(i = 0; endmatch <=lasts; endmatch++, start++ )	//i = 0 초기화 없어도 상관없음.
		{
			if(string[endmatch] == pattern[lastp])
			{
				for(j = 0, i = start; j< lastp && string[i] == pattern[j] ; i++ ,j++);
				if( j == lastp)
				{
					p_start_point.add(start);
				}
			}
		}
		return p_start_point;
	}
}

class KMP
{
	char[] T;
	char[] P;
	int[] F;
	int m;
	int n;
	int j = 0;
	ArrayList<Integer> start_point = new ArrayList<Integer>();

	KMP(String[] input)
	{
		this.T = input[0].toCharArray();
		this.P = input[1].toCharArray();
		this.F = new int[P.length];
		this.n = T.length;
		this.m = P.length;
	}
	public void run_kmp()
	{
		initializeF();				
		j = -1;
		for(int i = 0; i <= n-1; i++)
			{
				while(j>= 0 && P[j+1] != T[i])
                    j = F[j];
				if(P[j+1] == T[i])
					j++;
				if(j == m-1)
				{
					start_point.add(i-(m-1)); 
					j = F[j];	
				}
			}
 	}
	public void initializeF()
	{
		this.F[0] = -1;
		int k = 0;
		for(int i = 1; i < m; i++)
		{
			k = F[i-1];
			while(k >= 0 && P[k+1] != P[i])
				k = F[k];
			if(P[i] == P[k+1])
				F[i] = k+1;
			else F[i] = -1;
		}
	}
	public int[] get_f()
	{
     	return this.F;
	}
	public ArrayList<Integer> get_start_position()
	{
		return this.start_point;
	}

}