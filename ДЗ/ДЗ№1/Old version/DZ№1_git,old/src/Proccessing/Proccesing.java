package Proccessing;

import Commit.Commit;
import Dir.Dir;
import Element.Element;
import File.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Proccesing {

    private Dir currentdir;
    private Dir modifieddir;
    private Map<String, String> commitedFilesMap;
    private ArrayList<Commit> commits;

    public Proccesing() {
        this.currentdir = new Dir();
        this.modifieddir = currentdir;
        this.commitedFilesMap = new HashMap<>();
        this.commits = new ArrayList<>();

    }

    public void Proccesing() {
        String option = "0";
        boolean endofproccesing = false;
        Scanner scanner = new Scanner(System.in);
        EnteringName();
        EnteringE_mail();
        System.out.println("Commands: ");
        System.out.println();
        System.out.println("Type 'new file' to create new file in current dir");
        System.out.println("Type 'new dir' to create new dir in current dir");
        System.out.println("Type 'current dir' to get current dir hash code");
        System.out.println("Type 'modify dir' to get ,modified dir hash code");
        System.out.println("Type 'next dir' to go to another dir");
        System.out.println("Type 'commit' to commit files");
        System.out.println("Type 'log' to see history of commits");
        System.out.println("Type 'read not committed element' to read certain element");
        System.out.println("Type 'read committed element' to read certain committed element");
        System.out.println("Type 'read not committed elements' to read all not committed elements");
        System.out.println("Type 'read committed elements' to read all committed elements");
        System.out.println("Type 'exit' to exit");

        while (endofproccesing == false) {
            System.out.println("> ");
            option = scanner.nextLine();
            switch (option) {
                case "new file":
                    this.addFile();
                    break;
                case "new dir":
                    this.addDir();
                    break;
                case "current dir":
                    this.getCurrentDir();
                    break;
                case "modify dir":
                    this.changeDir();
                    break;
                case "next dir":
                    this.changeDirToRoot();
                    break;
                case "commit":
                    this.commit();
                    break;
                case "log":
                    this.log();
                    break;
                /*case "read not committed element":
                    this.readElement();
                    break;*/
                case "read committed element":
                    this.readCommittedElement();
                    break;
                case "read not committed elements":
                    this.readElements();
                    break;
                case "read committed elements":
                    this.readCommittedElements();
                    break;
                case "exit":
                    endofproccesing = true;
                    break;

                default:

                    System.out.println("Incorrect input!");
            }
        }
    }

    //Disabled
    void addFile() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type name of file: ");
        String temp = scanner.nextLine();
        Element file = new File(temp);
        //this.currentdir.addFile((File) file);
    }

    //Disabled
    void addDir() {

        //Element tree = new Dir();
        //this.currentdir.addDir((Dir) tree);
        System.out.println("New dir created");
    }

    void getCurrentDir() {

        System.out.println("Current dir" + currentdir.getHashCode());
    }

    void changeDir() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type dir hashcode: ");
        String input = scanner.nextLine();

        boolean dirExists = modifieddir.keepDir(input);

        if (dirExists) {
            currentdir = modifieddir.getDir(input);
            System.out.println("Current dir was changed to " + input);
        } else {
            System.out.println("No such dir");
        }
    }

    void changeDirToRoot() {

        currentdir = modifieddir;
        System.out.println("Current dir was changed to modified dir");
    }

    void commit() {

        Commit commit;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type commit message: ");
        String message = scanner.nextLine();

        if (commits.isEmpty()) {
            commit = new Commit(modifieddir.getHashCode(), message);
        } else {
            commit = new Commit(modifieddir.getHashCode(), commits.get(commits.size() - 1).getHashCode(), message);
        }
        commits.add(commit);
        commit.Add_to_Map(this.commitedFilesMap);
        modifieddir.Add_to_Map(this.commitedFilesMap);
    }

    void log() {

        for (Commit c : commits) {
            System.out.println("commit" + c.getHashCode());
            System.out.println(c.getContent());
            System.out.println();
        }
    }
    //Must be done
   /* void readElement() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter element hashcode: ");
        String input = scanner.nextLine();
        if (modifieddir.getHashCode().equals(input)) {
            System.out.println(modifieddir.getContent());
            return;
        }
        if (modifieddir.keepElement(input)) {
        System.out.println(modifieddir.getElement(input).getContent());
        } else {
            System.out.println("No such element");
        }
    }*/

    void readCommittedElement() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type element hash code:");
        String input = scanner.nextLine();
        for (Map.Entry<String, String> entry : commitedFilesMap.entrySet()) {

            if (entry.getKey().equals(input)) {
                System.out.println(entry.getValue());
                return;
            }
        }
        System.out.println("No such element");
    }

    void readElements() {
        modifieddir.Element_Ouput();
    }

    void readCommittedElements() {
        for (Map.Entry<String, String> entry : commitedFilesMap.entrySet()) {

            System.out.println("Element:");
            System.out.println(entry.getKey() + "\n" + entry.getValue());
            System.out.println();
        }
    }

    public static String EnteringName()
    {
        String name;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your Name to command git config --global user.name ");
        name = scanner.nextLine();
        return name;
    }
    public static String EnteringE_mail()
    {
        String e_mail;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your E_mail to command git config --global user.email ");
        e_mail = scanner.nextLine();
        return e_mail;
    }
}
