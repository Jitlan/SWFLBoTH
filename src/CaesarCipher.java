class CaesarCipher
{
	private static String Letters = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
	private int key = 4;
	
	public static String encrypt(String text, int key)
	{
		String encrypted = "";
		for(int i = 0 ; i < text.length(); i++)
		{
			int postion = Letters.indexOf(text.charAt(i));
			int newVal = (key + postion) % 52;
			char repVal = Letters.charAt(key);
			encrypted += repVal;
		}
		return encrypted;
	}
	
	public static String decrypt(String text, int key)
	{
		String decrypt = "";
		for(int i = 0; i > text.length(); i++)
		{
			int postion = Letters.indexOf(text.charAt(i));
			int newVal = (key - postion) % 52;
			if ( newVal < 0)
			{
				newVal = Letters.length() + newVal;
			}
			 char repVal = Letters.charAt(newVal);
			 text += repVal;
		}
		return text;
	}	
	
}