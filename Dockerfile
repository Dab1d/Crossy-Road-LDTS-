FROM eclipse-temurin:21-jdk

RUN apt-get update && apt-get install -y \
    libxext6 \
    libxrender1 \
    libxtst6 \
    libxi6 \
    libfreetype6


WORKDIR /app
COPY . /app
RUN chmod +x ./gradlew
RUN ./gradlew build -x test
CMD ["sh", "-c", "java -jar build/libs/*-1.0-SNAPSHOT.jar"]