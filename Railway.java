import java.util.*;

public class Railway {
    private static Scanner sc;

    static void clear() {
        System.out.print("\033[H\033[2J");
    }

    
    public static void main(String[] args) {
        sc = new Scanner(System.in);

        for (int i = 0; i < Admin.x_axis; i++) {
            Admin.Train.add(new ArrayList<ArrayList<String>>(Admin.y_axis));
            for (int j = 0; j < Admin.y_axis; j++) {
                Admin.Train.get(i).add(new ArrayList<String>(Arrays.asList("0", "0", "0")));
            }
        }
        Admin.TrainInfo.add(new TrainClass(String.valueOf(Admin.TrainIdGenerator), "CHENNAI-EXPRESS", "CHENNAI-BOMBAY",
                "CHENNAI HYDERABAD BOMBAY"));
        Admin.TrainIdGenerator++;

        User.Users.add(new User("Ja0", "Javahar", "123"));

        main_func();
    }

    static void main_func() {
        clear();
        System.out.println("ENTER 1 TO ADMIN LOGIN");
        System.out.println("ENTER 2 TO USER LOGIN");
        System.out.println("3.EXIT");
        int n = sc.nextInt();

        if (n == 1) {
            Admin.login();
        } else if (n == 2) {
            User.user_main();
        } else if (n == 3) {
            System.exit(0);

        } else {
            System.out.println("INVALID OPTION");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER TO CONTINUE.");
            try {
                System.in.read();
                main_func();
            } catch (Exception e) {
            }
        }
    }
}

class TrainClass {

    

    public String TrainId;
    public String TrainName;
    public String TrainRoute;
    public String TrainStations;

    TrainClass(String trainId, String trainName, String trainRoute, String trainStations) {
        this.TrainId = trainId;
        this.TrainName = trainName;
        this.TrainRoute = trainRoute;
        this.TrainStations = trainStations;
    }

}

class Admin {

    private static Scanner sc = new Scanner(System.in);
    static String id = "admin";
    static String pass = "admin";

    static int x_axis = 1;
    static int y_axis = 5;

    static List<TrainClass> TrainInfo = new ArrayList<>();
    static ArrayList<ArrayList<ArrayList<String>>> Train = new ArrayList<>(x_axis);

    static boolean called = false;
    static int TrainIdGenerator = 1;



    static void login() {
        Railway.clear();
        System.out.println("\tADMIN LOIGN");
        System.out.println("ENTER ADMIN ID: ");
        String adminId = sc.next();
        System.out.println("ENTER PASSWORD: ");
        String password = sc.next();

        if (adminId.equals(id) && password.equals(pass)) {
            admin_main();
        } else {
            System.out.println("INVALID ID OR PASSWORD");
            try {
                System.in.read();
                Railway.main_func();
            } catch (Exception e) {
            }
        }
    }

    static void admin_main() {
        Railway.clear();
        System.out.println("ENTER 1 TO ADD TRAIN");
        System.out.println("ENTER 2 TO DECLARE SEATS AVIALABILITY");
        System.out.println("ENTER 3 TO VIEW TRAINS");
        System.out.println("ENTER 4 TO BACK");

        int AdminOption = sc.nextInt();

        if (AdminOption == 1) {
            add_train();
        } else if (AdminOption == 2) {
            declare_seats_available();
        } else if (AdminOption == 3) {
            called = true;
            print_trains();
        } else if (AdminOption == 4) {
            Railway.main_func();
        } else {
            System.out.println("INVALID OPTION");
            try {
                System.in.read();
                admin_main();
            } catch (Exception e) {
            }
        }

    }

    static void add_train() {
        Railway.clear();

        System.out.print("ENTER NAME OF THE TRAIN : ");
        String name = sc.next();

        System.out.print("ENTER ROUTE : ");
        String route = sc.next();

        System.out.print("ENTER STATIONS NAME : ");
        sc.nextLine();
        String stations = sc.nextLine();

        Train.add(new ArrayList<ArrayList<String>>());
        TrainInfo.add(new TrainClass(String.valueOf(TrainIdGenerator), name, route, stations));
        TrainIdGenerator++;

        System.out.println("PLEASE PRESS ENTER TO CONTINUE");
        try {
            System.in.read();
            admin_main();
        } catch (Exception e) {
        }
    }

