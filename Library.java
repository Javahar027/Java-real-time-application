import java.util.*;

import java.text.*;
import java.time.LocalDate;
import java.time.Period;

public class Library {
    private static Scanner sc;
    static String curr_date;

    
    public static void main(String[] args) {
        Admin.admin_details.add(new Admin("admin","admin"));
        BookMenu.books.add(new BookMenu("dhoni",10,1,"1",100,0));
        ArrayList<String> dummy= new ArrayList<>();
        ArrayList<String> dummy1= new ArrayList<>();
        User.user_details.add(new User("java","java",1500,true,dummy,dummy1));
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        curr_date = String.valueOf(format.format(date));
        sc=new Scanner(System.in);

        mainfunc();
    }   

    static void clear(){
        System.out.println("\033[H\033[2J"); 
    } 

    static void mainfunc(){

        clear();
        System.out.println("PLEASE ENTER 1 IF YOU ARE ADMIN");
        System.out.println("PLEASE ENTER 2 IF YOU ARE USER");
        System.out.println("PLEASE ENTER 3 TO EXIT");
        System.out.println("PLEASE ENTER 4 TO CHANGE THE DATE");
        System.out.println();
        System.out.println("PLEASE ENTER ANY OF THE ABOVE OPTIONS");

        int options=sc.nextInt();

        switch(options){
            case 1:
                Admin.admin_land();
                break;
            case 2:
                User.user_land();
                break;
            case 3:
                System.exit(0);
                break;
            case 4:
                change_date();
                break;
            default:
                System.out.println("INVALID INPUT");
                System.out.println();
                System.out.println("PLEASE PRESS ENTER");
                try{
                    System.in.read();
                    mainfunc();
                }
                catch(Exception e){

                }
        }


    }

    static void change_date(){
        clear();


        System.out.println("ENTER THE NO OF DAYS TO CHANGE THE DATE");
        int chn_date=sc.nextInt();
        System.out.println(addOneDay(curr_date, chn_date));
        curr_date=addOneDay(curr_date, chn_date);

        System.out.println();
        System.out.println("PLEASE PRESS ENTER");
        try{
            System.in.read();
            mainfunc();
        }
        catch(Exception e){

        }



    }
    public static String addOneDay(String date,int n) {
        return LocalDate
                .parse(date)
                .plusDays(n)
                .toString();
    }
}

class Admin{

    static Scanner sc=new Scanner(System.in);

    static ArrayList <Admin> admin_details = new ArrayList<>();


    public String admin_name;
    public String admin_pass;


    Admin(String admin_name,String admin_pass){
        this.admin_name=admin_name;
        this.admin_pass=admin_pass;
        

    }

    static void admin_land(){
        
        Library.clear();

        System.out.println("********** WELOCME ADMIN **********");
        System.out.println();
        System.out.println("PLEASE ENTER YOUR USERNAME");
        String uname=sc.next();  
        System.out.println();
        System.out.println("PLEASE ENTER YOUR PASSWORD");
        String pass=sc.next();

        // admin_details.add(new Admin(uname,pass));
        // System.out.println(admin_details.get(0).admin_name +" "+ admin_details.get(0).admin_pass);
        boolean f=false;
        for(int i=0;i<admin_details.size();i++){
            if((admin_details.get(i).admin_name.equals(uname)) && (admin_details.get(i).admin_pass.equals(pass))){
                f=true;
                
            }
        }
        if(f){
            admin_func();
        }
        else{
            System.out.println("INVALID USERNAME OR PASSWORD");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU");
            try{
                System.in.read();
                Library.mainfunc();
            }
            catch(Exception e){

            }
            
        }
    }


    static void admin_func(){

        Library.clear();
        System.out.println("PLEASE ENTER 1 FOR BOOK MENU");
        System.out.println("PLEASE ENTER 2 TO ADD USER");
        System.out.println("PLEASE ENTER 3 TO ADD NEW ADMIN");
        System.out.println("PLEASE ENTER 4 TO VIEW REPORTS");

        System.out.println("PLEASE ENTER 5 TO GO BACK");

        System.out.println();
        System.out.println("PLEASE ENTER ANY OF THE ABOVE OPTIONS");

        int options=sc.nextInt();

        switch(options){
            case 1:
                book_menu();
                break;
            case 2:
                add_user();
                break;
            case 3:
                new_admin();
                break;
            case 4:
                view_reports();
                break;

            case 5:
                Library.mainfunc();
                break;
            default:
                System.out.println("INVALID INPUT");
                System.out.println();
                System.out.println("PLEASE PRESS ENTER");
                try{
                    System.in.read();
                    admin_land();
                }
                catch(Exception e){

                }
        }
    }

    static void book_menu(){

        Library.clear();
        System.out.println("PLEASE ENTER 1 TO ADD BOOK");
        System.out.println("PLEASE ENTER 2 TO MODIFY BOOK");
        System.out.println("PLEASE ENTER 3 TO REMOVE BOOK");
        System.out.println("PLEASE ENTER 4 TO VIEW BOOKS");
        System.out.println("PLEASE ENTER 5 TO SEARCH BOOK");
        System.out.println("PLEASE ENTER 6 TO BOOK BORROWER DETAILS BY ISBN");
        System.out.println("PLEASE ENTER 7 TO GO BACK");
        System.out.println();
        System.out.println("PLEASE ENTER ANY OF THE ABOVE OPTIONS");

        int options=sc.nextInt();

        switch(options){
            case 1:
                BookMenu.add_book();
                break;
            case 2:
                BookMenu.modify_book();
                break;
            case 3:
                BookMenu.remove_book();
                break;
            case 4:
                BookMenu.view_book();
                break;
            case 5:
                BookMenu.search_book();
                break;
            case 6:
                BookMenu.isbn_borrow();
                break;
            case 7:
                admin_func();
                break;
            default:
                System.out.println("INVALID INPUT");
                System.out.println();
                System.out.println("PLEASE PRESS ENTER");
                try{
                    System.in.read();
                    admin_func();
                }
                catch(Exception e){

                }
        }
    }

