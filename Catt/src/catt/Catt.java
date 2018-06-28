package catt;


public class Catt {
    
    public String name = "Catto";
    public String food = "fish";
    
    
    public static void main(String[] args) {
        
        Animal a = new Animal();
        System.out.println(a.name);
        a.talk();
        
        Queen b = new Queen();
        System.out.println(b.name);
        b.talk();
        
        Tomcat c = new Tomcat();
        System.out.println(c.name);
        c.talk();
    }
    
}

class Animal {
    
    public String name = "Ket";
    public String food = "fish";
    
    public void talk() {
        System.out.println("Nyaa~");
    }
}

class Queen extends Animal{
    
    public String name = "Catto";
    public String food = "fish";
    
    
    public void talk() {
        System.out.println("Ooh Nyaa Nyaa~");
    }
    
}

class Tomcat extends Queen {
    
    public String name = "Leo";
    public String food = "fish";
            
    public void talk() {
        System.out.println("Nyaaaa");
    }
}

class Persian extends Animal{
    
    public String name = "Catto";
    public String food = "fish";
    
    public void talk() {
        System.out.println("kkkkkkkkk");
    }
    
}