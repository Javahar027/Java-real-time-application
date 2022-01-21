import java.util.*;

class Amazon {
    private static Scanner sc;
    public static void  main(String[] args) {
        
        clear();
        sc=new Scanner(System.in);
        mainfunc();
        
    } 

static void mainfunc(){
    clear();
    System.out.println("********** WELCOME TO AMAZON **********");
    System.out.println();
    System.out.println("PLEASE ENTER 1 IF YOU ARE A ADMIN");
    System.out.println("PLEASE ENTER 2 IF YOU ARE A MERCHANT");
    System.out.println("PLEASE ENTER 3 IF YOU ARE A USER");
    System.out.println("ENTER 4 IF YOU NEED TO EXIT");
    System.out.println();
    System.out.println("PLEASE ENTER ANY OF THE ABOVE OPTIONS");

    int option=sc.nextInt();
    
    switch(option){
        case 1:
            Admin.admin_login();
            break;
        case 2:
            Merchant.merchant_land();
            break;
        case 3:
            User.user_land();
            break;
        case 4:
            System.exit(0);
            break;
        default:
            System.out.println("INVALID INPUT");
            break;

    }
}
static void clear(){
    System.out.println("\033[H\033[2J");
}

}

class Admin{

    static Scanner sc=new Scanner(System.in);
    static List<String> mer_name = new ArrayList<>();
    static List<String> mer_pass = new ArrayList<>();
    static List<String> mer_sta = new ArrayList<>();
    static List<String> product = new ArrayList<>();
    static List<Integer> count = new ArrayList<>();
    static List<Integer> count1 = new ArrayList<>();
    static List<Integer> cost = new ArrayList<>();
    static int user=0;
    

static void admin_login(){
    Amazon.clear();

    System.out.println("********** WELOCME ADMIN **********");
    String username="admin";
    String password="admin";
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
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try{
            System.in.read();
            Amazon.mainfunc();;
        }
        catch(Exception e){

        }
        
    }


}

static void adminfunc(){
    Amazon.clear();
    System.out.println("PLEASE ENTER 1 TO ADD A MERCHANT ");
    System.out.println("PLEASE ENTER 2 TO SEE THE LIST OF MERCHANTS");
    System.out.println("PLEASE ENTER 3 APPROVE THE MERCHANTS");
    System.out.println("PLEASE ENTER 4 TO DELETE A MERCHANT");
    System.out.println("PLEASE ENTER 5 TO VIEW ALL PRODUCTS");
    System.out.println("PLEASE ENTER 6 TO ADD NEW PRODUCT");
    System.out.println("PLEASE ENTER 7 TO GO BACK");

    // admin_options=0;
    int admin_options=sc.nextInt();
    switch(admin_options){
        case 1:
            add_merchant();
            break;
        case 2:
            show_merchants();
            break;
        case 3:
            approve_merchants();
            break;
        case 4:
            delete_merchants();
            break;
        case 5:
            view_products();
            break;
        case 6:
            add_product();
            break;
        case 7:
            Amazon.mainfunc();
            break;
        default:
            System.out.println("Invalid Input");
            break;
    }
}

static void add_merchant(){

    Amazon.clear();
    System.out.println("ENTER THE USERNAME OF THE MERCHANT");
    String u=sc.next();
    System.out.println();
    System.out.println("ENTER THE PASSWORD FOR THE MERCHNAT");
    String p=sc.next();
    mer_name.add(u);
    mer_pass.add(p);
    mer_sta.add("pass");
    System.out.println();
    System.out.println("THE MERCHANT "+u+" HAS SUCCESSFULLY ADDED");
    System.out.println();
    System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try{
            System.in.read();
            adminfunc();
        }
        catch(Exception e){

        }

    
}

static void show_merchants(){

    Amazon.clear();
    System.out.println("******* THE MERCHANTS ARE *******");
    if(mer_name.size()>0){
        for(int i=0;i<mer_name.size();i++){
            System.out.println(mer_name.get(i));
        }
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try{
            System.in.read();
            adminfunc();
        }
        catch(Exception e){

        }
    }
    else{
        System.out.println("THERE IS NO MERCHANTS ");
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try{
            System.in.read();
            adminfunc();
        }
        catch(Exception e){

        }

    }

}

