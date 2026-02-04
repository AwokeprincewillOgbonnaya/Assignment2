package Human;

public class Person  {
    private String name;
    private String id;

    public Person(String name,String id){
        this.name=name;
        this.id=id;
    }
public void setName( String name){
   this.name=name;
}
public String getName(){
        return name;
}

public void setId(){
        this.id=id;
}
public String getId(String id){
        return id;
}
}
