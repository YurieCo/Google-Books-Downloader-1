/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googlebooksdownloader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Scanner;

import java.util.StringTokenizer;

/**
 *
 * @author umang
 */
public class ImageUrlCreater
{

    public static LinkedList<StringBuffer> imageUrl = new LinkedList<StringBuffer>();

    private static StringBuffer getBinaryJsonByBookID(StringBuffer bookId) throws MalformedURLException, IOException
    {

        StringBuffer sURL = new StringBuffer("http://books.google.co.in/books?id=" + bookId + "&lpg=PR1&pg=PR4&jscmd=click3");
        StringBuffer response = new StringBuffer("");
        URL url = new URL(sURL.toString());
        URLConnection urlConnection = url.openConnection();

        System.out.println("surl" + sURL);

        urlConnection.setRequestProperty("Accept", "text/html");
        // do not remove this comment as it will enable the zipped response
        //urlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
        urlConnection.setRequestProperty("Accept-Language", "en-us,en;");
        urlConnection.setRequestProperty("Connection", "keep-alive");
        urlConnection.setRequestProperty("Cookie", "PREF=ID=87cacd9eca7c3d3d:U=61453bc60ed21321:FF=0:TM=1316797527:LM=1316797529:S=DwCvNv2dwUC0PM-H; NID=51=LnjMsuN6oE0PSNXGGXuDA_TYtlP5rtV3JxyyfSxfZO2NlL3TMbDXG-mLUuGVw4-r0nnSG9XWK8-7pUJXM5daKkR0eUVP_HbaQM_qGnvvBwi21E6adRBIMDfA0jLyTCie; SID=DQAAAL0AAACahCJZfqJn-UUMhVINiKwAnVbikwsMpxv2coUq-umg1ajL7k9lO7rsImbAc5Cx712V03dMxEvLgBHpED9IEpjf7SZAI751rqX0CYtACZgfB93StxUacUiJXrrjMBrWCuZPpjeMOwcAis39iZI_T-XGfBSPExpp9YrZrItV_DphpWvATBuQmIjUAxZnXw9tEDjnnGLIS12YNu_qVyXPowrnWk-6qWsHAYXcZTIdFjqMNwR0cgF7uYIFIMSltvg2J28; HSID=A__R2WjxJOuu-PrE1; __utma=27880111.1388352251.1328869790.1328890429.1328895849.6; __utmz=27880111.1328885708.4.3.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=java; __utmc=27880111; PP_TOS_ACK=2; __utmb=27880111.1.10.1328895849");
        urlConnection.setRequestProperty("Host", "books.google.co.in");
        urlConnection.setRequestProperty("Referer", "http://books.google.co.in/books?id=" + bookId + "&printsec=frontcover&source=gbs_ge_summary_r&cad=0");
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.7 (KHTML, like Gecko) Chrome/16.0.912.36 Safari/535.7");

        Scanner s = new Scanner(new InputStreamReader(urlConnection.getInputStream()));
        while (s.hasNext())
        {
            response = response.append(s.next());
        }
        System.out.println("response " + response);
        return response;

    }

