package kr.go.mapo.service;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import kr.go.mapo.service.AES256;

public class AES256 {
  public static String md5(String msg) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(msg.getBytes());
    return byteToHexString(md.digest());
  }
  
  public static String sha256(String msg) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("SHA-256");
    md.update(msg.getBytes());
    return byteToHexString(md.digest());
  }
  
  public static String byteToHexString(byte[] data) {
    StringBuilder sb = new StringBuilder();
    byte b;
    int i;
    byte[] arrayOfByte;
    for (i = (arrayOfByte = data).length, b = 0; b < i; ) {
      byte b1 = arrayOfByte[b];
      sb.append(Integer.toString((b1 & 0xFF) + 256, 16).substring(1));
      b++;
    } 
    return sb.toString();
  }
  
  public static String encryptAES256(String msg, String key) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidParameterSpecException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
    SecureRandom random = new SecureRandom();
    byte[] bytes = new byte[20];
    random.nextBytes(bytes);
    byte[] saltBytes = bytes;
    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    PBEKeySpec spec = new PBEKeySpec(key.toCharArray(), saltBytes, 70000, 256);
    SecretKey secretKey = factory.generateSecret(spec);
    SecretKeySpec secret = new SecretKeySpec(secretKey.getEncoded(), "AES");
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(1, secret);
    AlgorithmParameters params = cipher.getParameters();
    byte[] ivBytes = ((IvParameterSpec)params.<IvParameterSpec>getParameterSpec(IvParameterSpec.class)).getIV();
    byte[] encryptedTextBytes = cipher.doFinal(msg.getBytes("UTF-8"));
    byte[] buffer = new byte[saltBytes.length + ivBytes.length + encryptedTextBytes.length];
    System.arraycopy(saltBytes, 0, buffer, 0, saltBytes.length);
    System.arraycopy(ivBytes, 0, buffer, saltBytes.length, ivBytes.length);
    System.arraycopy(encryptedTextBytes, 0, buffer, saltBytes.length + ivBytes.length, encryptedTextBytes.length);
    return Base64.getEncoder().encodeToString(buffer);
  }
  
  public static String decryptAES256(String msg, String key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    ByteBuffer buffer = ByteBuffer.wrap(Base64.getDecoder().decode(msg));
    byte[] saltBytes = new byte[20];
    buffer.get(saltBytes, 0, saltBytes.length);
    byte[] ivBytes = new byte[cipher.getBlockSize()];
    buffer.get(ivBytes, 0, ivBytes.length);
    byte[] encryoptedTextBytes = new byte[buffer.capacity() - saltBytes.length - ivBytes.length];
    buffer.get(encryoptedTextBytes);
    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    PBEKeySpec spec = new PBEKeySpec(key.toCharArray(), saltBytes, 70000, 256);
    SecretKey secretKey = factory.generateSecret(spec);
    SecretKeySpec secret = new SecretKeySpec(secretKey.getEncoded(), "AES");
    cipher.init(2, secret, new IvParameterSpec(ivBytes));
    byte[] decryptedTextBytes = cipher.doFinal(encryoptedTextBytes);
    return new String(decryptedTextBytes);
  }
}
