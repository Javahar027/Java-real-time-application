import java.util.*;
public class Atm {

    static int notes[]={0,0,0,0};
    static int amount_val[]={2000,500,200,100};

    static String user_name[]={"a","b","c","d","e"};
    static String pass_word[]={"1","2","3","4","5"};
    // static int user_count[]={0,0,0,0,0};
    static int user_bal[]={10000,20000,30000,40000,50000};
    // static String bank[]={"sbi","sbi","iob","sbi","sbi"};
    static List<String> u1= new ArrayList<>();
    static List<String> u2= new ArrayList<>();
    static List<String> u3= new ArrayList<>();
    static List<String> u4= new ArrayList<>();
    static List<String> u5= new ArrayList<>();
    static String u,p,tra;

    static int total=0,user=0,amount,note,sum=0,trans=0,am;
    private static Scanner sc;

    static void mainfunc(){

        System.out.print("\033[H\033[2J");
        System.out.println("********** WELCOME TO SBI ATM **********");
        System.out.println();
        System.out.println("PLEASE ENTER 1 IF YOU ARE A ADMIN");
        System.out.println("PLEASE ENTER 2 IF YOU ARE A USER");
        System.out.println("ENTER 3 IF YOU NEED TO EXIT");
        System.out.println();
        System.out.println("PLEASE ENTER ANY OF THE ABOVE OPTIONS");
        
        int option=0;
        option=sc.nextInt();
        switch(option){
            case 1:
                adminlogin();
                break;
            case 2:
                userlogin();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }

    }

    static void adminlogin(){

        System.out.print("\033[H\033[2J");
        String username="admin@123";
        String password="admin@123";
        System.out.println("PLEASE ENTER YOUR USERNAME");
        String uname=sc.next();  
        System.out.println();
        System.out.println("PLEASE ENTER YOUR PASSWORD");
        String pass=sc.next();

        if((username.equals(uname))&&(password.equals(pass))){
            adminfunc();
            
        }
        else{
            System.out.println("PLEASE ENTER A VALID USERNAME AND PASS WORD");
            mainfunc();

        }
    }

    static void adminfunc(){
        System.out.print("\033[H\033[2J");
        System.out.println("PLEASE ENTER 1 TO ADD AMOUNT IN THE ATM ");
        System.out.println("PLEASE ENTER 2 TO CHECK THE BALANCE OF THE ATM");
        System.out.println("ENTER 3 TO GO BACK");
        int admin_options=0;
        admin_options=sc.nextInt();
        switch(admin_options){
            case 1:
                add_amount();
                break;
            case 2:
                show_amount();
                break;
            case 3:
                mainfunc();
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }

    }

    static void add_amount(){

        System.out.print("\033[H\033[2J");
        for(int i=0;i<4;i++){
            System.out.println("ENTER NUMBER OF "+amount_val[i]+ " NOTES "); //amount_val[2000,500,200,100]
            notes[i]=sc.nextInt();
            System.out.println();
        }
        for(int i=0;i<4;i++){
            total+=amount_val[i]*notes[i];
        }
        System.out.print("\033[H\033[2J");
        System.out.println("AMOUNT HAVE BEEN ADDED SUCCESSFULLY");
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try{
            System.in.read();
            adminfunc();
        }
        catch(Exception e){

        }

    }

    static void show_amount(){
        System.out.print("\033[H\033[2J");
        for(int i=0;i<4;i++){
            System.out.println("NUMBER OF NOTES IN "+amount_val[i]+" IS " +notes[i]);
            // total+=amount_val[i]*notes[i];
        }
        System.out.println("TOTAL AMOUNT IN THIS ATM "+total);
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try{
            System.in.read();
            adminfunc();
        }
        catch(Exception e){

        }

    }

    static void userlogin(){
        System.out.print("\033[H\033[2J");                                            //   0   1   2   3   4
        System.out.println("ENTER YOUR USERNAME");           //static String user_name[]={"a","b","c","d","e"};
                                                             //static String pass_word[]={"1","2","3","4","5"};
        u=sc.next();
        System.out.println("ENTER YOUR PASSWORD");
        p=sc.next();

        for(int i=0;i<user_name.length;i++){
            if(user_name[i].equals(u)){
                user=i;
            }
        }
        if((user_name[user].equals(u)) && (p.equals(pass_word[user]))){
            // user_count[user]++;
            userfunc(user);
        }
        else{
            System.out.println("INVALID USERNAME OR PASSWORD");
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try {
                System.in.read();
                userlogin();
            } catch (Exception e) {
            }
        }

    }

