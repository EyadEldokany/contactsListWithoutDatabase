import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactsList {
    private ArrayList <String> admins = new ArrayList<>();
    private ArrayList <String> adminsPassword = new ArrayList<>();
    private ArrayList <String> name = new ArrayList<>();
    private ArrayList <String> phoneNumber = new ArrayList<>();
    private ArrayList <String> email = new ArrayList<>();

    public ArrayList<String> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<String> admins) {
        this.admins = admins;
    }

    public ArrayList<String> getAdminsPassword() {
        return adminsPassword;
    }

    public void setAdminsPassword(ArrayList<String> adminsPassword) {
        this.adminsPassword = adminsPassword;
    }

    public ArrayList<String> getName() {
        return name;
    }
    public void setName(ArrayList<String> name) {
        this.name = name;
    }

    public ArrayList<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(ArrayList<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<String> getEmail() {
        return email;
    }

    public void setEmail(ArrayList<String> email) {
        this.email = email;
    }

    public void add(String Name , String PhoneNumber , String Email){
        name.add(Name);
        phoneNumber.add(PhoneNumber);
        email.add(Email);
    }
    public void delete(int index , String Name){
        if(Objects.equals(name.get(index), Name)){
            name.remove(index);
            phoneNumber.remove(index);
            email.remove(index);
        }
        else{
            System.out.println("Wrong Name");
        }
    }
    public void modify(int index ,String OldName , String NewName , String PhoneNumber , String Email){
        if(Objects.equals(name.get(index), OldName)){
            name.set(index , NewName);
            phoneNumber.set(index,PhoneNumber);
            email.set(index , Email);
        }
        else{
            System.out.println("Wrong Information");
        }
    }
    public void search(String Phonenumber){
        for (int i = 0; i <=phoneNumber.size() ; i++){
            if (Objects.equals(phoneNumber.get(i), Phonenumber)){
                System.out.println("Name : " + name.get(i) + "\nPhone number : " + phoneNumber.get(i) + "\nE-mail : " + email.get(i));
                break;
            }
        }
    }
    public boolean CheckName(String name){
        if (name.length()<3 || name.length()>20){
            return false;
        }
        else {
            Pattern p = Pattern.compile("[a-zA-Z]*");
            Matcher m = p.matcher(name);
            return m.matches();
        }
    }
    public boolean CheckPhoneNumber(String number){
            String phoneNumberForm = "(010||011||012||015)\\d{8}";
            Pattern p = Pattern.compile(phoneNumberForm);
            Matcher m = p.matcher(number);
           return m.matches();
    }
    public boolean CheckEmail(String Email){
            String emailForm = "^[a-zA-Z0-9]+@(gmail|yahoo|outlook|hotmail)\\.(com|net)";
            Pattern p = Pattern.compile(emailForm, Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(Email);
            return m.matches();
    }
    public void printInfo(){
        System.out.println("Index          Name          Phone number          email   ");
        for (int i = 0; i < name.size(); i++) {
            System.out.println(i + "              " + name.get(i) + "          " + phoneNumber.get(i) + "           " + email.get(i));
        }
    }
    public void CreateNewAdmin(String name , String password){
        admins.add(name);
        adminsPassword.add(password);
    }

}