    static void add_user(){

        Library.clear();
        ArrayList<String> cart_pass= new ArrayList<>();
        ArrayList<String> cart_pass1= new ArrayList<>();
        System.out.println("ENTER MAIL ID OF THE USER");
        String uname=sc.next();  
        System.out.println();
        System.out.println("ENTER THE PASSWORD FOR THE USER");
        String pass=sc.next();

        boolean f=true;
        for(int i=0;i<User.user_details.size();i++){
            if((User.user_details.get(i).user_name.equals(uname)) && (User.user_details.get(i).user_pass.equals(pass))){
                f=false;
            }
        }
        if(f){
            Library.clear();
            User.user_details.add(new User(uname,pass,1500,true,cart_pass,cart_pass1));
            System.out.println("THE USER "+uname+" HAS BEEN SUCCESSFULLY ADDED");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER");
            try{
                System.in.read();
                admin_func();
            }
            catch(Exception e){

            }
        }
        else{

            Library.clear();
            
            System.out.println("THE USER "+uname+" HAS ALREADY EXISTED");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER");
            try{
                System.in.read();
                admin_func();
            }
            catch(Exception e){

            }

        }


    }

    

    static void new_admin(){

        Library.clear();

        System.out.println("PLEASE ENTER  USERNAME");
        String uname=sc.next();  
        System.out.println();
        System.out.println("PLEASE ENTER  PASSWORD");
        String pass=sc.next();
        boolean f=true;
        for(int i=0;i<admin_details.size();i++){
            if((admin_details.get(i).admin_name.equals(uname)) && (admin_details.get(i).admin_pass.equals(pass))){
                f=false;
            }
        }
        if(f){
            admin_details.add(new Admin(uname,pass));
            Library.clear();
            System.out.println("NEW ADMIN ADDED SUCCESSFULLY");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER");
            try{
                System.in.read();
                admin_func();
            }
            catch(Exception e){

            }

        }
        else{
            Library.clear();
            System.out.println("ADMIN ALREADY EXISTED");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER");
            try{
                System.in.read();
                admin_func();
            }
            catch(Exception e){

            }

        }
    }

    static void view_reports(){

        Library.clear();
        System.out.println("PLEASE ENTER 1 TO VIEW LESS QUANTITY BOOKS");
        System.out.println("PLEASE ENTER 2 TO VIEW NOT BORROWED BOOKS SO FAR");
        System.out.println("PLEASE ENTER 3 TO VIEW HEAVILY BORROWED BOOKS");
        System.out.println("PLEASE ENTER 4 TO VIEW STUDENTS NOT RETURN BOOK ON TIME");
        System.out.println("PLEASE ENTER 5 TO VIEW FINE HISTORY");            
        System.out.println("PLEASE ENTER 6 TO GO BACK");
        System.out.println();
        System.out.println("PLEASE ENTER ANY OF THE ABOVE OPTIONS");

        int options=sc.nextInt();

        switch(options){
            case 1:
                BookMenu.less_quantity();
                break;
            case 2:
                BookMenu.not_borrow();
                break;
            case 3:
                BookMenu.heavy_borrow();
                break;
            case 4:
                BookMenu.not_return();
                break;
            case 5:
                BookMenu.fine_details();
                break;
            case 6:
                admin_func();
                break;
            default:
                System.out.println("INVALID INPUT");
                System.out.println();
                System.out.println("PLEASE PRESS ENTER");
                try{
                    System.in.read();
                    admin_func();
                }
                catch(Exception e){

                }
        }
    }


}

class BookMenu{

    static Scanner sc=new Scanner(System.in);

    static ArrayList <BookMenu> books = new ArrayList<>();
    static ArrayList<String> fine_history=new ArrayList<>();

    public String book_name;
    public int book_quantity;
    public int book_id;
    public String book_ISBN;
    public int book_cost;
    public int borrow_count;

    BookMenu(String book_name,int book_quantity,int book_id,String book_ISBN,int book_cost,int borrow_count){
        this.book_name=book_name;
        this.book_quantity=book_quantity;
        this.book_id=book_id;
        this.book_ISBN=book_ISBN;
        this.book_cost=book_cost;
        this.borrow_count=borrow_count;

    }

    // books.add(new BookMenu("Dhoni",10,1,"1",100));

    static void add_book(){

        Library.clear();
        System.out.println("ENTER THE NAME OF THE BOOK");
        String b_name=sc.next();
        System.out.println();

        System.out.println("ENTER THE QUANTITY OF THE BOOK");
        int b_quantity=sc.nextInt();
        System.out.println();

        System.out.println("ENTER THE ID OF THE BOOK");
        int b_id=sc.nextInt();
        System.out.println();

        System.out.println("ENTER THE ISBN OF THE BOOK");
        String b_isbn=sc.next();
        System.out.println();

        System.out.println("ENTER THE COST OF THE BOOK");
        int b_cost=sc.nextInt();
        System.out.println();

        boolean f=true;
        for(int i=0;i<books.size();i++){
            if(books.size()>0){
                if((books.get(i).book_id == b_id) && (books.get(i).book_ISBN.equals(b_isbn))){
                    f=false;
                } 
            }
        }
        if(f){
            Library.clear();
            books.add(new BookMenu(b_name,b_quantity,b_id,b_isbn,b_cost,0));
            System.out.println("THE BOOK "+b_name+" HAS SUCCESSFULLY ADDED");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER");
            try{
                System.in.read();
                Admin.book_menu();
            }
            catch(Exception e){

            }

        }
        else{
            Library.clear();
            System.out.println("THE BOOK "+b_name+" IS ALREADY ADDED AND CANNOT BE ADDED AGAIN");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER");
            try{
                System.in.read();
                Admin.book_menu();
            }
            catch(Exception e){

            }

        }
    }

