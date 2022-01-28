import java.util.*;


public class splitwise {
    private static Scanner sc;
    
    public static void main(String[] args) {
        
        sc=new Scanner(System.in);
        ArrayList<Integer> dummy1=new ArrayList<>();
        ArrayList<Integer> dummy2=new ArrayList<>();
        User.user_details.add(new User("java","java",0,1500,dummy1));
        User.user_details.add(new User("arun","arun",1,1500,dummy2));
        mainfunc();
    }

    static void clear(){
        System.out.println("\033[H\033[2J"); 
    }
    
    static void mainfunc(){

        clear();
        System.out.println("******** WELCOME TO SPLITWISE *******");
        System.out.println();
        System.out.println("ENTER 1 TO REGISTER");
        System.out.println("ENTER 2 IF YOU ARE EXISTING USER");
        System.out.println("ENTER 3 TO EXIT");
        int options=sc.nextInt();

        switch(options){
            case 1:
                User.register();
                break;
            case 2:
                User.login();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("INVALID INPUT");
                System.out.println();
                System.out.println("PLEASE PRESS ENTER TO CONTINUE ");
                try{
                    System.in.read();
                    mainfunc();
                }
                catch(Exception e){

                }
        } 

    } 
}

class User{
    
    static Scanner sc=new Scanner(System.in);
    static ArrayList <User> user_details = new ArrayList<>();
    static int u_id=0;
    static int curr_user=0;
    static String curr_user_name;

    

    public String user_name;
    public String password;
    public int user_id;
    public int wallet;
    public ArrayList<Integer> expense_id;

    User(String user_name,String password,int user_id,int wallet,ArrayList<Integer> expense_id){
        this.user_name=user_name;
        this.password=password;
        this.user_id=user_id;
        this.wallet=wallet;
        this.expense_id=expense_id;

    }

    
    static void register(){

        splitwise.clear();
        System.out.println("WELCOME TO REGISTER PAGE");
        System.out.println();
        System.out.println("ENTER YOUR USERNAME");
        String uname=sc.next();
        System.out.println();
        System.out.println("ENTER YOUR PASSWORD");
        String pass=sc.next();
        boolean f=true;
        if(user_details.size()>0){
            for(int i=0;i<user_details.size();i++){
                if((user_details.get(i).user_name.equals(uname)) && (user_details.get(i).password.equals(pass))){
                    f=false;
                    
                }
            }
        }
        if(f){
            
            ArrayList<Integer> dummy=new ArrayList<>();
            user_details.add(new User(uname,pass,u_id,0,dummy));
            System.out.println("SUCCESSFULLY REGISTERED..!!YOU CAN LOGIN NOW AND YOUR USER ID IS "+u_id);
            u_id++;
 
        }
        else{
            System.out.println("USERNAME ALREADY EXISTS");
        }
        System.out.println();
        System.out.println("PLEASE PRESS ENTER TO PREVIOUS MENU"); 


        try{
            System.in.read();
            splitwise.mainfunc();
        }
        catch(Exception e){

        }


    }
    
    static void login(){

        splitwise.clear();
        System.out.println("WELCOME TO LOGIN PAGE");
        System.out.println();
        System.out.println();
        System.out.println("ENTER YOUR USERNAME");
        String uname=sc.next();
        System.out.println();
        System.out.println("ENTER YOUR PASSWORD");
        String pass=sc.next();

        boolean f=false;
        for(int i=0;i<user_details.size();i++){
            if((user_details.get(i).user_name.equals(uname)) && (user_details.get(i).password.equals(pass))){
                curr_user=user_details.get(i).user_id;
                curr_user_name=user_details.get(i).user_name;
                f=true;
                
            }
        }
        if(f){
            user_func();
            
        }
        else{
            System.out.println("INVALID USERNAME OR PASSWORD");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU");
            try{
                System.in.read();
                splitwise.mainfunc();
            }
            catch(Exception e){

            }
            
        }
    }

