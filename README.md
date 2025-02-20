# Инструкция по сборке и запуску проекта с помощью Gradle Wrapper

## 🛠️ Подготовка окружения

### **Для Windows и Linux:**

1. **Установите JDK (Java Development Kit):**
    - Скачайте **JDK 17+** с [официального сайта Oracle](https://www.oracle.com/java/technologies/javase-downloads.html).
    - Установите JDK, следуя инструкциям установщика.
    - Проверьте установку из коммандной строки:
      ```bash
      java -version
      ```
    - Убедитесь, что переменная `JAVA_HOME` корректно настроена:
        - **Windows**:
          ```bash
          echo %JAVA_HOME%
          ```
        - **Linux**:
          ```bash
          echo $JAVA_HOME
          ```

---

## 🏗️ Сборка и запуск проекта

### **Для Windows:**

1. Откройте командную строку (CMD) или PowerShell.
2. Перейдите в корневую директорию проекта:
   ```bash
   cd path\to\project
3. Соберите проект:
   ```bash
   .\gradlew.bat build
4. Запустите приложение:
   ```bash
   .\gradlew.bat bootRun

### **Для Linux:**
1. Откройте терминал.

2. Перейдите в корневую директорию проекта:
    ```bash
    cd /path/to/your-project
3. Соберите проект:

    ```bash
    ./gradlew build
4. Запустите приложение:
    ```bash
    ./gradlew bootRun

## 🌐 Доступ к Swagger UI
После запуска приложения откройте браузер и перейдите по адресу: http://localhost:8085/restful/swagger-ui/index.html
Тестовый файл с числами находится в корне проекта - Numbers.xlsx