    static void modify_book(){

        Library.clear();

        System.out.println("ENTER THE ID OF THE BOOK");
        int b_id=sc.nextInt();
        System.out.println();

        System.out.println("ENTER THE ISBN OF THE BOOK");
        String b_isbn=sc.next();
        System.out.println();

        boolean f=false;
        int book=0;
        for(int i=0;i<books.size();i++){
            if(books.size()>0){
                if((books.get(i).book_id == b_id) && (books.get(i).book_ISBN.equals(b_isbn))){
                    f=true;
                    book=i;
                } 
            }
        }

        if(f){
            Library.clear();
            System.out.println("DO YOU WANT TO MODITY THE QUANTITY OF THE BOOK "+books.get(book).book_name);
            System.out.println("ENTER 1 TO MODIFY");
            int m=sc.nextInt();
            if(m==1){
                Library.clear();
                System.out.println("ENTER THE QUANTITY TO MODIFY");
                int x=sc.nextInt();
                books.get(book).book_quantity=x;
                System.out.println();
                System.out.println("THE BOOK "+books.get(book).book_name+" HAS BEEN UPDATED");
                System.out.println();
                System.out.println("PLEASE PRESS ENTER");
                try{
                    System.in.read();
                    Admin.book_menu();
                }
                catch(Exception e){
    
                }
            }
            else{
                Admin.book_menu();
            }
        }
        else{
            Library.clear();
            System.out.println();
            System.out.println("YOU HAVE ENTERED WORNG BOOK ID OR ISBN NUMBER..PLEASE ENTER CORRECT VALUES..");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER");
            try{
                System.in.read();
                Admin.book_menu();
            }
            catch(Exception e){

            }


        }
    }

    static void remove_book(){

        Library.clear();

        System.out.println("ENTER THE ID OF THE BOOK");
        int b_id=sc.nextInt();
        System.out.println();

        System.out.println("ENTER THE ISBN OF THE BOOK");
        String b_isbn=sc.next();
        System.out.println();

        boolean f=false;
        int book=0;
        for(int i=0;i<books.size();i++){
            if(books.size()>0){
                if((books.get(i).book_id == b_id) && (books.get(i).book_ISBN.equals(b_isbn))){
                    f=true;
                    book=i;
                } 
            }
        }

        if(f){
            Library.clear();
            System.out.println("DO YOU WANT TO REMOVE THE BOOK "+books.get(book).book_name);
            System.out.println("ENTER 1 TO REMOVE");
            int m=sc.nextInt();
            if(m==1){
                Library.clear();
                books.remove(book);
                System.out.println();
                System.out.println("THE BOOK HAS BEEN REMOVED");
                System.out.println();
                System.out.println("PLEASE PRESS ENTER");
                try{
                    System.in.read();
                    Admin.book_menu();
                }
                catch(Exception e){
    
                }
            }
            else{
                Admin.book_menu();
            }
        }
        else{
            Library.clear();
            System.out.println();
            System.out.println("YOU HAVE ENTERED WORNG BOOK ID OR ISBN NUMBER..PLEASE ENTER CORRECT VALUES..");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER");
            try{
                System.in.read();
                Admin.book_menu();
            }
            catch(Exception e){

            }


        }


    }
    
    static void view_book(){

        Library.clear();
        System.out.println("ENTER 1 IF YOU WANT TO VIEW THE BOOKS BY NAME (ascending order) ");
        System.out.println("ENTER 2 IF TOU WANT TO VIEW THE BOOKS BY QUANTITY (ascending order)");
        int sort=sc.nextInt();

        if(sort==1){
            Library.clear();
            System.out.println("THE BOOKS ARE SORTED IN ASCENDING ORDER ");
            System.out.println();
            System.out.println("NAME"+" "+"QUANTITY"+"   "+"ID"+"   "+"ISBN"+"   "+"COST");
            Collections.sort(books,booknameComparator);
            for(int i=0;i<books.size();i++){
                System.out.println(books.get(i).book_name+"\t"+books.get(i).book_quantity+"\t"+books.get(i).book_id+"\t"+books.get(i).book_ISBN+"    "+books.get(i).book_cost);
            }   
            System.out.println();
            System.out.println("PLEASE PRESS ENTER");
            try{
                System.in.read();
                Admin.book_menu();
            }
            catch(Exception e){

            }
        }
        if(sort==2){
            Library.clear();
            System.out.println("THE BOOKS ARE SORTED IN ASCENDING ORDER ");
            System.out.println();
            System.out.println("NAME"+" "+"QUANTITY"+"   "+"ID"+"   "+"ISBN"+"   "+"COST");
            Collections.sort(books,bookquantityComparator);
            for(int i=0;i<books.size();i++){
                System.out.println(books.get(i).book_name+"\t"+books.get(i).book_quantity+"\t"+books.get(i).book_id+"\t"+books.get(i).book_ISBN+"    "+books.get(i).book_cost);
            }   
            System.out.println();
            System.out.println("PLEASE PRESS ENTER");
            try{
                System.in.read();
                Admin.book_menu();
            }
            catch(Exception e){

            }
        }
    }

    public String getBookName(){
        return this.book_name;
    }

    public int getQuantity(){
        return this.book_quantity;
    }

    public static Comparator<BookMenu> booknameComparator = new Comparator<BookMenu>() {
			
        public int compare(BookMenu s1, BookMenu s2)
                {
    
                    String BookName1 = s1.getBookName().toUpperCase();
                    String BookName2 = s2.getBookName().toUpperCase();
    
                    // ascending order
                    return BookName1.compareTo(BookName2);
    
                    // descending order
                    // return
                    // StudentName2.compareTo(StudentName1);
                }
            };
    
    public static Comparator<BookMenu> bookquantityComparator = new Comparator<BookMenu>() {
    
        public int compare(BookMenu s1, BookMenu s2)
                {
    
                    int Quantity1 = s1.getQuantity();
                    int Quantity2 = s2.getQuantity();
    
                    // ascending order
                    return Quantity1-Quantity2;
    
                    // descending order
                    // return
                    // StudentName2.compareTo(StudentName1);
                }
            };