    static void user_func(){
        
        splitwise.clear();
        System.out.println("ENTER 1 TO CREATE GROUP");
        System.out.println("ENTER 2 TO UPDATE WALLET AMOUNT");
        System.out.println("ENTER 3 TO GROUP ");
        System.out.println("ENTER 4 TO NON GROUP EXPENSES");

        // System.out.println("ENTER 5 TO VIEW AND PAY PENDING DUES");
        // System.out.println("ENTER 3 TO ADD AN EXPENSE");
        // System.out.println("ENTER 4 TO REMOVE FRIENDS FROM A GROUP");
        // System.out.println("ENTER 5 TO VIEW AND PAY PENDING DUES");
        // System.out.println("ENTER 6 TO VIEW TRANSACTION HISTORY");
        System.out.println("ENTER 5 TO LOGOUT");
        int options=sc.nextInt();
        
        switch(options){
        case 1:
            Group.create_group();
            break;
        case 2:
            update_wallet();
            break;
        case 3:
            Group.group_expense();
            break;
        case 4:
            Group.non_expense();
            break;
      
        case 5:
            splitwise.mainfunc();
        default:
            System.out.println("INVALID INPUT");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER TO CONTINUE ");
            try{
                System.in.read();
                splitwise.mainfunc();
            }
            catch(Exception e){

            }
        }

    }
    
    static void update_wallet(){

        splitwise.clear();
        System.out.println("HOW MUCH AMOUNT DO YOU WANT TO ADD IN YOUR WALLET");
        int amount=sc.nextInt();
        int a=user_details.get(curr_user).wallet;
        a=a+amount;
        user_details.get(curr_user).wallet=a;
        System.out.println();
        System.out.println("THE AMOUNT HAS BEEN ADDED IN YOUR WALLET..YOUR WALLET AMOUNT IS "+user_details.get(curr_user).wallet);
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU");

        try{
            System.in.read();
            user_func();
        }
        catch(Exception e){

        }

    }



}
class Group{

    static Scanner sc=new Scanner(System.in);
    static ArrayList <Group> group_details = new ArrayList<>();

    static int g_id=0;
    static int curr_g_id=0;
    static String curr_g_name;

    
    public String group_name;
    public int group_id;
    public ArrayList<String> members;

    Group(String group_name,int group_id,ArrayList<String> members){
        this.group_name=group_name;
        this.group_id=group_id;
        this.members=members;
    }

    static void create_group(){

        splitwise.clear();
        System.out.println("ENTER THE NAME OF THE GROUP");
        String name=sc.next();
        System.out.println();
        System.out.println("ENTER NO OF FRIENDS TO ADD GROUP");
        int no=sc.nextInt();
        System.out.println();
        System.out.println("THE EXISTING FRIENDS ARE ");
        System.out.println();
        
        // int n=sc.nextInt();

        if(User.user_details.size()>0 ){
            System.out.println("USER ID    USERNAME");
            System.out.println();
            for(int i=0;i<User.user_details.size();i++){
                if(User.user_details.get(i).user_id != User.curr_user){
                    System.out.println(User.user_details.get(i).user_id+"           "+User.user_details.get(i).user_name);
                }
                
            }
        }
        else{
            System.out.println("THERE IS NO USERS");
        }
        System.out.println();
        System.out.println("IF YOU WANT TO ADD ENTER THEIR ID "+g_id);
        ArrayList<String> l=new ArrayList<>();

        l.add(User.user_details.get(User.curr_user).user_name);
        for(int i=0;i<no;i++){
            int mem=sc.nextInt();
            for(int j=0;j<User.user_details.size();j++){
                if(User.user_details.get(j).user_id==mem){
                    l.add(User.user_details.get(j).user_name);
                }

            }
        }
        
        group_details.add(new Group(name,g_id,l));
        System.out.println("THE GROUP "+name+" HAS SUCCESSFULLY CREATED..YOUR GROUP ID IS "+g_id);
        g_id++;
        System.out.println();
        System.out.println("PLEASE PRESS ENTER TO PREVIOUS MENU"); 
        try{
            System.in.read();
            User.user_func();
        }
        catch(Exception e){

        }

    }