    static void declare_seats_available(){
        Railway.clear();

        System.out.println("ENTER TRAIN ID : ");
        String id = sc.next();
        boolean isIdPresent = false;    
        for (int i = 0; i < TrainInfo.size(); i++) {
            if (TrainInfo.get(i).TrainId.equals(id)) {
                isIdPresent = true;
            }
        }

        if (isIdPresent) {

            System.out.println("Enter NO OF SEATS : ");
            int No = sc.nextInt();

            int Id = Integer.parseInt(id) - 1;

            if (Train.get(Id).size() == 0) {
                for (int i = 0; i < No; i++) {
                    String[] temp1 = TrainInfo.get(Id).TrainStations.split(" ");
                    ArrayList<String> temparory = new ArrayList<String>();
                    for (int j = 0; j < temp1.length; j++) {
                        temparory.add("0");
                    }
                    Train.get(Id).add(temparory);
                }
            } else {
                Train.get(Id).clear();
                for (int i = 0; i < No; i++) {
                    String[] temp1 = TrainInfo.get(Id).TrainStations.split(" ");
                    ArrayList<String> temparory = new ArrayList<String>();
                    for (int j = 0; j < temp1.length; j++) {
                        temparory.add("0");
                    }
                    Train.get(Id).add(temparory);
                }
            }

            System.out.println();
            System.out.println("SEAT DECLARATION SUCCESSFULY");
            System.out.println();
            System.out.println("PRESS ENTER TO COTINUE");
            try {
                System.in.read();
                admin_main();
            } catch (Exception e) {
            }
        } else {
            System.out.println();
            System.out.println("INVALID TRAIN ID");
            System.out.println();
            System.out.println("PRESS ENTER TO CONTINUE ");
            try {
                System.in.read();
                admin_main();
            } catch (Exception e) {
            }
        }

    }
    
    static void print_trains() {
        Railway.clear();
        for (int i = 0; i < Train.size(); i++) {
            for (int j = 0; j < Train.get(i).size(); j++) {
                for (int k = 0; k < Train.get(i).get(j).size(); k++) {
                    System.out.printf("%-5s", Train.get(i).get(j).get(k));
                }
                System.out.println();
            }

            System.out.println("TRAIN ID : " + TrainInfo.get(i).TrainId + "\n" + "TRAIN NAME : "+ TrainInfo.get(i).TrainName + "\n" + "TRAIN ROUTE : " + TrainInfo.get(i).TrainRoute + "\n"+ "TRAIN STATIONS : " + TrainInfo.get(i).TrainStations);
            System.out.println();
        }
        System.out.println("PRESS ENTER TO CONTINUE");

        try {
            System.in.read();
            if (called) {
                admin_main();
            } else {
                User.user_main();
            }
        } catch (Exception e) {
        }
    }

    
    static int get_available(int index) {
        int res = 0;
        for (int j = 0; j < Train.get(index).size(); j++) {
            for (int k = 0; k < Train.get(index).get(j).size(); k++) {
                if (Train.get(index).get(j).get(k).equals("0")) {
                    res++;
                }
            }
        }

        return res;
    }

}

class User{

    private static Scanner sc = new Scanner(System.in);

    static List<User> Users = new ArrayList<>();
    static List<Tickets> TicketDetails = new ArrayList<>();
    static Formatter fmt = new Formatter();

    static int userIdGenerator = 1;
    static boolean isBook = false;

    public String UserId;
    public String UserName;
    public String UserPassword;

    static String CurrentUser = null;

    User(String userId, String userName, String userPassword) {
        this.UserId = userId;
        this.UserName = userName;
        this.UserPassword = userPassword;
    }

