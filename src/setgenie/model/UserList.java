package setgenie.model;

import java.io.*;
import java.util.ArrayList;

public class UserList {

    private String userListFileName = "userList.ser";
    private ArrayList<User> userList = new ArrayList<>();

    public UserList() {
        this.readUserList();
        if(userList == null || userList.isEmpty()){
            this.createUserList();
            this.writeUserListFile();
            this.readUserList();
        }
        this.printUserList();
    }

    private void readUserList(){
        FileInputStream fileInStream = null;
        ObjectInputStream objInStream = null;
        try {
            fileInStream = new FileInputStream(userListFileName);
            objInStream = new ObjectInputStream(fileInStream);
            userList = (ArrayList<User>) objInStream.readObject();
            objInStream.close();
            if (userList.isEmpty()){
                System.out.println("The user list is empty.");
            }
        } catch (FileNotFoundException fne) {
            System.out.println("File was not found, a new one will be created");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void writeUserListFile() {
        FileOutputStream outStream = null;
        ObjectOutputStream objOut = null;
        try {
            outStream = new FileOutputStream(userListFileName);
            objOut = new ObjectOutputStream(outStream);
            objOut.writeObject(userList);
            objOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void createUserList() {
        for (int i = 0; i < 20; i++) {
            String userString = "test" + i;
            userList.add(new User(userString, "User", "test@user.com", "password", userString));
        }
    }

    public void add(User u) {
        userList.add(u);
        writeUserListFile();
    }

    public User get(int i) {
        return userList.get(i);
    }

    public int size() {
        return userList.size();
    }

    public void remove(int i) {
        userList.remove(i);
    }

    public ArrayList<User> getUserList(){
        return userList;
    }

    public void setUserList(ArrayList<User> newUserList){
        this.userList = newUserList;
    }

    public void printUserList() {
        System.out.println("The UserList has these users:");
        for (int i = 0; i < userList.size(); i++) {
            User currentUser = (User) userList.get(i);
            System.out.println(currentUser.getUsername());
        }
    }
}