    static void group_expense(){

        splitwise.clear();
        System.out.println("THE AVAILABLE GROUPS ARE ");
        System.out.println();
        System.out.println("GROUP ID         GROUP NAME");
        for(int i=0;i<group_details.size();i++){
            System.out.println(group_details.get(i).group_id+"                 "+group_details.get(i).group_name);
        }

        System.out.println();
        System.out.println("ENETR THE ID TO ENTER INTO THAT GROUP");
        int g=sc.nextInt();

        boolean flag=false;
        for(int i=0;i<group_details.size();i++){
            if((group_details.get(i).group_id)==g){
                flag=true;
                curr_g_id=group_details.get(i).group_id;
                curr_g_name=group_details.get(i).group_name;
            }
        }

        if(flag){
            group_main();
        }
        else{
            splitwise.clear();
            System.out.println("ENTER A VALID GROUP ID");
            System.out.println("PLEASE PRESS ENTER ");
            try{
                System.in.read();
                User.user_func();
            }
            catch(Exception e){
    
            }
        }
    }

    static void group_main(){

        splitwise.clear();
        System.out.println("ENTER 1 TO ADD AN EXPENSE");
       
        System.out.println("ENTER 2 TO REMOVE FRIENDS FROM THIS GROUP");
        System.out.println("ENTER 3 TO VIEW AND PAY PENDING DUES");
        System.out.println("ENTER 4 TO VIEW TRANSACTION HISTORY");
        System.out.println("ENTER 5 TO GO BACK");
        System.out.println();
        System.out.println("ENTER ANY OF THE ABOVE OPTIONS");
        int options=sc.nextInt();

        switch(options){
            case 1:
                Expense.add_expense();
                break;
            
            case 2:
                remove_friend();
                break;
            case 3:
                Expense.view_due();
                break;
            case 4:
                Expense.history_fun();
                break;
            case 5:
                User.user_func();
                break;
           

        }
    }
    
    // static void (){

    //     splitwise.clear();
    //     System.out.println("ENTER OF FRIENDS YOU WANT TO ADD IN GROUP "+group_details.get(curr_g_id).group_name);
    //     int num=sc.nextInt();
        
    //     if(User.user_details.size()>0 ){
    //         System.out.println("USER ID    USERNAME");
    //         System.out.println();
    //         for(int i=0;i<User.user_details.size();i++){
    //             if(User.user_details.get(i).user_id != User.curr_user){
    //                 if(group_details.get(curr_g_id).members>0){
    //                     for(int j=0;j<group_details.get(curr_g_id).members.size();j++){
    //                         if(group_details.get(curr_g_id).members.get(j)!)
    //                     }
    //                 }

    //                 System.out.println(User.user_details.get(i).user_id+"           "+User.user_details.get(i).user_name);
    //             }
                
    //         }
    //     }
    //     for(int i=0;i<num;i++)
    // }

    static void remove_friend(){

        splitwise.clear();
        System.out.println("THE AVAILABLE USERS");
        System.out.println();
        for(int i=0;i<group_details.get(curr_g_id).members.size();i++){
            if(!group_details.get(curr_g_id).members.get(i).equals(User.curr_user_name)){
                System.out.println(group_details.get(curr_g_id).members.get(i));     
            }
            
        }
        System.out.println();
        System.out.println("ENTER THE USER NAME TO REMOVE");
        String s=sc.next();

        boolean f=false;
        for(int i=0;i<group_details.get(curr_g_id).members.size();i++){
            if(group_details.get(curr_g_id).members.get(i).equals(s)){
                f=true;
                group_details.get(curr_g_id).members.remove(i);
            }
        }

        if(f){
            System.out.println("THE USER "+s+" SUCCESSFULLY REMOVED FROM THE GROUP ");
            
        }
        else{
            System.out.println("PLEASE ENTER VALID USERNAME");
        }
        System.out.println();
        System.out.println("PLEASE PRESS ENTER TO PREVIOUS MENU"); 
        try{
            System.in.read();
            group_main();
        }
        catch(Exception e){

        }


    }

