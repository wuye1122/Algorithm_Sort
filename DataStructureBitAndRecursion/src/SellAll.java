import java.util.HashMap;


public class SellAll<V> {
/*
 * 
 *   哈希表 回头再续
 *  常见的哈希表: put  get  containKey  setAll
 *  
 *  为每一个数据value 增加一个time
 *  添加时候设置好时间
 * 
 *  我是真的真的一点也不懂  ？？？？？
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
	
	private V value;
	private long time;
	
	
	public SellAll(V value, long time) {
		
		this.value = value;
		this.time = time;
	}


	public V getValue() {
		return value;
	}


	public long getTime() {
		return time;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class MyHashMap<K,V>{
	
	
	private HashMap<K,SellAll<V>> mymap;
	
	private long time;
	
	private SellAll<V> value;
	
	
	public boolean containkey(K key){
		return this.mymap.containsKey(key);
	}
	
	public void put(K key,V value){
		this.mymap.put(key, new SellAll<V>(value,time++));
		
	}
	
	public void setAll(V value){
		this.value=new SellAll<V>(value,time++);
		
	}
	
	public V get(K key){
		if(this.containkey(key)){
			if(this.mymap.get(key).getTime()>this.value.getTime()){

				return this.mymap.get(key).getValue();
			}else{
				
			    return this.value.getValue();
			}
			}
			
		else{
			return null;
		}
		
	}
}
