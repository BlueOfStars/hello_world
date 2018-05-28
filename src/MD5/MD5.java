package MD5;

import java.io.FileInputStream;
import java.security.MessageDigest;

public class MD5 {

    public static void main(String[] args) throws Exception {
        //MessageDigest md5 = MessageDigest.getInstance("md5");
        //byte[] digest = md5.digest("my string !!!".getBytes());
        //System.out.println(byteToHex(digest));

        long start = System.currentTimeMillis();
        System.out.println(fileMd5("f:\\data.mdb"));
        System.out.println( (System.currentTimeMillis() - start) );

    }

    public static String fileMd5(String dir) throws Exception {
        FileInputStream in = new FileInputStream(dir);
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.reset();
        byte[] bytes = new byte[10 * 1024 * 1024];
        int len;
        while ((len = in.read(bytes)) != -1) {
            md.update(bytes, 0, len);
        }
        byte[] digest = md.digest();
        return byteToHex(digest);
    }

    public static String byteToHex(byte[] bytes){
        StringBuffer sb = new StringBuffer();
        int digital;
        for (int i = 0; i < bytes.length; i++) {
            digital = bytes[i];
            if(digital < 0)
                digital += 256;
            if(digital < 16)
                sb.append("0");
            sb.append(Integer.toHexString(digital));
        }
        return sb.toString().toUpperCase();
    }

}
