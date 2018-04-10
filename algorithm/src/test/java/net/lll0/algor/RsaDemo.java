package net.lll0.algor;

import net.lll0.algor.rsa.Base64Utils;
import net.lll0.algor.rsa.RSAUtils;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author liangjun
 * @create 2018-03-06 9:49
 **/
public class RsaDemo {


    @Test
    public void demo() throws Exception {


         String PUCLIC_KEY =
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtInJPzz7iDuiEjDjuj3e" +
                        "spmmu+v4XyR7I4vAX+FWB2cfsGXaLhl3H6+jd9CXCfy+8AjOPRz0XkCBNxlFktXh" +
                        "CdXRedyiJq4d16EuIz3BHzF0OE/lOMLpWGmB6IvOZkPYWnFyWR0rOhPiX7FZvN8Y" +
                        "qPf25dZNWE4kfJGlbJ7IbaSb7h6/T+MTVMKCZvOnkKzK0dd05SKUTlY7MODodyHk" +
                        "16DNkfVMuRPh/bj+dI6xK4x1C8+xG+YmOiFZpaUXH9wSL8ETWn1Mu8+89TakArU1" +
                        "v+usbCXaoDE5zzq4ftqJNFMz85FhhtEYUVKHdSvHruTXmMstsjXUyj+gkHJFGohU" +
                        "2QIDAQAB";
        //
        String PRIVATE_KEY =
                "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQC0ick/PPuIO6IS" +
                        "MOO6Pd6ymaa76/hfJHsji8Bf4VYHZx+wZdouGXcfr6N30JcJ/L7wCM49HPReQIE3" +
                        "GUWS1eEJ1dF53KImrh3XoS4jPcEfMXQ4T+U4wulYaYHoi85mQ9hacXJZHSs6E+Jf" +
                        "sVm83xio9/bl1k1YTiR8kaVsnshtpJvuHr9P4xNUwoJm86eQrMrR13TlIpROVjsw" +
                        "4Oh3IeTXoM2R9Uy5E+H9uP50jrErjHULz7Eb5iY6IVmlpRcf3BIvwRNafUy7z7z1" +
                        "NqQCtTW/66xsJdqgMTnPOrh+2ok0UzPzkWGG0RhRUod1K8eu5NeYyy2yNdTKP6CQ" +
                        "ckUaiFTZAgMBAAECggEBALB1XDZrLI7jem29S1hl0J1QgR98bK7RwWnk1orgfG2P" +
                        "5fFMHAyi50QZL/WT84zXdOi4MpyZCGB3O9TW5qG2WtZ6Hty1Qef8lz6DU80uNux+" +
                        "MdI4hRsNp3W66jaZL4vVFEqSR+nCENYbSU+u0L9Cb5/3fWL4K3D8L71xvfaE2/IN" +
                        "Iq9Dj7W+FaV8Bc74mLvJOBoVTzyqyEzAIT5/B0c0kP29ySypm5DdloVd7uJACHVr" +
                        "kv3XKpXjynoKltXcAq6dx6WMBLQA/4Fu6Rwiz8X8PT4+5dhMVNhQA66WibEwuGuI" +
                        "MXv+Dh5b+j/L1P+QM7wt828ZJ6ZznG+hXoD3XYQZO+ECgYEA86AhyXZeIxQN7zGs" +
                        "4A3FDvtI+CXtzELcyZKXvDkSvJH9NcVwUKlC2Ea0XA4EDSG87J2h33fpPaxWOQyK" +
                        "tm3ncVW/ctzyoxTCpLU3Mk+fKdX/trK83iN+qtBEuvbNr6emFAO88wW2MQy0PiZq" +
                        "iOC2cTT56aEq2yFQzgGYWUx/8bsCgYEAvbVUJvQYy6mZUltcjbA71it8EO3ow5pC" +
                        "fe7ar7fr09MewOe3b4C8tMkQgs+73er5OQnHOA8JaHNdRJjFniKG+KIrJksRJ60y" +
                        "ND7Ml86ZFkNEWJ3v+8wQilVnhZr//ZjSvFv2BpwMk9aDqp3txOkYTw/nji3mjCy6" +
                        "+KjKAU7ikHsCgYEA7lm+dJH/66XVNC2Piu0t3EhwzYaeLndD91oaZaYY9LCH4LG3" +
                        "/tJ6eYpDLsTvpcFaSsy18CIq6ZHQEaR5mZ3RD4rq8X/FS1QmUmqRBAHuIEokEiSw" +
                        "r0xewtNcSubnuXD2BSLbG5B8/WQGe7+t/xiKphtEXhS2Dwl7OvFIkiVMD70CgYEA" +
                        "o8Tl4LrYrPi8Y1x7idWZ0km30OWRC0sgG5cXMpqT+0lGQ0HGGXwJbAgnOMYcaHdw" +
                        "rszCLqLMfF8bJRy9fMZRvlJA7c3gAWCC9pdAB81SWuW3Gsk9YyHHJaSUucIVO9ey" +
                        "FOlOemY8dWO6RpAPsu2HDrmsLBFz9Y6n2gHcYUS4UgECgYEAt5TeLpAkMHKHaidp" +
                        "8emOe78lnQ5fKfOG6YG0UCXyJjylVCcB234w6PL/gXCbv7snPc0poRpj2+OfKOOM" +
                        "z5rm3BtWrMpJqcsJwKWMHfM2y9bSQzp51sk2HK0Ao9IsDV97el2rsL9ZzPDktown" +
                        "MyprwB6TZ8Q6DF0Jb1QRN62Snac=";





        String s = "1122333443434";
        PublicKey publicKey = RSAUtils.loadPublicKey(PUCLIC_KEY);
        // 加密
        byte[] encryptByte = RSAUtils.encryptData(s.getBytes(), publicKey);
        // 为了方便观察吧加密后的数据用base64加密转一下，要不然看起来是乱码,所以解密是也是要用Base64先转换
        String afterencrypt = Base64Utils.encode(encryptByte);

        System.out.println("加密结果 " + afterencrypt);



        PrivateKey privateKey = RSAUtils.loadPrivateKey(PRIVATE_KEY);
        // 因为RSA加密后的内容经Base64再加密转换了一下，所以先Base64解密回来再给RSA解密
        byte[] decryptByte = RSAUtils.decryptData(Base64Utils.decode(afterencrypt), privateKey);
        String decryptStr = new String(decryptByte);
        System.out.println("解密结果 " + decryptStr);

    }
}
