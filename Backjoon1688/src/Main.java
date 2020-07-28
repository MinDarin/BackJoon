import java.io.BufferedReader; //백준 테스트용 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int N = sc.nextInt();
		Point[] P = new Point[N+1];
		for(int i = 1; i <=N;i++)
		{
			int temp_x = sc.nextInt();
			int temp_y = sc.nextInt();
			Point temp = new Point(temp_x,temp_y);
			P[i] = temp;
		}
		P[0] = P[N];
		while(sc.hasNext())
		{
		int temp_x = sc.nextInt();
		int temp_y = sc.nextInt();		
		Point check_point = new Point(temp_x, temp_y);
		IsPointInside is = new IsPointInside();
		boolean result = is._IsPointInside(check_point, P, N);
		if(result == true)
			System.out.println("1");
		else System.out.println("0");
		}
	}
}

class Point
{
	int x = 0;
	int y = 0;
	Point()
	{
		
	}
	Point(int X,int Y)
	{
		this.x = X; this.y = Y;
	}
}
class Line
{
	Point P1 = new Point();
	Point P2 = new Point();
	Line()
	{}
		
	Line(Point p1, Point p2)
	{
		this.P1= p1;
		this.P2 = p2;
	}
	public void set_line(Point p1, Point p2, boolean if_need, int other)
	{
		this.P1.x = p1.x;
		this.P1.y = p1.y;
		this.P2.x = p2.x;
		this.P2.y = p2.y;
		if(if_need == true)
		{
			this.P2.x = other;
		}
	}
}

class Intersection
{
	public boolean _Intersection(Line AB, Line CD)
	{
		boolean lineCrossing = false;
		Direction d =new Direction();
		if((d._Direction(AB.P1, AB.P2, CD.P1) *
				d._Direction(AB.P1, AB.P2, CD.P2)<= 0 ) 
							&& ((d._Direction(CD.P1, CD.P2, AB.P1) *
									d._Direction(CD.P1, CD.P2, AB.P2)<= 0 )) )
			lineCrossing = true;
		else lineCrossing = false;
		return lineCrossing;
	}
}
class Direction
{
	public int _Direction(Point A, Point B, Point C)
	{
		int dxAB ,dxAC, dyAB, dyAC, Dir = -2;
		dxAB = B.x - A.x;
		dyAB = B.y - A.y;
		dxAC = C.x - A.x;
		dyAC = C.y - A.y;
		if( dxAB*dyAC < dyAB*dxAC) Dir = 1;
		if( dxAB*dyAC > dyAB*dxAC) Dir = -1;
		if( dxAB*dyAC == dyAB*dxAC)
		{
			if(dxAB == 0 && dyAB == 0)
				Dir = 0;
			else if(dxAB*dxAC < 0 || dyAB*dyAC < 0) Dir = -1;
			else if((dxAB*dxAB + dyAB*dyAB) >= (dxAC*dxAC + dyAC *dyAC))  Dir = 0;
			else Dir = 1;
		}
		return Dir;
	}
}
class IsPointInside
{
	public boolean _IsPointInside(Point A, Point[] P, int n)
	{
		Intersection is = new Intersection();
		Direction d = new Direction();
		
		int Count;
		int i;
		int LastPoint;
		Line TestLine = new Line();
		Line PolygonLine = new Line();
		boolean PointOnTestLine = false;
		Count = 0;
		LastPoint = 0;
		TestLine.set_line(A, A, true, 1000000001);
		for(i = 1; i <= n; i++)
		{
			PolygonLine.set_line(P[i], P[i], false, 0);

			if(is._Intersection(TestLine, PolygonLine))
				PointOnTestLine = true;
			else 
			{
				PolygonLine.set_line(PolygonLine.P1,P[LastPoint],false,0);
				
				LastPoint = i ;
				if(!PointOnTestLine)
				{
					if(is._Intersection(PolygonLine, TestLine))
					{
						Count++;
					}
				}
				else
				{
						if(d._Direction(TestLine.P1, TestLine.P2, PolygonLine.P1) * d._Direction(TestLine.P1, TestLine.P2, PolygonLine.P2) < 0)
						{
							Count++;
//							PointOnTestLine = false;
						}
				}
				PointOnTestLine = false;
	
			}
		}

		if(Count % 2 == 1)
			return true;
		else return false;
	}
}