    static void non_expense(){

        splitwise.clear();
        System.out.println("ENTER 1 TO ADD AN EXPENSE");
        System.out.println("ENTER 2 TO VIEW AND PAY PENDING DUES");
        System.out.println("ENTER 3 TO VIEW TRANSACTION HISTORY");
        System.out.println("ENTER 4 TO GO BACK");
        System.out.println();
        System.out.println("ENTER ANY OF THE ABOVE OPTIONS");
        int options=sc.nextInt();

        switch(options){
            case 1:
                Expense.add_expense_non();
                break;
            case 2:
                Expense.view_due1();
                break;

            case 3:
                Expense.view_history1();
                break;
            case 4:
                User.user_func();
                break;
           

        }

    }

}

    

class Expense{

    static Scanner sc=new Scanner(System.in);
    static ArrayList <Expense> expense_details = new ArrayList<>();
    static ArrayList <Expense> non_group = new ArrayList<>();
    static int exp_id=1;
    static String dum_name;
    public String expense_type;
    public int group_id;
    public int expense_id;
    public String expense_name;
    public int total;
    public String creater; 
    public ArrayList<String> g_members;

    public String ex_type;
    public String ex_name;
    public int am;
    public ArrayList<String> mem;

    

    Expense(String expense_type,int group_id,String expense_name,int expense_id,int total,String creater,ArrayList<String> g_members){

        this.expense_type=expense_type;
        this.group_id=group_id;
        this.expense_name=expense_name;
        this.expense_id=expense_id;
        this.total=total;
        this.creater=creater;
        this.g_members=g_members;
   }
   Expense(String ex_type,String ex_name,int am,ArrayList<String> mem){
        this.ex_type=ex_type;
        this.ex_name=ex_name;
        this.am=am;
        this.mem=mem;
   }

   static void add_expense(){
    
    splitwise.clear();
    System.out.println("ENTER THE NAME OF THE EXPENSE ");
    String exp_name=sc.next();
    System.out.println();
    System.out.println("ENTER THE AMOUNT OF THE EXPENSE ");
    int tot=sc.nextInt();
    expense_details.add(new Expense("Group",Group.curr_g_id,exp_name,exp_id,tot,User.curr_user_name,Group.group_details.get(Group.curr_g_id).members));
    int ind_am=tot/Group.group_details.get(Group.curr_g_id).members.size();

    for(int i=0;i<Group.group_details.get(Group.curr_g_id).members.size();i++){
        if((Group.group_details.get(Group.curr_g_id).members.get(i)).equals(User.curr_user_name)){
            Due.due_details.add(new Due(Due.d_id,Group.group_details.get(Group.curr_g_id).members.get(i),Group.curr_g_id,exp_id,Group.curr_g_name,exp_name,ind_am,true));
            Due.d_id++;
        }
        else{
            Due.due_details.add(new Due(Due.d_id,Group.group_details.get(Group.curr_g_id).members.get(i),Group.curr_g_id,exp_id,Group.curr_g_name,exp_name,ind_am,false));
            Due.d_id++;
        }
    }
    exp_id++;
    System.out.println();
    System.out.println("YOUR EXPENSE HAS SUCCESSFULLY ADDED ");
    System.out.println();
    System.out.println("PLEASE PRESS ENTER ");
    try{
        System.in.read();
        Group.group_main();
    }
    catch(Exception e){

    }

   }

