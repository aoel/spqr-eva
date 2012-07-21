public class Stack<T> {
	
  private class StackStorage {
    T object;
	StackStorage prev;
  }
  
  StackStorage top;
  
  public Stack() {top = new StackStorage(); }
  
  public void push(T obj) {
    StackStorage store = new StackStorage();
	store.prev = top;
	store.object = obj;
	top = store;
  }
  
  public T pop() {
    T ret = top.object;
	top = top.prev;
	return ret;
  }
}
