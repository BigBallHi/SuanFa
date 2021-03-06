
算法逻辑没问题，但是数据结构有大问题。
1、存图用的是邻接矩阵，一个10000*10000的int型二维矩阵所占内存=（10000*10000）*4/1024/1021 = 381MB;所以肯定会超空间
2、算法复杂度 = O(n^2);
3、某个节点的邻节点不能从矩阵里面体现出来，所以每次访问某点的邻接点都要从第一个点开始遍历

import java.util.Random;
import java.util.Scanner;

public class Main{
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int s = in.nextInt();
		int[][] g = new int[n+1][n+1];
		int a = 0;
		int b = 0;
		int c = 0;
		for(int j = 0;j<=n;j++){
			for(int k = 0;k<=n;k++){
				g[j][k]=1001;
			}
		}
		for(int i = 1;i<=s;i++){
			a = in.nextInt();
			b = in.nextInt();
			c = in.nextInt();
			g[a][b] = c;
			g[b][a] = c;
		}
		dijkstra(g);
	}
		public static void dijkstra(int[][] g){
		int n = g[0].length-1;
		boolean[] isMin = new boolean[n+1];
		int[] dij = new int[n+1];
		int[] pre = new int[n+1];
		for(int i = 2;i<=n;i++){
			dij[i] = g[1][i];
		}
		int k = 1;
		int min = 1001;
		dij[1] = 0;
		int sum = 0;
		for(int i =1;i<=n-1;i++){
			isMin[k] = true;
			for(int j = 2;j<=n;j++){
				if(isMin[j]==false){
					if(dij[j]>=dij[k]+g[k][j]){
						dij[j] = dij[k]+g[k][j];
						pre[j] = k;
						//System.out.println("通过 "+k+" 更新 "+j+"dij["+j+"] = "+dij[j]);
					}
				}
			}
			min = 1001;
			for(int z = 1;z<=n;z++){
				if(isMin[z] == false){
					if(dij[z]<min){
						min = dij[z];
						k=z;
						
						
					}
				}
			}
			//System.out.println(pre[k]+"--> "+ k+"------------"+g[pre[k]][k]);

			sum+=g[pre[k]][k];

			
		}
		System.out.println(sum);
		
	}
}
