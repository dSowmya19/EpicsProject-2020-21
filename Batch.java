import java.util.*; 
public class Batch extends Timetable{
    static Random rand = new Random(); 
    static ArrayList<Integer> list = new ArrayList<Integer>();
    static ArrayList<Integer> cbcs_list = new ArrayList<Integer>();
    static ArrayList<Integer> lab_list = new ArrayList<Integer>(Arrays.asList(33,34,35));
    boolean add(Course x,Professor y){
        int i,j,k,m,n;
        int[] cbcs_classes = {53,54,55,60,61,62,63,64,65};
        if(x.getType() == "CBCS") {
        	for(int hours : cbcs_classes)
        	{
        		i = hours/10;
        		j = hours%10;
        		if(this.a[i][j] == null) {cbcs_list.add(hours);}
        	}
        	System.out.println(cbcs_list);
        	if(cbcs_list.size()>=x.getCredits())
        		{
	            for(i=0;i<x.getCredits();i++){
	                k=rand.nextInt(cbcs_list.size());
	                n=cbcs_list.get(k)%10;
	                m=cbcs_list.get(k)/10;
	                this.a[m][n]=x.getName()+"("+y.getName()+")";
	                
	                cbcs_list.remove(k);
	            }
	            cbcs_list.clear();
	            return true;
        		}
        	else {cbcs_list.clear();return false;}
        	
        }
        else if(x.getType().equals("Lab"))
        {
        	if(lab_list.size()>2*x.getCredits()) {
        		for(i = 0;i<2;i++)
        		{
        			m = lab_list.get(i)/10;
        			n = lab_list.get(i)%10;
	                this.a[m][n]=x.getName()+"("+y.getName()+")";
	                y.a[m][n]=this.getName()+"("+x.getName()+")";
	                lab_list.remove(i);
        		
        		}
	            lab_list.clear();
	            return true;
        	}
	            else
	            {
	            	lab_list.clear();
	            	return false;
	            }
        }

        else
        {
	        for(i=0;i<6;i++){
	            for(j=0;j<6;j++){
	            	if(i == 5 && (j ==3 || j==4 || j==5))continue;
	                if(y.a[i][j]==null && this.a[i][j]==null){
	                    list.add(i*10 + j);
	                }
	            }
	        }
	
	        if(list.size()>=x.getCredits()){
	            for(i=0;i<x.getCredits();i++){
	                k=rand.nextInt(list.size());
	                n=list.get(k)%10;
	                m=list.get(k)/10;
	                this.a[m][n]=x.getName()+"("+y.getName()+")";
	                y.a[m][n]=this.getName()+"("+x.getName()+")";
	                list.remove(k);
	            }
	            list.clear();
	            return true;
	        }
	        else {
	        list.clear();
	        return false;
	        }
	    }
    }
}