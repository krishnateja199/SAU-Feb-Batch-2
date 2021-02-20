
class Main 
{ 
    public static void main(String args[]) 
    { 
        Singleton ref = Singleton.getInstance(); 
  
             ref.s = (ref.s).toUpperCase(); 
  
        System.out.println("String  x is " + ref.s); 
      
        
    } 
} 
class Singleton 
{ 
    private static Singleton single_instance = null; 
     public String s; 
     private Singleton() 
    { 
        s = "singleton_class"; 
    } 
  public static Singleton getInstance() 
    { 
      
        if (single_instance == null) 
            single_instance = new Singleton(); 
  
        return single_instance; 
    } 
} 