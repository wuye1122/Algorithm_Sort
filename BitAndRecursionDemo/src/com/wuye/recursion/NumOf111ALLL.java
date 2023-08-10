package com.wuye.recursion;

public class NumOf111ALLL {

	/* 
	 * rescursion-�����ִ�ת������ĸ��ϵ�����
	 * 
	 * 
	 * 
	 * ***C(3,1)=C(3,2)
	 * �������Ҫ�ѵ�:C(4,1)=C(4,3)
	 *           C(4,2)=C(4,2) 
	 * 
	 * 
	 * 
	 *  ���ڱ����ݹ�:Ҫ������1-9  ��ĸA-Z 
	 *  
	 *  
	 *   
	 *  1111--> AAAA  AAL LAA LL ALA  ����5
	 * 
	 *  P[i]:����[0,i-1]�ѽ�ת�����     [i,N-1]�м������
	 *  
	 *  123   3�� 
	 *  
	 *  ��һ�����(����λ�̶��� i+1,N  ��ʣһλ�� �������)
	 *  p[i]='1'-'9' ����p[i]=p[i+1],��Ϊǰ�߰��������Ԫ�ء�
	 *  
	 *   p[1] p[i+1]=BC  X=2  P[i]=2  
	 *   
	 *   
	 *  
	 *    
	 *  
	 *  
	 *  p[i,i+1]="10"-"26" p[i]=p[i]+p[i+2]
	 *  
	 *     p[i+2]=1 MC   P[i]=2+p[i+2]=3
	 *     
	 *     p[i+2]=p[3]=p[length]=1���һλ�ˡ�
	 *     
	 *  p[0]=3
	 *  p[1]=2
	 *  p[2]=1
	 *  
	 *  ����:�����ݹ�ķ�֧p(i+1)  p(i+2) һ����N��
	 *  
	 *     ʱ�临�Ӷ�O(2^n)  �ݹ�ʹ�õĺ���ջ �ռ临�Ӷ�O(N);
	 *       
	 *      
	 *       
	 *       
	 *     
	 * 
	 * */
	
	//����һ:
	public int Recusion1(String str){
		if(str.equals("")||str==null){
			return 0;
		}
		char []ch=str.toCharArray();
		return p(ch,0);
	}
	
	
	//����[i,N-1]�м�����ת������
	
	public int p(char[]ch,int i){
		if(i==ch.length){
			return 1;//���i�Ѿ��ﵽ��β�� ��ôi=1��ʣһ��Ԫ����
		}
		if(ch[i]=='0'){
			return 0;//�������0��ô���ܽ���ת��			
		}	
		int res=p(ch,i+1);
		if(i+1<ch.length&&((ch[i]-'0')*10+ch[i+1]-'0'<27)){//iһ��Ҫ�ǵ����ڶ�λ
			res+=p(ch,i+2);		
		}
		return res;	
	}
	
     /*�������������ǿ���ָ�� p(i)=p(i+1)+p(i+2)����쳲��������й�������	
	
	
	    ��Ϊ��˳����㱾���ʱ�临�Ӷȿ��Ե���O(N)
	    ��Ϊ����ʹ�õ���p(i)�ж��Ƿ����0,��״̬ת�Ƶı��ʽ
	    ������ʹ�� ����˷������Ż�   �ﵽO(logN)
	 112221212121�������ַ����Ϳ��ԴﵽO(logN)   
	    
	    
	    
	    
   	    쳲������������ϸ���  p(i)=p(i+1)+p(i+2)�Ĺ��� 
                ʹ�þ���˷������Ż��ﵽO(logN)
	
	
	
	
	*/
	//������:
	public int Recusion2(String st){
		if(st==null||st.equals(" ")){
			return 0; 	
		   }
		char []ch=st.toCharArray();
		
		int cur=ch[ch.length-1]=='0'?0:1;
		//�������һ��Ԫ�����Ϊ0��ת������  �����Ϊ0��ת��
		
		int next=1;//next����  ��һ��֮ǰ  �Ҵ�ʱ������
		int tem=0;//��ʱ����
		
		for(int i=ch.length-2;i>=0;i--){
			if(ch[i]=='0'){
				next=cur;
				cur=0;
			}
			else {
				
				tem=cur;//��ʱ���������� ���� ��ס��һ�ε� ֵ
				        //�ô�ʱ��cur��ȥ�ж�  �Ƿ� ��ס��λ�������
				
				if(i+1<ch.length&&((ch[i]-'0')*10+ch[i+1]-'0'<27)){//iһ��Ҫ�ǵ����ڶ�λ
					cur+=next;	
				}
				  next=tem;
				
			}
		}
		return cur;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumOf111ALLL rr=new NumOf111ALLL();
		
		System.out.println(rr.Recusion2("1111"));
		
        System.out.println('X'-'A');
	}

}