    static void search_book(){

        Library.clear();
        System.out.println("ENTER 1 IF YOU WANT TO SEARCH THE BOOKS BY NAME ");
        System.out.println("ENTER 2 IF TOU WANT TO SEARCH THE BOOKS BY ISBN ");
        int search=sc.nextInt();

        if(search==1){

            Library.clear();
            System.out.println("ENTER THE NAME OF THE BOOK ");
            String n_book=sc.next();
            boolean f=false;
            int book=0;
            for(int i=0;i<books.size();i++){
                    if((books.get(i).book_name.equals(n_book))){
                        f=true;
                        book=i;
                    } 
            }
            if(f){
                Library.clear();
                System.out.println("NAME"+" "+"QUANTITY"+"   "+"ID"+"   "+"ISBN"+"   "+"COST");
                System.out.println();
                System.out.println(books.get(book).book_name+"\t"+books.get(book).book_quantity+"\t"+books.get(book).book_id+"\t"+books.get(book).book_ISBN+"    "+books.get(book).book_cost);
                System.out.println();
                System.out.println("PLEASE PRESS ENTER");
                try{
                    System.in.read();
                    Admin.book_menu();
                }
                catch(Exception e){
    
                }
            }
            else{

                Library.clear();
                System.out.println();
                System.out.println("THE BOOK IS NOT AVAILABLE ");
                System.out.println();
                System.out.println("PLEASE PRESS ENTER");
                try{
                    System.in.read();
                    Admin.book_menu();
                }
                catch(Exception e){
    
                }
                

            }

        }

        if(search==2){
            Library.clear();
            System.out.println("ENTER THE ISBN OF THE BOOK ");
            String n_isbn=sc.next();
            boolean fa=false;
            int book1=0;
            for(int i=0;i<books.size();i++){
                    if((books.get(i).book_ISBN.equals(n_isbn))){
                        fa=true;
                        book1=i;
                    } 
            }
            if(fa){
                Library.clear();
                System.out.println("NAME"+" "+"QUANTITY"+"   "+"ID"+"   "+"ISBN"+"   "+"COST");
                System.out.println();
                System.out.println(books.get(book1).book_name+"\t"+books.get(book1).book_quantity+"\t"+books.get(book1).book_id+"\t"+books.get(book1).book_ISBN+"    "+books.get(book1).book_cost);
                System.out.println();
                System.out.println("PLEASE PRESS ENTER");
                try{
                    System.in.read();
                    Admin.book_menu();
                }
                catch(Exception e){
    
                }
            }
            else{

                Library.clear();
                System.out.println();
                System.out.println("THE BOOK IS NOT AVAILABLE ");
                System.out.println();
                System.out.println("PLEASE PRESS ENTER");
                try{
                    System.in.read();
                    Admin.book_menu();
                }
                catch(Exception e){
    
                }
                

            }


        }

    }

    static void less_quantity(){

        Library.clear();
        System.out.println("NAME"+" "+"QUANTITY"+"   "+"ID"+"   "+"ISBN"+"   "+"COST");
        System.out.println();
        boolean f=true;
        for(int i=0;i<books.size();i++){
            if(books.get(i).book_quantity<=5){
                System.out.println(books.get(i).book_name+"\t"+books.get(i).book_quantity+"\t"+books.get(i).book_id+"\t"+books.get(i).book_ISBN+"    "+books.get(i).book_cost);
                f=false;
            }
        }
        
        if(f){
            Library.clear();
            System.out.println("THERE ARE NO BOOKS IN LESS QUANTITY ");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER");
            try{
                System.in.read();
                Admin.view_reports();
            }
            catch(Exception e){

            }
        }
        else{
            System.out.println();
            System.out.println("PLEASE PRESS ENTER");
            try{
                System.in.read();
                Admin.view_reports();
            }
            catch(Exception e){

            }
        }

    }

    static void not_borrow(){

        Library.clear();
        System.out.println("THE BOOKS ARE");
        System.out.println();
        System.out.println("NAME"+" "+"QUANTITY"+"   "+"ID"+"   "+"ISBN"+"   "+"COST");
        System.out.println();
        boolean f=true;
        for(int i=0;i<books.size();i++){
            if(books.get(i).borrow_count==0){
                System.out.println(books.get(i).book_name+"\t"+books.get(i).book_quantity+"\t"+books.get(i).book_id+"\t"+books.get(i).book_ISBN+"    "+books.get(i).book_cost);
                f=false;
            }
        }

        if(f){
            Library.clear();
            System.out.println("ALL BOOKS GOT BORROWED ");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER");
            try{
                System.in.read();
                Admin.view_reports();
            }
            catch(Exception e){

            }
        }
        else{
            System.out.println();
            System.out.println("PLEASE PRESS ENTER");
            try{
                System.in.read();
                Admin.view_reports();
            }
            catch(Exception e){

            }
        }
    }
    
    static void heavy_borrow(){

        Library.clear();
        System.out.println("THE BOOKS ARE");
        System.out.println();
        System.out.println("NAME"+" "+"QUANTITY"+"   "+"ID"+"   "+"ISBN"+"   "+"COST"+"    "+"BORROW COUNT");
        System.out.println();
        boolean f=true;
        for(int i=0;i<books.size();i++){
            if(books.get(i).borrow_count>=10){
                System.out.println(books.get(i).book_name+"\t"+books.get(i).book_quantity+"\t"+books.get(i).book_id+"\t"+books.get(i).book_ISBN+"    "+books.get(i).book_cost+"\t"+books.get(i).borrow_count);
                f=false;
            }
        }

        if(f){
            Library.clear();
            System.out.println("NO BOOKS HAVE BEEN HEAILY BORROWED ");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER");
            try{
                System.in.read();
                Admin.view_reports();
            }
            catch(Exception e){

            }
        }
        else{
            System.out.println();
            System.out.println("PLEASE PRESS ENTER");
            try{
                System.in.read();
                Admin.view_reports();
            }
            catch(Exception e){

            }
        }


    }

