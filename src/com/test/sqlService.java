package com.test;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class sqlService {

	int columns;
	Integer grp;
	String status;
	Integer UserID;
	ResultSet result;

	// 2. Выборка информации о пользователях по:
	// - группе;
	public void getUsersGroups(Statement st) {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("2. Выборка информации о пользователях по: Введите ID группы: ");
			grp = in.nextInt();
			result = st.executeQuery("SELECT U. ID UID, U.NAME UNAME, G.NAME GNAME FROM USERS U INNER JOIN "
					+ "GROUPS G ON U.GROUPID=G.GROUPID WHERE U.GROUPID = " + grp + ";");
			columns = result.getMetaData().getColumnCount();
			System.out.println("Выборка информации о пользователях по группе: " + grp);
			while (result.next()) {
				for (int i = 1; i <= columns; i++) {
					System.out.print(result.getString(i) + "\t");
				}
				System.out.println("");
			}
			System.out.println("------------------------------------------");
		} catch (Exception e) {
			System.out.println("Ошибка в запросе. Запрос не выполнен!");
		}

	}

	// 2. Выборка информации о пользователях по:
	// - статусу.
	public void getUsersStatuses(Statement st) {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("2. Выборка информации о пользователях по: Введите статус: ");
			status = in.nextLine();
			result = st.executeQuery("SELECT U. ID UID, U.NAME UNAME, G.NAME GNAME FROM USERS U INNER JOIN "
					+ "GROUPS G ON U.GROUPID=G.GROUPID WHERE U.STATUS = " + status + ";");
			columns = result.getMetaData().getColumnCount();
			System.out.println("2. Выборка информации о пользователях по: статусу: " + status);
			while (result.next()) {
				for (int i = 1; i <= columns; i++) {
					System.out.print(result.getString(i) + "\t");
				}
				System.out.println();
			}
			System.out.println("------------------------------------------");
		} catch (Exception e) {
			System.out.println("Ошибка в запросе. Запрос не выполнен!");
		}
	}

	// 3. Выборка информации о группах, в которых больше двух пользователей.
	public void getGroupsMoreThanTwo(Statement st) {
		try {
			result = st.executeQuery("select G.NAME, U.GROUPID FROM USERS U INNER JOIN GROUPS G ON U.GROUPID=G.GROUPID "
					+ "group by U.GROUPID " + "HAVING count(*)>2;");
			columns = result.getMetaData().getColumnCount();
			System.out.println("3. Выборка информации о группах, в которых больше двух пользователей.");
			while (result.next()) {
				for (int i = 1; i <= columns; i++) {
					System.out.print(result.getString(i) + "\t");
				}
				System.out.println();
			}
			System.out.println("------------------------------------------");
		} catch (Exception e) {
			System.out.println("Ошибка в запросе. Запрос не выполнен!");
		}
	}

	// 4. Выборка информации о пользователях, у которых был день рождения в прошлом
	// или позапрошлом месяцах
	public void getUsersDOBTwoMonth(Statement st) {
		try {
			result = st.executeQuery("SELECT * FROM USERS WHERE MONTH(DOB) IN (MONTH(NOW())-1, MONTH(NOW())-2)");
			columns = result.getMetaData().getColumnCount();
			System.out.println(
					"4. Выборка информации о пользователях, у которых был день рождения в прошлом или позапрошлом месяцах.");
			while (result.next()) {
				for (int i = 1; i <= columns; i++) {
					System.out.print(result.getString(i) + "\t");
				}
				System.out.println();
			}
			System.out.println("------------------------------------------");

		} catch (Exception e) {
			System.out.println("Ошибка в запросе. Запрос не выполнен!");
		}
	}

	// 5. Изменение статуса произвольного пользователя, перевод в другую группу.

	public void changeUserStatus(Statement st) {
			Scanner in1 = new Scanner(System.in);
			Scanner in2 = new Scanner(System.in);
			System.out.println("5. Изменение статуса произвольного пользователя: Введите ID пользователя: ");
			UserID = in1.nextInt();
			System.out.println("5. Изменение статуса произвольного пользователя: Введите статус: ");
			String status = in2.nextLine();
			try {
			st.execute("UPDATE USERS SET STATUS = " + status + " where ID = " + UserID + ";");
			System.out.println("Статус изменен");
			System.out.println("------------------------------------------");
		} catch (Exception e) {
			System.out.println("Ошибка в запросе. Запрос не выполнен!");
		}
	}

	// 5. Изменение статуса произвольного пользователя, перевод в другую группу.

	public void changeUserGroup(Statement st) {
		try {
			Scanner in1 = new Scanner(System.in);
			Scanner in2 = new Scanner(System.in);
			System.out.println("5. Изменение группы произвольного пользователя: Введите ID пользователя: ");
			UserID = in1.nextInt();
			System.out.println("5. Изменение группы произвольного пользователя: Введите ID группы пользователя: ");
			grp = in2.nextInt();
			st.execute("UPDATE USERS SET GROUPID = " + grp + " where ID = " + UserID + ";");
			System.out.println("Группа изменена");
			System.out.println("------------------------------------------");
		} catch (Exception e) {
			System.out.println("Ошибка в запросе. Запрос не выполнен!");
		}
	}

	// 6. Удаление произвольного пользователя.
	public void deleteUser(Statement st) {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("6. Удаление произвольного пользователя. Введите ID пользователя: ");
			UserID = in.nextInt();
			st.execute("DELETE FROM USERS where ID = " + UserID + ";");
			System.out.println("Пользователь удален");
			System.out.println("------------------------------------------");
		} catch (Exception e) {
			System.out.println("Ошибка в запросе. Запрос не выполнен!");
		}
	}

	// 7. Выборка информации о всех пользователях.
	public void selectAllUsers(Statement st) throws Exception {
		try {
			result = st.executeQuery("SELECT * FROM USERS;");
			columns = result.getMetaData().getColumnCount();
			System.out.println("7. Выборка информации о всех пользователях.");
			while (result.next()) {
				for (int i = 1; i <= columns; i++) {
					System.out.print(result.getString(i) + "\t");
				}
				System.out.println("");
			}
			System.out.println("------------------------------------------");

		} catch (Exception e) {
			System.out.println("Ошибка в запросе. Запрос не выполнен!");
		}
	}

}