package com.wuye.graph;

import java.util.LinkedList;
import java.util.Queue;


public class Topological {
/*
 * ��Ҫ���:��һ�������޻�ͼ DAG ������������õ���һ���������������
 *  
 *       ���ǰ��ռ�ͷ��˳�� ��������ϵ�������ȱ������� 
 *       
 *       
 *      
 * 
 * */
	//���ȶ���ڵ���
		private class ENode{
			public int tp;
	     
			public ENode nextNode;
		}

		//��ζ��嶥����
		private class TOP{
			public String data;

			public ENode first;

		}

		public TOP[] top;//���嶥������


		//���������г�ʼ���ڵ� �ͱ�
		Topological(String [] ch,String[][]ch1){


			//���г�ʼ���ڵ�
			top=new TOP[ch.length];
			for(int i=0;i<ch.length;i++){
				top[i]=new TOP();
				top[i].data=ch[i];
				top[i].first=null;//��ʱ��û�нڵ� Ҳ����û��������
			}


			for(int i=0;i<ch1.length;i++){

				int p1=getPostion(ch1[i][0]);
				int p2=getPostion(ch1[i][1]);
				
				
				
				ENode en=new ENode();//�½��ڵ�

				en.tp=p2;
	        
				if(top[p1].first==null){
					top[p1].first=en;
				}else{
					lastNode(top[p1].first,en);
				}
			}

		}
		
		//����ͼ  ���ֶ�������ͼ�ıȽϷ���  һ����ֻ��Ҫ�����һ����
		
		
		//����ָ����������top��������

		public int getPostion(String ch){
			for(int i=0;i<top.length;i++){
				if(top[i].data.equals(ch)){
					return i;
				}
			}
			return -1;//û�ҵ�

		}

		//���µĽڵ����ӵ�ǰ��ڵ�����
		public void lastNode(ENode list,ENode node){
			ENode pp=list;
			while(pp.nextNode!=null){
				pp=pp.nextNode;
			}
			pp.nextNode=node;
		}


		//������д�ӡ

		public void  printList(){

			for(int i=0;i<top.length;i++){

				System.out.print(i+"["+top[i].data+"]:");
				ENode pp=top[i].first;
				while(pp!=null){
					System.out.print(pp.tp+"("+top[pp.tp].data+")");
					pp=pp.nextNode;
				}
				System.out.println(" ");
			}	
		}
		
		
		
		//������������
		public int tipolo(){
			
			int index=0;
			
			int num=this.top.length;
			
			Queue<Integer> queue=new LinkedList<Integer>();// ��������
			
			int [] ru=new int[num];//�����������
			
			String[] results=new String[num];//���������˳��
		
		   for(int i=0;i<num;i++){
			   ENode node=top[i].first;
			   while(node!=null){
				   ru[node.tp]++;
				   node=node.nextNode;
			   }
		   }
		
		   
		    //�����Ϊ0�Ľڵ�����������
		    for(int i=0;i<num;i++){
		    	if(ru[i]==0){
		    		queue.offer(i);
		    	}
		    }
		    
		    while(!queue.isEmpty()){
		    	
		    	int j=queue.poll().intValue();//ȡ��
		    	
		    	//��������뵽�������� results
		    	results[index++]=top[j].data;
		    	
		    	
		    	//ȡ���ڵ�ִ��Ľڵ�
		    	ENode node=top[j].first;
		    	
		    	while(node!=null){
		    		
		    		
		    		ru[node.tp]--;
		    		
		    		if(ru[node.tp]==0){
		    			queue.offer(node.tp);
		    		}
		    	    node=node.nextNode;
		    	}
		    	
		    }
		    
		    if(index!=num){
		    	System.out.println("ͼ�ǻ�");
		    	return 1;
		    }
		    
		    System.out.println("ͼ��������������:");
		    for(int i=0;i<num;i++){
		    	System.out.println(results[i]);
		    }
			return 0;
		    
		}
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String[] vexs = {"A", "B", "C", "D", "E", "F", "G"};//��������
	        String[][] edges = new String[][]{//�����飬����A->G B->A��
	            {"A", "G"}, 
	            {"B", "A"}, 
	            {"B", "D"}, 
	            {"C", "F"}, 
	            {"C", "G"}, 
	            {"D", "E"}, 
	            {"D", "F"}}; 
	        Topological topolog=new Topological(vexs,edges);
	        topolog.printList();
	        
	        System.out.println("����ͼ�ı�������:���������������");
	        
	        topolog.tipolo();
	        
	}

}