    static void not_return(){
        
        Library.clear();
        boolean f=false;
        for(int i=0;i<Borrow.borrow_details.size();i++){
            if(Borrow.borrow_details.get(i).return_status.equals("no")){
                f=true;
            }
        }
        if(f){
            Library.clear();
            System.out.println("NOT RETURN BOOKS ARE");
            System.out.println();
            System.out.printf("%-5s%-10s%-15s%-20s%-20s\n","ID","NAME","USERNAME","BORROW DATE","RETURN DATE");
            for(int i=0;i<Borrow.borrow_details.size();i++){
                if(Borrow.borrow_details.get(i).return_status.equals("no")){
                    System.out.printf("%-5d%-10s%-15s%-20s%-20s\n",Borrow.borrow_details.get(i).b_id,Borrow.borrow_details.get(i).b_name,Borrow.borrow_details.get(i).user_name,Borrow.borrow_details.get(i).borrow_date,Borrow.borrow_details.get(i).return_date);
                }
            }
        }
        else{
            Library.clear();
            System.out.println("ALL BOOKS ARE RETURN ");
        }
        System.out.println();
        System.out.println("PLEASE PRESS ENTER");
        try{
            System.in.read();
            Admin.view_reports();
        }
        catch(Exception e){

        }

    }

    static void fine_details(){

        Library.clear();
        if(fine_history.size()>0){
            System.out.println("THE FINE HISTORY ");
            System.out.println();
            for(int i=0;i<fine_history.size();i++){
                System.out.println(fine_history.get(i));
            }
        }
        else{
            System.out.println("NO FINES TILL NOW");
        }

        System.out.println("PLEASE PRESS ENTER");
        System.out.println();
        try{
            System.in.read();
            Admin.view_reports();
        }
        catch(Exception e){

        }

        
    }

    static void isbn_borrow(){

        Library.clear();
        System.out.println("ENTER THE ID OF THE BOOK");
        int id=sc.nextInt();
        boolean f=false;
        for(int i=0;i<Borrow.borrow_details.size();i++){
            if(Borrow.borrow_details.get(i).b_id==id){
                f=true;
            }
        }
        if(f){
            Library.clear();
            System.out.println("THE BOOKS ARE ");
            for(int i=0;i<Borrow.borrow_details.size();i++){
                System.out.println("BOOK NAME -> "+Borrow.borrow_details.get(i).b_name+" USERNAME -> "+Borrow.borrow_details.get(i).user_name+" EXPECTED DATE -> "+Borrow.borrow_details.get(i).return_date);
            }

        }
        else{
            Library.clear();
            System.out.println("ALL BOOKS ARE IN THE RACK");
        }
        System.out.println();
        System.out.println("PLEASE PRESS ENTER ");
        try{
            System.in.read();
            Admin.view_reports();
        }
        catch(Exception e){

        }



    }
}

class User{

    static int x=0;
    static String username;
    static Scanner sc=new Scanner(System.in);

    static ArrayList <User> user_details = new ArrayList<>();

    public String user_name;
    public String user_pass;
    public int wallet_amount;
    public boolean mscard;
    public ArrayList<String> cart;
    public ArrayList<String> fine_history;
    
    User(String user_name,String user_pass,int wallet_amount,boolean mscard,ArrayList<String> cart,ArrayList<String> fine_history){
        this.user_name=user_name;
        this.user_pass=user_pass;
        this.wallet_amount=wallet_amount;
        this.mscard=mscard;
        this.cart=cart;
        this.fine_history=fine_history;
    }

    static void user_land(){

        Library.clear();

        System.out.println("********** WELOCME USER **********");
        System.out.println();
        System.out.println("PLEASE ENTER YOUR USERNAME");
        username=sc.next();  
        System.out.println();
        System.out.println("PLEASE ENTER YOUR PASSWORD");
        String pass=sc.next();
        boolean f=false;
        for(int i=0;i<user_details.size();i++){
            if((user_details.get(i).user_name.equals(username)) && (user_details.get(i).user_pass.equals(pass))){
                x=i;
                f=true;
                
            }
        }
        if(f){
            user_func(x);
        }
        else{
            System.out.println("INVALID USERNAME OR PASSWORD");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU");
            try{
                System.in.read();
                Library.mainfunc();
            }
            catch(Exception e){

            }
            
        }

    }

    static void user_func(int j){

        Library.clear();
        System.out.println("PLEASE ENTER 1 FOR BOOKS MENU");
        System.out.println("PLEASE ENTER 2 TO FINE MENU");
        System.out.println("PLEASE ENTER 3 TO MEMBERSHIP CARD MENU");
        System.out.println("PLEASE ENTER 4 TO GO BACK");

        System.out.println();
        System.out.println("PLEASE ENTER ANY OF THE ABOVE OPTIONS");

        int options=sc.nextInt();

        switch(options){
            case 1:
                user_book(j);
                break;
            case 2:
                user_fine(j);
                break;
            case 3:
                user_card(j);                                
                break;
            case 4:
                Library.mainfunc();
                break;
            default:
                System.out.println("INVALID INPUT");
                System.out.println();
                System.out.println("PLEASE PRESS ENTER");
                try{
                    System.in.read();
                    user_land();
                }
                catch(Exception e){

                }
        }


    }

    static void user_book(int j){

        Library.clear();
        System.out.println("PLEASE ENTER 1 TO VIEW AVAILABLE BOOKS");
        System.out.println("PLEASE ENTER 2 TO ADD A BOOK TO CART");
        System.out.println("PLEASE ENTER 3 TO REMOVE A BOOK FROM CART");
        System.out.println("PLEASE ENTER 4 TO VIEW CART");
        System.out.println("PLEASE ENTER 5 TO CHECKOUT A BOOK");
        System.out.println("PLEASE ENTER 6 TO BORROWED BOOKS HISTORY");
        System.out.println("PLEASE ENTER 7 TO RETURN BOOK ");

        // System.out.println("PLEASE ENTER 7 TO EXTEND RETURN DATE");
        System.out.println("PLEASE ENTER 8 TO BOOK LOST OPTIONS");
        System.out.println("PLEASE ENTER 9 TO GO BACK");

        System.out.println();
        System.out.println("PLEASE ENTER ANY OF THE ABOVE OPTIONS");

        int options=sc.nextInt();

        switch(options){
            case 1:
                view_books(j);
                break;
            case 2:
                add_cart(j);
                break;
            case 3:
                remove_cart(j);
                break;
            case 4:
                view_cart(j);
                break;
            case 5:
                Borrow.checkout_book(j);
                break;
            case 6:
                Borrow.borrow_history(j);
                break;
            case 7:
                Borrow.return_book(j);
                break;
            case 8:
                Borrow.book_lost(j);
                break;
            case 9:
                user_func(j);
                break;
            default:
                System.out.println("INVALID INPUT");
                System.out.println();
                System.out.println("PLEASE PRESS ENTER");
                try{
                    System.in.read();
                    user_func(j);
                }
                catch(Exception e){

                }
        }

    }

