package googlebooksdownloader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.imageio.ImageIO;

/**
 *
 * @author umang
 */
public class ImageDownloader
{

    public static void getImage(StringBuffer URL, StringBuffer location, int i) throws MalformedURLException, IOException
    {
        //StringBuffer response = new StringBuffer("");

        URL url = new URL("http://" + URL);//image url


        URLConnection urlConnection = url.openConnection();

        urlConnection.setRequestProperty("Accept", "text/html");
        // do not remove this comment as it will enable the zipped response
        //urlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
        urlConnection.setRequestProperty("Accept-Language", "en-us,en;");
        urlConnection.setRequestProperty("Connection", "keep-alive");
        urlConnection.setRequestProperty("Cookie", "PREF=ID=87cacd9eca7c3d3d:U=61453bc60ed21321:FF=0:TM=1316797527:LM=1316797529:S=DwCvNv2dwUC0PM-H; NID=51=LnjMsuN6oE0PSNXGGXuDA_TYtlP5rtV3JxyyfSxfZO2NlL3TMbDXG-mLUuGVw4-r0nnSG9XWK8-7pUJXM5daKkR0eUVP_HbaQM_qGnvvBwi21E6adRBIMDfA0jLyTCie; SID=DQAAAL0AAACahCJZfqJn-UUMhVINiKwAnVbikwsMpxv2coUq-umg1ajL7k9lO7rsImbAc5Cx712V03dMxEvLgBHpED9IEpjf7SZAI751rqX0CYtACZgfB93StxUacUiJXrrjMBrWCuZPpjeMOwcAis39iZI_T-XGfBSPExpp9YrZrItV_DphpWvATBuQmIjUAxZnXw9tEDjnnGLIS12YNu_qVyXPowrnWk-6qWsHAYXcZTIdFjqMNwR0cgF7uYIFIMSltvg2J28; HSID=A__R2WjxJOuu-PrE1; __utma=27880111.1388352251.1328869790.1328869790.1328869790.1; __utmb=27880111.2.10.1328869790; __utmc=27880111; __utmz=27880111.1328869790.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none)");
        //urlConnection.setRequestProperty("Host", "books.google.co.in");
        //urlConnection.setRequestProperty("Referer", "http://books.google.co.in/books?id=" + bookId + "&printsec=frontcover&source=gbs_ge_summary_r&cad=0");
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:10.0) Gecko/20100101 Firefox/10.0");
        urlConnection.connect();
        BufferedImage bi = ImageIO.read(urlConnection.getInputStream());
        //System.out.println("location " + location);
        ImageIO.write(bi, "jpg", new File(location + "/image" + i + ".jpg"));
        System.out.println("Written file " + i);
        urlConnection = null;
        url=null;
        bi=null;

    }
}
