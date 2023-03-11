# OOP

package com.company;
import java.io.*;
import java.util.Scanner;


abstract class Employers {
    Scanner sc = new Scanner(System.in);
    moderator m;
    private final int id;
    

    Employers() {
        id = 00;
        m = new moderator(1);
    }

    Employers(int id) {
        this.id = id;
        m = new moderator(1);
    }

    public int getid() {
        return id;
    }

    abstract void post_vacancy();
    public boolean selectCandidate(Candidate object){
              if(object.getExperience() >=5){
                  return true;
              }
              return false;

              }



    public void receive_application(Candidate object) {
        moderator.count++;
        if ((object.getName() != null) && (object.getCandid_id() != 00) && (object.getNIC() != null)) {
            if ((object.getEducational_qualification() != null) && (object.getDOB() != null) && (object.getPermanent_adress() != null)) {
                if (selectCandidate(object)) {
                    m.vacany("Selected");}}}}
    }



class educational_institute extends Employers{
   private int teachingyears;
   private String coppres;
    private int numberofcampus;
    educational_institute(){
        super();
    }
    educational_institute(int numberofcampus,int id){
        super(id);
        this.numberofcampus =  numberofcampus;
        
    }
    
    void post_vacancy(){

        System.out.println("teaching years should be above 2");

        System.out.println("ability to cope with pressure?");

    }
    public void receive_application(Candidate obj){
              System.out.println("teaching years?");
             teachingyears=sc.nextInt();
        System.out.println("ability to cope with pressure");
        coppres=sc.nextLine();
        if(coppres=="yes"){
            if(teachingyears>=2){
                super.receive_application(obj);
            }
        }
    }
}
class Bank extends Employers{
    private int numofbranch;
    private String comskills;
   private String ability;
   Bank(){
       super();
   }
   Bank(int numofb,int id){
       super(id);
       numofbranch=numofb;
   }

    void post_vacancy(){
        System.out.println("vacancy available \n requirements are:");
        System.out.println("candidate should have Communication skills");

        System.out.println("candidate should be able to work in a large team");

    }
    public void receive_application(Candidate obj){
        System.out.println("do you vahe communication skills");
         comskills=sc.nextLine();
         System.out.println("can you work in a large team?");
         ability = sc.nextLine();
         if((comskills=="yes") &&(ability=="yes")){
                  super.receive_application(obj);
         }
                 
    }
}
class pharmaceutical extends Employers{
    private float annualbudget;
    private String anaskills;
    pharmaceutical(){
        super();
    }
    pharmaceutical(float budget,int id){
        super(id);
        annualbudget=budget;
    }

    void post_vacancy(){
        System.out.println("vacancy available \n requirements are:");
        System.out.println("candidate should have good analytical skills");

    }
    public void receive_application(Candidate obj){
        System.out.println("do you have good analyticall skills?");
          anaskills = sc.nextLine();
          if(anaskills=="yes"){
              super.receive_application(obj);
          }
    }
}
class construction extends Employers{
 private int numofactiveproj;
   private String abilitytowork;
   construction(){
       super();
   }
   construction(int num,int id){
       super(id);
       numofactiveproj=num;
   }
   void post_vacancy(){
       System.out.println("vacancy availabe\n requirements are:");
       System.out.println("Candidate should have ability to work in remote areas");

   }
   public void receive_application(Candidate obj){
       System.out.println("can you work in remote areas?");
       abilitytowork=sc.nextLine();
       if(abilitytowork=="yes"){
           super.receive_application(obj);
       }
   }
}

class Candidate{
  private String name;
  private String NIC;
  private String educational_qualification;
  private String DOB;
  private int experience;
  private String permanent_adress;
  private float expected_Salary;
  private final  int  candid_id;
  private static int idcount=0;
  Scanner sc = new Scanner(System.in);
  Candidate(){
      idcount++;
      candid_id= idcount;
  }

