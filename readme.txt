Airline Managemment System - Group 5

/***********************************************************************/
                       Group member information

Name			Master ID	Email
Catherine Ma - 马天瑶	1152735		296793179@qq.com
Velan Wang - 王思淇	1152755		409772932@qq.com
Chatri Pienwittayasakul	1237054		chatri_pi02@hotmail.co.th
Loyd Ea			1237149		ea_l@epitech.eu
Jean Thai			1237140		thai_j@epitech.eu


/***********************************************************************/
		  Installation guide

1. Import file AMS2013061705_Final.zip into netbeans project.

2. Create a database called "c2_airline" into a MySQL database.

3. Select "c2_airline" database freshly created.

4. Import file c2_airline.sql into c2_airline database.

5. Go to Glassfish admin console -> JDBC -> Connection Pools.

6. Create a new connection pool with following information:
	Pool name:	AMSPool
	Ressource type:	javax.sql.DataSource

	-- Pool configuration --
	databaseName:	c2_airline
	serverName:	localhost
	user:		c2_airline
	password:	SFAXQjMQwNa29n8K

7. Go to JDBC Resources panel.

8. Create a new JDBC Resource called "jdbc/ams" and linked to "AMSPool".

9. Restart Glassfish server

10. Run the project and connect with Administrator account:
	user:		admin
	password:	admin