package com.rsa.rsa;

/**
 * 
 * 客户调用方法
 * @date 2017年5月15日
 *
 */
public class ClientTest {
	public static void main(String[] args) throws Exception {
		String filepath="E:/key";
		//私钥---对应privateKey.keystore的字符串
		String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALcoUHf22+uLQ3FuHWSU6fHk7YRa57y3+hdKB8m2/zpZsNttIKXSx3T4t+v4X7zuoxSi1t/RYqwqcTE66ZQuGCvV6IGkEV/pAZLVNMksCpStTsiN2KMYrtYo1e9mpylj7/N7rX2zE1qFtK09RQbntJmodM8rPL2W1jmHoJkFWKtzAgMBAAECgYEAoEHu/riJvrQww8wkfcBqXlP/muJrh822TrBg1hd/hI+71pLKkS03hlqlmxvMsSRgnwrIVjgATUIpnni8rgIS9LQeBTzl32PSOke8nO/8F9NHdK8wRELtNPZqk0j++vBFzUE39LNhIG2+xvdQDFqkiqI1NdIoVMiaHPzFmGu3w1ECQQDoyFrMdtt6kL5LvUGjzXVHyOQlmTOtxMU7H/5lGH/LVXsb3XXHiXxw0hmSKkra4ZALVtGLxcKu2ZHeZQr983FLAkEAyWzhEIc3ceAjxm7H3Y6cjIN1lLseUAuyWSXOawkdpWdlQf1fEmbPSYlvB2jYNU2fjzc//Q4UynbtP2OPIVP9eQJAUz1J0rFx3Esj8Rt0/Gj81jWM97Dn3OxvBqxzIJ15HTGs+xLfCgIs4H8Qq8a5y7k69AMQnWWTL0kXsyn4m0TRLwJBALTo86QSrju7Iqag7SYTZovVro+tGGawerkS+bis8VGT8iA432D5sgfMRkqTYk1NsJfC+dfhA89szV13oCBA/ZECQDSwWCMLWsEPjK8pOFWdwuNDvmKzwX1Ho37BSdZboVr5R5M0wDt5zaj09W6GByYI73479aX6TF6Qg7xalWZsxBU=";
//		String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMKN1dItz8OXFjTs8UtyzeAPVULBn5gCnbeYZtr/W4Pfs1ZKFBiMzMkL7jR9UtTlLSb38jmlDrAlaGoPZlCmRVJ+IGmQDgTHRW17NJbvZJw1dcgM3wXm163GKBP8ZTJzN42JqMjDwRdwPGsW3HHokvG3KcJco/9OcbTzIFapa5fVAgMBAAECgYB9n3HaVeRaqdsX74raqdWPgLcP9NAlKkNGgiyf6dTgsPguloSlWXz9sCtuTyHF//kIuX75g7+ZM35ZRXpORx5oxng39u0pIHHu1wqKc0n3hRo0seoA8K3jCxgtOPPiYicL8gdjnYznaK+VYRaMtSm215hsPOusY+/6GL4Nl3q74QJBAOG4NjnkdnyPoWj8HrLbP2c4XDIvPhyH+tSpAAj3S52+GIeoBekgB76/tztUoKhlRODO/wZEQGT512NmQcFSVm0CQQDcp1G3eBKu5ZfYZwfB+DdViMtSaNyzFP1RJRtP/LliGCMMNOLvb8HqltF1ygZz0jSbK3+qLF1jm2NtnlL9gAYJAkEAjKjG4fzE+YpoA4xZdQu7zw8IJR3bjtwOK0fFhdDVhk9X6fGC/WvAZ9YA0TBDjazN52oW8kjF+CbZWk/22gn9YQJAOIQaqBV3I5jm5aSuFf6Pnbbl7Puy26OapngMoNYoXXm1MGEzZwSG9KEgkTznni7PDpd7oYivet3H/8G3m/p4kQJATCydVLU/XgxgqkmZOT9gVKGenicNdoFE9izRTCC4uf+ZwsYWhFDmqTwcbV1D5vwboAGdw4fod4BouoF0mB7LLQ==";
		//公钥---对应publicKey.keystore的字符串
		String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC3KFB39tvri0Nxbh1klOnx5O2EWue8t/oXSgfJtv86WbDbbSCl0sd0+Lfr+F+87qMUotbf0WKsKnExOumULhgr1eiBpBFf6QGS1TTJLAqUrU7IjdijGK7WKNXvZqcpY+/ze619sxNahbStPUUG57SZqHTPKzy9ltY5h6CZBVircwIDAQAB";
//		String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDCjdXSLc/DlxY07PFLcs3gD1VCwZ+YAp23mGba/1uD37NWShQYjMzJC+40fVLU5S0m9/I5pQ6wJWhqD2ZQpkVSfiBpkA4Ex0VtezSW72ScNXXIDN8F5tetxigT/GUyczeNiajIw8EXcDxrFtxx6JLxtynCXKP/TnG08yBWqWuX1QIDAQAB";
		System.out.println("--------------公钥加密私钥解密过程-------------------");
		String plainText="ip=255.254.253.252.251&channelCode=TEST";
		//公钥加密过程
		//第一种。直接读取文件进行加密
//		byte[] cipherData=RSAEncrypt.encrypt(RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(filepath)),plainText.getBytes());
		//第二种。直接定义变量进行加密
		byte[] cipherData=RSAEncrypt.encrypt(RSAEncrypt.loadPublicKeyByStr(publicKey),plainText.getBytes());
		String cipher=Base64.encode(cipherData);
		cipher = "Li+CzWjCc/02lmUshlxh+nezLLD4E8NphIRrOb445lNU3KyK21JeLjixHnJ4bCVjAStTJeFwjWEKzkzKdksXl4nc7y7ItZroJi8u79sFCieczb3WgxU+N33kpxxcD/j8Q2rjKewuVrgMT5GiGnTgxUiBD5OsFX/tnapC+jrZfpM=";
		System.out.println("=="+cipher);
		//私钥解密过程
		//第一种。直接读取文件进行解密
//		byte[] res=RSAEncrypt.decrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)), Base64.decode(cipher));
		//第二种。直接定义变量进行解密
		byte[] res = RSAEncrypt.decrypt(RSAEncrypt.loadPrivateKeyByStr(privateKey), Base64.decode(cipher));
		String restr=new String(res);
		System.out.println("原文："+plainText);
		System.out.println("加密："+cipher);
		System.out.println("解密："+restr);
		System.out.println();
		
//		System.out.println("--------------私钥加密公钥解密过程-------------------");
//		plainText="ihep_私钥加密公钥解密";
//		//私钥加密过程
//		cipherData=RSAEncrypt.encrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)),plainText.getBytes());
//		cipher=Base64.encode(cipherData);
//		//公钥解密过程
//		res=RSAEncrypt.decrypt(RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(filepath)), Base64.decode(cipher));
//		restr=new String(res);
//		System.out.println("原文："+plainText);
//		System.out.println("加密："+cipher);
//		System.out.println("解密："+restr);
//		System.out.println();
		
//		System.out.println("---------------私钥签名过程------------------");
//		String content="ihep_这是用于签名的原始数据";
//		String signstr=RSASignature.sign(content,RSAEncrypt.loadPrivateKeyByFile(filepath));
//		System.out.println("签名原串："+content);
//		System.out.println("签名串："+signstr);
//		System.out.println();
//		
//		System.out.println("---------------公钥校验签名------------------");
//		System.out.println("签名原串："+content);
//		System.out.println("签名串："+signstr);
//		
//		System.out.println("验签结果："+RSASignature.doCheck(content, signstr, RSAEncrypt.loadPublicKeyByFile(filepath)));
//		System.out.println();
		
	}
}
