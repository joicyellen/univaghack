package br.com.hackunivag.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {
	
	private static final String hexDigits = "0123456789abcdef";
	
	 public static String encrypt(String user, String password) {   
	      String sign = user + password;   
	  
	      try {   
	         java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");   
	         md.update(sign.getBytes());   
	         byte[] hash = md.digest();   
	         StringBuffer hexString = new StringBuffer();   
	         for (int i = 0; i < hash.length; i++) {   
	            if ((0xff & hash[i]) < 0x10)   
	               hexString.append("0" + Integer.toHexString((0xFF & hash[i])));   
	            else   
	               hexString.append(Integer.toHexString(0xFF & hash[i]));   
	         }   
	         sign = hexString.toString();   
	      }   
	      catch (Exception nsae) {   
	         nsae.printStackTrace();   
	      }   
	      return sign;   
	   } 
	 
	    /**
	     * Criptografa em SHA-1, lança RuntimeException caso não encontre
	     * o algoritmo de criptografia especificado
	     * @param valor
	     * @return
	     */
	    public static String criptografarSHA1(String valor) {
		String cript = null;
		try {
		    cript = Criptografia.byteArrayToHexString(Criptografia.digest(valor.getBytes(), "SHA-1"));
		} catch (NoSuchAlgorithmException e) {
		    throw new RuntimeException(e.getMessage());
		}
		return cript;	
	    }	 
	    
	    /**
	     * Realiza um digest em um array de bytes através do algoritmo especificado
	     * Exemplo: senhaEncriptada.equals(CriptoUtil.byteArrayToHexString(CriptoUtil.digest(senhaNaoEncriptada.getBytes(),"SHA-1")))
	     * @param input - O array de bytes a ser criptografado
	     * @param algoritmo - O algoritmo a ser utilizado (SHA / MD5)
	     * @return byte[] - O resultado da criptografia
	     * @throws NoSuchAlgorithmException - Caso o algoritmo fornecido não seja
	     * válido
	     */
	     public static byte[] digest(byte[] input, String algoritmo) throws NoSuchAlgorithmException {
	         MessageDigest md = MessageDigest.getInstance(algoritmo);
	         md.reset();
	         return md.digest(input);
	     }   
	     
	     /**
	      * Converte o array de bytes em uma representação hexadecimal.
	      * @param input - O array de bytes a ser convertido.
	      * @return Uma String com a representação hexa do array
	      */
	     public static String byteArrayToHexString(byte[] b) {
	         StringBuffer buf = new StringBuffer();

	         for (int i = 0; i < b.length; i++) {
	             int j = ((int) b[i]) & 0xFF; 
	             buf.append(hexDigits.charAt(j / 16)); 
	             buf.append(hexDigits.charAt(j % 16)); 
	         }
	      
	         return buf.toString();
	     }	     
}
