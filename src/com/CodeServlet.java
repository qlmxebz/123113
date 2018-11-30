package com;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CodeServlet
 */
@WebServlet("/CodeServlet")
public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("image/JPEG");	
		ServletOutputStream out = response.getOutputStream();	
		// ����ͼƬ�ĸ߶ȺͿ��		
		int width = 80;		
		int height = 25;	
		// �������������	
		Random ran = new Random();	
		// ����ͼƬ��������ʹ��RGBģʽ���ͼƬ	
		BufferedImage image = new BufferedImage(width, height,	BufferedImage.TYPE_INT_RGB);	
		// ���廭�ʹ��߶���		
		Graphics graphics = image.getGraphics();	
		// ������֤���ı�����ɫ
		graphics.setColor(new Color(200, 200, 200));
		// �����������		
		graphics.fillRect(0, 0, width, height);	
		// ����Ҫ��ʾ����֤��		
		StringBuffer sb = new StringBuffer("");
		// ������֤������	
		String[] code = { "A", "a", "B", "b", "C", "c", "D", "d", "E", "e",				"F", "f", "G", "g", "H", "h", "I", "i", "J", "j", "K", "k",				"L", "l", "M", "m", "N", "n", "O", "o", "P", "p", "Q", "q",				"R", "r", "S", "s", "T", "t", "U", "u", "V", "v", "W", "w",				"X", "x", "Y", "y", "Z", "z", "0", "1", "2", "3", "4", "5",				"6", "7", "8", "9", "0", "1", "2", "3", "4", "5", "6", "7",				"8", "9", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",				"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "1",				"2", "3", "4", "5", "6", "7", "8", "9", "0", "1" };	
		for (int i = 0; i < 4; i++)
		{	
			String str = code[ran.nextInt(code.length)];		
			// ������ɫ
			graphics.setColor(new Color(ran.nextInt(150), ran.nextInt(150), ran	.nextInt(150)));
			// ��������	
			graphics.setFont(new Font("����", Font.BOLD, 20));	
			// ������֤��			
			graphics.drawString(str, 20 * i+4, 20 - ran.nextInt(5));
			sb.append(str);	
			}
		// �������100�����ŵ�	
		for (int i = 0; i < 100; i++)
		{			
			// ������ɸ��ŵ������	
			int x = ran.nextInt(width);		
			int y = ran.nextInt(height);
			// ������ɸ��ŵ����ɫ	
			graphics.setColor(new Color(ran.nextInt(185) + 40,	ran.nextInt(185) + 40, ran.nextInt(185) + 40));	
			// ���ø��ŵ��λ�ó���	
			graphics.drawOval(x, y, 1, 1);		
			}	
		String codeInfo = sb.toString();
		// ����֤���ֵ�ŵ�session�У��Թ�ǰ̨������֤
		System.out.println(codeInfo);
	request.getSession().setAttribute("code", codeInfo);
	// ��Imageͨ��out���Ϊjpeg��ʽ��ͼƬ	
	ImageIO.write(image, "JPEG", out);	
	out.flush();		
	out.close();
		
		}
		
	}