    public Candidate(String name, String NIC, String educational_qualification, String DOB, int experience, String permanent_adress, float expected_Salary) {
        this.name = name;
        this.NIC = NIC;
        this.educational_qualification = educational_qualification;
        this.DOB = DOB;
        this.experience = experience;
        this.permanent_adress = permanent_adress;
        this.expected_Salary = expected_Salary;
        idcount++;
        this.candid_id = idcount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getEducational_qualification() {
        return educational_qualification;
    }

    public void setEducational_qualification(String educational_qualification) {
        this.educational_qualification = educational_qualification;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getPermanent_adress() {
        return permanent_adress;
    }

    public void setPermanent_adress(String permanent_adress) {
        this.permanent_adress = permanent_adress;
    }

    public float getExpected_Salary() {
        return expected_Salary;
    }

    public void setExpected_Salary(float expected_Salary) {
        this.expected_Salary = expected_Salary;
    }

    public int getCandid_id() {
        return candid_id;
    }
   public void input(){
      System.out.println("input name");
        name = sc.nextLine();
        System.out.println("input cnic");
        NIC = sc.nextLine();
        System.out.println("input adress");
        permanent_adress = sc.nextLine();
        System.out.println("educational qualification");
        educational_qualification = sc.nextLine();
        System.out.print("experience");
        experience= sc.nextInt();
        System.out.println("Date of birth");
        DOB = sc.nextLine();
        System.out.println("expection Salary");
         expected_Salary =sc.nextInt();
   }
}
class moderator {
    public static int count;
    private int mod_id;

    moderator() {
        mod_id = 1;
    }

    moderator(int mod_id) {
        this.mod_id = mod_id;
    }

    public void vacany(String x) {
        System.out.println(x);
    }

    public void writedata() {
        File f = new File("info.txt");
        try {
            f.createNewFile();
            BufferedWriter bw = new BufferedWriter((new FileWriter(f)));
            bw.write(count);
             bw.close();

        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    public void writedata(String message){
        try{
            File f = new File("message.txt");
            f.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write(message);
            bw.close();

        }catch(IOException e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
    public  static int gettotalnumberofapplication(){
            return count;
    }


}
class nothingorg{
    Employers e[]= new Employers[4];
    Candidate c;
    Scanner sc = new Scanner(System.in);
    nothingorg(){
        e[0] = new educational_institute();
        e[1] = new Bank();
        e[2] = new pharmaceutical();
        e[3] = new construction();
        c = new Candidate();
    }
    public void panel(){
        System.out.println("Welcome to nothing.org");
        System.out.println("please enter 1 for employer and 2 for candidate");
        int choice = sc.nextInt();
        if(choice==1){
            System.out.println("Select your Company: ");
            int choices = sc.nextInt();
            System.out.println("1 educational institue");
            System.out.println("2 Bank");
            System.out.println("3 pharmaceutical company");
            System.out.println("4 Construction company");
            switch(choices) {
                case 1:
                    e[0].post_vacancy();
                    break;
                case 2:
                    e[1].post_vacancy();
                    break;
                case 3:
                    e[2].post_vacancy();
                    break;
                case 4:
                    e[3].post_vacancy();
                    break;
            }

        }else{
                c.input();
            System.out.println("here are the available employers");
            System.out.println("1 educational institue");
            System.out.println("2 Bank");
            System.out.println("3 pharmaceutical company");
            System.out.println("4 Construction company");
            int choices = sc.nextInt();
            switch(choices){
                case 1 :  e[0].receive_application(c);
                    break;
                case 2:   e[1].receive_application(c);
                    break;
                case 3: e[2].receive_application(c);
                    break;
                case 4: e[3].receive_application(c);
                    break;
            }

        }
    }
        }
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        nothingorg obj = new nothingorg();
         obj.panel();
         /// there can be alot of employers and candidates but for test purpose i made only one for each class
    }
}