static void approve_merchants(){

    Amazon.clear();

    for(int i=0;i<mer_sta.size();i++){
        if(mer_sta.get(i).equals("fail")){
            System.out.println("DO YOU WANT TO APPROVE THE MERCHNANT "+mer_name.get(i)+" .IF YES TYPE 1");
            int app=sc.nextInt();
            if(app==1){
                mer_sta.set(i,"pass");
                System.out.println("THE MERCHANT "+mer_name.get(i)+" HAS BEEN APPROVED");
                System.out.println();
            }
            else{
                System.out.println();
                System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
                try{
                    System.in.read();
                    adminfunc();
                }
                catch(Exception e){

                }

            }
        }
        // else{
            
        //     System.out.println("ALL THE MERCHANTS ARE APPROVED ");
        //     System.out.println();
        //     System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        //     try{
        //         System.in.read();
        //         adminfunc();
        //     }
        //     catch(Exception e){

        //     }

        // }
    }
    System.out.println();
    System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
    try{
        System.in.read();
        adminfunc();
    }
    catch(Exception e){

    }

}

    
static void delete_merchants(){ 

    Amazon.clear();
    System.out.println("ENTER THE MERCHANT USERNAME TO DELETE ");
    String u=sc.next();
    boolean flag=false;
    for (int i=0;i<mer_name.size();i++){
        if(mer_name.get(i).equals(u)){
            flag=true;
            user=i;

        }
    }

    if(flag){
        mer_name.remove(user);
        mer_pass.remove(user);
        mer_sta.remove(user);
        System.out.println();
        System.out.println("THE MERCHANT HAS SUCCESSFULLY REMOVED");
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try{
            System.in.read();
            adminfunc();
        }
        catch(Exception e){

        }

    }
    else{
        System.out.println("THE MERCHANT IS NOT FOUND PLEASE ENTER VALID MENCHANT");
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try{
            System.in.read();
            adminfunc();
        }
        catch(Exception e){

        }
    }
}

static void view_products(){

    Amazon.clear();
    if(product.size()>0){
        System.out.println("THE PRODUCTS AVAILABLE ARE");
        System.out.println();
        System.out.println("PRODUCT"+"\t"+"QUANTITY"+"  "+"COST");
        System.out.println();
        for(int i=0;i<product.size();i++){
            System.out.println(product.get(i)+"\t"+count.get(i)+"\t"+cost.get(i));
        }
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try{
            System.in.read();
            adminfunc();
        }
        catch(Exception e){

        }

    }
    else{

        System.out.println("THERE IS NO PRODUCTS AVAILABLE ");
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try{
            System.in.read();
            adminfunc();
        }
        catch(Exception e){

        }
        

    }
}

static void add_product(){

        Amazon.clear();
        System.out.println("ENTER THE NAME OF THE PRODUCT TO ADD");
        String pro=sc.next();
        System.out.println();

        System.out.println("ENTER THE NUMBER OF THE PRODUCT TO ADD");
        int num_pro=sc.nextInt();
        System.out.println();

        System.out.println("ENTER THE COST OF THE PRODUCT ");
        int cos_pro=sc.nextInt();
        System.out.println();

        product.add(pro);
        count.add(num_pro);
        count1.add(num_pro);
        cost.add(cos_pro);

        System.out.println();
        System.out.println("THE PRODUCT "+pro+" HAS SUCCESSFULLY ADDED");
        System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                adminfunc();
            }
            catch(Exception e){

            }
    }



}

class Merchant{
    