   static void add_expense_non(){
       splitwise.clear();
       System.out.println("ENTER THE NAME OF THE EXPENSE");
       String ex=sc.next();
       System.out.println();
       System.out.println("ENTER THE AMOUNT ");
       int tot=sc.nextInt();
       System.out.println();

       if(User.user_details.size()>0 ){
        System.out.println("USER ID    USERNAME");
        System.out.println();
        for(int i=0;i<User.user_details.size();i++){
            if(User.user_details.get(i).user_id != User.curr_user){
                System.out.println(User.user_details.get(i).user_id+"           "+User.user_details.get(i).user_name);
            }
            
        }
    }
    else{
        System.out.println("THERE IS NO USERS");
    }
    System.out.println();
    System.out.println("ENTER THE NO OF FRIENDS U WANT TO ADD ");
    int no=sc.nextInt();
    System.out.println();
    

    ArrayList<String> l=new ArrayList<>();
    l.add(User.curr_user_name);
    System.out.println("ENTER THEIR ID ");
    for(int i=0;i<no;i++){
        int mem=sc.nextInt();
        for(int j=0;j<User.user_details.size();j++){
            if(User.user_details.get(j).user_id==mem){
                l.add(User.user_details.get(j).user_name);
            }

        }
    }
    non_group.add(new Expense("nongroup",ex,tot,l));
    System.out.println();
    System.out.println("THE EXPENSE HAS SUCESSFULLY ADDED");
    add_due(ex,tot,l);
    System.out.println("THE DUE HAS SUCCESSFULLY ADDED");
    System.out.println();
    System.out.println("PLEASE PRESS ENTER TO PREVIOUS MENU"); 
    try{
        System.in.read();
        Group.non_expense();
    }
    catch(Exception e){

    }

        
}
    
    static void add_due(String ex,int tot,ArrayList <String> l){

        splitwise.clear();
        int am=tot/l.size();
        for(int i=1;i<l.size();i++){
            String a=l.get(i);
            Due.due_details1.add(new Due(ex,a,am,false,User.curr_user_name));
        }
    }

    static void view_due1(){
        splitwise.clear();
        System.out.printf("%-20s%-20s%-10s\n","EXPENSE NAME","CREATER","AMOUNT");
        boolean f=false;
        for(int i=0;i<Due.due_details1.size();i++){
            if((Due.due_details1.get(i).u_name.equals(User.curr_user_name))&&(!Due.due_details1.get(i).status_1));{
                f=true;
                System.out.printf("%-20s%-20s%-10s\n",Due.due_details1.get(i).ex_name,Due.due_details1.get(i).creater,Due.due_details1.get(i).am);
            }

        }
        if(f){
            splitwise.clear();
            System.out.println("NO DUES1");
            payment_non();
        }
        else{
            splitwise.clear();
            System.out.println("NO DUES");

        }
        System.out.println();
        System.out.println("PLEASE PRESS ENTER TO PREVIOUS MENU"); 
        try{
            System.in.read();
            Group.non_expense();
        }
        catch(Exception e){
    
        }
        
    }

   static void view_due(){

        splitwise.clear();
        System.out.println("THE PENDING DUES ARE ");
        System.out.println();
        System.out.printf("%-10s%-20s%-20s%-20s%-10s\n","DUE ID","GROUP NAME","EXPESNSE ID","EXPENSE NAME","DUE AMOUNT");
        System.out.println();
        boolean f=false;

        for(int i=0;i<Due.due_details.size();i++){
            if((Due.due_details.get(i).user_name.equals(User.curr_user_name))){
                if(!Due.due_details.get(i).status){
                    System.out.printf("%-10d%-20s%-20d%-20s%-10d\n",Due.due_details.get(i).due_id,Due.due_details.get(i).gname,Due.due_details.get(i).exp_id,Due.due_details.get(i).exp_name,Due.due_details.get(i).amount);
                    f=true;

                }
            }
        }
        if(f){
            payment();
        }
        else{
            splitwise.clear();
            System.out.println("NO DUES ");

        }
        System.out.println();
        System.out.println("PLEASE PRESS ENTER ");
        try{
            System.in.read();
            Group.group_main();
        }
        catch(Exception e){
    
        }


   }

