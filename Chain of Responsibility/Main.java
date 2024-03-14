public class Main{
    public static void main(String args[]){

        LogProcessor logObject = (new InfoLogProcessor(new ErrorLogProcessor(new DebugLogProcessor(null))));

        logObject.log(LogProcessor.INFO,"This is INFO test msg");
        logObject.log(LogProcessor.ERROR,"This is ERROR test msg");
        logObject.log(LogProcessor.DEBUG,"This is DEBUG test msg");
    }
}