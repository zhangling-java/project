package com.zhangling.spring.boot.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

public class StringUtil {

    public static class PasswordUtil {
        private static final String HEX_NUMS_STR="0123456789ABCDEF";
        private static final Integer SALT_LENGTH = 16;

        public enum Type {
            MD5("MD5"),SHA1PRNG("SHA1PRNG"),SHA("SHA"),SHA256("SHA-256");

            private String type;
            private Type(String type){
                this.type = type;
            }

        }

        public enum AlgorithmType {
            NATIVEPRNG("NativePRNG"),SHA1PRNG("SHA1PRNG");

            private String algorithmType;
            private AlgorithmType(String algorithmType){
                this.algorithmType = algorithmType;
            }

        }


        public static class PasswordModel{
            private String encryptedPassword;

            public int getEncryptedCount() {
                return encryptedCount;
            }

            public void setEncryptedCount(int encryptedCount) {
                this.encryptedCount = encryptedCount;
            }

            private int encryptedCount;

            public String getEncryptedPassword() {
                return encryptedPassword;
            }

            public void setEncryptedPassword(String encryptedPassword) {
                this.encryptedPassword = encryptedPassword;
            }

            public String getSalt() {
                return salt;
            }

            public void setSalt(String salt) {
                this.salt = salt;
            }

            private String salt;
        }

        /**
         * 生成盐
         * @return
         */
        private static byte[] createSalt(AlgorithmType algorithmType){
            byte[] salt = new byte[SALT_LENGTH];
            try {
                SecureRandom random = SecureRandom.getInstance(algorithmType.algorithmType);
                random.nextBytes(salt);
                return salt;
            } catch (NoSuchAlgorithmException e) {
                return null;
            }
        }
        /**
         * 生成摘要
         * @param password
         * @param salt
         * @return
         */
        private static byte[] digest(String password, byte[] salt,Type type,int encryptedCount){

            try {
                MessageDigest msgDigest = MessageDigest.getInstance(type.type);
                if (salt != null && salt.length > 0){
                    msgDigest.update(salt);
                }

                byte[] digest = password.getBytes();
                for (int i=0;i<encryptedCount;i++){
                    digest = msgDigest.digest(digest);
                }
                return digest;
            } catch (NoSuchAlgorithmException e) {
                return null;
            }
        }

        public static PasswordModel generate(String password,Type type) throws UnsupportedEncodingException {
            PasswordModel passwordModel = new PasswordModel();
            byte[] salt = createSalt(AlgorithmType.SHA1PRNG);
            Random random = new Random();
            int count = random.nextInt(1024)+32;
            passwordModel.setEncryptedPassword(encodeBASE64(StringUtil.byteToHexString(digest(password,salt,type,count))));
            passwordModel.setSalt(encodeBASE64(StringUtil.byteToHexString(salt)));
            passwordModel.setEncryptedCount(count);
            return passwordModel;
        }



        public static boolean verify(String password, String salt,Type type,String encryptedPassword,int encryptedCount) throws UnsupportedEncodingException {
            boolean success = false;
            if (generate(password,decodeBASE64(salt),type,encryptedCount).equals(decodeBASE64(encryptedPassword))){
                success = true;
            }
            return success;
        }

        public static String generate(String password,String salt,Type type,int encryptedCount){
            return StringUtil.byteToHexString(digest(password,StringUtil.hexStringToByte(salt),type,encryptedCount));
        }
    }


    public static String encodeBASE64(String source) throws UnsupportedEncodingException {
        final Base64.Encoder encoder = Base64.getEncoder();
        final byte[] textByte = source.getBytes("UTF-8");
        return encoder.encodeToString(textByte);
    }

    public static String decodeBASE64(String source) throws UnsupportedEncodingException {
        final Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(source), "UTF-8");
    }

    /**
     * 将16进制字符串转换成字节数组
     * @param hex
     * @return
     */
    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] hexChars = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (PasswordUtil.HEX_NUMS_STR.indexOf(hexChars[pos]) << 4
                    | PasswordUtil.HEX_NUMS_STR.indexOf(hexChars[pos + 1]));
        }
        return result;
    }

    /**
     * 将指定byte数组转换成16进制字符串
     * @param b
     * @return
     */
    public static String byteToHexString(byte[] b) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            hexString.append(hex.toUpperCase());
        }
        return hexString.toString();
    }


}
