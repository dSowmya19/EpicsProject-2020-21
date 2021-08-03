import java.awt.*;
import java.util.*;
import java.awt.event.*;    
import javax.swing.*; 
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;


class Main{  

public static void main(String[] args) throws IOException { 


    Map<String,Batch> B = new HashMap<String,Batch>();
    Map<String,Course> CO = new HashMap<String,Course>();
    Map<String,Professor> PR = new HashMap<String,Professor>();

    JFrame f=new JFrame();  
    JFrame s=new JFrame();  
    JPanel home=new JPanel();
    JLabel l1=new JLabel("Welcome to Timetable Generator");
    l1.setBounds(250,50,850,200);
    l1.setFont(new Font("TimesRoman",Font.BOLD,35));
    BufferedImage image = ImageIO.read(new File("src/timetable.jpeg"));
    JLabel label = new JLabel(new ImageIcon(image));
    label.setSize(600,500);
    label.setBounds(300,20,500,600);
    home.setLayout(null);
    home.setBackground(Color.cyan);
    home.add(label);
    home.add(l1);


   
    JPanel view=new JPanel(); 
    String[] Timet={"Select",};
    String[] profs={"Select"};  
    String[] credits={"1","2","3","4","5","6"};
    String[] course={"Select"};
    JComboBox<?> cr=new JComboBox<Object>(credits);
    JComboBox<String> cb=new JComboBox<String>(Timet); 
    JComboBox<String> pf=new JComboBox<String>(profs);
    JComboBox<?> co=new JComboBox<Object>(course);
    JTabbedPane t=new JTabbedPane();
	JLabel vl=new JLabel("Timetable");
	vl.setBounds(530,5,250,80);
    vl.setFont(new Font("TimesRoman",Font.BOLD,20)); 
	final String timet[][] = { {"Monday","","","","","",""},    
                          {"Tuesday","","","","","",""},    
                          {"Wednesday","","","","","",""},
                          {"Thursday","","","","","",""}, 
                          {"Friday","","","","","",""}, 
                          {"Saturday","","","","","","","",""},
                          {"Sunday","","","","","","","",""}};
	String column[]={"","1","2","3","4","5","6"};
    JTable jt=new JTable(timet,column);
    jt.setSize(1000,100);
    JScrollPane sp=new JScrollPane(jt);
    sp.setSize(1000,150);
    sp.setBounds(100,150,1000,135);
    cb.setBounds(475,70,100,20);
    pf.setBounds(600,70,100,20);
    cb.addActionListener(new ActionListener(){  
	    public void actionPerformed(ActionEvent e){  
            for(int i=0;i<7;i++){
                for(int j=0;j<6;j++){
			        timet[i][j+1]=B.get(cb.getItemAt(cb.getSelectedIndex()).toString()).a[i][j];
                }
            }
            view.revalidate();
            view.repaint();  
        }
    });
    
    pf.addActionListener(new ActionListener(){  
	    public void actionPerformed(ActionEvent e){  
            for(int i=0;i<6;i++){
                for(int j=0;j<6;j++){
			        timet[i][j+1]=PR.get(pf.getItemAt(pf.getSelectedIndex()).toString()).a[i][j];
                }
            }
            view.revalidate();
            view.repaint();  
        }
    });
    view.setLayout(null);
    view.setBackground(Color.cyan);
	view.add(vl); 
	view.add(cb);
    view.add(pf);
    jt.setVisible(true);
    sp.setVisible(true);
    view.add(sp);
    

    JPanel delete=new JPanel(); 
    JLabel d1 = new JLabel("Delete Course");
    d1.setBounds(50,50,500,50);
    d1.setFont(new Font("TimesRoman",Font.BOLD,30));
    JLabel d2 = new JLabel("Course");
    d2.setFont(new Font("TimesRoman",Font.BOLD,20));
    d2.setBounds(50,125,200,50);
    JComboBox<String> d3 = new JComboBox<String>(course);
    d3.setBounds(250,125,200,50);
    JButton d4 = new JButton("Delete");
    d4.setBounds(550,125,200,50);
    d4.setBackground(Color.orange);
    JLabel d5 = new JLabel("Delete Professor");
    d5.setFont(new Font("TimesRoman",Font.BOLD,30));
    d5.setBounds(50,200,500,50);
    JLabel d6 = new JLabel("Professor");
    d6.setFont(new Font("TimesRoman",Font.BOLD,20));
    d6.setBounds(50,275,200,50);
    JComboBox<String> d7 = new JComboBox<String>(profs);
    d7.setBounds(250,275,200,50);
    JButton d8 = new JButton("Delete");
    d8.setBounds(550,275,200,50);
    d8.setBackground(Color.orange);
    JLabel d9 = new JLabel("Delete Batch");
    d9.setFont(new Font("TimesRoman",Font.BOLD,30));
    d9.setBounds(50,350,500,50);
    JLabel d10 = new JLabel("Batch");
    d10.setFont(new Font("TimesRoman",Font.BOLD,20));
    d10.setBounds(50,425,200,50);
    JComboBox<String> d11 = new JComboBox<String>(profs);
    d11.setBounds(250,425,200,50);
    JButton d12 = new JButton("Delete");
    d12.setBounds(550,425,200,50);
    d12.setBackground(Color.orange);
    delete.setBackground(Color.cyan);
    delete.setLayout(null);
    delete.add(d1);
    delete.add(d2);
    delete.add(d3);
    delete.add(d4);
    delete.add(d5);
    delete.add(d6);
    delete.add(d7);
    delete.add(d8);
    delete.add(d9);
    delete.add(d10);
    delete.add(d11);
    delete.add(d12); 



    JPanel createBatch=new JPanel();
    JLabel cb1= new JLabel("Name");
    cb1.setFont(new Font("TimesRoman",Font.BOLD,20)); 
    cb1.setBounds(50,50,200,50);
    JTextField cb2 = new JTextField();
    cb2.setBounds(250,50,200,50);
    JLabel cb3 =new JLabel("Courses");
    cb3.setFont(new Font("TimesRoman",Font.BOLD,20)); 
    cb3.setBounds(50,175,200,50);
    JComboBox<String> cb4 = new JComboBox<String>(course);
    cb4.setBounds(250,175,200,50);
    JComboBox<String> cb7 = new JComboBox<String>(profs);
    cb7.setBounds(550,175,200,50);
    JButton cb5 = new JButton("ADD");
    cb5.setBounds(850,175,200,50);
    cb5.setBackground(Color.orange);
    JButton cb6 = new JButton("Create");
    cb6.setBounds(550,50,200,50);
    cb6.setBackground(Color.orange);
    cb6.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            cb.addItem(cb2.getText());
            d11.addItem(cb2.getText());
            B.put(cb2.getText(),new Batch());
            B.get(cb2.getText()).setName(cb2.getText());
            JOptionPane.showMessageDialog(s,"A new batch "+cb2.getText()+" has been created");
        }
    });
    cb5.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            if(cb4.getSelectedIndex()!=0 && cb7.getSelectedIndex()!=0){
                if(B.get(cb2.getText()).add(CO.get(cb4.getItemAt(cb4.getSelectedIndex()).toString()),PR.get(cb7.getItemAt(cb7.getSelectedIndex()).toString()))){
                    JOptionPane.showMessageDialog(s,"A new course has been added to the batch "+cb2.getText()+"\n"+"Course: "+cb4.getItemAt(cb4.getSelectedIndex()).toString()+"\n"+"Professor: "+cb7.getItemAt(cb7.getSelectedIndex()).toString());
                }
                else{
                    JOptionPane.showMessageDialog(s,"Periods are insufficient for adding this course to the batch");
                }
            }
            else{
                JOptionPane.showMessageDialog(s,"Select a valid course and valid professor");
            }
        }
    });
    cb4.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            cb7.removeAllItems();
            cb7.addItem("Select");
            for(int i=0;i<CO.get(cb4.getItemAt(cb4.getSelectedIndex()).toString()).getProfsSize();i++){
                cb7.addItem(CO.get(cb4.getItemAt(cb4.getSelectedIndex()).toString()).getProfsItem(i));
            }
        }
    });
    JLabel cb8 = new JLabel("Add CBCS Course");
    cb8.setFont(new Font("TimesRoman",Font.BOLD,20));
    cb8.setBounds(50, 280, 200, 50);
    JTextField cb9 = new JTextField();
    cb9.setBounds(250,280,200,50);
    String cr1[] = {"Credits","1","2","3","4","5","6"};
    JComboBox<String> cb11 = new JComboBox<String>(cr1);
    cb11.setBounds(550, 280, 200, 50);
    JTextField cb12 = new JTextField("Faculty");
    cb12.setBounds(850, 280, 200, 50);
    JButton cb10 = new JButton("Create CBCS Course");
    cb10.setBounds(550,380,200,50);
    cb10.setBackground(Color.orange);
    cb10.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e)
    	{

            if(cb11.getSelectedIndex()!=0 && cb12.getText()!="Faculty"){
        		CO.put(cb9.getText(),new Course());
                CO.get(cb9.getText()).setName(cb9.getText());
                CO.get(cb9.getText()).setCredits(Integer.parseInt(cb11.getItemAt(cb11.getSelectedIndex()).toString()));
                CO.get(cb9.getText()).setType("CBCS");
                PR.put(cb12.getText(),new Professor());
                PR.get(cb12.getText()).setName(cb12.getText());
                CO.get(cb9.getText()).addProfs(cb12.getText());
                PR.get(cb12.getText()).addCourses(cb9.getText());
                if(B.get(cb2.getText()).add(CO.get(cb9.getText()),PR.get(cb12.getText()))){

                	JOptionPane.showMessageDialog(s,"CBCS course added"+"\n"+"Course: "+cb9.getText()+"\n"+"Credits: "+Integer.parseInt(cb11.getItemAt(cb11.getSelectedIndex()).toString()) + "\n"+"Professor "+cb12.getText());
                }
                else{
                    JOptionPane.showMessageDialog(s,"Periods are insufficient for adding this course to the batch");
                }
            }
            else{
                JOptionPane.showMessageDialog(s,"Select a valid course and valid professor");
            }

        }
            
 
    });
    createBatch.setLayout(null);
    createBatch.setBackground(Color.cyan);
    createBatch.add(cb1);
    createBatch.add(cb2);
    createBatch.add(cb3);
    createBatch.add(cb4);
    createBatch.add(cb5);
    createBatch.add(cb6);
    createBatch.add(cb7);
    createBatch.add(cb8);
    createBatch.add(cb9);
    createBatch.add(cb10);
    createBatch.add(cb11);
    createBatch.add(cb12);


    
    JPanel createProfessor=new JPanel();
    JLabel cp1=new JLabel("Name");
    cp1.setFont(new Font("TimesRoman",Font.BOLD,20));
    cp1.setBounds(50,100,200,50);
    JTextField cp2=new JTextField();
    cp2.setBounds(250,100,200,50);
    JLabel cp3=new JLabel("Course");
    cp3.setFont(new Font("TimesRoman",Font.BOLD,20));
    cp3.setBounds(50,275,200,50);
    JComboBox<String> cp4=new JComboBox<String>(course);
    cp4.setBounds(250,275,200,50);
    JButton cp5=new JButton("Add");
    cp5.setBackground(Color.orange);
    cp5.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            if(cp4.getSelectedIndex()!=0){
                CO.get(cp4.getItemAt(cp4.getSelectedIndex()).toString()).addProfs(cp2.getText());
                PR.get(cp2.getText()).addCourses(cp4.getItemAt(cp4.getSelectedIndex()).toString());
                JOptionPane.showMessageDialog(s,"The course "+cp4.getItemAt(cp4.getSelectedIndex()).toString()+" has been assigned to "+cp2.getText());
            }
            else{
                JOptionPane.showMessageDialog(s,"Select a valid course!");
            }
        }
    });
    cp5.setBounds(550,275,200,50);
    JButton cp6=new JButton("Create");
    cp6.setBounds(550,100,200,50);
    cp6.setBackground(Color.orange);
    cp6.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            pf.addItem(cp2.getText());
            cb7.addItem(cp2.getText());
            d7.addItem(cp2.getText());
            PR.put(cp2.getText(),new Professor());
            PR.get(cp2.getText()).setName(cp2.getText());
            JOptionPane.showMessageDialog(s,"A new professor "+cp2.getText()+" has been created");

        }
    });

    createProfessor.setLayout(null);
    createProfessor.setBackground(Color.cyan);
    createProfessor.add(cp1);
    createProfessor.add(cp2);
    createProfessor.add(cp3);
    createProfessor.add(cp4);
    createProfessor.add(cp5);
    createProfessor.add(cp6);



	JPanel createCourse=new JPanel();
    JLabel cc1= new JLabel("Name");
    cc1.setFont(new Font("TimesRoman",Font.BOLD,20));
    cc1.setBounds(50,50,200,50);
    JTextField cc2 = new JTextField();
    cc2.setBounds(250,50,200,50);
    JLabel cc6= new JLabel("Course Type");
    cc6.setFont(new Font("TimesRoman",Font.BOLD,20));
    cc6.setBounds(50,175,200,50);
    String type[] = {"Theory","Lab"};
    JComboBox<?> cc7 = new JComboBox<Object>(type);
    cc7.setBounds(250,175,200,50);
    JLabel cc3 = new JLabel("Credits");
    cc3.setFont(new Font("TimesRoman",Font.BOLD,20));
    cc3.setBounds(50,300,200,50);
    JComboBox<?> cc4 = new JComboBox<Object>(credits);
    cc4.setBounds(250,300,200,50);
    JButton cc5 = new JButton("Create");
    cc5.setBounds(250,450,200,50);
    cc5.setBackground(Color.orange);
    cc5.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){ 
            d3.addItem(cc2.getText());
            cb4.addItem(cc2.getText());
            cp4.addItem(cc2.getText());
            CO.put(cc2.getText(),new Course());
            CO.get(cc2.getText()).setName(cc2.getText());
            CO.get(cc2.getText()).setCredits(Integer.parseInt(cc4.getItemAt(cc4.getSelectedIndex()).toString()));
            CO.get(cc2.getText()).setType(cc7.getItemAt(cc7.getSelectedIndex()).toString());
            JOptionPane.showMessageDialog(s,"A new course has been created"+"\n"+"Course: "+cc2.getText()+"\n"+"CourseType: "+(cc7.getItemAt(cc7.getSelectedIndex()).toString())+"\n"+"Credits: "+Integer.parseInt(cc4.getItemAt(cc4.getSelectedIndex()).toString()));        
        }
    });
    createCourse.setLayout(null);
    createCourse.setBackground(Color.cyan);
    createCourse.add(cc1);
    createCourse.add(cc2);
    createCourse.add(cc3);
    createCourse.add(cc4);
    createCourse.add(cc5);
    createCourse.add(cc6);
    createCourse.add(cc7);

	JPanel insertData=new JPanel();
    JLabel in1= new JLabel("Course");
    in1.setFont(new Font("TimesRoman",Font.BOLD,20));
    in1.setBounds(50,50,200,50);
    JButton in2 = new JButton("Open");
    in2.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		JFileChooser fc = new JFileChooser();
    		fc.showSaveDialog(null);
    		File course_file = fc.getSelectedFile();
    		String course_path = course_file.getAbsolutePath();
    		String line = "";  
    		String splitBy = ",";
			try {
				BufferedReader br = new BufferedReader(new FileReader(course_path));
				while ((line = br.readLine()) != null)
				{  
					String[] c = line.split(splitBy);
				
	    		d3.addItem(c[0]);
	            cb4.addItem(c[0]);
	            cp4.addItem(c[0]);
	            CO.put(c[0],new Course());
	            CO.get(c[0]).setName(c[0]);
	            CO.get(c[0]).setType(c[1]);
	            CO.get(c[0]).setCredits(Integer.parseInt(c[2]));
	    		}
				br.close();
				in2.setText("Saved!");
 
			} catch (Exception c) {
				JOptionPane.showMessageDialog(s,"Please Check Your File Format");
				
			}  
			
    		
    		
    	}
    });
    in2.setBounds(250,50,200,50);
    in2.setBackground(Color.orange);
    
    JLabel in3= new JLabel("Faculty");
    in3.setFont(new Font("TimesRoman",Font.BOLD,20));
    in3.setBounds(50,175,200,50);
    JButton in4 = new JButton("Open");
    in4.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		JFileChooser fc = new JFileChooser();
    		fc.showSaveDialog(null);
    		File faculty_file = fc.getSelectedFile();
    		String faculty_path = faculty_file.getAbsolutePath();
    		String line = "";  
    		String splitBy = ",";
			try {
				BufferedReader br = new BufferedReader(new FileReader(faculty_path));
				while ((line = br.readLine()) != null)
				{  
					String[] c = line.split(splitBy);
		            pf.addItem(c[0]);
		            cb7.addItem(c[0]);
		            d7.addItem(c[0]);
		            PR.put(c[0],new Professor());
		            PR.get(c[0]).setName(c[0]);
					
					String[] pc = c[1].split(":");
					int i =0;
					while(i<pc.length) {
						CO.get(pc[i]).addProfs(c[0]);
						PR.get(c[0]).addCourses(pc[i]);
						i+=1;
					}

	    		}
				br.close();
				in4.setText("Saved!");
 
			} catch (Exception g) {
				JOptionPane.showMessageDialog(s,"Please Check Your File Format");
				
			}  
			
    		
    		
    	}
    });
    in4.setBounds(250,175,200,50);
    in4.setBackground(Color.orange);

    JLabel in5= new JLabel("Batch");
    in5.setFont(new Font("TimesRoman",Font.BOLD,20));
    in5.setBounds(50,300,200,50);
    JButton in6 = new JButton("Open");
    in6.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		JFileChooser fc = new JFileChooser();
    		fc.showSaveDialog(null);
    		
    		
    	}
    });
    in6.setBounds(250,300,200,50);
    in6.setBackground(Color.orange);
    
    
	insertData.add(in1);
	insertData.add(in2);
	insertData.add(in3);
	insertData.add(in4);
	insertData.add(in5);
	insertData.add(in6);
	insertData.setLayout(null);
	insertData.setBackground(Color.cyan);
	

    t.add("Home",home);  
    t.add("View",view);  
    t.add("Create Batch",createBatch);
    t.add("Create Course",createCourse);
	t.add("Create Professor",createProfessor);
    t.add("Delete",delete); 
	t.add("insertData",insertData); 
    t.setBackground(Color.green);  
    f.add(t);  
    f.setSize(1500,800);  
    t.setBounds(50,50,1200,600); 
    f.setLayout(null); 
    f.setVisible(true);
	
	
	
}
}  












   

