# ImageTest
This project shows how we can edit images in Java and also extract text data from it
Only english tessdata is available in the Tessdata folder. others can be downloaded from Online.
Environment varible way of pointing to tessdata folder didnt work for me. hence i'm pointing to the folder path at run time in code itself.
If you have the image file in files folder before running the program, everything works perfect. You dont need this below block of code:
	Graphics2D drawer = dest.createGraphics() ;
	drawer.setBackground(Color.WHITE);
	drawer.clearRect(10, 10,10, 10);
	
		But if you are capturing the screenshot at runtime and then cropping it, you may need above block of code.
		
Read my blog: https://vishwasshenoy.wordpress.com/2020/10/08/image-handling-with-java/
