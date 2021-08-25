# dev env

## mysql

mysql server start (localhost):

```
C:/_dev/mysql/mysql-8.0.26-winx64/bin/mysqld --console
```

mysql user and table

```sql
create database jpa_example;
create user 'jpa_user'@'%' identified by 'mypassword';
grant all on jpa_example.* to 'jpa_user'@'%';
```