    static void user_main() {
        Railway.clear();
        System.out.print("----- WELCOME USER -----\n" +
                "\nPRESS 1 TO REGISTER" +
                "\nPRESS 2 TO LOGIN" +
                "\nPRESS 3 TO GO BACK \n" +
                "\nENTER YOUR CHOICE : ");
        int choice = sc.nextInt();
        if (choice == 1) {
            registerUser();
        } else if (choice == 2) {
            user_login();
        } else if (choice == 3) {
            Railway.main_func();
        } else {
            System.out.println("INVALID OPTIONS");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER TO CONTINUE ");
            try {
                System.in.read();
                user_main();
            } catch (Exception e) {
            }
        }
    }

    static void registerUser() {
        Railway.clear();
        System.out.println("ENTER USERNAME");
        sc.nextLine();
        String username = sc.nextLine();

        System.out.println("ENTER PASSWORD");
        String password = sc.next();

        String uId = username.substring(0, 2) + String.valueOf(userIdGenerator);
        userIdGenerator++;

        Users.add(new User(uId, username, password));

        System.out.println();
        System.out.println("PRESS ENTER TO CONTINUE ");
        try {
            System.in.read();
            user_func();
        } catch (Exception e) {
        }
    }

    static void user_login() {
        Railway.clear();
        System.out.println("ENTER YOUR USERNAME");
        String username = sc.next();

        System.out.println("ENTER YOUR PASSWORD");
        String password = sc.next();

        for (int i = 0; i < Users.size(); i++) {
            if (Users.get(i).UserName.equals(username) && Users.get(i).UserPassword.equals(password)) {
                CurrentUser = Users.get(i).UserId;
                user_func();
            }
        }

        System.out.println("INVALID OPTIONS");
        System.out.println();
        System.out.println("PRESS ENTER TO CONTINUE");
        try {
            System.in.read();
            Railway.main_func();
        } catch (Exception e) {
        }

    }

