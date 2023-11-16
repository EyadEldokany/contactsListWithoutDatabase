import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ContactsList obj = new ContactsList();
        boolean z = true;
        obj.CreateNewAdmin("Eyad" , "Eyad");
        obj.CreateNewAdmin("Ali" , "Ali");
        obj.CreateNewAdmin("Youssef" , "Youssef");
        obj.CreateNewAdmin("Mohamed" , "Mohamed");
        obj.CreateNewAdmin("Abdelrahman" , "Abdelrahman");
        for (;z;){
            System.out.println("Enter admin name");
            String name = in.next();
            System.out.println("Enter admin password");
            String password = in.next();
            for (int i = 0; i < obj.getAdmins().size(); i++) {
                if (Objects.equals(name, obj.getAdmins().get(i)) && Objects.equals(password, obj.getAdminsPassword().get(i))){
                    System.out.println("Welcome " + name);
                    z=false;
                    break;
                }
            }
        }
        while (true) {

            byte x;
            System.out.println("1.Add , 2.Modify , 3.Remove , 4.Search , 5.PrintAllInfo");
            x = in.nextByte();
            if (x == 1) {
                System.out.println("Enter name : ");
                String name = in.next();
                if (obj.CheckName(name)) {
                    System.out.println("Name added");
                } else {
                    System.out.println("Name must be written in english and has 3 or more characters");
                    for (; ; ) {
                        System.out.println("Enter Name : ");
                        name = in.next();
                        if (obj.CheckName(name)) {
                            break;
                        } else {
                            System.out.println("Name must be written in english and has 3 or more characters");
                        }
                    }
                }
                System.out.println("Enter phone number : ");
                String phoneNumber = in.next();
                boolean y = true;
                for (int i = 0; i < obj.getPhoneNumber().size(); i++) {
                    if(Objects.equals(obj.getPhoneNumber().get(i), phoneNumber)){
                        System.out.println("This number was already used");
                        y = false;
                        break;
                    }
                }
                if (y) {
                    if (obj.CheckPhoneNumber(phoneNumber)) {
                        System.out.println("phone number added");
                    } else {
                        System.out.println("Invalid phone number");
                        for (; ; ) {
                            System.out.println("Enter phone number : ");
                            phoneNumber = in.next();
                            if (obj.CheckPhoneNumber(phoneNumber)) {
                                break;
                            } else {
                                System.out.println("Invalid phone number");
                            }
                        }
                    }
                }
                else {
                    for (; ; ) {
                        y=true;
                        System.out.println("Enter phone number : ");
                        phoneNumber = in.next();
                        for (int i = 0; i < obj.getPhoneNumber().size(); i++) {
                            if(Objects.equals(obj.getPhoneNumber().get(i), phoneNumber)){
                                System.out.println("This number was already used");
                                y = false;
                                break;
                            }
                        }
                        if (y) {
                            if (obj.CheckPhoneNumber(phoneNumber)) {
                                break;
                            } else {
                                System.out.println("Invalid phone number");
                            }
                        }
                    }
                }
                System.out.println("Enter email : ");
                String email = in.next();


                if (obj.CheckEmail(email)) {
                    System.out.println("Email added");
                } else {
                    System.out.println("Invalid Email");
                    for (; ; ) {
                        System.out.println("Enter Email : ");
                        email = in.next();
                        if (obj.CheckEmail(email)) {
                            break;
                        } else {
                            System.out.println("Invalid email");
                        }
                    }
                }
                obj.add(name, phoneNumber, email);
            }
            if (x==2){
                System.out.println("Enter the user current Index : ");
                int index = in.nextInt();
                System.out.println("Enter the current name : ");
                String oldname = in.next();
                System.out.println("Enter new name : ");
                String newname = in.next();
                if (obj.CheckName(newname)) {
                    System.out.println("Name added");
                } else {
                    System.out.println("Name must be written in english and has 3 or more characters");
                    for (; ; ) {
                        System.out.println("Enter Name : ");
                        newname = in.next();
                        if (obj.CheckName(newname)) {
                            break;
                        } else {
                            System.out.println("Name must be written in english and has 3 or more characters");
                        }
                    }
                }
                System.out.println("Enter new phone number : ");
                String phoneNumber = in.next();
                boolean y = true;
                if(Objects.equals(phoneNumber, obj.getPhoneNumber().get(index))){
                    System.out.println("Phone number added");
                }
                else{
                for (int i = 0; i < obj.getPhoneNumber().size(); i++) {
                    if(Objects.equals(obj.getPhoneNumber().get(i), phoneNumber)){
                        System.out.println("This number was already used");
                        y = false;
                        break;
                    }
                }
                if (y) {
                    if (obj.CheckPhoneNumber(phoneNumber)) {
                        System.out.println("phone number added");
                    } else {
                        System.out.println("Invalid phone number");
                        for (; ; ) {
                            System.out.println("Enter phone number : ");
                            phoneNumber = in.next();
                            if (obj.CheckPhoneNumber(phoneNumber)) {
                                break;
                            } else {
                                System.out.println("Invalid phone number");
                            }
                        }
                    }
                }
                else {
                    for (; ; ) {
                        y = true;
                        System.out.println("Enter phone number : ");
                        phoneNumber = in.next();
                        for (int i = 0; i < obj.getPhoneNumber().size(); i++) {
                            if (Objects.equals(obj.getPhoneNumber().get(i), phoneNumber)) {
                                System.out.println("This number was already used");
                                y = false;
                                break;
                            }
                        }
                        if (y) {
                            if (obj.CheckPhoneNumber(phoneNumber)) {
                                break;
                            } else {
                                System.out.println("Invalid phone number");
                            }
                        }
                    }
                }
                }
                System.out.println("Enter new email : ");
                String email = in.next();

                if (obj.CheckEmail(email)) {
                    System.out.println("Email added");
                } else {
                    System.out.println("Invalid Email");
                    for (; ; ) {
                        System.out.println("Enter Email : ");
                        email = in.next();
                        if (obj.CheckEmail(email)) {
                            break;
                        } else {
                            System.out.println("Invalid email");
                        }
                    }
                }
                obj.modify(index , oldname , newname , phoneNumber ,email);
            }
            if (x==3){
                System.out.println("Enter user index : ");
                int index = in.nextInt();
                System.out.println("Enter user name : ");
                String name = in.next();
                obj.delete(index , name);
            }
            if (x==4){
                System.out.println("Enter phone number : ");
                String phoneNumber = in.next();
                try{
                    obj.search(phoneNumber);
                }
                catch (IndexOutOfBoundsException e ){
                    System.out.println("Phone number is not available");
                }
            }
            if(x==5){
                obj.printInfo();
            }
        }
    }
}