    static Scanner sc=new Scanner(System.in);

static void merchant_land(){

    Amazon.clear();
    System.out.println("********** WELOCME MERCHANT **********");
    System.out.println();
    System.out.println("PLEASE ENTER 1 REGISTER ");
    System.out.println("PLEASE ENTER 2 TO LOGIN ");
    System.out.println("PLEASE ENTER 3 TO GO BACK ");
    int log=sc.nextInt();

    switch(log){
        case 1:
            merchant_reg();
            break;
        case 2:
            merchant_login();
            break;
        case 3:
            Amazon.mainfunc();
            break;
        default:
            System.out.println("Invalid Input");
            break;

    }

}

static void merchant_reg(){

    Amazon.clear();

    System.out.println("ENTER YOUR USERNAME");
    String u_reg=sc.next();
    System.out.println();
    System.out.println("ENTER YOUR PASSWORD");
    String u_pass=sc.next();
    Admin.mer_name.add(u_reg);
    Admin.mer_pass.add(u_pass);
    Admin.mer_sta.add("fail");
    System.out.println();
    System.out.println("MERCHNANT HAS BEEN ADDED AND WAITING FOR APPROVAL");
    System.out.println();
    System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
    try {
        System.in.read();
        merchant_land();
    } catch (Exception e) {
    }


}


static void merchant_login(){
    
    Amazon.clear();
    int us=0;
    System.out.println("ENTER YOUR USERNAME");           
    String u=sc.next();
    System.out.println("ENTER YOUR PASSWORD");
    String p=sc.next();

    for(int i=0;i<Admin.mer_name.size();i++){
        if(Admin.mer_name.get(i).equals(u)){
            us=i;
        }
    }

    if((Admin.mer_name.get(us).equals(u)) && (p.equals(Admin.mer_pass.get(us))) && (Admin.mer_sta.get(us).equals("pass"))){
        merchant_func();
    }
    else{
        System.out.println("INVALID USERNAME OR PASSWORD OR NOT APPROVED");
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try {
            System.in.read();
            merchant_land();
        } catch (Exception e) {
        }
    }

}

static void merchant_func(){

        Amazon.clear();
        System.out.println("PLEASE ENTER 1 TO ADD A PRODUCTS ");
        System.out.println("PLEASE ENTER 2 TO UPDATE PRODUCT");
        System.out.println("PLEASE ENTER 3 TO VIEW MOST SOLD PRODUCT");
        System.out.println("PLEASE ENTER 4 TO VIEW SALES REPORT");
        System.out.println("PLEASE ENTER 5 TO VIEW ALL PRODUCTS");
        System.out.println("PLEASE ENTER 6 TO GO BACK");

        
        int merchant_options=sc.nextInt();
        switch(merchant_options){
            case 1:
                add_products();
                break;
            case 2:
                update_products();
                break;
            
            case 3:
                most_sold();
                break;
            case 4:
                sales_report();
                break;
            case 5:
                view_all();
                break;
            case 6:
                merchant_land();
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }


    }
    
static void add_products(){

        Amazon.clear();
        System.out.println("ENTER THE NAME OF THE PRODUCT TO ADD");
        String pro=sc.next();
        System.out.println();
        System.out.println("ENTER THE NUMBER OF THE PRODUCT TO ADD");
        int num_pro=sc.nextInt();
        System.out.println();
        System.out.println("ENTER THE COST OF THE PRODUCT ");
        int cos_pro=sc.nextInt();
        System.out.println();
        Admin.product.add(pro);
        Admin.count.add(num_pro);
        Admin.count1.add(num_pro);
        Admin.cost.add(cos_pro);
        System.out.println();
        System.out.println("THE PRODUCT "+pro+" HAS SUCCESSFULLY ADDED");
        System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                merchant_func();
            }
            catch(Exception e){

            }
    }

static void update_products(){

        int ind=0;
        Amazon.clear();
        System.out.println("ENTER THE NAME OF THE PRODUCT TO UPDATE");
        String pro=sc.next();
        System.out.println();
        boolean flag=false;
        for(int i=0;i<Admin.product.size();i++){
            if(Admin.product.get(i).equals(pro)){
                flag=true;
                ind=i;
            }
        }
        if(flag){
            System.out.println("ENTER THE NUMBER OF ITEMS NEEDS TO BE UPDATED");
            int items=sc.nextInt();
            System.out.println();
            System.out.println("ENTER THE COST OF ITEM NEED TO BE UPDATED");
            int ct=sc.nextInt();
            Admin.count.set(ind,items);
            Admin.cost.set(ind,ct);
            System.out.println("THE ITEM "+pro+" HAS SUCCESSFULLY UPDATED");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                merchant_func();
            }
            catch(Exception e){

            }

        }
        else{
            System.out.println("THE PRODUCT IS NOT AVAILABLE");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                merchant_func();
            }
            catch(Exception e){

            }

        }


    }

