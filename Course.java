import java.util.*;
public class Course{
    private String name;
    private int credits;
    private String type;
    private ArrayList<String> profs = new ArrayList<String>();
    void setName(String s){
        this.name = s;
    }
    void setCredits(int f){
        this.credits=f;
    }
    void setType(String s)
    {
    	this.type = s;
    }
    String getName(){
        return this.name;
    }
    int getCredits(){
        return this.credits;
    }
    String getType()
    {
    	return this.type;
    }
    void addProfs(String s){
        this.profs.add(s);
    }
    int getProfsSize(){
        return this.profs.size();
    }
    String getProfsItem(int d){
        return this.profs.get(d);
    }
}