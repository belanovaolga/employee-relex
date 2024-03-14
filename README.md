# emloyee-relex
Relex company spring internship 2024 test task Java

## Стек:
Java 17\
Maven\
PostgreSQL\
Spring Boot 3.2.3\
Spring-Boot-Web\
Spring-Boot-Data-JPA\
Spring-Boot-Security 6\
JWT\
Project Lombok\
SpringDoc OpenAPI 2.3.0

## Задание:
Разработать приложение в виде RESTful API на языке Java с использованием фреймворка Spring Boot.\
Данные, получаемые и отправляемые приложением, должны быть в формате JSON.\
Приложение должно реализовывать функционал для оптимизации работы фермы.
## Реализованные требования:

_Примеры привожу в Postman_

### Авторизация:
* есть API, позволяющий авторизоваться в системе;
* есть поддержка Spring Security

![Authentication .png](src%2Fmain%2Fresources%2Fimages%2FAuthentication.png)

***

### Создание нового сотрудника:
* есть API, позволяющий зарегистрировать в системе нового сотрудника и сохранить данные в хранилище\
  _В качестве хранилища используется PostgreSQL_
* регистрация нового пользователя доступна только с ролью администратора;
* есть шифрование паролей\
 _Через BCryptPasswordEncoder_

![Auth Token.png](src%2Fmain%2Fresources%2Fimages%2FAuth%20Token.png)

![Employee Create .png](src%2Fmain%2Fresources%2Fimages%2FEmployee%20Create.png)

![Employee Create DB before .png](src%2Fmain%2Fresources%2Fimages%2FEmployee%20Create%20DB%20before.png)

![Employee Create DB after .png](src%2Fmain%2Fresources%2Fimages%2FEmployee%20Create%20DB%20after.png)

### Изменение роли сотрудника:
* есть API, позволяющий изменить роль сотрудника, тем самым дать/забрать доступ к некоторым функциям API;
* изменение роли сотрудника доступно только с ролью администратора

![Auth Token1.png](src%2Fmain%2Fresources%2Fimages%2FAuth%20Token1.png)

![Update Role.png](src%2Fmain%2Fresources%2Fimages%2FUpdate%20Role.png)

![Update Role DB after.png](src%2Fmain%2Fresources%2Fimages%2FUpdate%20Role%20DB%20after.png)

### Удаление сотрудника:
* есть API, позволяющий удалить сотрудника из системы;
* удаление сотрудника доступно только с ролью администратора

![Auth Token2.png](src%2Fmain%2Fresources%2Fimages%2FAuth%20Token2.png)

![Employee Delete .png](src%2Fmain%2Fresources%2Fimages%2FEmployee%20Delete.png)

![Employee Delete DB after.png](src%2Fmain%2Fresources%2Fimages%2FEmployee%20Delete%20DB%20after.png)
