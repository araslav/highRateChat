# Этап 1: Сборка приложения
FROM debian:bullseye-slim AS build

# Устанавливаем OpenJDK 17 и Maven
RUN apt-get update && apt-get install -y openjdk-17-jdk maven

# Устанавливаем рабочую директорию для сборки
WORKDIR /app

# Копируем pom.xml и скачиваем зависимости
COPY pom.xml .

RUN mvn dependency:go-offline

# Копируем исходный код приложения
COPY src /app/src

# Собираем приложение (генерируем JAR)
RUN mvn clean package -DskipTests

# Выводим содержимое папки target для отладки
RUN ls -l /app/target

# Этап 2: Запуск приложения
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем собранный JAR-файл из предыдущего этапа
COPY --from=build /app/target/chat-0.0.1-SNAPSHOT.jar /app/chat-0.0.1-SNAPSHOT.jar

# Открываем порт для приложения
EXPOSE 8080

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "/app/chat-0.0.1-SNAPSHOT.jar"]
