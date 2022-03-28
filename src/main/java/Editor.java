import java.io.*;

public class Editor {
    public static void main(String args[]) throws IOException {
        String s = null;
        String filepath = "/Users/sakshimehra/Desktop/test.js";
        try {
            boolean isMac = System.getProperty("os.name")
                    .toLowerCase().startsWith("mac");
            boolean isWindows = System.getProperty("os.name")
                    .toLowerCase().startsWith("windows");
            ProcessBuilder builder = new ProcessBuilder();
            Process p = null;
            if(isMac){
                try{
                    p = Runtime.getRuntime().exec(String.format("open %s", filepath));
                }
                catch(Exception e){
                    p = Runtime.getRuntime().exec(String.format("open \"TextEditor\" %s", filepath));
                }
            }
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }

            System.exit(0);
            } catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }
    }
//        System.out.println(isMac);
//        System.out.println(isWindows);
}

