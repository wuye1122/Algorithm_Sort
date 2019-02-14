package com.wuye.array;

import java.util.LinkedList;
import java.util.Queue;

public class Test1{

public int minPathValue(int [][]m){

 if(m==null||m.length==0||m[0].length==0||m[0][0]!=0||m[m.length-1][m.length-1]!=0){
    
       return -1;
 }
      int res=0;
      int[][]map=new int[m.length][m[0].length];
      map[0][0]=1;
      Queue<Integer> rq=new LinkedList<Integer>();//行坐标
       Queue<Integer> cq=new LinkedList<Integer>();//列坐标
      rq.add(0);
      cq.add(0);
      int r=0;
      int c=0;
      while(!rq.isEmpty()){
      r=rq.poll();
      c=cq.poll();
            if(r==m.length-1&&c==m[0].length-1){
             return map[r][c];
            }
            walk(map[r][c],r-1,c,m,map,rq,cq);//up
            walk(map[r][c],r+1,c,m,map,rq,cq);//dowm
            walk(map[r][c],r,c-1,m,map,rq,cq);//left
            walk(map[r][c],r,c+1,m,map,rq,cq);//right
      }
            return res;
}

public void walk(int pre,int tor,int toc,int[][]m, int [][]map,Queue<Integer> rq,Queue<Integer> cq){

  if(tor<0||tor==m.length||tor<0||toc==m[0].length||m[tor][toc]!=0||map[tor][toc]!=0){
     return;
  }
       map[tor][toc]=pre+1;
      rq.add(tor);
      rq.add(toc);

}
    public static void  main(String []args){
    int [][]arr={{0,1,0,0},{0,0,0,1},{1,0,1,0},{0,0,0,0}};
    
    System.out.println(new Test1().minPathValue(arr));
    
    }




}