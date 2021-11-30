package collections;

public class Queue<T> implements InterfaceQueue<T>{

	
	private LinkedList<T> value;
	
	private LinkedList<T> lastValue;



	public Queue() {
		
		value = null;
		
		lastValue = null;


	}
	
	
	@Override
	public void add(T element) {
		
		
		LinkedList<T> newValue = new LinkedList<T>(element);
		
		if(isEmpty()==true) {
			
			value = newValue;
		}else {
			lastValue.setNext(newValue);
		}
		lastValue = newValue;
	}

	@Override
	public T remove() {
		
		if(isEmpty()==true) {
				
			return null;
		}else {
			T newValue = value.getObject();
			value = value.getNext();
				
			return newValue;
		}
		
	}


	@Override
	public T peek() {
		return value.getObject();
	}


	@Override
	public boolean isEmpty() {
		if(value==null) {
			return true;
		}else {
			return false;
		}
		
	}

	public int getSize() {

		if(value==null){
			return 0;
		}else{

			int size = 1;
			LinkedList<T> tmp = value;
			while(tmp!=null) {

				size++;
				tmp = tmp.getNext();
			}
			return size;
		}

	}
}
