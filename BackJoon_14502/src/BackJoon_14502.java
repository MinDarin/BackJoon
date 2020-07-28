/*
 * import java.io.BufferedReader; import java.io.FileNotFoundException; import
 * java.io.FileReader; import java.io.FileWriter; import java.io.IOException;
 * import java.io.InputStreamReader; import java.io.Reader; import
 * java.util.Scanner;
 * 
 * public class BackJoon_14502 { public static void main(String[] args) { new
 * lab(); } }
 * 
 * class lab{ int N = 0;//Çà int M = 0;//¿­ int[][] map; int[][] recovery_position
 * = new int[3][2]; int real_max = 0; queue virus_position = new queue(); queue
 * q = new queue(); lab(){ this.input(); this.set_wall();
 * System.out.println(real_max); }
 * 
 * int[][] save_map; public void input() { InputStreamReader r = new
 * InputStreamReader(System.in); BufferedReader bf =new BufferedReader(r); try {
 * String s = bf.readLine(); String[] s_arr; s_arr = s.split(" "); N =
 * Integer.parseInt(s_arr[0]); M = Integer.parseInt(s_arr[1]); map = new
 * int[N][]; save_map = new int[N][]; for(int i = 0; i < N ; i++) { map[i] = new
 * int[M]; save_map[i] = new int[M]; s = bf.readLine(); s_arr = s.split(" ");
 * for(int j = 0; j < M ; j++) { map[i][j] = Integer.parseInt(s_arr[j]);
 * if(map[i][j] == 2) { node n = new node(i,j); q.push(n); node n2 = new
 * node(i,j); virus_position.push(n2); } } } } catch (IOException e) { // TODO
 * Auto-generated catch block e.printStackTrace(); }
 * 
 * } public void file_output(String s) { try {
 * 
 * @SuppressWarnings("resource") FileWriter fw = new FileWriter("output.txt");
 * fw.write(s); } catch (IOException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); }
 * 
 * } public void set_wall() { Stack s = new Stack(); Virus v = new Virus();
 * find_max fm = new find_max(); int wall_num = 0;
 * 
 * for(int i1 = 0 ; i1 < N ; i1++) { for(int j1 = 0; j1 < M; j1++) {
 * if(map[i1][j1] == 0) wall_num = s.push(i1,j1, map); else continue; for(int i2
 * = i1 ; i2 < N ; i2++) { int t2; if(i2 == M-1) t2 = 0; else t2 = i2; for(int
 * j2 = t2; j2 < M; j2++) { if(map[i2][j2] == 0) wall_num = s.push(i2,j2, map);
 * else continue; for(int i3 = i2 ; i3 < N ; i3++) { int t3; if(i3 == M-1) t3 =
 * 0; else t3 = i3; for(int j3 = t3; j3 < M; j3++) { if(map[i3][j3] == 0) {
 * wall_num = s.push(i3, j3,map); // map = s.renewal_map(); if(wall_num == 3) {
 * // map = s.renewal_map();
 * 
 * for(int temp_i = 0 ; temp_i < N; temp_i++) for(int temp_j = 0 ; temp_j < N;
 * temp_j++) save_map[temp_i][temp_j] = map[temp_i][temp_j];
 * 
 * int[][] spreaded_map = v.spread(map,N,M,q); int temp_sum =
 * fm.max_sum(spreaded_map, N,M); //
 * System.out.println("["+i1+","+j1+"]"+"["+i2+","+j2+"]"+"["+i3+","+j3+"]"+
 * temp_sum); if(real_max < temp_sum) { System.out.println(); for(int k = 0; k
 * <N; k++) { for(int l =0; l <M;l++) System.out.print(map[k][l]+" ");
 * System.out.println(); } real_max = temp_sum;
 * System.out.println("º®"+"["+i1+","+j1+"]"+"["+i2+","+j2+"]"+"["+i3+","+j3+"]"+
 * temp_sum); } fm.reset_max();
 * 
 * for(int temp_i = 0 ; temp_i < N; temp_i++) for(int temp_j = 0 ; temp_j < M;
 * temp_j++) map[temp_i][temp_j] = save_map[temp_i][temp_j];
 * q.reset(virus_position,map); wall_num = s.pop(); } } else continue; } }
 * wall_num = s.pop(); } } wall_num = s.pop(); } } //
 * System.out.println(fm.get_max()); } } class node{ int y = 0; int x = 0; node
 * link; node(int i, int j) { this.y = i; this.x = j; } } class queue{ int size
 * = 0; node head = new node(-1,-1); public void reset(queue restore, int[][]map
 * ) { this.size = 0; this.head = new node(-1,-1); node r = restore.head.link;
 * 
 * while(r != null) { this.push(new node(r.y,r.x)); map[r.y][r.x] = 2; r =
 * r.link; } } public void push(node n) { node temp = null; if(head.link ==
 * null) head.link = n; else { temp = head; while(temp.link !=null) { temp =
 * temp.link; } temp.link = n; } size++; } public node pull() { node return_temp
 * = null; if(size >= 1) { return_temp = head.link; if(size >=2 ) { node temp2 =
 * head.link.link; head.link = temp2; } } size--; return return_temp; } public
 * boolean isEmpty() { if(size == 0) return false; else return true; } } class
 * Virus{
 * 
 * int [][] spreaded_map; node temp_node; int temp_x; int temp_y; public void
 * reset_map(int[][]map,queue restore) { node temp_node2 = restore.head.link;
 * while(temp_node2 != null) { map[temp_node2.y][temp_node2.x] = 2; temp_node2 =
 * temp_node2.link; } } public int[][] spread(int[][] map,int N,int M, queue q)
 * { spreaded_map = map; while(q.isEmpty()) { temp_node = q.pull(); temp_x =
 * temp_node.x; temp_y = temp_node.y;
 * System.out.print("["+temp_y+","+temp_x+"]"); if(temp_y-1>=0)
 * if(map[temp_y-1][temp_x] == 0) { map[temp_y-1][temp_x] = 2; node n = new
 * node(temp_y-1,temp_x); q.push(n); } if(temp_y+1 < N) if(map[temp_y+1][temp_x]
 * == 0) { map[temp_y+1][temp_x] = 2; node n = new node(temp_y+1,temp_x);
 * q.push(n);
 * 
 * } if(temp_x-1 >= 0) if(map[temp_y][temp_x - 1] == 0) { map[temp_y][temp_x -1]
 * = 2; node n = new node(temp_y,temp_x-1); q.push(n);
 * 
 * } if(temp_x+1 < M) if(map[temp_y][temp_x + 1] == 0) { map[temp_y][temp_x +1]
 * = 2; node n = new node(temp_y,temp_x+1); q.push(n); }
 * 
 * for(int k = 0; k <N; k++) { for(int l =0; l <M;l++)
 * System.out.print(map[k][l]+" "); System.out.println(); }
 * System.out.println();
 * 
 * } return spreaded_map; } } class find_max { int max = 0; int sum = 0; public
 * int max_sum(int[][] map, int N, int M) { for(int i = 0 ; i <N; i++) { for(int
 * j = 0 ; j <M ; j++) { if(map[i][j] == 0) { sum++; } } } if(sum > max) {
 * this.max = sum; } return max; } public int get_max() { return this.max; }
 * public void reset_max() { max = 0; sum = 0; } }
 * 
 * class Stack { int count = 0; int[][] recovery_position = new int[3][2];
 * int[][] new_map; Stack() { for(int i = 0 ; i < 3; i ++) for(int j = 0 ; j <2;
 * j++) recovery_position[i][j] = -1; } public int[][] renewal_map() { return
 * new_map; } public int push(int y, int x, int[][] map) {
 * recovery_position[this.count][0] = y; recovery_position[this.count++][1] = x;
 * map[y][x] = 1; this.new_map = map; return this.count; } public int pop() {
 * this.new_map[recovery_position[count-1][0]][recovery_position[count-1][1]] =
 * 0; return --count; } }
 */