    static void view_books(int j){

        Library.clear();
        if(BookMenu.books.size()>0){
            System.out.println("THE AVAILABLE BOOKS ARE");
            System.out.println();
            System.out.println("NAME"+" "+"QUANTITY"+"   "+"ID"+"   "+"ISBN"+"   "+"COST");
            System.out.println();
            for(int i=0;i<BookMenu.books.size();i++){
                System.out.println(BookMenu.books.get(i).book_name+"\t"+BookMenu.books.get(i).book_quantity+"\t"+BookMenu.books.get(i).book_id+"\t"+BookMenu.books.get(i).book_ISBN+"    "+BookMenu.books.get(i).book_cost);
            }
            System.out.println();
            System.out.println("PLEASE PRESS ENTER");
            try{
                System.in.read();
                user_book(j);
            }
            catch(Exception e){

            }
            
        }
        else{

            Library.clear();
            System.out.println("THERE IS NO BOOK AVAILABLE IN THIS LIBRARY");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER");
            try{
                System.in.read();
                user_book(j);
            }
            catch(Exception e){

            }

        }

    }

    static void add_cart(int j){

        Library.clear();
        System.out.println("ENTER THE NAME OF THE BOOK");
        String name=sc.next();
        System.out.println();
        boolean flag=true;

        for(int i=0;i<user_details.get(j).cart.size();i++){
            if(user_details.get(j).cart.get(i).equals(name)){
                flag=false;
            }
        }
        boolean f=true;

        if(flag){
            for(int i=0;i<BookMenu.books.size();i++){
                if(BookMenu.books.get(i).book_name.equals(name)){
                    f=false;
                    user_details.get(j).cart.add(BookMenu.books.get(i).book_name);   
                }
            }
            if(f){
                Library.clear();
                System.out.println("THE BOOK IS NOT AVAILABLE");
                System.out.println();
                System.out.println("PLEASE PRESS ENTER");
                try{
                    System.in.read();
                    user_book(j);
                }
                catch(Exception e){
    
                }
    
            }
            else{
                Library.clear();
                System.out.println("THE BOOK "+name+" HAS BEEN ADDED TO THE CART");
                System.out.println();
                System.out.println("PLEASE PRESS ENTER");
                try{
                    System.in.read();
                    user_book(j);
                }
                catch(Exception e){
    
                }
            }

        }
        else{

            Library.clear();
            System.out.println("THE BOOK HAS ALREADY ADDED IN THE CART");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER");
            try{
                System.in.read();
                user_book(j);
            }
            catch(Exception e){

            }
        }    

    }

    static void remove_cart(int j){

        Library.clear();
        System.out.println("ENTER THE NAME OF THE BOOK TO REMOVE FROM THE CART ");
        String name=sc.next();
        System.out.println();
        boolean f=true;
        for(int i=0;i<BookMenu.books.size();i++){
            if(BookMenu.books.get(i).book_name.equals(name)){
                f=false;
                user_details.get(j).cart.remove(BookMenu.books.get(i).book_name);   
            }
        }
        if(f){
            Library.clear();
            System.out.println("THE BOOK IS NOT AVAILABLE IN THE CART ");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER");
            try{
                System.in.read();
                user_book(j);
            }
            catch(Exception e){

            }

        }
        else{
            Library.clear();
            System.out.println("THE BOOK "+name+" HAS BEEN REMOVE FROM THE CART");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER");
            try{
                System.in.read();
                user_book(j);
            }
            catch(Exception e){

            }
        }

    }
    
    static void view_cart(int j){

        Library.clear();
        if(user_details.get(j).cart.size()>0){
            for(int i=0;i<user_details.get(j).cart.size();i++){
                System.out.println(user_details.get(j).cart.get(i));
            }
            System.out.println();
            System.out.println("PLEASE PRESS ENTER");
            try{
                System.in.read();
                user_book(j);
            }
            catch(Exception e){
    
            } 

        }
        else{
            Library.clear();
            System.out.println("THERE IS NO BOOKS IN THE CART");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER");
            try{
                System.in.read();
                user_book(j);
            }
            catch(Exception e){
    
            } 
        }
        
    }

    static void user_fine(int j){

        Library.clear();
        for(int i=0;i<user_details.get(j).fine_history.size();i++){
            System.out.println(user_details.get(j).fine_history.get(i));
        }
        System.out.println();
        System.out.println("PLEASE PRESS ENTER");
        try{
            System.in.read();
            user_func(j);
        }
        catch(Exception e){

        }

    }
    
    static void user_card(int j){

        Library.clear();
        System.out.println("DID YOU LOST THE MASTER CARD .IF YES FINE OF RUPPES 10 WILL BE DETECTED FROM YOUR WALLET ");
        System.out.println();
        System.out.println("IF YES PRESS 1 ");
        int fn=sc.nextInt();
        if(fn==1){
            int a=user_details.get(j).wallet_amount;
            a=a-10;
            user_details.get(j).wallet_amount=a;
            System.out.println();
            System.out.println("THE AMOUNT 10 HAS BEEN DETECTED ");
            user_details.get(j).fine_history.add("FINE FOR LOST MASTER CARD AND FINE IS 10 RUPEES");
            BookMenu.fine_history.add("FINE FOR LOST MASTER CARD BY "+user_details.get(j).user_name+" FINE OF 10 RUPPEES");
            System.out.println("PLEASE PRESS ENTER");
            try{
                System.in.read();
                user_book(j);
            }
            catch(Exception e){
    
            } 
        }

    }

}

