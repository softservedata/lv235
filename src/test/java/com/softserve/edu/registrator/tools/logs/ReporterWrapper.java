package com.softserve.edu.registrator.tools.logs;

import org.testng.Reporter;

public class ReporterWrapper {
    
    private static enum ReporterTags {
        BR_ERROR("<br>[ERROR]"),
        BR_WARNING("<br>[WARNING]"),
        BR_INFO("<br>[INFO]"),
        BR_DEBUG("<br>[DEBUG]");
        //
        private String field;

        private ReporterTags(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return this.field;
        }
    }
    
    private static enum ReporterLevels {
        ERROR_LEVEL(2),
        WARNING_LEVEL(5),
        INFO_LEVEL(7),
        DEBUG_LEVEL(9);
        //
        private int level;

        private ReporterLevels(int level) {
            this.level = level;
        }

        public int getLevel() {
            return this.level;
        }
    }

    private static final String IMG_TEMPLATE = "<br><img src='%s' alt='could not take screen shot' width='80%' height='80%'>";
    private static volatile ReporterWrapper instance = null;
    private boolean consoleOutput;

    private ReporterWrapper(boolean consoleOutput) {
        this.consoleOutput = consoleOutput;
        // TODO Set default verbose.
    }

    public static ReporterWrapper get() {
        return get(true);
    }

    public static ReporterWrapper get(boolean consoleOutput) {
        if (instance == null) {
            synchronized (ReporterWrapper.class) {
                if (instance == null) {
                    instance = new ReporterWrapper(consoleOutput);
                }
            }
        }
        return instance;
    }
    
    public void error(String message){
        Reporter.log(ReporterTags.BR_ERROR.toString() + CurrentTime.get() + message,
                ReporterLevels.ERROR_LEVEL.getLevel(), consoleOutput);
    }

    public void warning(String message){
        Reporter.log(ReporterTags.BR_WARNING.toString() + CurrentTime.get() + message,
        ReporterLevels.WARNING_LEVEL.getLevel(), consoleOutput);
    }

    public void info(String message){
        Reporter.log(ReporterTags.BR_INFO.toString() + CurrentTime.get() + message,
                ReporterLevels.INFO_LEVEL.getLevel(), consoleOutput);
    }

    public void debug(String message){
        Reporter.log(ReporterTags.BR_DEBUG.toString() + CurrentTime.get() + message,
                ReporterLevels.DEBUG_LEVEL.getLevel(), consoleOutput);
    }

    public void addScreenShot() {
        CaptureScreen captureScreen = new CaptureScreen();
        Reporter.log(String.format(IMG_TEMPLATE, captureScreen.takeScreen()));
    }

}