    static void userfunc(int user){

        System.out.print("\033[H\033[2J");
        System.out.println("ENTER 1 TO WITHDRAW AMOUNT");
        System.out.println("ENTER 2 TO CHECK BALANCE");
        System.out.println("ENTER 3 TO DEPOSIT AMOUNT");
        System.out.println("ENTER 4 TO CHANGE THE PIN ");
        System.out.println("ENTER 5 TO TRANSFER AMOUNT ");
        System.out.println("ENTER 6 TO MINI STATEMENT ");
        System.out.println("ENTER 7 TO GO BACK");
        int ch1 = sc.nextInt();
        switch (ch1) {
            case 1:
                withdraw_amount(user);
                break;
            case 2:
                show_balance(user);
                break;
            case 3:
                deposit(user);
                break;
            case 4:
                pinchange(user);
                break;
            case 5:
                transfer(user);
                break;
            case 6:
                mini(user);
                break;
            case 7:
                mainfunc();
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    static void withdraw_amount(int i){

        int rem=0,rem1=0,rem2=0,rem3=0;
        System.out.print("\033[H\033[2J");
        System.out.println("ENTER AMOUNT TO WITHDRAW ");
        amount=sc.nextInt();

        if((amount<=total)){
            if(amount<user_bal[i])
                if(amount%100==0){
                    int temp=amount;

                    if(temp>=2000){
                        rem=temp/2000;
                        temp=temp%2000;
                    }
                    if(temp>=500){
                        rem1=temp/500;
                        temp=temp%500;
                    }
                    if(temp>=200){
                        rem2=temp/200;
                        temp=temp%200;
                    }
                    if(temp>=100){
                        rem3=temp/100;
                    }
                    if((rem<=notes[0]) &&  (rem1<=notes[1]) && (rem2<=notes[2]) && (rem3<=notes[3])){
                        notes[0]=notes[0]-rem;
                        notes[1]=notes[1]-rem1;
                        notes[2]=notes[2]-rem2;
                        notes[3]=notes[3]-rem3;
                        user_bal[i]-=amount;
                        total-=amount;
                        System.out.println("AMOUNT HAS BEEN WITHDRAWN SUCCESSFULLY");
                        System.out.println();
                        if(i==0){
                            u1.add("WITHDRAWN"+"\t"+amount);
                        }
                        if(i==1){
                            u2.add("WITHDRAWN"+"\t"+amount);
                        }
                        if(i==2){
                            u3.add("WITHDRAWN"+"\t"+amount);
                        }
                        if(i==3){
                            u4.add("WITHDRAWN"+"\t"+amount);
                        }
                        if(i==4){
                            u5.add("WITHDRAWN"+"\t"+amount);
                        }
                        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
                        try {
                            System.in.read();
                            userfunc(i);
                        } catch (Exception e) {
                        }
                    }
                    else{
                        System.out.println("NOTES ARE NOT AVAILABLE");
                        System.out.println();
                        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
                        try {
                            System.in.read();
                            userfunc(i);
                        } catch (Exception e) {
                        }
                    }
                }
                else{
                    System.out.println("PLEASE ENTER AMOUNT IN 100's ");
                    System.out.println();
                    System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
                    try {
                        System.in.read();
                        userfunc(i);
                    } catch (Exception e) {
                    }
                }
            else{
                System.out.println("YOUR ACCOUNT BALANCE IS INSUFFICIENT TO WITHDDRAW");
                System.out.println();
                System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
                try {
                    System.in.read();
                    userfunc(i);
                } catch (Exception e) {
                }
                    }
                }
        else{
            System.out.println("THE ATM HAS INSUFFICIENT FUNDS AND UNABLE TO DISPENSE");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try {
                System.in.read();
                userfunc(i);
            } catch (Exception e) {
            }
        }


    }

    static void show_balance(int i){

        System.out.print("\033[H\033[2J");
        System.out.println("YOUR ACCOUNT BALANCE IS " + user_bal[i]);
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try {
            System.in.read();
            userfunc(i);
        } catch (Exception e) {
        }
    }

    static void deposit(int i){

        System.out.print("\033[H\033[2J");
        for(int j=0;j<4;j++){
            System.out.println("ENTER NUMBER OF "+amount_val[j]+ " NOTES ");
            note=sc.nextInt();
            System.out.println();
            notes[j]+=note;
            sum+=note*amount_val[j];

        }
        total+=sum;
        // for(int j=0;j<4;j++){
        //     total+=amount_val[j]*notes[j];
        // }
        user_bal[i]+=sum;
        if(i==0){
            u1.add("DEPOSITED"+"\t"+sum);
        }
        if(i==1){
            u2.add("DEPOSITED"+"\t"+sum);
        }
        if(i==2){
            u3.add("DEPOSITED"+"\t"+sum);
        }
        if(i==3){
            u4.add("DEPOSITED"+"\t"+sum);
        }
        if(i==4){
            u5.add("DEPOSITED"+"\t"+sum);
        }
        System.out.print("\033[H\033[2J");
        System.out.println("AMOUNT HAVE BEEN ADDED SUCCESSFULLY");
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try{
            System.in.read();
            userfunc(i);
        }
        catch(Exception e){

        }


    }

    static void pinchange(int i){

        System.out.print("\033[H\033[2J");
        System.out.println("ENTER OLD PASSWORD");
        String oldpass=sc.next();

        if(oldpass.equals(pass_word[i])){
            System.out.print("\033[H\033[2J");
            System.out.println("ENTER NEW PASSWORD");
            String newpass=sc.next();
            System.out.println();
            System.out.println("CONFIRM PASSWORD");
            String confirmpass=sc.next();
            if(confirmpass.equals(newpass)){
                pass_word[i]=newpass;
                System.out.println("PASSWORD CHANGED SUCCESSFULLY");
            }
            else{
                System.out.println("PASSWORD DOESN'T MATCH");
            }
        
        }
        else{
            System.out.println("PLEASE ENTER CORRECT PASSWORD");
    
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try {
                System.in.read();
                userfunc(i);
            } catch (Exception e) {
            }
        }
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try {
                System.in.read();
                userfunc(i);
            } catch (Exception e) {
            }

    }

    static void transfer(int i){

        System.out.print("\033[H\033[2J");
        System.out.println("ENTER THE USERNAME THE AMOUNT NEED TO BE TRANSFERRED ");
        tra=sc.next();
        boolean flag=false;
        for(int j=0;j<user_name.length;j++){
            if(tra.equals(user_name[j])){
                flag=true;
                trans=j;
            }
        }
        System.out.println("ENTER THE AMOUNT TO BE TRANSFERRED TO THE USER "+tra);
        am=sc.nextInt();
        if(flag){
            user_bal[trans]+=am;
            user_bal[i]-=am;
            System.out.println("THE AMOUNT "+am+" HAS SUCCESSFULLY TRANSFERRED TO "+tra);
            if(i==0){
                u1.add("TRANFERRED"+"\t"+am);
            }
            if(i==1){
                u2.add("TRANFERRED"+"\t"+am);
            }
            if(i==2){
                u3.add("TRANFERRED"+"\t"+am);
            }
            if(i==3){
                u4.add("TRANFERRED"+"\t"+am);
            }
            if(i==4){
                u5.add("TRANFERRED"+"\t"+am);
            }
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try {
                System.in.read();
                userfunc(i);
            } catch (Exception e) {
            }

        }
        else{
            System.out.println("PLEASE ENTER VALID USERNAME");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try {
                System.in.read();
                userfunc(i);
            } catch (Exception e)
            }
        }




    static void mini(int i){
        System.out.print("\033[H\033[2J");

        if((i==0)&&(u1.size()>=6)){
            for(int j=0;j<u1.size();j++){
                System.out.println(u1.get(j));
            }
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try {
                System.in.read();
                userfunc(i);
            } catch (Exception e) {
            }
        }
        else{
            System.out.println("NEED MINIMUN 6 ACTIONS TO SHOW MINI STATEMENT");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try {
                System.in.read();
                userfunc(i);
            } catch (Exception e) {
            }
        }


        if((i==1)&&(u1.size()>=6)){
            for(int j=0;j<u1.size();j++){
                System.out.println(u2.get(j));
            }
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try {
                System.in.read();
                userfunc(i);
            } catch (Exception e) {
            }
        }
        else{
            System.out.println("NEED MINIMUN 6 ACTIONS TO SHOW MINI STATEMENT");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try {
                System.in.read();
                userfunc(i);
            } catch (Exception e) {
            }
        }


        if((i==2)&&(u1.size()>=6)){
            for(int j=0;j<u1.size();j++){
                System.out.println(u3.get(j));
            }
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try {
                System.in.read();
                userfunc(i);
            } catch (Exception e) {
            }
        }
        else{
            System.out.println("NEED MINIMUN 6 ACTIONS TO SHOW MINI STATEMENT");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try {
                System.in.read();
                userfunc(i);
            } catch (Exception e) {
            }
        }
        

        if((i==3)&&(u1.size()>=6)){
            for(int j=0;j<u1.size();j++){
                System.out.println(u4.get(j));
            }
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try {
                System.in.read();
                userfunc(i);
            } catch (Exception e) {
            }
        }
        else{
            System.out.println("NEED MINIMUN 6 ACTIONS TO SHOW MINI STATEMENT");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try {
                System.in.read();
                userfunc(i);
            } catch (Exception e) {
            }
        }


        if((i==4)&&(u1.size()>=6)){
            for(int j=0;j<u5.size();j++){
                System.out.println(u5.get(j));
            }
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try {
                System.in.read();
                userfunc(i);
            } catch (Exception e) {
            }
        }
        else{
            System.out.println("NEED MINIMUN 6 ACTIONS TO SHOW MINI STATEMENT");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try {
                System.in.read();
                userfunc(i);
            } catch (Exception e) {
            }
        }

    }
    
    public static void main(String args[]){
        sc=new Scanner(System.in);
        mainfunc();

    }
}
