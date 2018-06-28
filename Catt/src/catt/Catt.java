package catt;


public class Catt {
    
    public String name = "Ket";
    public String food = "fish";
    
    
    public static void main(String[] args) {
        
        Animal a = new Animal();
        System.out.println(a.name);
        a.talk();
        
        Animal b = new Animal();
        System.out.println(b.name);
        b.talk();
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
    
    @Override
    public void talk() {
        System.out.println("Ooh Nyaa Nyaa~");
    }
    
}

class Tomcat extends Queen {
    
    public String name = "Leo";
}