    static void user_func() {
        Railway.clear();
        System.out.println("ENTER 1 TO TRAINS AND AVAILABILITY");
        System.out.println("ENTER 2 TO BOOK TICKETS");
        System.out.println("ENTER 3 TO VIEW BOOKINGS");
        System.out.println("ENTER 4 TO CANCEL BOOKING");
        System.out.println("ENTER 5 TO GO BACK  ");

        int n = sc.nextInt();

        if (n == 1) {
            Admin.called = false;
            Admin.print_trains();
        } else if (n == 2) {
            book_tickets();
        } else if (n == 3) {
            // viewBookings();
        } else if (n == 4) {
            // cancleBooking();
        } else if (n == 5) {
            Railway.main_func();
        } else {
            System.out.println("Invalid option");
            System.out.println();
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                user_func();
            } catch (Exception e) {
            }
        }

    }
    static void book_tickets() {
        Railway.clear();
        System.out.println();
        System.out.println("****************************** TRAINS ******************************");
        System.out.println();
        System.out.printf("%-8s%-20s%-20s%-20s\n", "S.MO", "TRAIN NAME", "TRAIN ROUTE", "TRAIN ID");
        for (int i = 0; i < Admin.TrainInfo.size(); i++) {
            System.out.printf("%-8s%-20s%-20s%-20s\n", i + 1, Admin.TrainInfo.get(i).TrainName,
                    Admin.TrainInfo.get(i).TrainRoute, Admin.TrainInfo.get(i).TrainId);
        }
        System.out.println();
        System.out.println("ENTER NO OF BOOKING :");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            Railway.clear();
            System.out.println("ENTER TRAIN ID");
            String trainId_book = sc.next();

            boolean isIdPresent = false;
            // TrainInfo = [{1,...},{2,..},{3,...}]
            for (int j = 0; j < Admin.TrainInfo.size(); j++) {
                if (Admin.TrainInfo.get(j).TrainId.equals(trainId_book)) {
                    isIdPresent = true;
                }
            }

            if (isIdPresent) {

                printTrain(Integer.parseInt(trainId_book) - 1);

                System.out.println("Enter STATION IN AND OUT : ");
                int stationIn = sc.nextInt();
                int stationOut = sc.nextInt();

                int tId = Integer.parseInt(trainId_book) - 1;
                isBook = true;
                int SeatNo = bookSeat(stationIn, stationOut, tId, User.CurrentUser);

                if (SeatNo != -1) {
                    System.out.println("YOUR SEAT NO : " + SeatNo);
                } else {
                    TicketDetails.add(new Tickets(-1, CurrentUser, Admin.TrainInfo.get(tId).TrainName,
                            Admin.TrainInfo.get(tId).TrainRoute, "Pending",
                            Integer.parseInt(Admin.TrainInfo.get(tId).TrainId),
                            -1, stationIn, stationOut));
                    System.out.println("CURRENTLY NO SEATS AVAILABLE..YOU ARE IN THE WAITING LIST ");
                }

                System.out.println();
                System.out.println("PRESS ENTER TO CONTINUE");
                try {
                    System.in.read();
                } catch (Exception e) {
                }
            } else {
                System.out.println();
                System.out.println("INVALID TRAIN ID");
                System.out.println();
                System.out.println("PRESS ENTER TO CONTINUE ");
                try {
                    System.in.read();
                    book_tickets();
                } catch (Exception e) {
                }
            }
        }

        System.out.println();
        System.out.println("PRESS ENTER TO CONTINUE");
        try {
            System.in.read();
            user_func();
        } catch (Exception e) {
        }

    }

    static void printTrain(int tId) {
        System.out.println();
        for (int j = 0; j < Admin.Train.get(tId).size(); j++) {
            for (int k = 0; k < Admin.Train.get(tId).get(j).size(); k++) {
                System.out.printf("%-5s", Admin.Train.get(tId).get(j).get(k));
            }
            System.out.println();
        }
        System.out.println("TRAIN ID: " + Admin.TrainInfo.get(tId).TrainId + "\n" + "TRAIN NAME: "
                + Admin.TrainInfo.get(tId).TrainName + "\n" + "TRAIN ROUTE : " + Admin.TrainInfo.get(tId).TrainRoute
                + "\n"
                + "TRAIN STATIONS : " + Admin.TrainInfo.get(tId).TrainStations);
        System.out.println(
                "AVAILABLITY OF SEATS : "
                        + Admin.get_available(Integer.parseInt(Admin.TrainInfo.get(tId).TrainId) - 1));
        System.out.println("..............");
        System.out.println();
    }

    static int bookSeat(int in, int out, int tId, String setUser) {

        int res = -1;
        for (int i = 0; i < Admin.Train.get(tId).size(); i++) {
            int tot = 0, size = 0;
            for (int k = in - 1; k < out; k++) {
                size++;
                if (Admin.Train.get(tId).get(i).get(k).equals("0")) {
                    tot++;
                }
            }
            if (tot == size) {

                for (int k = in - 1; k < out; k++) {
                    Admin.Train.get(tId).get(i).set(k, setUser);
                }
                res = i;
                if (isBook) {
                    TicketDetails.add(new Tickets(Tickets.TicketNoGenerator, User.CurrentUser,
                            Admin.TrainInfo.get(tId).TrainName, Admin.TrainInfo.get(tId).TrainRoute, "Booked",
                            Integer.parseInt(Admin.TrainInfo.get(tId).TrainId), i, in, out));
                    Tickets.TicketNoGenerator++;
                }
                return res;
            }
        }

        return res;
    }
    
    static void viewBookings() {
        Railway.clear();

        System.out.printf("%-15s%-20s%-20s%-13s%-13s%-13s%-5s\n", "TICKET NO.", "TRAIN NAME", "TRAIN ROUTE", "SEAT NO",
                "STATION IN", "STATION OUT", "STATUS");
        for (int i = 0; i < TicketDetails.size(); i++) {
            if (TicketDetails.get(i).PassangerId.equals(User.CurrentUser)) {

                System.out.printf("%-15d%-20s%-20s%-13s%-13d%-13d%-5s\n", TicketDetails.get(i).TicketNo,
                        TicketDetails.get(i).Ticket_TrainName, TicketDetails.get(i).Ticket_TrainRoute,
                        TicketDetails.get(i).Ticket_TrainSeat, TicketDetails.get(i).Ticket_Start,
                        TicketDetails.get(i).Ticket_End, TicketDetails.get(i).Ticket_TicketStatus);
            }
        }
        System.out.println();
        System.out.println("PRESS ENTER TO CONTINUE");
        try {
            System.in.read();
            user_func();
        } catch (Exception e) {
        }
    }

    static void cancleBooking() {
        Railway.clear();
        System.out.println("ENTER TICKET NO : ");
        int ticker_no = sc.nextInt();

        boolean isTicket = false;
        // TrainInfo = [{1,...},{2,..},{3,...}]
        for (int i = 0; i < TicketDetails.size(); i++) {
            if (TicketDetails.get(i).TicketNo == ticker_no) {
                isTicket = true;
            }
        }

        if (isTicket) {

            for (int i = 0; i < TicketDetails.size(); i++) {
                if (TicketDetails.get(i).TicketNo == ticker_no) {
                    removeSeat(TicketDetails.get(i).Ticket_TrainId - 1, TicketDetails.get(i).Ticket_TrainSeat,
                            TicketDetails.get(i).Ticket_Start, TicketDetails.get(i).Ticket_End);
                    TicketDetails.remove(i);
                    bookPending();
                    break;
                }
            }

            System.out.println();
            System.out.println("TICKET NO. " + ticker_no + "CALLED SUCCESSFULLY!");
        } else {
            System.out.println();
            System.out.println("TICKET NO. " + ticker_no + " NOT FOUND PLEASE ENTER VALID TICKET NUMBER !");
        }
        System.out.println();
        System.out.println("PRESS ENTER TO CONTINUE");
        try {
            System.in.read();
            user_func();
        } catch (Exception e) {
        }
    }

    static void removeSeat(int tId, int tSeat, int tStart, int tEnd) {
        for (int j = tStart - 1; j < tEnd; j++) {
            Admin.Train.get(tId).get(tSeat).set(j, "0");
        }
    }

    static void bookPending() {
        isBook = false;

        for (int i = 0; i < TicketDetails.size(); i++) {
            if (TicketDetails.get(i).Ticket_TicketStatus.equals("Pending")) {
                int res = bookSeat(TicketDetails.get(i).Ticket_Start, TicketDetails.get(i).Ticket_End,
                        TicketDetails.get(i).Ticket_TrainId - 1, TicketDetails.get(i).PassangerId);
                if (res != -1) {
                    TicketDetails.get(i).Ticket_TicketStatus = "Booked";
                    TicketDetails.get(i).TicketNo = Tickets.TicketNoGenerator;
                    TicketDetails.get(i).Ticket_TrainSeat = res;

                    Tickets.TicketNoGenerator++;
                }
            }
        }
    }


}
class Tickets {

    static int TicketNoGenerator = 1;

    public int TicketNo;
    public String PassangerId;
    public String Ticket_TrainName;
    public String Ticket_TrainRoute;
    public String Ticket_TicketStatus;
    public int Ticket_TrainId;
    public int Ticket_TrainSeat;
    public int Ticket_Start;
    public int Ticket_End;

    Tickets(int TicketNo, String PassangerId, String Ticket_TrainName, String Ticket_TrainRoute,
            String Ticket_TicketStatus, int Ticket_TrainId, int Ticket_TrainSeat, int Ticket_Start, int Ticket_End) {
        this.TicketNo = TicketNo;
        this.PassangerId = PassangerId;
        this.Ticket_TrainName = Ticket_TrainName;
        this.Ticket_TrainRoute = Ticket_TrainRoute;
        this.Ticket_TicketStatus = Ticket_TicketStatus;
        this.Ticket_TrainId = Ticket_TrainId;
        this.Ticket_TrainSeat = Ticket_TrainSeat;
        this.Ticket_Start = Ticket_Start;
        this.Ticket_End = Ticket_End;
    }
}