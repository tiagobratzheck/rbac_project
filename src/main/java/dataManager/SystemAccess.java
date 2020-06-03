package dataManager;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import entities.Roles;
import entities.User;

public class SystemAccess {

	public static void start() {
		System.out.println("\t\t Welcome to the RBAC simulator \n");		
		menuAccess();

	}

	private static void menuAccess() {
		System.out.println("\nPlease, choose one of the options below: \n");
		System.out.println("(1) - Show the Roles \n" 
						 + "(2) - Show the users \n");
						 

		menuOptions();

	}

	private static void menuOptions() {
		Scanner input = new Scanner(System.in);
		try {			
			int option = input.nextInt();			
			switch (option) {
			case 1:
				showRoles();
				menuAccess();
			case 2:
				showUsers();
				menuAccess();		
			default:
				break;
			}			
		} catch (InputMismatchException e) {
			System.out.println("\t Please, just choose 1 or 2 \n");
			menuAccess();
		}
		input.close();
	}	

	private static void showRoles() {
		Type listType = new TypeToken<ArrayList<Roles>>(){}.getType();
		Gson json = new GsonBuilder().setPrettyPrinting().create();
		Reader reader;
		try {
			reader = Files.newBufferedReader(Paths.get("c:\\temp\\ws-sts\\RBAC\\roles.json"));		
			List<Roles> roles = json.fromJson(reader, listType);
			roles.forEach(x -> System.out.println(x));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void showUsers() {	
		Type listType = new TypeToken<ArrayList<User>>(){}.getType();
		Gson json = new GsonBuilder().setPrettyPrinting().create();
		Reader reader;
		try {
			reader = Files.newBufferedReader(Paths.get("c:\\temp\\ws-sts\\RBAC\\users.json"));
			List<User> user_r = json.fromJson(reader, listType);
			user_r.forEach(x -> System.out.println(x));
		} catch (IOException e) {
			e.printStackTrace();
		}				
	}
}
