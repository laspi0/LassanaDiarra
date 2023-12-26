package main;

import dao.IUsers;
import dao.UsersImpl;
import entity.Users;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        IUsers usr = new UsersImpl();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Ajouter un utilisateur");
            System.out.println("2. Voir les utilisateurs");
            System.out.println("3. Quitter");

            System.out.println("Choisissez une option :");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addUser(usr, sc);
                    break;
                case 2:
                    listUsers(usr);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Option invalide !");
                    break;
            }
        }
    }

    private static void addUser(IUsers usr, Scanner sc) {
        Users u = new Users();
        System.out.println("Donner le nom de l'utilisateur");
        String nomUser = sc.nextLine();
        System.out.println("Donner l'email");
        String emailUser = sc.nextLine();
        System.out.println("Donner le mot de passe");
        String mdpUser = sc.nextLine();
        System.out.println("Donner le prénom de l'utilisateur");
        String prenomUser = sc.nextLine();

        u.setMdp(mdpUser);
        u.setNom(nomUser);
        u.setEmail(emailUser);
        u.setPrenom(prenomUser);

        int ok = usr.add(u);
        if (ok == 1) {
            System.out.println("L'utilisateur a été enregistré avec succès");
        } else {
            System.out.println("Echec de l'ajout de l'utilisateur");
        }
    }

    private static void listUsers(IUsers usr) {
        List<Users> userList = usr.list();
        for (Users user : userList) {
            System.out.println(user);
        }
    }
}
