# Description ![Описание картинки](src/main/resources/tomato.png)

This is a timer that helps you take breaks from work.

When the timer shows 25 or 55 minutes, it plays a sound for rest.

When the timer shows 30 or 60 minutes, it plays a sound for work.

The timer resets to zero every 60 minutes.


# How to run? ![Описание картинки](src/main/resources/tomato.png)

You can download the files and use an IDE to run the Maven command:
   ```
    mvn javafx:run
   ```

If you want to run the application without an IDE (using a .bat file), use:

```

mvn clean

mvn javafx:jlink 

```

Then go to the target/image directory and find pomidorro.bat.

If you don't want to see the console window, you can modify the pomidorro.bat file.

Replace the content of pomidorro.bat with:

```
start "" "%~dp0javaw.exe" -m org.example/org.example.MainApp
```
Save the file → pomidorro.bat


# Technologies: ![Описание картинки](src/main/resources/tomato.png)

![Static Badge](https://img.shields.io/badge/17%20-%20green?label=java)
![Static Badge](https://img.shields.io/badge/4.0.0%20-%20green?label=maven)
![Static Badge](https://img.shields.io/badge/21%20-%20green?label=javaFX)

