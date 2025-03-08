Challenge Backend

 Descripción
Este proyecto es una API REST desarrollada en Spring Boot 3.4.3 y Java 21 que permite realizar cálculos con un porcentaje dinámico, almacenar un historial de llamadas en PostgreSQL, y ejecutarse en Docker.

Tecnologías utilizadas

Java 21

Spring Boot 3.4.3

Spring Data JPA (PostgreSQL)

Spring Cache

SpringDoc OpenAPI (Swagger)

Docker & Docker Compose

JUnit 5 & Mockito (Pruebas unitarias)

 Configuración del entorno

Requisitos previos

Antes de ejecutar la aplicación, asegúrate de tener instalado:

Java 21 (Descargar JDK 21)

Maven 3.8+ (Descargar Maven)

Docker & Docker Compose (Descargar Docker)

Clonar el repositorio

git clone https://github.com/dmvalencia921/Challenge_tenpo.git

Configurar el archivo application.properties

En src/main/resources/application.properties, asegúrate de que PostgreSQL use la configuración de Docker:

spring.datasource.url=jdbc:postgresql://db:5432/tenpo
spring.datasource.username=admin
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=update

Verificar contenedores en ejecución:

Descargar la imagen desde Docker Hub

Si deseas usar la imagen preconstruida en Docker Hub, puedes descargarla :

Descargar la imagen:

docker pull diegovalh08/docker_tenpo:tagname


Verificar que el contenedor está corriendo:

docker ps

Documentación de la API

 Acceder a Swagger UI

Una vez levantado el servidor, accede a Swagger en:
 http://localhost:8080/swagger-ui.html

