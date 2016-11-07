package battleship;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class WebPageStrategy implements Strategy {
  
  private final Scanner input;
  
  public WebPageStrategy(URL url) throws IOException {
    URLConnection site = url.openConnection();
    InputStream is = site.getInputStream();
    input = new Scanner(new BufferedInputStream(is));
  }

  @Override
  public Scanner behaviour() {
    return input;
  }
  
}
