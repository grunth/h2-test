package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//
public class desktop {

	public static void main(String[] args) throws Exception {

		Class.forName("org.h2.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		Statement st = null;
		st = conn.createStatement();

		sqlService myService = new sqlService();
		// 2. Выборка информации о пользователях по:
		// - группе;

		myService.getUsersGroups(st);

		// 2. Выборка информа2ции о пользователях по:
		// - статусу.
		myService.getUsersStatuses(st);

		// 3. Выборка информации о группах, в которых больше двух пользователей.
		myService.getGroupsMoreThanTwo(st);

		// 4. Выборка информации о пользователях, у которых был день рождения в прошлом
		// или позапрошлом месяцах
		myService.getUsersDOBTwoMonth(st);

		// 5. Изменение статуса произвольного пользователя, перевод в другую группу.
		myService.changeUserStatus(st);

		// 5. Изменение статуса произвольного пользователя, перевод в другую группу.
		myService.changeUserGroup(st);

		// 6. Удаление произвольного пользователя.
		myService.deleteUser(st);

		// 7. Выборка информации о всех пользователях.
		myService.selectAllUsers(st);

		// // Прибираемся за собой
		// st.execute("DROP TABLE USERS;");
		// st.execute("DROP TABLE GROUPS;");
		// File file = new File("tables.sql");
		// StringBuilder sb = new StringBuilder();
		// BufferedReader in = new BufferedReader(new
		// FileReader(file.getAbsoluteFile()));
		// try {
		// String s;
		// while ((s = in.readLine()) != null) {
		// sb.append(s);
		// sb.append("\n");
		// }
		// } finally {
		// in.close();
		// }
		// st.execute(sb.toString());

	}

}