class Borrow{

    static Scanner sc=new Scanner(System.in);

    static ArrayList <Borrow> borrow_details = new ArrayList<>();

    public int b_id;
    public String b_name;
    public String user_name;
    public String borrow_date;
    public String return_date;
    public String return_status;
    public String actual_date;

    Borrow(int b_id,String b_name,String user_name,String borrow_date,String return_date,String return_status,String actual_date){
        this.b_id=b_id;
        this.b_name=b_name;
        this.user_name=user_name;
        this.borrow_date=borrow_date;
        this.return_date=return_date;
        this.return_status=return_status;
        this.actual_date=actual_date;
    }

    static void checkout_book(int j){

        Library.clear();
        // System.out.println();
        System.out.println("ENTER THE BOOK ID");
        int bo_id=sc.nextInt();
        System.out.println();

        System.out.println("ENTER THE BOOK NAME");
        String bo_name=sc.next();
        System.out.println();

        System.out.println("ENTER THE DATE YOU RETURN THE BOOK (YYYY-MM-DD) ");
        String bo_return=sc.next();
        System.out.println();


        System.out.println();
        System.out.println("PLEASE PRESS ENTER ");

        boolean f=true;
        for(int i=0;i<borrow_details.size();i++){
            if((borrow_details.get(i).b_name.equals(bo_name)) && (borrow_details.get(i).b_id==bo_id) && (borrow_details.get(i).user_name.equals(User.user_details.get(j).user_name))){
                f=false;
    
            }
        }
        boolean f1=false;
        boolean f2=false;
        int bo=0;
        for(int i=0;i<BookMenu.books.size();i++){
            if((BookMenu.books.get(i).book_name.equals(bo_name))&&(BookMenu.books.get(i).book_id==bo_id)){
                f1=true;
                if(BookMenu.books.get(i).book_quantity>0){
                    f2=true;
                    bo=i;
                }
            }
        }
        if(f){
            if(User.user_details.get(j).wallet_amount>=500){ 
                if(f1){
                    if(f2){
                        borrow_details.add(new Borrow(bo_id,bo_name,User.user_details.get(j).user_name,Library.curr_date,bo_return,"no","null"));
                        int a=BookMenu.books.get(bo).book_quantity;
                        int k=a-1;
                        BookMenu.books.get(bo).book_quantity=k;
                        int b=BookMenu.books.get(bo).borrow_count;
                        b=b+1;
                        BookMenu.books.get(bo).borrow_count=b;
                        Library.clear();
                        System.out.println();
                        System.out.println("PLEASE PRESS ENTER ");
                        System.out.println();
                        System.out.println("THE BOOK "+bo_name+" SUCCESSFULLY BORROWED AND RETURN DATE IS "+bo_return);

                    }
                    else{
                        Library.clear();
                        System.out.println("THE BOOK IS NOT AVAILABLE");
                        System.out.println();
                        System.out.println("PLEASE PRESS ENTER ");
                        

                    }
                }
                else{
                    Library.clear();
                    System.out.println("THERE IS NO SUCH BOOKS IN LIBRARY..PLEASE ENTER VALID BOOK ");
                    System.out.println();
                    System.out.println("PLEASE PRESS ENTER ");
                } 
            }  
            else{
                Library.clear();
                System.out.println("THE MININMUM BALANCE IN WALLET SHOULD BE 500.OTHERWISE YOU CAN'T BORROW A BOOK");
                System.out.println();
                System.out.println("PLEASE PRESS ENTER ");
            }
        }
        else{
            Library.clear();
            System.out.println("YOU ALREADY BORROWED THIS BOOK .YOU CAN'T BORROW A BOOOK TWICE");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER ");

        }
        try{
            System.in.read();
            User.user_book(j);
        }
        catch(Exception e){

        }

        
        
    }

    static void borrow_history(int j){
        if(borrow_details.size()>0){
            Library.clear();
            System.out.println("BOOK"+"   "+"ID"+"   "+"USER"+"   "+"BORROW DATE"+"   "+"RETURN DATE");
            for(int i=0;i<borrow_details.size();i++){
                System.out.println(borrow_details.get(i).b_name+"  "+borrow_details.get(i).b_id+"   "+borrow_details.get(i).user_name+"   "+borrow_details.get(i).borrow_date+"     "+borrow_details.get(i).return_date);
            }
            System.out.println();
           
            // System.out.println("THE BOOK IS NOT AVAILABLE");
            
        }
        else{
            Library.clear();
            System.out.println("NO BOOK HAVE BEEN BORROWED");
            System.out.println();
            

        }
        System.out.println("PLEASE PRESS ENTER ");
        System.out.println();
        try{
            System.in.read();
            User.user_book(j);
        }
        catch(Exception e){

        }
        
    }
    
    static void return_book(int j){

        Library.clear();
        System.out.println("ENTER YOUR USER NAME");
        String name=sc.next();
        System.out.println();
        System.out.println("ENTER THE ID OF THE BOOK YOU WANT TO RETURN");
        int id=sc.nextInt();
        for(int i=0;i<borrow_details.size();i++){
            if((borrow_details.get(i).b_id==id) && (borrow_details.get(i).user_name.equals(name))){
                if(borrow_details.get(i).return_status.equals("no")){
                    Library.clear();
                    System.out.println("THE BOOK HAS SUCCESSFULLY RETURNED ");
                    borrow_details.get(i).return_status="yes";
                    BookMenu.books.get(i).book_quantity+=1;
                    borrow_details.get(i).actual_date=Library.curr_date;
                    fine(j,borrow_details.get(i).b_id);

                }
                else{
                    Library.clear();
                    System.out.println("THE BOOK HAS ALREADY RETURNED ");
                }
            }
            else{
                Library.clear();
                System.out.println("THE BOOK ID DOESN'T MATCH ");
            }
        
        }
        System.out.println("PLEASE PRESS ENTER ");
        System.out.println();
        try{
            System.in.read();
            User.user_book(j);
        }
        catch(Exception e){

        }
        
        

    }