   static void payment_non(){
    
    splitwise.clear();
    System.out.println("ENTER THE NAME OF THE EXPENSE U WANT TO PAY ");
    String e_name=sc.next();
    boolean flag=true;;
    System.out.println();
   
    for(int i=0;i<Due.due_details1.size();i++){
        if(Due.due_details1.get(i).ex_name.equals(e_name)){
            if(!Due.due_details1.get(i).status_1){
                flag=false;
                System.out.println("CREATED BY " +Due.due_details1.get(i).creater+"      "+"AMOUNT "+Due.due_details1.get(i).am);
                System.out.println();
                System.out.println("IF YOU WANT TO PAY PRESS 1 ");
                int  op=sc.nextInt();
                if(op==1){
                    System.out.println("THE DUE HAS SUCCESSFULLY FULFILLED");
                    int am=Due.due_details1.get(i).am;
                    Due.due_details1.get(i).status_1=true;

                    String a=Due.due_details1.get(i).creater;
                    int x=0;
                    int y=0;
                    for(int j=0;j<User.user_details.size();j++){
                        if(User.user_details.get(j).user_name.equals(a)){
                            x=j;
                        }
                        else if(User.user_details.get(j).user_name.equals(Due.due_details1.get(i).u_name)){
                            y=j;
                        }
                    }
                    int u1=User.user_details.get(x).wallet;
                    int u2=User.user_details.get(y).wallet;

                    u1+=Due.due_details1.get(i).am;
                    u2-=Due.due_details1.get(i).am;

                    User.user_details.get(x).wallet=u1;
                    User.user_details.get(y).wallet=u2;
                    History.history1.add(new History(User.curr_user_name,Due.due_details1.get(i).creater,e_name,am));


                }
                else{
                    Group.non_expense();
                }

            }
        }
    }
    if(flag){
        System.out.println("INVALID NAME ");

    }
    System.out.println();
    System.out.println("PLEASE PRESS ENTER ");
    try{
        System.in.read();
        Group.non_expense();
    }
    catch(Exception e){

    }
}



   static void payment(){

        System.out.println();
        System.out.println("ENTER THE DUE ID THE DUE YOU WANT TO PAY");
        int id=sc.nextInt();
        System.out.println();
        
        int x=0;
        int y=0;
    
                
        String dum_name=expense_details.get(Group.curr_g_id).creater;

        for(int i=0;i<User.user_details.size();i++){
            if(User.user_details.get(i).user_name.equals(dum_name)){
                y=i;
            }
        }

        int id1=User.curr_user;

        boolean f=true;
        for(int i=0;i<Due.due_details.size();i++){
            if((Due.due_details.get(i).exp_id==id) && (!Due.due_details.get(i).status) &&(User.curr_user_name.equals(Due.due_details.get(i).user_name))){
                System.out.println("YOUR DUE AMOUNT IS "+Due.due_details.get(i).amount+" AND CREATED BY "+dum_name);
                f=false;
                System.out.println("IF YOU WANT TO PAY PRESS 1 ");
                int  op=sc.nextInt();
                if(op==1){
                    System.out.println("THE DUE HAS SUCCESSFULLY FULFILLED");
                    int am=Due.due_details.get(i).amount;
                    Due.due_details.get(i).status=true;

                    int a=User.user_details.get(id1).wallet;
                    a-=Due.due_details.get(i).amount;
                    User.user_details.get(id1).wallet=a;

                    int b=User.user_details.get(y).wallet;
                    b+=Due.due_details.get(i).amount;
                    User.user_details.get(y).wallet=b;

                    History.history.add(new History("U R PAYER",id,User.curr_user_name,dum_name,Group.curr_g_id,expense_details.get(Group.curr_g_id).expense_id,expense_details.get(Group.curr_g_id).expense_name,am));
                    History.history.add(new History("U R RECEIVER",id,dum_name,User.curr_user_name,Group.curr_g_id,expense_details.get(Group.curr_g_id).expense_id,expense_details.get(Group.curr_g_id).expense_name,am));

                }
                else{
                    Group.group_main();
                }
            
            }

        }
        if(f){
            System.out.println("INVALID ID ");

        }
        System.out.println();
        System.out.println("PLEASE PRESS ENTER ");
        try{
            System.in.read();
            Group.group_main();
        }
        catch(Exception e){
    
        }

   }
   
