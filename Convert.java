import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Convert{

    public static String getStringFromInputStreamAndRemoveBom(InputStream inputStream) throws IOException {

        byte[] bytes = IOUtils.toByteArray(inputStream);

        if (Integer.toHexString(bytes[0]).equals("ffffffff") && Integer.toHexString(bytes[1]).equals("fffffffe")) {
            System.out.println("Charset: UTF-16-LE");
            byte[] filteredByteArray = Arrays.copyOfRange(bytes, 2, bytes.length);
            return new String(filteredByteArray, "UTF-16LE");
        }
        else if (Integer.toHexString(bytes[0]).equals("fffffffe") && Integer.toHexString(bytes[1]).equals("ffffffff")) {
            System.out.println("Charset: UTF-16-BE");
            byte[] filteredByteArray = Arrays.copyOfRange(bytes, 2, bytes.length);
            return new String(filteredByteArray, "UTF-16BE");
        }
        else if (Integer.toHexString(bytes[0]).equals("00000000") && Integer.toHexString(bytes[1]).equals("00000000")
                && Integer.toHexString(bytes[2]).equals("ffffffff") && Integer.toHexString(bytes[3]).equals("fffffffe")) {
            System.out.println("Charset: UTF-32-BE");
            byte[] filteredByteArray = Arrays.copyOfRange(bytes, 4, bytes.length);
            return new String(filteredByteArray, "UTF-32BE");
        }
        else if (Integer.toHexString(bytes[0]).equals("ffffffff") && Integer.toHexString(bytes[1]).equals("fffffffe")
                && Integer.toHexString(bytes[2]).equals("00000000") && Integer.toHexString(bytes[3]).equals("00000000")) {
            System.out.println("Charset: UTF-32-LE");
            byte[] filteredByteArray = Arrays.copyOfRange(bytes, 4, bytes.length);
            return new String(filteredByteArray, "UTF-32LE");
        }
        else if (Integer.toHexString(bytes[0]).equals("ffffffef") && Integer.toHexString(bytes[1]).equals("ffffffbb")
                && Integer.toHexString(bytes[2]).equals("ffffffbf")) {
            System.out.println("Charset: UTF-8-BOM");
            byte[] filteredByteArray = Arrays.copyOfRange(bytes, 3, bytes.length);
            return new String(filteredByteArray, "UTF-8");
        }
        else {
            System.out.println("Charset: UTF-8");
            return new String(bytes, "UTF-8");
        }

    }
	
}