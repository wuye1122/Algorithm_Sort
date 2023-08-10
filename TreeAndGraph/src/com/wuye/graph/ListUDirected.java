package com.wuye.graph;

public class ListUDirected {
	/*
	 *  ����ͼ�ڽӱ�  ����ͼ�ڽӱ�ȫ��������
	 * 
	 *  * ����weight��ĵط� �ڶ���ENode���ʱ��  ���һ������int weight
	 *  
	 *    �ڽ��г�ʼ����ʱ�� int weight=edge[i][2];ȡ��weight
	 * 
	 *  ����ͼ�ڽӱ� 
	 * 
	 * */
	//���ȶ���ڵ���
	private class ENode{
		public int tp;
        public int weight; 
		public ENode nextNode;
	}

	//��ζ��嶥����
	private class TOP{
		public String data;

		public ENode first;

	}

	public TOP[] top;//���嶥������


	//���������г�ʼ���ڵ� �ͱ�
	ListUDirected(String [] ch,String[][]ch1){


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
			int weight=Integer.parseInt(ch1[i][2]);
			
			
			ENode en=new ENode();//�½��ڵ�

			en.tp=p2;
            en.weight=weight;
			if(top[p1].first==null){
				top[p1].first=en;
			}else{
				lastNode(top[p1].first,en);
			}
		}

	}
	
	//����ͼ  ���ֶ�������ͼ�ıȽϷ���  һ����ֻ��Ҫ�����һ����
	ListUDirected(String[][]ch1,String [] ch){


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
			int weight=Integer.parseInt(ch1[i][2]);

			ENode en=new ENode();//�½��ڵ�

			en.tp=p2;
			en.weight=weight;

			if(top[p1].first==null){
				top[p1].first=en;
			}else{
				lastNode(top[p1].first,en);
			}
			
			ENode en1=new ENode();
			en1.tp=p1;
			en1.weight=weight;
			if(top[p2].first==null){
				top[p2].first=en1;
			}else{
				lastNode(top[p2].first,en1);
				
			}
			
		}

	}
	
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
				System.out.print(pp.tp+"("+top[pp.tp].data+")"+"Ȩֵ"+pp.weight+"  ");
				pp=pp.nextNode;
			}
			System.out.println(" ");
		}	
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String []str={"A","B","C"};
      
      String [][]str1={{"A","B","3"},{"B","C","4"},{"A","C","5"}};
		ListUDirected lud=new ListUDirected(str,str1);
		System.out.println("����������ͼ���ڽӱ�");
		lud.printList();
		
		
		 String [][]str2={{"A","B","2"},{"B","A","2"},{"B","C","3"},{"C","B","3"},{"A","C","4"},{"C","A","4"}};
		ListUDirected lud2=new ListUDirected(str,str2);
		System.out.println();
		System.out.println("����������ͼ���ڽӱ�");
		lud2.printList();
		
		  
	}

}