    private static LinkedList<StringBuffer> getJsonForPage(LinkedList<StringBuffer> li, StringBuffer bookId) throws MalformedURLException, IOException
    {
        //StringBuffer url = "books.google.co.in/books?id=" + bookId + "&lpg=PP1&pg=PR5&jscmd=click3";

        LinkedList<StringBuffer> returnVal = new LinkedList<StringBuffer>();
        for (StringBuffer pageid : li)
        {
            System.out.println("getting json for page id: " + pageid);
            StringBuffer sURL = new StringBuffer("http://books.google.co.in/books?id=" + bookId + "&lpg=PR1&pg=" + pageid + "&jscmd=click3");
            // System.out.println("test request url: " + sURL);
            StringBuffer response = new StringBuffer("");
            URL url = new URL(sURL.toString());
            URLConnection urlConnection = url.openConnection();

            urlConnection.setRequestProperty("Accept", "text/html");
            // do not remove this comment as it will enable the zipped response
            //urlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
            urlConnection.setRequestProperty("Accept-Language", "en-us,en;");
            urlConnection.setRequestProperty("Connection", "keep-alive");
            urlConnection.setRequestProperty("Cookie", "PREF=ID=87cacd9eca7c3d3d:U=61453bc60ed21321:FF=0:TM=1316797527:LM=1316797529:S=DwCvNv2dwUC0PM-H; NID=51=LnjMsuN6oE0PSNXGGXuDA_TYtlP5rtV3JxyyfSxfZO2NlL3TMbDXG-mLUuGVw4-r0nnSG9XWK8-7pUJXM5daKkR0eUVP_HbaQM_qGnvvBwi21E6adRBIMDfA0jLyTCie; SID=DQAAAL0AAACahCJZfqJn-UUMhVINiKwAnVbikwsMpxv2coUq-umg1ajL7k9lO7rsImbAc5Cx712V03dMxEvLgBHpED9IEpjf7SZAI751rqX0CYtACZgfB93StxUacUiJXrrjMBrWCuZPpjeMOwcAis39iZI_T-XGfBSPExpp9YrZrItV_DphpWvATBuQmIjUAxZnXw9tEDjnnGLIS12YNu_qVyXPowrnWk-6qWsHAYXcZTIdFjqMNwR0cgF7uYIFIMSltvg2J28; HSID=A__R2WjxJOuu-PrE1; __utma=27880111.1388352251.1328869790.1328890429.1328895849.6; __utmz=27880111.1328885708.4.3.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=java; __utmc=27880111; PP_TOS_ACK=2; __utmb=27880111.1.10.1328895849");
            urlConnection.setRequestProperty("Host", "books.google.co.in");
            urlConnection.setRequestProperty("Referer", "http://books.google.co.in/books?id=" + bookId + "&printsec=frontcover&source=gbs_ge_summary_r&cad=0");
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:10.0) Gecko/20100101 Firefox/10.0");

            Scanner s = new Scanner(new InputStreamReader(urlConnection.getInputStream()));
            response = new StringBuffer(s.next());
            extractURL(response);
            returnVal.add(response);
        }
        return returnVal;
    }

    private static void extractURL(StringBuffer response)
    {

        StringTokenizer tok = new StringTokenizer(response.toString(), "[]");
        StringBuffer s1 = new StringBuffer(tok.nextToken());
        s1 = new StringBuffer(tok.nextToken());
        StringTokenizer tok1 = new StringTokenizer(s1.toString(), "{}");
        //StringBuffer s2 = tok1.nextToken();
        while (tok1.hasMoreElements())
        {
            StringBuilder s3 = new StringBuilder(tok1.nextToken());
            if (s3.toString().equalsIgnoreCase(",") == false)
            {
                StringTokenizer tok2 = new StringTokenizer(s3.toString(), ",");
                while (tok2.hasMoreElements())
                {
                    StringBuilder s4 = new StringBuilder(tok2.nextToken());
                    StringBuilder sub = new StringBuilder(s4.toString().substring(1, 4));
                    if (sub.toString().equalsIgnoreCase("src"))
                    {
                        StringBuffer s = new StringBuffer(s4.toString().substring(7, s4.length()));
                        s = new StringBuffer(s.toString().replace("\\u0026", "&"));
                        s = new StringBuffer(s.toString().substring(7, s.length() - 1));
                        System.out.println("Extracted IMAGE URL " + s);
                        imageUrl.add(s);
                        return;
                    }
                }
            }
        }
    }

    private static LinkedList<StringBuffer> getPids(StringBuffer source)
    {
        LinkedList<StringBuffer> pidList = new LinkedList<StringBuffer>();
        StringTokenizer tok = new StringTokenizer(source.toString(), "[]");
        StringBuffer level1 = new StringBuffer(tok.nextToken());
        level1 = new StringBuffer(tok.nextToken());
        StringTokenizer tok1 = new StringTokenizer(level1.toString(), "{}");
        while (tok1.hasMoreTokens())
        {
            StringBuilder token = new StringBuilder(tok1.nextToken());

            // System.out.println(token);
            if (token.toString().equalsIgnoreCase(",") == false)
            {
                StringTokenizer quoteTokenizer = new StringTokenizer(token.toString(), ":,");
                quoteTokenizer.nextToken();
                StringBuffer pid1 = new StringBuffer(quoteTokenizer.nextToken());

                pid1 = new StringBuffer(pid1.substring(1, pid1.length() - 1));
                pidList.add(pid1);
            }

        }
        return pidList;
    }

    private static StringBuffer getIdFromURL(StringBuffer URL)
    {
        StringTokenizer tok = new StringTokenizer(URL.toString(), "&=");
        tok.nextToken();

        return new StringBuffer(tok.nextToken());
    }

    //public static void main(StringBuffer args[]) throws MalformedURLException, IOException
    public static LinkedList<StringBuffer> imageURLs(StringBuffer sURL) throws MalformedURLException, IOException
    {

        //    StringBuffer sURL = "http://books.google.co.in/books?id=d9fvFC49TxcC&printsec=frontcover&source=gbs_ge_summary_r&cad=0#v=onepage&q&f=false";
        System.out.println("trying to connect to the url");
        StringBuffer pageID = null;
        try
        {
            pageID = (getIdFromURL(sURL));
        }
        catch (Exception e)
        {
            System.out.println("Could not connect to the url spedified/invalid url. \nExiting. \n:-(");
            System.exit(1);
        }

        System.out.println("Getting no of pages");
        StringBuffer response = getBinaryJsonByBookID(pageID);
        LinkedList<StringBuffer> li = getPids(response);
        System.out.println(li.size() + " pages needs to be downloaded");
        System.out.println("begging to get jsong for pages...");
        LinkedList<StringBuffer> json = getJsonForPage(li, pageID);
        System.out.println("Extracting URLs completed");
        return imageUrl;
    }
}
