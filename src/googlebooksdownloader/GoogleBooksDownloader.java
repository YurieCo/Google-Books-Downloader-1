package googlebooksdownloader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author umang
 */
public class GoogleBooksDownloader
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException
    {
        if (args.length <= 0 || args.length >= 3)
        {
            System.out.println("\nInvalid arguments provided.Exitting");
            System.exit(0);
        }
        StringBuffer URL = /*new StringBuffer("http://books.google.co.in/books?id=ZC6yU-EEWZwC&printsec=frontcover&dq=java&hl=en&sa=X&ei=Y1g1T7WGO8WxrAeL0726Dw&ved=0CDIQ6AEwADgK#v=onepage&q&f=false"); //*/ new StringBuffer(args[0]);
        StringBuffer locationStringBuffer =/* new StringBuilder("/home/umang/test/");//*/ new StringBuffer(args[1]);

        Scanner s = new Scanner(System.in);
        File location = new File(locationStringBuffer.toString());
        if (location.isDirectory() == false)
        {
            System.out.println("\nEntered location is not a directory or no such directory exists. Dying... \n:'-(");
            System.exit(0);
        }
        if (location.canRead() == false || location.canWrite() == false)
        {
            System.out.println("\nYou do not have rights to access theis place. \nPlease try running the utility with sudo/man or get admin rights.\n:'-(");
            System.exit(0);
        }
        LinkedList<StringBuffer> imageURLS = ImageUrlCreater.imageURLs(URL);
        int i = 0;
        for (StringBuffer url : imageURLS)
        {
            ImageDownloader.getImage(url, new StringBuffer(location.getAbsolutePath()), ++i);
        }
        System.out.println("success");
        System.out.println("---Completed writing---");
    }
}