static void most_sold(){

        Amazon.clear();
        int max=0;
        int n=0;
        for(int i=0;i<Admin.count.size();i++){
            if((Admin.count1.get(i)-Admin.count.get(i))>max){
                max=Admin.count1.get(i)-Admin.count.get(i);
                n=i;
            }
        }
        System.out.println("THE MOST SOLD PRODUCT ");
        System.out.println();
        System.out.println(Admin.product.get(n)+" "+max+" SOLD");
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try{
            System.in.read();
            merchant_func();
        }
        catch(Exception e){

        }


    }

static void sales_report(){

        Amazon.clear();
        System.out.println("THE SALES REPORT");
        System.out.println();
        for(int i=0;i<User.report.size();i++){
            System.out.println(User.report.get(i));
        }
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try{
            System.in.read();
            merchant_func();
        }
        catch(Exception e){

        }


    }
    
static void view_all(){

        Amazon.clear();
        if(Admin.product.size()>0){
            System.out.println("THE PRODUCTS AVAILABLE ARE");
            System.out.println();
            System.out.println("PRODUCT"+"\t"+"QUANTITY"+"  "+"COST");
            System.out.println();
            for(int i=0;i<Admin.product.size();i++){
                System.out.println(Admin.product.get(i)+"\t"+Admin.count.get(i)+"\t"+Admin.cost.get(i));
            }
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                merchant_func();
            }
            catch(Exception e){

            }

        }
        else{

            System.out.println("THERE IS NO PRODUCTS AVAILABLE ");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                merchant_func();
            }
            catch(Exception e){

            }
            

        }

    }

}

class User{

    static List<String> user_name = new ArrayList<>();
    static List<String> user_pass = new ArrayList<>();
    static List<String> cart = new ArrayList<>();
    static List<String> history = new ArrayList<>();
    static List<String> report = new ArrayList<>();

    
    static Scanner sc=new Scanner(System.in);

static void user_land(){

        Amazon.clear();
        System.out.println("********** WELOCME USER **********");
        System.out.println();
        System.out.println("PLEASE ENTER 1 TO REGISTER ");
        System.out.println("PLEASE ENTER 2 TO LOGIN ");
        System.out.println("PLEASE ENTER 3 TO GO BACK ");
        int log=sc.nextInt();


        switch(log){
            case 1:
                user_reg();
                break;
            case 2:
                user_login();
                break;
            case 3:
                Amazon.mainfunc();
                break;
            default:
                System.out.println("Invalid Input");
                break;

        }

    }

static void user_reg(){

        Amazon.clear();

        System.out.println("ENTER YOUR USERNAME");
        String u_reg=sc.next();
        System.out.println();
        System.out.println("ENTER YOUR PASSWORD");
        String u_pass=sc.next();
        user_name.add(u_reg);
        user_pass.add(u_pass);
        System.out.println();
        System.out.println("REGISTRATION HAS BEEN COMPLETED ADN YOU CAN LOGIN ");
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try {
            System.in.read();
            user_land();
        } catch (Exception e) {
        }
    }

static void user_login(){

        Amazon.clear();
        int us=0;
        System.out.println("ENTER YOUR USERNAME");           
        String u=sc.next();
        System.out.println("ENTER YOUR PASSWORD");
        String p=sc.next();

        for(int i=0;i<user_name.size();i++){
            if(user_name.get(i).equals(u)){
                us=i;
            }
        }
        if((user_name.get(us).equals(u)) && (p.equals(user_pass.get(us)))){
            user_func(us);
            
        }
        else{
            System.out.println("INVALID USERNAME OR PASSWORD");
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try {
                System.in.read();
                user_land();
            } catch (Exception e) {
            }
        }

    }

static void user_func(int i){

        Amazon.clear();
        System.out.println("PLEASE ENTER 1 TO VIEW AVAILABLE PRODUCTS ");
        System.out.println("PLEASE ENTER 2 TO ADD PRODUCT TO CART");
        System.out.println("PLEASE ENTER 3 TO VIEW CART");
        System.out.println("PLEASE ENTER 4 TO VIEW PREVIOUS PURCHASE HISTORY");
        // System.out.println("PLEASE ENTER 5 TO COMPARE PRICES");
        System.out.println("PLEASE ENTER 5 TO BUY ITEMS");
        System.out.println("PLEASE ENTER 6 TO GO BACK");

        
        int user_options=sc.nextInt();
        switch(user_options){
            case 1:
                view_products(i);
                break;
            case 2:
                cart(i);
                break;
            case 3:
                view_cart(i);
                break;
            case 4:
                history(i);
                break;
            // case 5:
            //     // compare_prices();
            //     break;
            case 5:
                buy_items(i);
                break;
            case 6:
                user_land();
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }


    }

static void view_products(int j){

        Amazon.clear();
        if(Admin.product.size()>0){
            System.out.println("THE PRODUCTS AVAILABLE ARE");
            for(int i=0;i<Admin.product.size();i++){
                System.out.println(Admin.product.get(i)+"\t Cost : "+Admin.cost.get(i));
            }
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                user_func(j);
            }
            catch(Exception e){

            }

        }
        else{

            System.out.println("THERE IS NO PRODUCTS AVAILABLE ");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                user_func(j);
            }
            catch(Exception e){

            }
            

        }

    }

