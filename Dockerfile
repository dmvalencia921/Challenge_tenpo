# Usamos la imagen oficial de OpenJDK 21
FROM openjdk:21-jdk

# Establecemos el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el JAR generado al contenedor
COPY target/Challenge-0.0.1-SNAPSHOT.jar app.jar

# Exponemos el puerto en el que correrá la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]