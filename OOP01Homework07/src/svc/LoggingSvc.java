package svc;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingSvc {
    Logger log = Logger.getLogger(getClass().getName());

    public LoggingSvc() {
        Path logPath = Paths.get(System.getProperty("user.dir"), "OOPHomework07", "src", "logging.txt");
        try {
            FileHandler fh = new FileHandler(logPath.toString(), true);
            log.addHandler(fh);

            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
        } catch (Exception exc) {
            log.warning(exc.getMessage());
        }
    }

    public void writeLog(String message) {
        log.info(message);
    }
}
