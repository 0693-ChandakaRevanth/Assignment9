import java.io.*;
class Fileexception extends Exception{
    private final String filename;
    public Fileexception(String message,String filename,Throwable cause){
        super(message,cause);
        this.filename =filename;
    }
    public String getFilename(){
        return filename;
    }
}
class Exceptions_Custom_Context{
    public void method(String filename) throws Fileexception{
        try(BufferedReader br=new BufferedReader(new FileReader(filename))){
            String line;
            while((line= br.readLine())!=null){
                System.out.println(line);
            }
        }catch(IOException e){
            throw new Fileexception("Error throw",filename,e);
        }
    }
    public static void main(String[] args){
        Exceptions_Custom_Context obj=new Exceptions_Custom_Context();
        String filename="inputs.txt";
        try {
            obj.method(filename);
        }catch (Fileexception e){
            System.out.println("Caught FileException.");
            System.out.println("Message: " + e.getMessage());
            System.out.println("Original Cause: " + e.getCause().getMessage());
        }
    }
}