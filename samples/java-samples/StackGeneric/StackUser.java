class StackUser {
	
	public static void main(String[] args) {
		 Stack<String> aStack= new Stack<String>();
		 
		 System.out.println("********** StackUser started *******");

		 aStack.push("hello");
		 aStack.push("world");
		 System.out.println("aStack.pop = " + aStack.pop());
		 
		 System.out.println("********** StackUser finished *******");
	}

}
