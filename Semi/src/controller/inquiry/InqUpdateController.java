package controller.inquiry;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import dao.board.InqFileDao;
import dao.board.InqFileDaoImpl;
import dto.board.InqFile;
import dto.board.Inquiry;
import service.board.InquiryService;
import service.board.InquiryServiceImpl;


@WebServlet("/inquiry/update")
public class InqUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InquiryService inquiryService = new InquiryServiceImpl();
	private InqFileDao inqFileDao = new InqFileDaoImpl(); 
	private Inquiry inquiry = new Inquiry();
	private InqFile file = new InqFile();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		// �Ķ���� �޾ƿ��� 
		inquiry = inquiryService.getParam(req, resp);

		// ��ȸ�ؿ���
		inquiry = inquiryService.view(inquiry);

		// �𵨿� ��� �����ϱ�
		req.setAttribute("inquiry", inquiry);
		
		InqFile inqFile = inquiryService.viewFile(inquiry);
		
		// ������ ȭ�� ����
		req.getRequestDispatcher("").forward(req, resp);
		
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
	
		
		//--- MultipartRequest �������� �Ű� ���� �غ�---
		// 1. ��û ��ü 
		//	���� ���� �ʿ� ���� 
		
		// 2. ���� ���� ��ġ
		// String ���� ������ ���� ��� ���� 
		String saveDirectory = getServletContext().getRealPath("");
		
//		System.out.println( saveDirectory);
		
		// 3. ���ε� ���� ������ 
		int maxPostSize = 1 *1024*1024; // 10MB ���� 
		
		// 4. ���ڵ� 
		// ���ε� ���� ���ڵ� ��� 
		String encoding = "UTF-8";
		
		
		// 5. �ߺ� ���� �̸� ��å
		// DefaultFileRenamePolicy �� �ߺ������� ������ 
		// ���� �̸� �ڿ� ���ڸ� �߰��ϰ� 1���� ������Ų��. 
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		//-----------------------------------------------
		
		// MultipartRequest ��ü ���� 
		// ���� ���ε� ó�� 
		MultipartRequest mul = new MultipartRequest(req, saveDirectory, maxPostSize, encoding, policy);

		inquiry.setTitle(mul.getParameter("title"));
		
		inquiry.setContent(mul.getParameter("content"));
		
		file.setStored_name(mul.getFilesystemName("file"));
//		System.out.println(mul.getFilesystemName("file"));
		file.setOrigin_name(mul.getOriginalFileName("file"));
		
		inquiryService.update(inquiry);
		inquiryService.insertFile(file);


		resp.sendRedirect("/inquiry/list");
	
	}
   

}
