# Challenge_EventPlanner

- Challenge Técnico de Wiselink de un planificador de eventos. En este entregable se desarrollaron todas las funcionalidades que pueden ser consumidas desde la API. Se implementó una interfaz WEB que permite visualizar todos los eventos cargados. Por último, para una fácil integración se incluyó documentación técnica.

Desarrollado utilizando:

Backend: Java Spring Boot

Frontend: React.js

Base de Datos: MySQL

Documentación: SwaggerUI y Postman Collection

## Requerimientos para instalación

- Java JDK 17
- MySQL 8.2.0
- Node.js 20.9.0

## Configuración Backend y Base de Datos

1. Hostear MySQL localmente mediante Docker.
2. Crear la base de datos 'EventPlanner'.
3. En la aplicación modificar el archivo 'application.properties' con la configuración de su base de datos.

```bash
src/main/resources/application.properties
```

```bash
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/EventPlanner
spring.datasource.username=user
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

4. Lanzar el proyecto 'ApiBackendApplication'.

## Configuración Frontend

1. Abrir proyecto 'front' desde una terminal (O abrirlo con Visual Studio Code y usar la terminal integrada)
2. Instalar las dependencias mediante el siguiente comando:

```bash
npm install
```

3. Lanzar proyecto:

```bash
npm start
```

## URLs Locales

API: http://localhost:8080/api/v1

Swagger: http://localhost:8080/swagger-ui/index.html

WEB: http://localhost:3000
