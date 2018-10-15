/*package whatever //do not write package name here */

/*DeepCloning of objects in java*/

import java.io.*;

class GFG implements Serializable {
    
    int age;
    String name;
    
    public GFG(int age, String name){
        this.age=age;
        this.name=name;
    }
    
    public void show(){
        System.out.println("age="+age+ " " + "name=" +name);
    }
    
    public static Object deepClone (Object object) {
		
		try {
			ByteArrayOutputStream b = new ByteArrayOutputStream();

			ObjectOutputStream out = new ObjectOutputStream(b);

			out.writeObject(object);
			ByteArrayInputStream bIn = new ByteArrayInputStream(b.toByteArray());

			ObjectInputStream oi = new ObjectInputStream(bIn);

			return (oi.readObject());
		} catch (Exception e) {
			System.out.println("exception:" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
    
class Myclass {
    
	public static void main (String[] args) {
		
		GFG obj1 = new GFG(10, "A");
		obj1.show();
		
		GFG obj2 = (GFG)GFG.deepClone(obj1);
		obj2.show();
		
		GFG obj3 = obj1.add(obj2);
		obj3.show();
		
		
	}
}