    static void fine(int j,int id){

        String date1=Library.curr_date;
        String date2=borrow_details.get(j).borrow_date;

        int total_days=0;
        while(!date1.equals(date2)){
            date2=Library.addOneDay(date2,1);
            total_days+=1;
        }
        // System.out.println(total_days);
        if(total_days<=15){
            Library.clear();
            System.out.println("YOU RETURNED THE WITHIN TIME .THANK YOU ");
        }
        else{
            int fine=0;
            total_days=total_days-15;
            double a=1;
            double two=2;
            int c=0;

            while(total_days!=0){
                double i=a;
                
                while(c<10){
                    if(total_days!=0){
                        fine+=(int)(Math.pow(two,i));
                        c+=1;
                        total_days-=1;
                    }
                    else{
                        break;
                    }


                }
                a+=1;
                c=0;

            }
            System.out.println("YOU HAVE FINE FOR NOT RETURN THE BOOK WITHIN TIME..YOUR ESTIMATED FINE AMOUNT IS "+fine);
            System.out.println();
            System.out.println("IF YOU WANT TO PAY THE FINE BY WALLET.PRESS 1 ");
            System.out.println("IF YOU WANT TO PAY THE FINE BY AMOUNT.PRESS 2 ");
            int rem=sc.nextInt();
            if(rem==1){
                Library.clear();
                if(User.user_details.get(j).wallet_amount>fine){
                    System.out.println("THE FINE DETECTED FROM YOUR WALLET");
                    User.user_details.get(j).fine_history.add("FINE FOR NOT RETURN THE BOOK WITHIN TIME AND THE BOOK ID IS"+" "+id+" OF RUPEES "+fine);
                    BookMenu.fine_history.add("FINE -> NOT RETURN -> BOOK ID "+id+" BY "+User.user_details.get(j).user_name+" FINE PAID "+fine );
                    User.user_details.get(j).wallet_amount-=fine;
                }
                else{
                    System.out.println("YOU DON'T HAVE SUFFICIENT AMOUNTS IN YOUR WALLET");
                    System.out.println();
                    System.out.println("PLEASE PAY BY FINE");
                    System.out.println("PLEASE PRESS ENTER ");
                    System.out.println();
                    try{
                        System.in.read();
                        fine(j,id);
                    }
                    catch(Exception e){
            
                    }

                }

            }
            if(rem==2){
                User.user_details.get(j).fine_history.add("FINE FOR NOT RETURN THE BOOK WITHIN TIME AND THE BOOK ID IS"+" "+id+" OF RUPEESS "+fine);
                BookMenu.fine_history.add("FINE -> NOT RETURN -> BOOK ID  "+id+" BY "+User.user_details.get(j).user_name+" FINE PAID "+fine );

                System.out.println("THANKS FOR PAYING THE FINE..");
            }
        }
        System.out.println("PLEASE PRESS ENTER ");
        System.out.println();
        try{
            System.in.read();
            User.user_book(j);
        }
        catch(Exception e){

        }


    }

    static void book_lost(int j){

        Library.clear();
        System.out.println("ENTER THE ID OF THE BOOK THAT LOST");
        int b_id=sc.nextInt();
        System.out.println();
        System.out.println("ENTER USERNAME");
        String name=sc.next();
        boolean f=false;
        int x=0;
        for(int i=0;i<borrow_details.size();i++){
            if((borrow_details.get(i).b_id==b_id)&&(borrow_details.get(i).user_name.equals(name)) && borrow_details.get(i).return_status.equals("no")){
                f=true;
                x=i;
            }
        }
        if(f){
            Library.clear();
            int cost=0;
            for(int i=0;i<BookMenu.books.size();i++){
                if(BookMenu.books.get(i).book_id==b_id){
                    cost=BookMenu.books.get(i).book_cost;
                }
            }
            System.out.println("THE FINE FOR LOST THE BOOK IS "+cost/2);
            System.out.println();
            System.out.println("IF YOU WANT TO PAY THE FINE BY WALLET.PRESS 1 ");
            System.out.println("IF YOU WANT TO PAY THE FINE BY AMOUNT.PRESS 2 ");
            int rem=sc.nextInt();
            if(rem==1){
                Library.clear();
                if(User.user_details.get(j).wallet_amount>cost/2){
                    System.out.println("THE FINE DETECTED FROM YOUR WALLET");
                    borrow_details.get(x).return_status="yes";
                    User.user_details.get(j).wallet_amount-=cost/2;
                    User.user_details.get(j).fine_history.add("FINE FOR LOST THE BOOK AND THE BOOK ID IS "+" "+b_id+" OF RUPEES "+cost/2);
                    BookMenu.fine_history.add("FINE -> BOOK LOST -> BOOK ID "+b_id+" BY "+User.user_details.get(j).user_name+" FINE PAID "+cost/2 );

                }
                else{
                    System.out.println("YOU DON'T HAVE SUFFICIENT AMOUNTS IN YOUR WALLET");
                    System.out.println();
                    System.out.println("PLEASE PAY BY FINE");
                    System.out.println("PLEASE PRESS ENTER ");
                    System.out.println();
                    try{
                        System.in.read();
                        User.user_book(j);
                    }
                    catch(Exception e){
            
                    }

                }
            }
            if(rem==2){
                System.out.println("THANKS FOR PAYING THE FINE..");
                borrow_details.get(x).return_status="yes";
                User.user_details.get(j).fine_history.add("FINE FOR NOT LOST THE BOOK WITHIN TIME AND THE BOOK ID IS"+" "+b_id+"OF RUPEES"+cost/2);
                BookMenu.fine_history.add("FINE -> BOOK LOST -> BOOK ID "+b_id+" BY "+User.user_details.get(j).user_name+" FINE PAID "+cost/2 );
            }
            System.out.println("PLEASE PRESS ENTER ");
            System.out.println();
            try{
                System.in.read();
                User.user_book(j);
            }
            catch(Exception e){
    
            }
        }
    }
}