   static void history_fun(){
       
    splitwise.clear();
    System.out.printf("%-20s%-10s%-20s%-20s%-10s%-10s%-20s%-10s\n","TYPE","DUE ID","USERNAME","TO WHOM","GROUP ID","EXP ID","EXP NAME","AMOUNT");
    System.out.println();
    for(int i=0;i<History.history.size();i++){
        if((History.history.get(i).type.equals("U R PAYER")) && (History.history.get(i).creater.equals(User.curr_user_name))){
            System.out.printf("%-20s%-10d%-20s%-20s%-10d%-10d%-20s%-10d\n",History.history.get(i).type,History.history.get(i).due_id,History.history.get(i).creater,History.history.get(i).creater1,History.history.get(i).group_id,History.history.get(i).exp_id,History.history.get(i).exp_name,History.history.get(i).amount);
        }
    }
    System.out.println();
    System.out.println();

    System.out.printf("%-20s%-10s%-20s%-20s%-10s%-10s%-20s%-10s\n","TYPE","DUE ID","USERNAME","BY WHOM","GROUP ID","EXP ID","EXP NAME","AMOUNT");
    System.out.println();
    for(int i=0;i<History.history.size();i++){
        if((History.history.get(i).type.equals("U R RECEIVER")) && (History.history.get(i).creater.equals(User.curr_user_name))){
            System.out.printf("%-20s%-10d%-20s%-20s%-10d%-10d%-20s%-10d\n",History.history.get(i).type,History.history.get(i).due_id,History.history.get(i).creater,History.history.get(i).creater1,History.history.get(i).group_id,History.history.get(i).exp_id,History.history.get(i).exp_name,History.history.get(i).amount);
        }
    }
    System.out.println();
    System.out.println("PLEASE PRESS ENTER ");
    try{
        System.in.read();
        Group.group_main();
    }
    catch(Exception e){

    }
    
   }

   static void view_history1(){
       splitwise.clear();
       if(History.history1.size()>0){
        for(int i=0;i<History.history1.size();i++){
            System.out.println("USERNAME ->   "+History.history1.get(i).u_name+"   CREATER ->   "+History.history1.get(i).creater_name+"   EXPENSENAME ->   "+History.history1.get(i).e_nam+"   AMOUNT ->   "+History.history1.get(i).amount);
        }
       }
       else{
           splitwise.clear();
           System.out.println("NO HISTORY");
       }
       System.out.println();
       System.out.println("PLEASE PRESS ENTER ");
       try{
           System.in.read();
           Group.non_expense();
       }
       catch(Exception e){
   
       }

       
   }
}
class Due{
    
    static Scanner sc=new Scanner(System.in);
    static ArrayList<Due> due_details = new ArrayList<>();
    static ArrayList<Due> due_details1 = new ArrayList<>();
    static int d_id=0;

    public int due_id;
    public String user_name;
    public int group_id;
    public int exp_id;
    public String gname;
    public String exp_name;
    public int amount;
    public boolean status;  
    
    Due(int due_id,String user_name,int group_id,int exp_id,String gname,String exp_name,int amount,boolean status){
        this.due_id=due_id;
        this.user_name=user_name;
        this.group_id=group_id;
        this.exp_id=exp_id;
        this.gname=gname;
        this.exp_name=exp_name;
        this.amount=amount;
        this.status=status;
    }

    public String ex_name;
    public String u_name;
    public int am;
    public boolean status_1;
    public String creater;

    Due(String ex_name,String u_name,int am,boolean status_1,String creater){
        this.ex_name=ex_name;
        this.u_name=u_name;
        this.am=am;;
        this.status_1=status_1;
        this.creater=creater;

    }


}

class History{

    static ArrayList <History> history = new ArrayList<>();
    static ArrayList <History> history1 = new ArrayList<>();

    public String type;
    public int due_id;
    public String creater;
    public String creater1;

    public int group_id;
    public int exp_id;
    
    public String exp_name;
    public int amount;

    History(String type,int due_id,String creater,String creater1,int group_id,int exp_id,String exp_name,int amount){
        this.type=type;
        this.due_id=due_id;
        this.creater=creater;
        this.creater1=creater1;
        this.group_id=group_id;
        this.exp_id=exp_id;
        
        this.exp_name=exp_name;
        this.amount=amount;
        
    }

    public String u_name;
    public String creater_name;
    public String e_nam;
    public int cost;

    History(String u_name,String creater_name,String e_nam,int cost){
        this.u_name=u_name;
        this.creater_name=creater_name;
        this.e_nam=e_nam;
        this.cost=cost;
    }

}