static void cart(int i){

        Amazon.clear();
        System.out.println("ENTER THE PRODUCT TO ADD IN CART");
        String pr=sc.next();
        System.out.println();
        boolean f=false;
        for(int j=0;j<Admin.product.size();j++){
            if(Admin.product.get(j).equals(pr)){
                f=true;
                cart.add(i,pr+"\t");
                System.out.println();
                System.out.println("THE PRODUCT HAS SUCCESSFULLY ADDED TO THE CART");
            }
        }
        System.out.println();
        System.out.println("PLEASE PRESS ENTER TO GO PREVIOUS MENU ");
        try{
            System.in.read();
            user_func(i);
        }
        catch(Exception e){

        }
    }

static void view_cart(int i){
            Amazon.clear();
            System.out.println("THE PRODUCTS IN THE CART ARE ");
            for(int j=0;j<cart.size();j++){
                System.out.println(cart.get(j));

            }
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                user_func(i);
            }
            catch(Exception e){

            }
        
    }
    
static void history(int i){

        Amazon.clear();
        System.out.println("THE PURCHASED HISTORY");
        System.out.println();
        for(int j=0;j<history.size();j++){
            System.out.println(history.get(i));
        }
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try{
            System.in.read();
            user_func(i);
        }
        catch(Exception e){

        }

    }

static void buy_items(int i){

        Amazon.clear();
        int x=0;
        System.out.println("ENTER THE ITEM NAME TO BE PURCHASED");
        String pr=sc.next();
        System.out.println();
        boolean f=false;
        for(int j=0;j<Admin.product.size();j++){
            if(Admin.product.get(j).equals(pr)){
                f=true;
                x=j;
            }
        }
        if(f){
            System.out.println("ENTER THE QUANTITY TO BE PURCHASED");
            int c=sc.nextInt();

    
            if(c<=Admin.count.get(x)){
                int tot=c*Admin.cost.get(x);
                System.out.println("THE TOTAL AMOUNT IS "+tot);
                System.out.println();
                System.out.println("DO YOU WANT TO BUY (y or n) ");
                String ans=sc.next();
                if(ans.equals("y")){
                    Amazon.clear();
                    System.out.println("THE ITEMS HAS BEEN SUCCESSFULLY PURCHASED ");
                    history.add("THE ITEM "+pr+" OF QUANTITY "+c+" PURCHASED FOR "+tot+" RUPPEES");
                    report.add("THE ITEM "+pr+" OF QUANTITY "+c+" PURCHASED");
                    System.out.println();
                    int y=Admin.count.get(x);
                    y-=c;
                    Admin.count.set(x,y);
                    System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
                    try{
                        System.in.read();
                        user_func(i);
                    }
                    catch(Exception e){

                    }
                
                }
                else{
                    user_func(i);
                }
            }
            else{
                Amazon.clear();
                System.out.println("THE PRODUCT IS NOT AVAILABE");
                System.out.println();
                System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
                try{
                    System.in.read();
                    user_func(i);
                }
                catch(Exception e){

                }
            }
        }
        else{
            Amazon.clear();
            System.out.println("THE PRODUCT IS NOT AVAILABE");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                user_func(i);
            }
            catch(Exception e){

            }

        }
        
    }

}
